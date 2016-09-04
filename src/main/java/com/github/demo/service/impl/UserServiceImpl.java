package com.github.demo.service.impl;

import com.github.demo.dao.AddressMapper;
import com.github.demo.dao.IUserModelDao;
import com.github.demo.model.AddressModel;
import com.github.demo.model.UserModel;
import com.github.demo.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by zhuoshangyi on 2016/8/31.
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource
    private IUserModelDao userModelDao;

    @Resource
    private AddressMapper addressDao;

    @Override
    @Transactional
    public List<UserModel> getAllUsers() {
        return userModelDao.getAllUsers();
    }

    @Override
    public int delUserById(Integer id) {
        return userModelDao.deleteByPrimaryKey(id);
    }

    @Override
    public int addUser(UserModel userModel) {
        return userModelDao.insertSelective(userModel);
    }

    @Override
    public int updateUserById(UserModel userModel) {
        return userModelDao.updateByPrimaryKey(userModel);
    }

    @Override
    public UserModel getUserById(Integer id) {
        return userModelDao.selectByPrimaryKey(id);
    }

    @Override
    public int updateUserAddressByUserId(AddressModel addressModel) {
        return addressDao.updateByUserIdSelective(addressModel);
    }

    @Override
    public AddressModel getUserAddressByUserId(Integer userId) {
        return addressDao.selectByUserId(userId);
    }
}
