package com.parawan.model;

import javax.persistence.*;

@Entity
@Table(name = "items")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name ="abbreviation")
    private String abbreviation;

    @Column(name = "quantity")
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "beach_id")
    private Beach beach;

    public Item(String name, String abbreviation, int quantity, Beach beach) {
        this.name = name;
        this.abbreviation = abbreviation;
        this.quantity = quantity;
        this.beach = beach;
    }

    public Item() {
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Beach getBeach() {
        return beach;
    }

    public void setBeach(Beach beach) {
        this.beach = beach;
    }
}
