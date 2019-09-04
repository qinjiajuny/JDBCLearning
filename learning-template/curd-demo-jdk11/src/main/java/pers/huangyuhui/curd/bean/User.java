package pers.huangyuhui.curd.bean;

/**
 * @project: curd-demo
 * @description: 用户基础信息
 * @author: 黄宇辉
 * @date: 8/22/2019-3:22 PM
 * @version: 1.0
 * @website: https://yubuntu0109.github.io/
 */
public class User {
    private Integer id;
    private String name;
    private Integer age;
    private String gender;
    private String password;
    private String telephone;
    private String birthday;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", password='" + password + '\'' +
                ", telephone='" + telephone + '\'' +
                ", birthday='" + birthday + '\'' +
                '}';
    }
}