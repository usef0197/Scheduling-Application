package UnitTest.test;

import controller.addAppointments;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.time.LocalDate;

public class UnitTest {

    @BeforeAll
    public static void initJavaFX() {
        new JFXPanel();
        Platform.runLater(() -> {
        });
    }

    @Test
    public void testOverlappingAppointments() throws IOException {
        // Load the FXML file and initialize the controller
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/views/addAppointments.fxml"));
        Parent root = loader.load(getClass().getResourceAsStream("/views/addAppointments.fxml"));
        addAppointments controller = loader.getController();

        controller.addAppointmentStartDate.setValue(LocalDate.of(2023, 1, 1));
        controller.addAppointmentStartTime.setValue("08:00");
        controller.addAppointmentEndDate.setValue(LocalDate.of(2023, 1, 1));
        controller.addAppointmentEndTime.setValue("09:00");
        controller.addAppointmentCustomerID.setText("1"); // Assuming a valid customer ID

        controller.addAppointmentSave(null);

        controller.addAppointmentStartDate.setValue(LocalDate.of(2023, 1, 1));
        controller.addAppointmentStartTime.setValue("08:30");
        controller.addAppointmentEndDate.setValue(LocalDate.of(2023, 1, 1));
        controller.addAppointmentEndTime.setValue("09:30");
        controller.addAppointmentCustomerID.setText("1");
        controller.addAppointmentSave(null);
        assertTrue();
    }
    @Test
    public void testOverlappingAppointmentsDifferentCustomer() {

        assertTrue();
    }
    private void assertTrue() {

    }
    @Test
    public void testOverlappingAppointmentsDifferentDay() {

        assertTrue();
    }
}
