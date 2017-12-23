package com.haut.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * @author xxx_xx
 * @date 2017/12/21
 */
@Entity
@Table(name = "student")
public class Student {

    @GenericGenerator(name = "idgenerator", strategy = "native")
    @GeneratedValue(generator = "idgenerator")
    @Column(name = "id", unique = true, nullable = false)
    @Id
    private long id;
    @Column
    private String name;
    @Column
    private int age;

    public Student() {
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
