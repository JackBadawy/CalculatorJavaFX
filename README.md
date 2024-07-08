# JavaFX Calculator Application

![Screenshot](src/img.png)

## Overview

This project is a calculator application built using JavaFX. The goal of this project is to become more familiar with Java,JavaFX, generics, and to create a visually appealing desktop application.

## Features

- Basic calculator functionality (number input and display).
- Unit & e2e testing.
- Simple and intuitive user interface designed with Scene Builder.
- Dynamic number display based on button presses.
- Basic arithmetic operations (addition, subtraction, multiplication, division).
- Handling division by zero with appropriate error message display.

## Change Log

### Initial Commit

- Set up the project structure.
- Added basic FXML layout with buttons for digits 0-9 and a display area.

### [05/07/2024]

- **Added FXML IDs and Event Handlers**
  - Added `fx:id` attributes to buttons and display text in FXML file.
  - Implemented `handleButtonAction` method to capture button presses and update the display.
  - Used `Text` node to display numbers instead of directly adding text to the `Rectangle` node.
- **Logic for Displaying Numbers**
  - Implemented logic to handle button presses and update the `Text` node.
  - Prevented leading zeros in the display.
- **Code Refinement**
  - Corrected string comparison in the `handleButtonAction` method using `.equals()` method.

### [05/07/2024] - Update 2

- **Arithmetic Operations**
  - Added buttons for basic arithmetic operations (+, -, \*, /) and connected them to the controller.
  - Implemented logic to handle arithmetic operations in `handleOperationButtonClick`.
- **Switch Expression for Operations**
  - Refactored `performMathsOperation` method to use a switch expression for cleaner code.
  - Added error handling for division by zero and displayed appropriate error messages.
- **Equals Button Logic**
  - Implemented `handleEqualsClick` method to perform the arithmetic operation and display the result.
  - Updated `currentInputNumber` after performing the operation to allow further calculations on the result.
  - Added error handling for non-numeric input in `performMathsOperation`.

### [05/07/2024] - Update 3

- **Styling**
  - Added `application.css` to style the calculator application.
  - Set fixed size for buttons (40px width, 32px height) and styled buttons with grey background, white text, and rounded borders.
- **Display Enhancements**
  - Centered display text inside a rectangle using `StackPane`.
  - Made display text bold for better visibility.
- **Layout Improvements**
  - Ensured all elements are horizontally centered within the window.
  - Organized number buttons and operation buttons in a structured layout for better usability.

### [05/07/2024] - Update 4

- **Enhanced Mathematical Operations**
  - Added square root and squaring functionality.
  - Ensured proper error handling for invalid operations (e.g., division by zero, square root of a negative number).
- **User Interface Enhancements**
  - Added custom title bar with close button and drag functionality.
  - Styled the calculator buttons and display area using CSS.
  - Ensured the user interface elements are properly aligned and centered.
- **Testing**
  - Added JUnit tests for controller logic.
  - Implemented JavaFX environment initialization for tests.
  - Added end-to-end tests for handling equals, clear, and toggle charge functionalities.

## Getting Started

### Prerequisites

- JDK 17 or higher
- JavaFX SDK
- IDE with JavaFX support (e.g., IntelliJ IDEA, Eclipse)

### Installation

1. Clone the repository:
   ```bash
   git clone git@github.com:JackBadawy/CalculatorJavaFX.git
   ```
2. Open the project in your IDE.
3. Ensure JavaFX SDK is configured in your project settings.
4. Run the Main class to start the application.

### Goals

Gain hands-on experience with JavaFX.
Better understand and implement generics in Java.
Develop a visually appealing desktop application.
