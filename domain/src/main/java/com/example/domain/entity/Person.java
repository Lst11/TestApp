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

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("ID:" + this.id + ";");
        result.append(" Name:" + this.name + ";");
        result.append(" Surname:" + this.surname + ";");
        result.append(" Phone:" + this.phone + ";");
        result.append(" Age:" + this.age + "\n");

        return result.toString();
    }
}
