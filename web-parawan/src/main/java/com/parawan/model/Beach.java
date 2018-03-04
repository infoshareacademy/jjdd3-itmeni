package com.parawan.model;

import com.parawan.Place;
import com.parawan.PlaceStatus;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "beaches")
public class Beach {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

/*    private List<Place> places = new ArrayList();*/

    @Column(name = "maxWidth")
    private Integer maxWidth;

    @Column(name = "maxHeight")
    private Integer maxHeight;

    private Integer hourOfStatus;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
/*
    public List<Place> getPlaces() {
        return places;
    }

    public void setPlaces(List<Place> places) {
        this.places = places;

    }
*/
    public Beach(String name, int maxWidth, int maxHeight) {
        this.name = name;
        this.maxWidth = maxWidth;
        this.maxHeight = maxHeight;

        //createPlaces();
    }

    public Integer getHourOfStatus() {
        return hourOfStatus;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHourOfStatus(Integer hourOfStatus) {
        this.hourOfStatus = hourOfStatus;
    }

    public int getMaxWidth() {
        return maxWidth;
    }

    public int getMaxHeight() {
        return maxHeight;
    }


    public void setMaxWidth(Integer maxWidth) {
        this.maxWidth = maxWidth;
    }

    public void setMaxHeight(Integer maxHeight) {
        this.maxHeight = maxHeight;
    }
/*
    public void createPlaces() {
        this.places.clear();
        int x = 0;
        int y = 0;
        for (int i = 0; i < (maxWidth * maxHeight); i++) {

            Place place = new Place((i + 1), x, y, PlaceStatus.FREE);
            places.add(place);
            x++;

            if (x >= maxWidth) {
                x = 0;
                y++;
            }
        }
    }
*//*
    public Place getPlaceByXY(int x, int y) {
        Place place = null;
        for (int i = 0; i < places.size(); i++) {
            if ((places.get(i).getX() == x) && (places.get(i).getY() == y)) {
                place = places.get(i);
            }
        }
        return place;
    }*/
}
