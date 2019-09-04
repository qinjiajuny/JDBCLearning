package pers.huangyuhui.curd;

import org.junit.BeforeClass;
import org.junit.Test;
import pers.huangyuhui.curd.bean.User;
import pers.huangyuhui.curd.service.UserService;
import pers.huangyuhui.curd.service.impl.UserServiceImpl;

import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest {
    private static UserService userService;

    @BeforeClass
    public static void init() {
        userService = new UserServiceImpl();
    }

    //test getAllUser() method
    @Test
    public void printAllUser() {
        List<User> allUsers = userService.getAllUser();
        System.out.println("获取所有的用户信息 : " + allUsers);
    }

    //test addUser method
    @Test
    public void addUser() {
        User user = new User();
        user.setName("addUser");
        user.setGender("男");
        user.setAge(0);
        user.setPassword("pwd");
        user.setTelephone("000000");
        user.setBirthday("0000-00-00");
        System.out.println("是否成功添加用户信息 : " + userService.addUser(user));
    }


    //test updateUser method
    @Test
    public void updateUser() {
        User user = new User();
        user.setId(1);
        user.setName("updateUser");
        user.setGender("女");
        user.setAge(0);
        user.setPassword("pwd");
        user.setTelephone("111111");
        user.setBirthday("1111-11-11");
        System.out.println("是否成功更新用户信息 : " + userService.updateUser(user));
    }

    //test deleteUser method
    @Test
    public void deleteUser() {
        System.out.println("是否成功删除用户信息 : " + userService.deleteUser(1));
    }
}
