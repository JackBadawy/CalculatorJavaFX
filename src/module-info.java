module CalculatorJavaFX {
    requires javafx.controls;
    requires javafx.fxml;
    requires transitive javafx.graphics;
	requires org.junit.jupiter.api;
	requires junit;
	requires javafx.swing;

    opens application to javafx.fxml;
    exports application;
    opens application.tests to javafx.graphics;
}
