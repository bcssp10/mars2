package com.codentech.mars2.room;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Transient;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.Type;
import org.springframework.data.annotation.LastModifiedDate;

import com.codentech.mars2.enumeration.RoomStatus;
import com.codentech.mars2.room.type.RoomType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Room {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "room_generator")
	@SequenceGenerator(name="room_generator", sequenceName = "room_seq",initialValue=1, allocationSize=1)
	@Column(name="id",nullable=false,updatable=false)
	private Integer id;
	
	@Column(unique=true,nullable=false,columnDefinition="varchar(10)")
	private String number;
	
	@Column(columnDefinition="varchar(20)")
	private String floor;
	
	//@Transient
	@Column(name="roomtype_id",updatable=false,insertable=false)
	@JsonIgnore
	private Integer roomTypeId; 

	@ManyToOne(fetch=FetchType.LAZY,optional=false)
	@JoinColumn(name="roomtype_id")
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private RoomType roomType; 
	
	@Enumerated(EnumType.STRING)
	private RoomStatus status; // change String to Enum
	
	@Column(columnDefinition = "text")
	private String notes;
	
	@LastModifiedDate
	private LocalDate lastCheckout;
	
	@Type(type="yes_no")
	private Boolean isActive;
	
	@Type(type="yes_no")
	private Boolean isDeleted;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getFloor() {
		return floor;
	}

	public void setFloor(String floor) {
		this.floor = floor;
	}
	
	public RoomType getRoomType() {
		return roomType;
	}

	public void setRoomType(RoomType type) {
		this.roomType = type;
	}

	public RoomStatus getStatus() {
		return status;
	}

	public void setStatus(RoomStatus status) {
		this.status = status;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public LocalDate getLastCheckout() {
		return lastCheckout;
	}

	public void setLastCheckout(LocalDate lastCheckout) {
		this.lastCheckout = lastCheckout;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	@JsonProperty("__roomType__id")
	public Integer getRoomTypeId() {
		return roomTypeId;
	}

	@JsonIgnore
	public void setRoomTypeId(Integer roomTypeId) {
		this.roomTypeId = roomTypeId;
	}


}
