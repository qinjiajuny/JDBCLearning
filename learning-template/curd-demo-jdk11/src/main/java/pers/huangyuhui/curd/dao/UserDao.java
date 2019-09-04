package pers.huangyuhui.curd.dao;

import pers.huangyuhui.curd.bean.User;
import pers.huangyuhui.curd.utils.DBUitl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @project: curd-demo
 * @description: 数据访问层(DAO):可利用JDK8新特性Lambda来优化此程序
 * @author: 黄宇辉
 * @date: 8/22/2019-3:28 PM
 * @version: 1.0
 * @website: https://yubuntu0109.github.io/
 */
public class UserDao {

    //获取数据库连接
    private static Connection connection = DBUitl.getConnection();

    //添加用户信息
    public boolean insertNewUser(User user) {
        String sql = "insert into tb_user(name, age, gender, password, telephone, birthday) values (?,?,?,?,?,?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, user.getName());
            preparedStatement.setInt(2, user.getAge());
            preparedStatement.setString(3, user.getGender());
            preparedStatement.setString(4, user.getPassword());
            preparedStatement.setString(5, user.getBirthday());
            preparedStatement.setString(6, user.getTelephone());
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    //查询所有用户信息
    public List<User> selectAllUser() {
        String sql = "select id, name, age, gender, password, telephone, birthday from tb_user";
        List<User> list = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setAge(resultSet.getInt("age"));
                user.setGender(resultSet.getString("gender"));
                user.setPassword(resultSet.getString("password"));
                user.setTelephone(resultSet.getString("telephone"));
                user.setBirthday(resultSet.getString("birthday"));
                list.add(user);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //更新用户信息
    public boolean updateUserById(User user) {
        String sql = "UPDATE tb_user SET name = ? , gender = ? , age = ? , password = ?, birthday = ?, telephone = ? where id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getGender());
            preparedStatement.setInt(3, user.getAge());
            preparedStatement.setString(4, user.getPassword());
            preparedStatement.setString(5, user.getBirthday());
            preparedStatement.setString(6, user.getTelephone());
            preparedStatement.setInt(7, user.getId());
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    //删除用户信息
    public boolean deleteUserById(Integer id) {
        String sql = "delete from tb_user where id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

}
