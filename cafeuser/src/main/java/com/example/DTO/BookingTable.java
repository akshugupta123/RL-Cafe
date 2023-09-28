package com.example.DTO;

public class BookingTable {

    private Integer id;
    private String date;
    private String time;
    private String type;
    private int capacity;
    private String avail;
    private String confirmation;
    private Integer userId; // Add the userId field

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
