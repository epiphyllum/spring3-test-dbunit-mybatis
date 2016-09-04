package com.github.demo.service;

import com.github.demo.model.AddressModel;
import com.github.demo.model.UserModel;

import java.util.List;

/**
 * Created by zhuoshangyi on 2016/8/31.
 */
public interface UserService {
    List<UserModel> getAllUsers();

    int delUserById(Integer id);

    int addUser(UserModel userModel);

    int updateUserById(UserModel userModel);

    UserModel getUserById(Integer id);

    int updateUserAddressByUserId(AddressModel addressModel);

    AddressModel getUserAddressByUserId(Integer userId);
}
