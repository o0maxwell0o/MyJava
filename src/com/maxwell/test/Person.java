package com.maxwell.test;

public class Person {
    //测试类
    private String name;
    private String gender;
    private int age;

    public Person() {

    }

    public Person(String name, String gender, int age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    //getter和setter方法
    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String toString() {
        return "姓名:" + name + "  性别:" + gender + "  年龄:" + age;
    }

}
