package com.employeemanagement.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Address implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer addressID;

	private String fatherName;

	private String villageName;

	private String mandalName;

	private String distictName;

	private Integer pinCode;

	public Integer getAddressID() {
		return addressID;
	}

	public void setAddressID(Integer addressID) {
		this.addressID = addressID;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getVillageName() {
		return villageName;
	}

	public void setVillageName(String villageName) {
		this.villageName = villageName;
	}

	public String getMandalName() {
		return mandalName;
	}

	public void setMandalName(String mandalName) {
		this.mandalName = mandalName;
	}

	public String getDistictName() {
		return distictName;
	}

	public void setDistictName(String distictName) {
		this.distictName = distictName;
	}

	public Integer getPinCode() {
		return pinCode;
	}

	public void setPinCode(Integer pinCode) {
		this.pinCode = pinCode;
	}

	public Address() {
	}

	public Address(Integer addressID, String fatherName, String villageName, String mandalName, String distictName,
			Integer pinCode) {
		this.addressID = addressID;
		this.fatherName = fatherName;
		this.villageName = villageName;
		this.mandalName = mandalName;
		this.distictName = distictName;
		this.pinCode = pinCode;
	}

	@Override
	public String toString() {
		return "Address [addressID=" + addressID + ", fatherName=" + fatherName + ", villageName=" + villageName
				+ ", mandalName=" + mandalName + ", distictName=" + distictName + ", pinCode=" + pinCode + "]";
	}

}
