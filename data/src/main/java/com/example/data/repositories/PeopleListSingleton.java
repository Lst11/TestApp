package com.example.data.repositories;

import com.example.domain.entity.Person;

import java.util.ArrayList;

public class PeopleListSingleton {

    public ArrayList<Person> list = new ArrayList<Person>() {{
        add(new Person("0", "Peter", "Parker", "https://cdn.vox-cdn.com/thumbor/3LI5EGLK1lbgApqkw06rr_x2h5U=/0x0:655x365/1200x800/filters:focal(249x23:353x127)/cdn.vox-cdn.com/uploads/chorus_image/image/55356661/spider_man_homecoming.0.jpg", 19));
        add(new Person("1", "Bruce", "Wayne", "https://cdn2us.denofgeek.com/sites/denofgeekus/files/styles/main_wide/public/dark_knight_rises_1-1.jpg?itok=9hlbrPrv", 25));
        add(new Person("2", "Tony", "Stark", "https://www.hindustantimes.com/rf/image_size_960x540/HT/p2/2019/03/01/Pictures/_c9b4233e-3c26-11e9-a8d4-ce33a0cf3537.jpg", 37));
        add(new Person("3", "Selina", "Kyle", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT_y2elZwdxzLpyVvntn3UD5b9n1NqwfV0ZKFcUL5t15j-nQDeNAg", 24));
        add(new Person("4", "James", "Gordon", "https://www.dccomics.com/sites/default/files/GothamGordon_marquee_5abc68af0a6d29.02104411.jpg", 38));
    }};

    private static final PeopleListSingleton ourInstance = new PeopleListSingleton();

    public static PeopleListSingleton getInstance() {
        return ourInstance;
    }
}
