package com.stopec.gy.mybatis;

import tk.mybatis.mapper.additional.insert.InsertListMapper;
import tk.mybatis.mapper.annotation.RegisterMapper;
import tk.mybatis.mapper.common.Mapper;

@RegisterMapper
public interface IMapper<T> extends Mapper<T>, InsertListMapper<T>{
}
