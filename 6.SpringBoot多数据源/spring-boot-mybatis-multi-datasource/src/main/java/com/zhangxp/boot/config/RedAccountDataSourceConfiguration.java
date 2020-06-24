package com.zhangxp.boot.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import tk.mybatis.spring.annotation.MapperScan;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = {"com.zhangxp.boot.mapper.redaccount.mapper"}, sqlSessionFactoryRef = "redAccountSqlSessionFactory")
public class RedAccountDataSourceConfiguration {
    public static final String MAPPER_XML_LOCATION = "classpath*:com/zhangxp/boot/mapper/redaccount/mapper/xml/*.xml";

    @Autowired
    @Qualifier("RedPacketDataSource")
    DataSource redAccountDataSource;

    @Bean
    public SqlSessionTemplate sqlSessionTemplate() throws Exception {
        return new SqlSessionTemplate(redAccountSqlSessionFactory());
    }

    @Bean
    public SqlSessionFactory redAccountSqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(redAccountDataSource);
        // 指定XML文件路径
        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(MAPPER_XML_LOCATION));
        return sqlSessionFactoryBean.getObject();
    }

    @Bean(name = "transactionManager")
    public DataSourceTransactionManager transactionManager() {
        return new DataSourceTransactionManager(redAccountDataSource);
    }
}
