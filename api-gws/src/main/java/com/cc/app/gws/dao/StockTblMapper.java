package com.cc.app.gws.dao;

import com.cc.app.gws.model.StockTbl;
import com.cc.app.gws.model.StockTblExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StockTblMapper {
    int countByExample(StockTblExample example);

    int deleteByExample(StockTblExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(StockTbl record);

    int insertSelective(StockTbl record);

    List<StockTbl> selectByExample(StockTblExample example);

    StockTbl selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") StockTbl record, @Param("example") StockTblExample example);

    int updateByExample(@Param("record") StockTbl record, @Param("example") StockTblExample example);

    int updateByPrimaryKeySelective(StockTbl record);

    int updateByPrimaryKey(StockTbl record);

    int uptStock(StockTbl record);
}