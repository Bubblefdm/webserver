package com.stopec.gy.mapper;


import com.stopec.gy.mybatis.IMapper;
import com.stopec.gy.pojo.req.order.Inputxml001;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

//public interface OrderPayMapper extends IMapper<Inputxml001> {
//
//    @Select("Select * From  D病人余额明细 where 系统编号 = #{aac001} for xml path('student'),type,root('allStudents') ")
//    String getOrder(@Param("aac001") String aac001);
//
//
//}