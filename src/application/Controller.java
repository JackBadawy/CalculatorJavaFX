package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import operations.Operation;
import operations.Addition;
import operations.Division;
import operations.Multiplication;
import operations.Subtraction;
import java.util.HashMap;
import java.util.Map;

public class Controller {
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
    private final Map<Character, Operation<Float>> operations = new HashMap<>();

    public Controller() {
        operations.put('+', new Addition());
        operations.put('-', new Subtraction());
        operations.put('*', new Multiplication());
        operations.put('/', new Division());
    }

    @FXML
    public void handleClearClick() {
        clearInput();
    }

    @FXML
    public void handleNumberButtonClick(javafx.event.ActionEvent event) {
        appendNumber(((Button) event.getSource()).getText());
    }

    @FXML
    public void handleOperationButtonClick(javafx.event.ActionEvent event) {
        setOperation(((Button) event.getSource()).getText().charAt(0));
    }

    @FXML
    public void handleEqualsClick() {
        try {
            float result = performMathsOperation();
            displayText.setText(Float.toString(result));
            clearInput();
            currentInputNumber.append(result);
        } catch (ArithmeticException e) {
            displayText.setText(e.getMessage());
        }
    }

    private void clearInput() {
        previousInputNumber.setLength(0);
        currentInputNumber.setLength(0);
        renderDisplayedNumber();
    }

    private void appendNumber(String number) {
        if (currentInputNumber.length() == 0 && number.equals("0")) {
            return;
        }
        currentInputNumber.append(number);
        renderDisplayedNumber();
    }

    private void setOperation(char operation) {
        currentOperation = operation;
        if (currentOperation == 's' || currentOperation == '^') {
            float result = performUnaryOperation();
            displayText.setText(Float.toString(result));
            currentInputNumber.setLength(0);
            currentInputNumber.append(result);
        } else {
            previousInputNumber.setLength(0);
            previousInputNumber.append(currentInputNumber);
            currentInputNumber.setLength(0);
            renderDisplayedNumber();
        }
    }

    private float performMathsOperation() {
        float num1 = previousInputNumber.length() > 0 ? Float.parseFloat(previousInputNumber.toString()) : 0;
        float num2 = currentInputNumber.length() > 0 ? Float.parseFloat(currentInputNumber.toString()) : 0;
        Operation<Float> operation = operations.get(currentOperation);
        if (operation == null) {
            throw new IllegalStateException("Unknown operation: " + currentOperation);
        }
        return operation.apply(num1, num2);
    }

    private float performUnaryOperation() {
        float num = currentInputNumber.length() > 0 ? Float.parseFloat(currentInputNumber.toString()) : 0;
        return switch (currentOperation) {
            case 's' -> num * num;
            case '^' -> num >= 0 ? (float) Math.sqrt(num) : handleInvalidSquareRoot();
            default -> throw new IllegalStateException("Unknown unary operation: " + currentOperation);
        };
    }

    private float handleInvalidSquareRoot() {
        System.out.println("Cannot take square root of negative number");
        return Float.NaN;
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

    private void renderDisplayedNumber() {
        displayText.setText(currentInputNumber.toString());
    }
}
