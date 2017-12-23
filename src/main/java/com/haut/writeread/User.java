package com.haut.writeread;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * @author xxx_xx
 * @date 2017/12/22
 */
@Entity
@Table(name = "user")
public class User {

    @GenericGenerator(name = "idgenerator", strategy = "native")
    @GeneratedValue(generator = "idgenerator")
    @Column(name = "id", unique = true, nullable = false)
    @Id
    private long id;
    @Column
    private String name;

    public User() {
    }

    public User(String name) {
        this.name = name;
    }

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
