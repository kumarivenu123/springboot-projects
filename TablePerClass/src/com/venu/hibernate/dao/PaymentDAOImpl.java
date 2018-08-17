package com.venu.hibernate.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.venu.hibernate.model.Card;
import com.venu.hibernate.model.Cheque;
import com.venu.hibernate.util.HibernateUtil;

public class PaymentDAOImpl implements PaymentDAO {

	@Override
	public void saveCard(Card card) {
		SessionFactory factory=HibernateUtil.getSessionFactory();
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		session.save(card);
		tx.commit();
		session.close();
	}

	@Override
	public void saveCheque(Cheque cheque) {
		SessionFactory factory=HibernateUtil.getSessionFactory();
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		session.save(cheque);
		tx.commit();
		session.close();

	}

}
