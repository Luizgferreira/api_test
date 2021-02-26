package org.example.JPAtest;

import javax.persistence.*;

@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int age;
    @ManyToOne
    private City city;

    public Person() {
    }

    public Person(String name, int age, City city) {
        //super();
        this.name = name;
        this.age = age;
        this.city = city;
    }

    public Person(String name, int age) {
        //super();
        //this.id = id;
        this.name = name;
        this.age = age;
        //this.city = city;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
}
