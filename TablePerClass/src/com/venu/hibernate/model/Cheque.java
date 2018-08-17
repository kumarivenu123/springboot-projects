package com.venu.hibernate.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "cheque")
@DiscriminatorValue("CH")
public class Cheque extends Payment {
	@Column(name = "chno")
	private int chequeNumber;
	@Column(name = "chtype", length = 8)
	private String chequeType;

	public int getChequeNumber() {
		return chequeNumber;
	}

	public void setChequeNumber(int chequeNumber) {
		this.chequeNumber = chequeNumber;
	}

	public String getChequeType() {
		return chequeType;
	}

	public void setChequeType(String chequeType) {
		this.chequeType = chequeType;
	}
}
