package com.github.demo.service;

import com.github.demo.base.TransactionBaseTest;
import com.github.demo.model.UserModel;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by zhuoshangyi on 2016/10/21.
 */
@DatabaseSetup("/dataset/t_address_s1.xml")
public class DataSetupOnClassAndMethodTest extends TransactionBaseTest{
    @Autowired
    private UserService userService;

    @Test
    @DatabaseSetup("/dataset/t_user_s1.xml")
    public void testCleanInsert() throws Exception {
        List<UserModel> allUserModels = userService.getAllUsers();
        Assert.assertNotNull(allUserModels);
        Assert.assertEquals(2,allUserModels.size());

    }
}
