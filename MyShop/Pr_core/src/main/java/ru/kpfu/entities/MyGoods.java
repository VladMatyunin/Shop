package ru.kpfu.entities;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Основная информация о товаре
 *
 * Gataullin Kamil
 * 22.02.2016 22:54
 */
@Entity
@Table(name = "goods")
public class MyGoods {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;
    private String imageUrl;
    @ManyToOne
    private MyCategory category;
    private BigDecimal price;
    public MyGoods() {
    }

    public MyGoods(Long id) {
        this.id = id;
    }

    public MyGoods(Long id, String name, MyCategory category, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public MyGoods(Long id, String name, String imageUrl, MyCategory category, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.imageUrl = imageUrl;
        this.category = category;
        this.price = price;
    }

    public MyGoods(Long id, String name, String description, String imageUrl, MyCategory category, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.imageUrl = imageUrl;
        this.category = category;
        this.price = price;
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

    public String getDecoratedName() {
        return "*** " + name + " ***";
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public MyCategory getCategory() {
        return category;
    }

    public void setCategory(MyCategory category) {
        this.category = category;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
