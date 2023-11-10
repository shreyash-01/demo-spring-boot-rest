package com.example.demospringbootrest.users;

public class User {
    private Integer userID;
    private String name;
    private Integer age;

    public User(Integer userID, String name, Integer age) {
        this.userID = userID;
        this.name = name;
        this.age = age;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
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

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
