package com.example.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.jetbrains.annotations.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "booking")
public class BookingTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_table_id")
    private Integer id;

    @Column(name = "book_date")
    private String date;

    @Column(name = "book_time")
    private String time;

    @Column(name = "book_type")
    private String type;

    @Column(name = "book_capacity")
    private int capacity;

    @Column(name = "book_Availability")
    private String avail;

    @Column(name = "book_Confirmation")
    private String confirmation;

    @Column(name = "user_id") // Add the userId column
    private Integer userId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getAvail() {
        return avail;
    }

    public void setAvail(String avail) {
        this.avail = avail;
    }

    public String getConfirmation() {
        return confirmation;
    }

    public void setConfirmation(String confirmation) {
        this.confirmation = confirmation;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "BookingTable [id=" + id + ", date=" + date + ", time=" + time + ", type=" + type + ", capacity="
                + capacity + ", avail=" + avail + ", confirmation=" + confirmation + ", userId=" + userId + "]";
    }

    public BookingTable(Integer id, String date, String time, String type, int capacity, String avail, String confirmation, Integer userId) {
        super();
        this.id = id;
        this.date = date;
        this.time = time;
        this.type = type;
        this.capacity = capacity;
        this.avail = avail;
        this.confirmation = confirmation;
        this.userId = userId;
    }

    public BookingTable() {

    }
}
