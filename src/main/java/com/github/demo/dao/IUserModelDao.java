package com.github.demo.dao;

import com.github.demo.model.UserModel;

import java.util.List;

public interface IUserModelDao {
    int deleteByPrimaryKey(Integer id);

    int insert(UserModel record);

    int insertSelective(UserModel record);

    UserModel selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserModel record);

    int updateByPrimaryKey(UserModel record);

    List<UserModel> getAllUsers();
}