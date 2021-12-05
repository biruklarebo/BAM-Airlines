package edu.gsu.gui;

import edu.gsu.bizlogic.BizLogicProcess;
import edu.gsu.common.Customer;
import edu.gsu.common.VO;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class ExceptionHandler {

	public static boolean process(VO vo) {
		
		try {
			BizLogicProcess.process(vo);
			
		} catch (Exception ex) {
			
			
			  Alert alert = new Alert(AlertType.ERROR);
			  alert.setTitle("Error");
			  //alert.setHeaderText("Look, an Information Dialog");
			  alert.setContentText(ex.getMessage());
			  alert.getDialogPane().setStyle("-fx-font-family: 'serif'");
             

			  alert.showAndWait();
			  return false;
		}
		return true;
	}
}
