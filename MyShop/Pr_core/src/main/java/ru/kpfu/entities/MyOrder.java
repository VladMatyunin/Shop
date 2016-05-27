package ru.kpfu.entities;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Vlad.M on 26.04.2016.
 */
@Entity
@Table(name = "orders")
public class MyOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private MyUser user;
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "items_id1")
    private List<MyCartItem> items;

    public MyOrder(){

    }
    public MyOrder(MyUser user, MyCart cart){
        this.user = user;
    }

    public MyUser getUser() {
        return user;
    }

    public void setUser(MyUser user) {
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<MyCartItem> getItems() {
        return items;
    }

    public void setItems(List<MyCartItem> items) {
        this.items = items;
    }
}
