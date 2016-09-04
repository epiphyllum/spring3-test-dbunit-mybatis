package com.github.demo.service;

import com.github.demo.base.TransactionBaseTest;
import com.github.demo.model.AddressModel;
import com.github.demo.model.UserModel;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DatabaseSetups;
import com.github.springtestdbunit.annotation.ExpectedDatabase;
import com.github.springtestdbunit.assertion.DatabaseAssertionMode;
import org.dbunit.dataset.Column;
import org.dbunit.dataset.filter.IColumnFilter;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by zhuoshangyi on 2016/8/26.
 */

public class UserlServiceTest extends TransactionBaseTest {

    @Autowired
    private UserService userService;

    @Test
    @DatabaseSetup("/dataset/t_user_s1.xml")
    @ExpectedDatabase("/dataset/t_user_e1.xml")
    public void testSelectAll() {
        List<UserModel> allUserModels = userService.getAllUsers();
        Assert.assertNotNull(allUserModels);
    }

    @Test
    @DatabaseSetup("/dataset/t_user_s1.xml")
    @ExpectedDatabase("/dataset/t_user_e2.xml")
    public void testDeleteData() {
        userService.delUserById(2);
    }


    @Test
    @DatabaseSetup("/dataset/t_user_s1.xml")
    @ExpectedDatabase(value = "/dataset/t_user_e3.xml", assertionMode = DatabaseAssertionMode.NON_STRICT_UNORDERED)
    public void testInsertAndIngoreOrder() {
        UserModel userModel = new UserModel();
        userModel.setUserName("测试4");
        userModel.setAge(26);
        userModel.setPassword("test4");
        userService.addUser(userModel);
    }


    @Test
    @DatabaseSetup("/dataset/t_user_s1.xml")
    @ExpectedDatabase(value = "/dataset/t_user_e4.xml", assertionMode = DatabaseAssertionMode.NON_STRICT_UNORDERED,columnFilters = {ColumnFilter.class})
    public void testIColumnFilter() {
        UserModel userModel = new UserModel();
        userModel.setUserName("测试1");
        userModel.setAge(27);
        userModel.setPassword("test1");
        userService.addUser(userModel);
    }


    public static class ColumnFilter implements IColumnFilter {

        @Override
        public boolean accept(String tableName, Column column) {
            return !(tableName.equals("t_user") && column.getColumnName().equals("id"));
        }
    }

    @Test
    @DatabaseSetup("/dataset/t_user_s1.xml")
    @ExpectedDatabase(value = "/dataset/t_user_e5.xml")
    public void testUpdateOneRow()
    {
        UserModel user = userService.getUserById(2);
        user.setUserName("新测试2");
        userService.updateUserById(user);
    }

    @Test
    @DatabaseSetup("/dataset/t_user_s1.xml")
    @ExpectedDatabase(value = "/dataset/t_user_e6.xml")
    public void testUpdateMultiRows()
    {
        List<UserModel> allUsers = userService.getAllUsers();
        for (UserModel user : allUsers) {
            user.setUserName("新"+user.getUserName());
            userService.updateUserById(user);
        }
    }

    @Test
    @DatabaseSetups({@DatabaseSetup("/dataset/t_user_s1.xml"),@DatabaseSetup("/dataset/t_address_s1.xml")})
    @ExpectedDatabase("/dataset/t_user_e5.xml")
    public void testUpdateMultiTables()
    {
        UserModel user = userService.getUserById(2);
        user.setUserName("新测试2");
        userService.updateUserById(user);
        AddressModel userAddress = userService.getUserAddressByUserId(user.getId());
        userAddress.setPhone("18676341851");
        userService.updateUserAddressByUserId(userAddress);
    }

}
