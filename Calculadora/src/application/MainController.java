package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Button;

public class MainController {
	
	@FXML
	private Label result;
	private long numero1 = 0;
	private String operador = "";
	private boolean start = true;
	private ModalClass modalClass = new ModalClass();
	
	@FXML
	public void apagarBotao(ActionEvent evento) {
		if (start) {
		result.setText(null);
		start = false;
		}
	}

	@FXML
	public void processamentoNum(ActionEvent evento){
		if (start) {
			result.setText("");
			start = false;
		}
		String value = ((Button)evento.getSource()).getText();
		result.setText(result.getText()+ value);
	}
	
	@FXML
	public void processamentoOpe(ActionEvent evento) {
		String value = ((Button)evento.getSource()).getText();
		
		if (!value.equals("=")) {
			if (!operador.isEmpty())
				return;
			
			operador = value;
			numero1 = Long.parseLong(result.getText());
			result.setText("");
		} else {
			if (operador.isEmpty())
				return;
			long numero2 = Long.parseLong(result.getText());
			float output = modalClass.calculo(numero1, numero2, operador);
			result.setText(String.valueOf(output));
			operador = "";
			start = true;
		}
	}
}
