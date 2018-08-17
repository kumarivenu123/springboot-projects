package com.venu.hibernate.dao;

public class PaymentDAOFactory {
	public static PaymentDAO getInstance()
	{
		return new PaymentDAOImpl();
	}

}
