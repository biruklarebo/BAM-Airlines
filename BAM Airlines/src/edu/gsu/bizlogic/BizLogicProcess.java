package edu.gsu.bizlogic;

import edu.gsu.common.Action;
import edu.gsu.common.Customer;
import edu.gsu.common.VO;
import edu.gsu.db.DBQueries;

public class BizLogicProcess 
{
	public static void process(VO vo, String message) throws Exception 
	{
		Customer co = vo.getCustomer();	
/*		switch (co.getAction()) 
		{
			case Action.LOGIN:
				DBQueries.login(vo);
				break;
			case Action.GET_FLIGHTS:
				DBQueries.getFlights(vo);
				break;
			case Action.CREATE_ACCOUNT:;
				DBQueries.createAccount(vo);
				break;
			// case Action.FORGOT_PASSWORD:;
				// DBQueries.forgotPassword(vo);
		}
		*/
		
		if (message == "CREATE_ACCOUNT") {
			DBQueries.createAccount(vo);
			System.out.println("checkpoint");
		}
	}
		// search flights
		// delete flights 
		// add flights
}
	
