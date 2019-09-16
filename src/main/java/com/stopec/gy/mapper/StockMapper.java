package com.stopec.gy.mapper;

import com.stopec.gy.mybatis.IMapper;
import com.stopec.gy.pojo.Stock;
import org.apache.ibatis.annotations.Update;

public interface StockMapper extends IMapper<Stock> {
    @Update("update stocks set count = count -1,sale = sale+1 where id=#{id} and count>0")
    int updataCount(int id);
}
