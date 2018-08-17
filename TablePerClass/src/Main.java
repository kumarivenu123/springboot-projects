import java.util.Date;

import com.venu.hibernate.dao.PaymentDAO;
import com.venu.hibernate.dao.PaymentDAOFactory;
import com.venu.hibernate.model.Card;
import com.venu.hibernate.model.Cheque;

public class Main {

	public static void main(String[] args) {
		PaymentDAO dao = PaymentDAOFactory.getInstance();
		Card card = new Card();
		card.setTxId(1123221);
		card.setAmount(20000);
		card.setPaymentDate(new Date());
		card.setCardNumber(44432221);
		card.setCardType("VISA");

		dao.saveCard(card);

		Cheque cheque = new Cheque();
		cheque.setTxId(388383);
		cheque.setAmount(39999);
		cheque.setPaymentDate(new Date());
		cheque.setChequeNumber(3999902);
		cheque.setChequeType("order");

		dao.saveCheque(cheque);

	}

}
