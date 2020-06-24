package com.zhangxp.boot.service;

import com.zhangxp.boot.mapper.account.entity.CapitalAccount;
import com.zhangxp.boot.mapper.account.mapper.CapitalAccountMapper;
import com.zhangxp.boot.mapper.redaccount.entity.RedPacketAccount;
import com.zhangxp.boot.mapper.redaccount.mapper.RedPacketAccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by zhangxp on 2020/6/24.
 */
@Service
public class PayService {
    @Autowired
    private CapitalAccountMapper capitalAccountMapper;
    @Autowired
    private RedPacketAccountMapper redPacketAccountMapper;

    @Transactional(rollbackFor = Exception.class)
    public void payAccount(int userId, int account) {
        System.out.println("--------------payAccount------------------");
        CapitalAccount capitalAccount = new CapitalAccount();
        capitalAccount.setUserId(userId);
        CapitalAccount capitalAccountDTO = this.capitalAccountMapper.selectOne(capitalAccount);
        // 从账户里扣钱
        if (capitalAccountDTO != null) {
            System.out.println("--------------扣钱----------------");
            capitalAccountDTO.setBalanceAmount(capitalAccountDTO.getBalanceAmount() - account);
            System.out.println(capitalAccountDTO.toString());
            this.capitalAccountMapper.updateByPrimaryKey(capitalAccountDTO);
        }
    }

    @Transactional(rollbackFor = Exception.class)
    public void payRedAccount(int userId, int account) {
        System.out.println("--------------payRedAccount------------------");
        RedPacketAccount redPacketAccount = new RedPacketAccount();
        redPacketAccount.setUserId(userId);
        RedPacketAccount redPacketAccountDTO = this.redPacketAccountMapper.selectOne(redPacketAccount);
        // 给账户里加钱
        if (redPacketAccountDTO != null) {
            System.out.println("--------------加钱----------------");
            redPacketAccountDTO.setBalanceAmount(redPacketAccountDTO.getBalanceAmount() + account);
            System.out.println(redPacketAccountDTO.toString());
            this.redPacketAccountMapper.updateByPrimaryKey(redPacketAccountDTO);
        }

        // 分布式事务的的坑，一个数据源操作发生异常时，另一个数据源的操作正常执行.
        int i = 3/0;
    }

    @Transactional(rollbackFor = Exception.class)
    public void pay(int fromUserId, int toUserId, int account) {
        System.out.println("--------------pay------------------");
        this.payAccount(fromUserId, account);
        this.payRedAccount(toUserId, account);
    }
}
