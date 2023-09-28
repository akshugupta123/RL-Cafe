package com.BookingTableController.domain;

//import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Entity
//@Table(name = "Booking")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookingTableController {
    
	 public Integer getId() {
			return id;
		}
	 public BookingTableController(Integer id, String date, String time, String type, Integer capacity, String availability, String confirmation) {
			super();

	
		this.id = id;
		this.date = date;
		this.time = time;
		this.type = type;
		this.capacity = capacity;
		this.availability = availability;
		this.confirmation = confirmation;
	}

//	public BookingTableController(Integer id2, String date2, String time2, String type, Integer capacity2,String availability2, String confirmation2) {
		// TODO Auto-generated constructor stub
//	}

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

	public void setTime(String Time, String time) {
		this.time = time;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getCapacity() {
		return capacity;
	}

	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}

	public String getAvailability() {
		return availability;
	}

	public void setAvailability(String availability) {
		this.availability = availability;
	}
	
	public String getConfirmation() {
		return confirmation;
	}

	public void setConfirmation(String confirmation) {
		this.confirmation = confirmation;
	}
	
	@Override
    public String toString() {
		 return "BookingTable  [id=" + id + ", date=" + date + ", time=" + time +
	                ", type=" + type + ", capacity=" + capacity + ",availability=" +availability + ",confirmation=" + confirmation +"]";
	    }
	//@Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer id;
    
    private String date;
    
    private String time;
    
    private String type;
    
    private Integer capacity;
    
    private String availability;

    private String confirmation;



	
	

}