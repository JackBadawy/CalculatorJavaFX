package application.tests;

import application.Controller;
import javafx.application.Platform;
import javafx.scene.text.Text;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;

import java.lang.reflect.Field;
import java.util.concurrent.CountDownLatch;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ControllerTest {

    private Controller controller;

    @BeforeAll
    public static void initToolkit() throws InterruptedException {
        JavaFXInitializer.initToolkit();
    }

    @BeforeEach
    public void setUp() throws Exception {
        controller = new Controller();
        setPrivateField(controller, "displayText", new Text());
    }

    private void setPrivateField(Object object, String fieldName, Object value) throws Exception {
        Field field = object.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(object, value);
    }

    @Test
    public void testHandleEqualsClick() throws Exception {
        runOnFxThreadAndWait(() -> {
            try {
                setPrivateField(controller, "currentInputNumber", new StringBuilder("3"));
                setPrivateField(controller, "previousInputNumber", new StringBuilder("9"));
                setPrivateField(controller, "currentOperation", '+');
                controller.handleEqualsClick();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

 

      
        assertEquals("12.0", getPrivateField(controller, "currentInputNumber").toString());
    }

    @Test
    public void testHandleClearClick() throws Exception {
        runOnFxThreadAndWait(() -> {
            try {
                setPrivateField(controller, "currentInputNumber", new StringBuilder("123"));
                setPrivateField(controller, "previousInputNumber", new StringBuilder("456"));
                controller.handleClearClick();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

        assertEquals("", getPrivateField(controller, "currentInputNumber").toString());
        assertEquals("", getPrivateField(controller, "previousInputNumber").toString());
        assertEquals("", ((Text) getPrivateField(controller, "displayText")).getText());
    }

    @Test
    public void testHandleToggleChargeClick() throws Exception {
        runOnFxThreadAndWait(() -> {
            try {
                setPrivateField(controller, "currentInputNumber", new StringBuilder("123"));
                controller.handleToggleChargeClick();
                controller.handleToggleChargeClick();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

        assertEquals("123", getPrivateField(controller, "currentInputNumber").toString());
    }

    private Object getPrivateField(Object object, String fieldName) throws Exception {
        Field field = object.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        return field.get(object);
    }

    private void runOnFxThreadAndWait(Runnable action) throws Exception {
        final CountDownLatch latch = new CountDownLatch(1);
        Platform.runLater(() -> {
            try {
                action.run();
            } finally {
                latch.countDown();
            }
        });
        latch.await();
    }
}
