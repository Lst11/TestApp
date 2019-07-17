package com.example.domain.entity;

public class Person implements DomainEntity {
    private String id;
    private String name;
    private String surname;
    private String phone;
    private int age;

    public Person(String id, String name, String surname, String phone, int age) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPhone() {
        return phone;
    }

    public int getAge() {
        return age;
    }
}
