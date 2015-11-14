package com.kirill.app.models;

import javax.persistence.*;

/**
 * Created by Admin
 *
 * @author Admin
 * @since 10.11.2015
 */
@Entity
@Table(name = "animals", catalog = "zoo_db")
public class Animals {

    private int id;
    private String type;
    private String name;
    private Integer price;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "name", unique = false, nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "price", unique = false, nullable = false)
    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Column(name = "type", unique = false, nullable = false)
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Animals)) return false;

        Animals animals = (Animals) o;

        if (getId() != animals.getId()) return false;
        if (!getType().equals(animals.getType())) return false;
        if (!getName().equals(animals.getName())) return false;
        return getPrice().equals(animals.getPrice());

    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + getType().hashCode();
        result = 31 * result + getName().hashCode();
        result = 31 * result + getPrice().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Animals{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
