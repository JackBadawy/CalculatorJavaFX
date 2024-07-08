package application;

import java.util.concurrent.CountDownLatch;

import javafx.application.Application;
import javafx.stage.Stage;

public class JavaFXInitializer extends Application  {
	public static final CountDownLatch latch = new CountDownLatch(1);

    @Override
    public void start(Stage primaryStage) {
        latch.countDown(); 
    }

    public static void initToolkit() throws InterruptedException {
        new Thread(() -> Application.launch(JavaFXInitializer.class)).start();
        latch.await(); 
    }
}
