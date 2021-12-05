package edu.gsu.gui;

import edu.gsu.bizlogic.BizLogicProcess;
import edu.gsu.common.Customer;
import edu.gsu.common.VO;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class ExceptionHandler {

	public static boolean process(VO vo) {
		
		try {
			Customer co = vo.getCustomer();
			BizLogicProcess.process(co);
			
		} catch (Exception ex) {
			
			  Alert alert = new Alert(AlertType.ERROR);
			  //alert.setTitle("Login Dialog");
			  //alert.setHeaderText("Look, an Information Dialog");
			  alert.setContentText(ex.getMessage());
			  
			  
			  alert.getDialogPane().setStyle("-fx-font-family: 'serif'");
             

			  alert.showAndWait();
			  return false;
		}
		
		return true;
		
		
		
	}
	
}
