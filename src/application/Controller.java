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
        if (currentOperation == 's' || currentOperation == '^') {
            float result = performMathsOperation();
            displayText.setText(Float.toString(result));
            currentInputNumber.setLength(0);
            currentInputNumber.append(result);
            return;
        }
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
		float num1 = previousInputNumber.length() > 0 ? Float.parseFloat(previousInputNumber.toString()) : 0;
        float num2 = currentInputNumber.length() > 0 ? Float.parseFloat(currentInputNumber.toString()) : 0;

        return switch (currentOperation) {
            case '+' -> num1 + num2;
            case '-' -> num1 - num2;
            case '*' -> num1 * num2;
            case 's' -> num2 * num2;
            case '^' -> (sqrtChecker(num2)) ? (float) Math.sqrt(num2) : handleInvalidSquareRoot();
            case '/' -> (num2 != 0) ? num1 / num2 : handleDivideByZero();
            default -> {
                System.out.println("Unknown operation: " + currentOperation);
                yield 0; 
            }
        };
    }
	
	private boolean sqrtChecker(float base) {
		if (base <= 0) {
			return false;
		}
		return true;
	}
	
	private float handleInvalidSquareRoot() {
	    System.out.println("Cannot take square root of negative number");
	    return 0;
	}
	
	private float handleDivideByZero() {
	    displayText.setText("Cannot divide by zero");
	    System.out.println("Cannot divide by zero");
	    return 0;
	}
	
	 @FXML
	    public void handleSquareClick() {
	        if (currentInputNumber.length() > 0) {
	            float num = Float.parseFloat(currentInputNumber.toString());
	            num = num * num;
	            currentInputNumber.setLength(0);
	            currentInputNumber.append(num);
	            renderDisplayedNumber();
	        }
	    }

	    @FXML
	    public void handleSquareRootClick() {
	        if (currentInputNumber.length() > 0) {
	            float num = Float.parseFloat(currentInputNumber.toString());
	            if (num >= 0) {
	                num = (float) Math.sqrt(num);
	                currentInputNumber.setLength(0);
	                currentInputNumber.append(num);
	                renderDisplayedNumber();
	            } else {
	                displayText.setText("Invalid input for sqrt");
	                System.out.println("Cannot take square root of negative number");
	            }
	        }
	    }
	
	 @FXML
	    public void handleToggleChargeClick() {
	        if (currentInputNumber.length() > 0) {
	            if (currentInputNumber.charAt(0) == '-') {
	                currentInputNumber.deleteCharAt(0); 
	            } else {
	                currentInputNumber.insert(0, '-'); 
	            }
	            renderDisplayedNumber();
	        }
	    }
	
}
