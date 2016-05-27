package ru.kpfu.entities;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Vlad.M on 25.04.2016.
 */
@Entity
@Table(name = "cart")
public class MyCart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    /**
     * key - id товара, value - кол-во товара
     */
    public MyCart(MyUser user){
        this.user = user;
    }
    @OneToOne(cascade = CascadeType.ALL)
    private MyUser user;
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "items_id")
    private List<MyCartItem> items;
    public MyCart(){

    }


    public MyUser getUser() {
        return user;
    }

    public void setUser(MyUser user) {
        this.user = user;
    }


    public List<MyCartItem> getItems() {
        return items;
    }

    public void setItems(List<MyCartItem> items) {
        this.items = items;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
