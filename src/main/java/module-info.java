module calculatorJavaFX {
	exports operations;
	exports application;

	requires javafx.base;
	requires javafx.controls;
	requires javafx.fxml;
	requires transitive javafx.graphics;
	 requires javafx.media;
	
	opens application to javafx.fxml;
}