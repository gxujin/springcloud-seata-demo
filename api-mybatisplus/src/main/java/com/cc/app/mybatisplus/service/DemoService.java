package com.cc.app.mybatisplus.service;

import com.cc.app.mybatisplus.dao.OrderTblMapper;
import com.cc.app.mybatisplus.feign.GwsService;
import com.cc.app.mybatisplus.model.OrderTbl;
import io.seata.core.context.RootContext;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DemoService {

    @Autowired
    private GwsService gwsService;

    @Autowired
    private OrderTblMapper orderTblMapper;

    @GlobalTransactional
    @Transactional(rollbackFor = Exception.class)
    public String createOrder(String name){
        String xid = RootContext.getXID();
        name = name == null ? "test" : name;
        gwsService.deduct(xid, name);

        OrderTbl orderTbl = new OrderTbl();
        orderTbl.setUserId("xujin");
        orderTbl.setCount(1);
        orderTbl.setMoney(100);
        orderTbl.setCommodityCode("product-1");
        orderTblMapper.insert(orderTbl);

        orderTbl.setId(null);

        return orderTbl.getId().toString();
//        return "success";
    }
}
