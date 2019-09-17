package com.stopec.gy.mapper;

import com.stopec.gy.mybatis.IMapper;
import com.stopec.gy.pojo.Stock;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;


public interface OrderPayMapper  extends IMapper<Stock> {

  @Select("Select * From  D病人余额明细 where 系统编号 = #{aac001}")
  String getOrder(@Param("aac001") String aac001);

}
