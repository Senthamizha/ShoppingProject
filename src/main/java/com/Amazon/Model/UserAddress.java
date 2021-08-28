package com.Amazon.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.Amazon.Repository.CommonRepo;

@Component
@Entity
@Table(name="user_address")
public class UserAddress{

	@Column(name="phone_number")
	private Long phone_number;
	@Id
    @Column
	private String userName;
	
	@Column(name="door_no")
	private Integer doorNo;
	@Column(name="street")
	private String street;
	
	@Column(name="city")
	private String city;
	
	@Column(name="state")
	private String state;
	
	@Column(name="pincode")
	private Integer pincode;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Integer getDoorNo() {
		return doorNo;
	}
	public void setDoorNo(Integer doorNo) {
		this.doorNo = doorNo;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Integer getPincode() {
		return pincode;
	}
	public void setPincode(Integer pincode) {
		this.pincode = pincode;
	}
	public Long getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(Long phone_number) {
		this.phone_number = phone_number;
	}
	public UserAddress(String userName, Integer doorNo, String street, String city, String state, Integer pincode,
			Long phone_number) {
		super();
		this.userName = userName;
		this.doorNo = doorNo;
		this.street = street;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
		this.phone_number = phone_number;
	}
	
	public UserAddress(Integer doorNo, String street, String city, String state, Integer pincode,
			Long phone_number) {
		super();
		this.doorNo = doorNo;
		this.street = street;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
		this.phone_number = phone_number;
	}
	public UserAddress() {
		super();
		// TODO Auto-generated constructor stub
	}

}
