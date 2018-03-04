package com.parawan.model;


import javax.persistence.*;

@Entity
@Table(name = "reservations")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long idOfReservation;

    @Column(name = "hour")
    private Integer hourOfReservation;

    @Column(name = "place_id")
    private Integer placeId;

    @Column(name = "rented_items")
    private String rentedItems;

    @Column(name = "name_of_person")
    private String nameOfPerson;


    public Reservation(Long idOfReservation, Integer hourOfReservation, Integer placeId, String rentedItems, String nameOfPerson) {
        this.idOfReservation = idOfReservation;
        this.hourOfReservation = hourOfReservation;
        this.placeId = placeId;
        this.rentedItems = rentedItems;
        this.nameOfPerson = nameOfPerson;
    }

    public Reservation() {
    }

    public Long getIdOfReservation() {
        return idOfReservation;
    }

    public void setIdOfReservation(Long idOfReservation) {
        this.idOfReservation = idOfReservation;
    }

    public String getRentedItems() {
        return rentedItems;
    }

    public void setRentedItems(String rentedItems) {
        this.rentedItems = rentedItems;
    }

    public Integer getHourOfReservation() {
        return hourOfReservation;
    }

    public void setHourOfReservation(Integer hourOfReservation) {
        this.hourOfReservation = hourOfReservation;
    }

    public Integer getPlaceId() {
        return placeId;
    }

    public void setPlaceId(Integer placeId) {
        this.placeId = placeId;
    }


    public String getNameOfPerson() {
        return nameOfPerson;
    }

    public void setNameOfPerson(String nameOfPerson) {
        this.nameOfPerson = nameOfPerson;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Reservation)) {
            return false;
        }
        Reservation r = (Reservation) o;
        return (Integer.compare(this.hourOfReservation, r.hourOfReservation) == 0 &&
                Integer.compare(this.placeId, r.placeId) == 0);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Reservation{");
        sb.append("idOfReservation=").append(idOfReservation);
        sb.append(", hourOfReservation=").append(hourOfReservation);
        sb.append(", placeId=").append(placeId);
        sb.append(", rentedItems='").append(rentedItems).append('\'');
        sb.append(", nameOfPerson='").append(nameOfPerson).append('\'');
        sb.append('}');
        return sb.toString();
    }
}

