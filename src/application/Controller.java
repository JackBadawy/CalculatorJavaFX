package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class Controller {
// have btn presses = adding num to input and maybe top bar txt 
	@FXML
	private Button btn1;
	@FXML
	private Button btn2;
	@FXML
	private Button btn3;
	@FXML
	private Button btn4;
	@FXML
	private Button btn5;
	@FXML
	private Button btn6;
	@FXML
	private Button btn7;
	@FXML
	private Button btn8;
	@FXML
	private Button btn9;
	@FXML
	private Button btn0;
	@FXML
	private Rectangle numDisplay;
	@FXML
    private Text displayText;
	
	private StringBuilder currentInputNumber = new StringBuilder();
	
	@FXML
    public void handleButtonAction(javafx.event.ActionEvent event) {
		
        Button clickedButton = (Button) event.getSource();
        String buttonText = clickedButton.getText();
        if (currentInputNumber.isEmpty() && buttonText.equals("0")) {return;}
        currentInputNumber.append(buttonText);
        renderDisplayedNumber();
    }
	
	public void renderDisplayedNumber() {
        displayText.setText(currentInputNumber.toString());
    }
	
}
