package com.github.demo.service;

import com.github.demo.base.TransactionBaseTest;
import com.github.demo.model.AddressModel;
import com.github.demo.model.UserModel;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.ExpectedDatabase;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by zhuoshangyi on 2016/10/22.
 */
@DatabaseSetup(value = {"/dataset/t_user_s1.xml","/dataset/t_address_s1.xml"})
@ExpectedDatabase(value = {"/dataset/t_user_e3.xml","/dataset/t_address_e1.xml"})
public class MultiDataSetupAndMultiExpectedDataOnClassTest extends TransactionBaseTest {
    @Autowired
    private UserService userService;

    @Test
    public void testDoNothing() throws Exception {
        UserModel user = userService.getUserById(2);
        user.setUserName("新测试2");
        userService.updateUserById(user);
        AddressModel userAddress = userService.getUserAddressByUserId(user.getId());
        userAddress.setPhone("222222222222");
        userService.updateUserAddressByUserId(userAddress);

    }
}
