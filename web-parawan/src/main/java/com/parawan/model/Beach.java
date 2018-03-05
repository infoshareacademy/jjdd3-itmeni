package com.parawan.model;

import com.parawan.Place;
import com.parawan.PlaceStatus;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "beaches")
public class Beach {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "maxWidth")
    private Integer maxWidth;

    @Column(name = "maxHeight")
    private Integer maxHeight;

    @OneToMany(mappedBy = "beach", fetch = FetchType.EAGER)
    private Set<Reservation> reservations;

    public Beach() {
    }

    public Beach(Long id, String name, Integer maxWidth, Integer maxHeight) {
        this.id = id;
        this.name = name;
        this.maxWidth = maxWidth;
        this.maxHeight = maxHeight;
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

    public Integer getMaxWidth() {
        return maxWidth;
    }

    public void setMaxWidth(Integer maxWidth) {
        this.maxWidth = maxWidth;
    }

    public Integer getMaxHeight() {
        return maxHeight;
    }

    public void setMaxHeight(Integer maxHeight) {
        this.maxHeight = maxHeight;
    }

    public Set<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(Set<Reservation> reservations) {
        this.reservations = reservations;
    }
}