package com.parawan.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "beaches")
public class Beach {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name = "";

    @Column(name = "max_width")
    private int maxWidth;

    @Column(name = "max_height")
    private int maxHeight;

    @OneToMany(mappedBy = "beach", fetch = FetchType.EAGER)
    private Set<Reservation> reservations;

    public Beach() {
    }

    public Beach(Integer id, String name, Integer maxWidth, Integer maxHeight) {
        this.id = id;
        this.name = name;
        this.maxWidth = maxWidth;
        this.maxHeight = maxHeight;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Beach{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", maxWidth=").append(maxWidth);
        sb.append(", maxHeight=").append(maxHeight);
        sb.append(", reservations=").append(reservations);
        sb.append('}');
        return sb.toString();
    }
}