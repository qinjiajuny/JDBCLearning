package pers.huangyuhui.curd.service.impl;

import pers.huangyuhui.curd.bean.User;
import pers.huangyuhui.curd.dao.UserDao;
import pers.huangyuhui.curd.service.UserService;

import java.util.List;

/**
 * @project: curd-demo
 * @description: 业务逻辑层的实现类
 * @author: 黄宇辉
 * @date: 8/22/2019-3:29 PM
 * @version: 1.0
 * @website: https://yubuntu0109.github.io/
 */
public class UserServiceImpl implements UserService {

    private static UserDao userDao = new UserDao();

    @Override
    public List<User> getAllUser() {
        return userDao.selectAllUser();
    }

    @Override
    public boolean addUser(User user) { return userDao.insertNewUser(user); }

    @Override
    public boolean updateUser(User user) {
        return userDao.updateUserById(user);
    }

    @Override
    public boolean deleteUser(Integer id) {
        return userDao.deleteUserById(id);
    }
}
