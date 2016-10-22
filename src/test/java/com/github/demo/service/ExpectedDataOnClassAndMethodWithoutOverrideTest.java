package com.github.demo.service;

import com.github.demo.base.TransactionBaseTest;
import com.github.demo.model.AddressModel;
import com.github.demo.model.UserModel;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.ExpectedDatabase;
import com.github.springtestdbunit.assertion.DatabaseAssertionMode;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by zhuoshangyi on 2016/10/22.
 */
@DatabaseSetup(value = {"/dataset/t_address_s1.xml","/dataset/t_user_s1.xml"})
@ExpectedDatabase(value = "/dataset/t_user_e1.xml",assertionMode = DatabaseAssertionMode.NON_STRICT)
public class ExpectedDataOnClassAndMethodWithoutOverrideTest extends TransactionBaseTest{
    @Autowired
    private UserService userService;

    @Test
    @ExpectedDatabase(value = "/dataset/t_address_e1.xml",assertionMode = DatabaseAssertionMode.NON_STRICT,override = false)
    public void testExpectOnMethod() throws Exception {
        UserModel user = userService.getUserById(2);
        AddressModel userAddress = userService.getUserAddressByUserId(user.getId());
        userAddress.setPhone("222222222222");
        userService.updateUserAddressByUserId(userAddress);

    }
}
