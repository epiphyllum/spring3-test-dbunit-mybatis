package com.github.demo.dao;

import com.github.demo.model.AddressModel;

public interface AddressMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AddressModel record);

    int insertSelective(AddressModel record);

    AddressModel selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AddressModel record);

    int updateByPrimaryKey(AddressModel record);

    int updateByUserIdSelective(AddressModel record);

    AddressModel selectByUserId(Integer userId);
}