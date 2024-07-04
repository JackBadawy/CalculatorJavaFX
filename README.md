# JavaFX Calculator Application

## Overview

This project is a calculator application built using JavaFX. The goal of this project is to become more familiar with Java,JavaFX, generics, and to create a visually appealing desktop application.

## Features

- Basic calculator functionality (number input and display).
- Simple and intuitive user interface designed with Scene Builder.
- Dynamic number display based on button presses.

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

## Getting Started

### Prerequisites

- JDK 11 or higher
- JavaFX SDK
- IDE with JavaFX support (e.g., IntelliJ IDEA, Eclipse)

### Installation

1. Clone the repository:
   ```bash
   git clone git@github.com:JackBadawy/CalculatorJavaFX.git
   ```
