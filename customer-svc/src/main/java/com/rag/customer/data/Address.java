package com.rag.customer.data;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Nonnull
    private String street;
    @Nonnull
    private String city;
    @Nonnull
    private String state;
    @Nonnull
    private String zip;
    @Nonnull
    private String country;

    @Setter
    @Getter
    @OneToOne
    @JoinColumn(name = "customer_id")
    Customer customer;

    public Address() {

    }

    public Address(@Nonnull String street, @Nonnull String city, @Nonnull String state, @Nonnull String zip, @Nonnull String country) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.country = country;
    }

    @Nonnull
    public String getCountry() {
        return country;
    }

    public void setCountry(@Nonnull String country) {
        this.country = country;
    }

    @Nonnull
    public String getZip() {
        return zip;
    }

    public void setZip(@Nonnull String zip) {
        this.zip = zip;
    }

    @Nonnull
    public String getState() {
        return state;
    }

    public void setState(@Nonnull String state) {
        this.state = state;
    }

    @Nonnull
    public String getCity() {
        return city;
    }

    public void setCity(@Nonnull String city) {
        this.city = city;
    }

    @Nonnull
    public String getStreet() {
        return street;
    }

    public void setStreet(@Nonnull String street) {
        this.street = street;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}