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
	private StringBuilder previousInputNumber = new StringBuilder();
	
	private char currentOperation;
	
	@FXML
	public void handleClearClick() {
		previousInputNumber.setLength(0);
		currentInputNumber.setLength(0);
		renderDisplayedNumber();
	}
	
	@FXML
    public void handleNumberButtonClick(javafx.event.ActionEvent event) {
		
        Button clickedButton = (Button) event.getSource();
        String buttonText = clickedButton.getText();
        if (currentInputNumber.isEmpty() && buttonText.equals("0")) {return;}
        currentInputNumber.append(buttonText);
        renderDisplayedNumber();
    }
	
	public void renderDisplayedNumber() {
        displayText.setText(currentInputNumber.toString());
    }
	
	@FXML
    public void handleOperationButtonClick(javafx.event.ActionEvent event) {
        Button clickedButton = (Button) event.getSource();
        currentOperation = clickedButton.getText().charAt(0);
        previousInputNumber.setLength(0);
        previousInputNumber.append(currentInputNumber);
        currentInputNumber.setLength(0); 
        renderDisplayedNumber();
    }
	
	@FXML
	public void handleEqualsClick() {
		float result = performMathsOperation();
		displayText.setText(Float.toString(result));
		previousInputNumber.setLength(0);
		currentInputNumber.setLength(0);
		currentInputNumber.append(result);
	}
	
	public float performMathsOperation() {
        float num1 = Float.parseFloat(previousInputNumber.toString());
        float num2 = Float.parseFloat(currentInputNumber.toString());

        return switch (currentOperation) {
            case '+' -> num1 + num2;
            case '-' -> num1 - num2;
            case '*' -> num1 * num2;
            case '/' -> {
                if (num2 != 0) {
                    yield num1 / num2;
                } else {
                	displayText.setText("Cannot divide by zero");
                    System.out.println("Cannot divide by zero");
                    yield 0; 
                }
            }
            default -> {
                System.out.println("Unknown operation: " + currentOperation);
                yield 0; 
            }
        };
    }
	
}
