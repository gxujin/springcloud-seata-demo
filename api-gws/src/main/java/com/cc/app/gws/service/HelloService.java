package com.cc.app.gws.service;

import com.cc.app.gws.dao.StockTblMapper;
import com.cc.app.gws.model.StockTbl;
import com.cc.app.gws.model.StockTblExample;
import io.seata.core.context.RootContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class HelloService {

    private Logger logger = LoggerFactory.getLogger(HelloService.class);

    @Autowired
    private StockTblMapper stockTblMapper;

    @Transactional(rollbackFor = Exception.class)
    public String deduct(String name) {
        logger.info("xid：{}", RootContext.getXID());
        logger.info("name: {}", name);
        Integer id = null;
        StockTblExample example = new StockTblExample();
        example.createCriteria().andCommodityCodeEqualTo(name);
        List<StockTbl> list = stockTblMapper.selectByExample(example);
        if(list.size() > 0){
            StockTbl stockTbl = list.get(0);
            id = stockTbl.getId();
        }
        if(id != null){
            StockTbl uptEntity = new StockTbl();
            uptEntity.setId(id);
            uptEntity.setCount(1);
            stockTblMapper.uptStock(uptEntity);
        }else{
            logger.error("查找不到记录");
        }
        stockTblMapper.deleteByPrimaryKey(2);

        return "success";
    }
}
