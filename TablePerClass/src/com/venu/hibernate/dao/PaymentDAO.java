package com.venu.hibernate.dao;

import com.venu.hibernate.model.Card;
import com.venu.hibernate.model.Cheque;

public interface PaymentDAO {
	void saveCard(Card card);
	void saveCheque(Cheque cheque);
}
