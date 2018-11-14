package com.keda.modules.rest;

/**
 * 用户数据访问接口。
 */

import com.keda.common.datasource.DBIdentifier;
import com.keda.modules.mapper.UserMapper;
import com.keda.modules.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WSUser {
    @Autowired
    private UserMapper userMapper;

    /**
     * 查询项目中所有用户信息
     *
     * @param projectCode 项目编码
     * @return 用户列表
     */
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public List<User> queryUser(@RequestParam(value = "projectCode", required = true) String projectCode) {
        DBIdentifier.setProjectCode(projectCode);
        return userMapper.getUsers();
    }

    @RequestMapping(value = "/users2", method = RequestMethod.GET)
    public List<User> queryUser2() {
        return userMapper.getUsers();
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public int delete(@RequestParam(value = "projectCode", required = true) String projectCode) {
        DBIdentifier.setProjectCode(projectCode);
        return userMapper.delete(1);
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String queryUser() {
        return "测试";
    }
}
