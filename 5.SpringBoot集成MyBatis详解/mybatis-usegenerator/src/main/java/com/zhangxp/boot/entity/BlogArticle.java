package com.zhangxp.boot.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "blog_article")
public class BlogArticle {
    /**
     * 主键
     */
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    /**
     * 文章标题
     */
    private String title;

    /**
     * 文章作者
     */
    private String author;

    /**
     * 阅读量
     */
    @Column(name = "read_num")
    private Integer readNum;

    /**
     * 评论量
     */
    @Column(name = "comment_num")
    private Integer commentNum;

    /**
     * 点赞量
     */
    @Column(name = "like_num")
    private Integer likeNum;

    /**
     * 文章展示类别,1:普通，2：大图片，3：无图片
     */
    @Column(name = "cover_type")
    private Integer coverType;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 是否推荐文章
     */
    private Boolean recommend;

    /**
     * 分类类别存在多级分类，用逗号隔开
     */
    @Column(name = "category_id")
    private String categoryId;

    /**
     * 发布状态
     */
    private Byte publish;

    /**
     * 是否置顶
     */
    private Boolean top;

    /**
     * 文章描述
     */
    private String description;

    /**
     * 文章内容
     */
    private String content;

    /**
     * html的content
     */
    @Column(name = "content_format")
    private String contentFormat;

    /**
     * 封面
     */
    private String cover;

    /**
     * 获取主键
     *
     * @return id - 主键
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置主键
     *
     * @param id 主键
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取文章标题
     *
     * @return title - 文章标题
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置文章标题
     *
     * @param title 文章标题
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 获取文章作者
     *
     * @return author - 文章作者
     */
    public String getAuthor() {
        return author;
    }

    /**
     * 设置文章作者
     *
     * @param author 文章作者
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * 获取阅读量
     *
     * @return read_num - 阅读量
     */
    public Integer getReadNum() {
        return readNum;
    }

    /**
     * 设置阅读量
     *
     * @param readNum 阅读量
     */
    public void setReadNum(Integer readNum) {
        this.readNum = readNum;
    }

    /**
     * 获取评论量
     *
     * @return comment_num - 评论量
     */
    public Integer getCommentNum() {
        return commentNum;
    }

    /**
     * 设置评论量
     *
     * @param commentNum 评论量
     */
    public void setCommentNum(Integer commentNum) {
        this.commentNum = commentNum;
    }

    /**
     * 获取点赞量
     *
     * @return like_num - 点赞量
     */
    public Integer getLikeNum() {
        return likeNum;
    }

    /**
     * 设置点赞量
     *
     * @param likeNum 点赞量
     */
    public void setLikeNum(Integer likeNum) {
        this.likeNum = likeNum;
    }

    /**
     * 获取文章展示类别,1:普通，2：大图片，3：无图片
     *
     * @return cover_type - 文章展示类别,1:普通，2：大图片，3：无图片
     */
    public Integer getCoverType() {
        return coverType;
    }

    /**
     * 设置文章展示类别,1:普通，2：大图片，3：无图片
     *
     * @param coverType 文章展示类别,1:普通，2：大图片，3：无图片
     */
    public void setCoverType(Integer coverType) {
        this.coverType = coverType;
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取更新时间
     *
     * @return update_time - 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置更新时间
     *
     * @param updateTime 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取是否推荐文章
     *
     * @return recommend - 是否推荐文章
     */
    public Boolean getRecommend() {
        return recommend;
    }

    /**
     * 设置是否推荐文章
     *
     * @param recommend 是否推荐文章
     */
    public void setRecommend(Boolean recommend) {
        this.recommend = recommend;
    }

    /**
     * 获取分类类别存在多级分类，用逗号隔开
     *
     * @return category_id - 分类类别存在多级分类，用逗号隔开
     */
    public String getCategoryId() {
        return categoryId;
    }

    /**
     * 设置分类类别存在多级分类，用逗号隔开
     *
     * @param categoryId 分类类别存在多级分类，用逗号隔开
     */
    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * 获取发布状态
     *
     * @return publish - 发布状态
     */
    public Byte getPublish() {
        return publish;
    }

    /**
     * 设置发布状态
     *
     * @param publish 发布状态
     */
    public void setPublish(Byte publish) {
        this.publish = publish;
    }

    /**
     * 获取是否置顶
     *
     * @return top - 是否置顶
     */
    public Boolean getTop() {
        return top;
    }

    /**
     * 设置是否置顶
     *
     * @param top 是否置顶
     */
    public void setTop(Boolean top) {
        this.top = top;
    }

    /**
     * 获取文章描述
     *
     * @return description - 文章描述
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置文章描述
     *
     * @param description 文章描述
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 获取文章内容
     *
     * @return content - 文章内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置文章内容
     *
     * @param content 文章内容
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * 获取html的content
     *
     * @return content_format - html的content
     */
    public String getContentFormat() {
        return contentFormat;
    }

    /**
     * 设置html的content
     *
     * @param contentFormat html的content
     */
    public void setContentFormat(String contentFormat) {
        this.contentFormat = contentFormat;
    }

    /**
     * 获取封面
     *
     * @return cover - 封面
     */
    public String getCover() {
        return cover;
    }

    /**
     * 设置封面
     *
     * @param cover 封面
     */
    public void setCover(String cover) {
        this.cover = cover;
    }
}