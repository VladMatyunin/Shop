package ru.kpfu.entities;

import javax.persistence.*;

/**
 * Created by Vlad.M on 27.04.2016.
 */
@Entity
@Table(name = "cartitem")
public class MyCartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne(cascade = CascadeType.ALL)
    private MyGoods goods;
    private Integer number;
    public MyCartItem(){}
    public MyCartItem(MyGoods goods,Integer number){
        this.goods = goods;
        this.number = number;
    }
    public MyGoods getGoods() {
        return goods;
    }

    public void setGoods(MyGoods goods) {
        this.goods = goods;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}
