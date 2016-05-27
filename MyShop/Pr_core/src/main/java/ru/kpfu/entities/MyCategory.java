package ru.kpfu.entities;

import javax.persistence.*;

/**
 * Информация о категории
 *
 * Gataullin Kamil
 * 27.02.2016 0:48
 */
@Entity
@Table(name = "categories")
public class MyCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    public MyCategory() {
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
