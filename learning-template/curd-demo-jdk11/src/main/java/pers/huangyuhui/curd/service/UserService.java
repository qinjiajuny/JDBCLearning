package pers.huangyuhui.curd.service;

import pers.huangyuhui.curd.bean.User;

import java.util.List;

/**
 * @project: curd-demo
 * @description: 业务逻辑层(Service)
 * @author: 黄宇辉
 * @date: 8/22/2019-3:29 PM
 * @version: 1.0
 * @website: https://yubuntu0109.github.io/
 */
public interface UserService {

    List<User> getAllUser();

    boolean addUser(User user);

    boolean updateUser(User user);

    boolean deleteUser(Integer id);
}
