package edu.gsu.bizlogic;

import edu.gsu.common.Action;
import edu.gsu.common.Customer;
import edu.gsu.common.VO;
import edu.gsu.db.DBQueries;

public class BizLogicProcess {
	public static void process(VO vo) throws Exception {
		Customer co = vo.getCustomer();	
		switch (co.getAction()) {
			case Action.LOGIN:
				DBQueries.login(vo);
				break;
			case Action.GET_FLIGHTS:
				DBQueries.getFlights(co);
				break;
			case Action.createAccount(co);
				DBQueries.createAccount(vo);
				break;
		}
		*/
	
		//search flight
		//delete 
		//	
	// }
	
}
