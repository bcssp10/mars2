package com.codentech.mars2.reservation;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Type;

import com.codentech.mars2.customer.Customer;
import com.codentech.mars2.room.Room;

@Entity
public class Reservation {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	@ManyToOne(fetch=FetchType.EAGER,optional=false)
	@JoinColumn(name="roomId")
	private Room room; 
	
	private Double roomRate;
	
	@ManyToOne(fetch=FetchType.EAGER,optional=false)
	@JoinColumn(name="customerId")
	private Customer customer;
	
	private String resStatus;
	
	private LocalDate resDate;
	
	private LocalDate checkIn;

	private LocalDate checkout;
	
	private int noOfGuests;
	
	private String guestInfo;
	
	private String stayPurpose;
	
	private String referenceCompany;
	
	private Boolean pickup;
	
	private String pickFrom;
	
	private String pickCareer;
	
	private Boolean drop;

	private String dropFrom;
	
	private String dropCareer;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room roomId) {
		this.room = roomId;
	}

	public Double getRoomRate() {
		return roomRate;
	}

	public void setRoomRate(Double roomRate) {
		this.roomRate = roomRate;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customerId) {
		this.customer = customerId;
	}

	public String getResStatus() {
		return resStatus;
	}

	public void setResStatus(String resStatus) {
		this.resStatus = resStatus;
	}

	public LocalDate getResDate() {
		return resDate;
	}

	public void setResDate(LocalDate resDate) {
		this.resDate = resDate;
	}

	public LocalDate getCheckIn() {
		return checkIn;
	}

	public void setCheckIn(LocalDate checkIn) {
		this.checkIn = checkIn;
	}

	public LocalDate getCheckout() {
		return checkout;
	}

	public void setCheckout(LocalDate checkout) {
		this.checkout = checkout;
	}

	public int getNoOfGuests() {
		return noOfGuests;
	}

	public void setNoOfGuests(int noOfGuests) {
		this.noOfGuests = noOfGuests;
	}

	public String getGuestInfo() {
		return guestInfo;
	}

	public void setGuestInfo(String guestInfo) {
		this.guestInfo = guestInfo;
	}

	public String getStayPurpose() {
		return stayPurpose;
	}

	public void setStayPurpose(String stayPurpose) {
		this.stayPurpose = stayPurpose;
	}

	public String getReferenceCompany() {
		return referenceCompany;
	}

	public void setReferenceCompany(String referenceCompany) {
		this.referenceCompany = referenceCompany;
	}

	public Boolean getPickup() {
		return pickup;
	}

	public void setPickup(Boolean pickup) {
		this.pickup = pickup;
	}

	public String getPickFrom() {
		return pickFrom;
	}

	public void setPickFrom(String pickFrom) {
		this.pickFrom = pickFrom;
	}

	public String getPickCareer() {
		return pickCareer;
	}

	public void setPickCareer(String pickCareer) {
		this.pickCareer = pickCareer;
	}

	public Boolean getDrop() {
		return drop;
	}

	public void setDrop(Boolean drop) {
		this.drop = drop;
	}

	public String getDropFrom() {
		return dropFrom;
	}

	public void setDropFrom(String dropFrom) {
		this.dropFrom = dropFrom;
	}

	public String getDropCareer() {
		return dropCareer;
	}

	public void setDropCareer(String dropCareer) {
		this.dropCareer = dropCareer;
	}
	
}