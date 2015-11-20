package com.kirill.app.models;

import javax.persistence.*;

/**
 * Created by Admin
 *
 * @author Admin
 * @since 17.11.2015
 */
@Entity
@Table(name = "food", catalog = "zoo_db")
public class Food {

    private Integer id;
    private String title;
    private Integer weight;
    private Integer price;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "price", unique = true, nullable = false)
    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Column(name = "title", unique = true, nullable = false)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name = "weight", unique = true, nullable = false)
    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Food)) return false;

        Food food = (Food) o;

        if (!getId().equals(food.getId())) return false;
        if (!getTitle().equals(food.getTitle())) return false;
        if (!getWeight().equals(food.getWeight())) return false;
        return getPrice().equals(food.getPrice());

    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + getTitle().hashCode();
        result = 31 * result + getWeight().hashCode();
        result = 31 * result + getPrice().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Food{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", weight=" + weight +
                ", price=" + price +
                '}';
    }
}
