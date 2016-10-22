package com.github.demo.service;

import com.github.demo.base.TransactionBaseTest;
import com.github.demo.model.UserModel;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.ExpectedDatabase;
import com.github.springtestdbunit.assertion.DatabaseAssertionMode;
import org.dbunit.dataset.Column;
import org.dbunit.dataset.filter.IColumnFilter;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by zhuoshangyi on 2016/10/22.
 */
public class ExpectedDataAndColumnFilterOnMethodTest extends TransactionBaseTest {

    @Autowired
    private UserService userService;

    @Test
    @DatabaseSetup("/dataset/t_user_s1.xml")
    @ExpectedDatabase(value = "/dataset/t_user_e2.xml", assertionMode = DatabaseAssertionMode.NON_STRICT,columnFilters = {ColumnFilter.class})
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
}
