package com.kirill.app.models;

import javax.persistence.*;

/**
 * Created by Admin
 *
 * @author Admin
 * @since 17.11.2015
 */
@Entity
@Table(name = "address", catalog = "zoo_db")
public class Address {

    private Integer id;
    private String country;
    private String street;
    private int zipCode;
    private User user;

    public Address() {
    }

    @Column(name = "country", unique = false, nullable = false)
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @OneToOne(fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn(name = "id", referencedColumnName = "address_id")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
//        this.id = user.getId();
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Address)) return false;

        Address address = (Address) o;

        if (getZipCode() != address.getZipCode()) return false;
        if (!getId().equals(address.getId())) return false;
        if (!getCountry().equals(address.getCountry())) return false;
        if (!getStreet().equals(address.getStreet())) return false;
        return getUser().equals(address.getUser());

    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + getCountry().hashCode();
        result = 31 * result + getStreet().hashCode();
        result = 31 * result + getZipCode();
        result = 31 * result + getUser().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", country='" + country + '\'' +
                ", street='" + street + '\'' +
                ", zipCode=" + zipCode +
                '}';
    }
}
