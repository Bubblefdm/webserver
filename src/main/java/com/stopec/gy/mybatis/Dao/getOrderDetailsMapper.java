package com.stopec.gy.mybatis.Dao;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface getOrderDetailsMapper {

    @Select("Select * From  D病人余额明细 where 系统编号 = #{aac001} for xml path('student'),type,root('allStudents') ")
    String getOrder(@Param("aac001")String aac001);


}