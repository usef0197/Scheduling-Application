package helper;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import main.DBConnection;
import model.Appointments;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class TimeManager {
    public static boolean checkOverlap(ObservableList<Appointments> appointments, LocalDateTime start, LocalDateTime end) {
        for(Appointments a : appointments) {
            if(a.getStart().equals(start) && a.getEnd().equals(end)){
                return true;


            }
        }
        return false;
    }
    public static ObservableList<Appointments> getAppointments(LocalDateTime start, LocalDateTime end) throws SQLException {
        ObservableList<Appointments> appointmentsObservableList = FXCollections.observableArrayList();
        String sql = "SELECT * FROM where start >= ? and end <= ?";
        PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql);
        ps.setTimestamp(1,Timestamp.valueOf(start));
        ps.setTimestamp(2,Timestamp.valueOf(end));
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            int id = rs.getInt("Appointment_ID");
            LocalDateTime s = rs.getTimestamp("start").toLocalDateTime();
            LocalDateTime e = rs.getTimestamp("end").toLocalDateTime();
            appointmentsObservableList.add(new Appointments(id, s, e));

        }
        return appointmentsObservableList;
    }
}


