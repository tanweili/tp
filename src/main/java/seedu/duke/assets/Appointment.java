package seedu.duke.assets;

import java.time.LocalDate;

public class Appointment {
    protected String appointmentId;
    protected String patientNric;
    protected String patientName;
    protected String doctorNric;
    protected String doctorName;
    protected String appointmentDate;
    protected String appointmentDetails;

    public Appointment(String appointmentId, String patientNric, String patientName, String doctorNric,
                       String doctorName, String appointmentDate, String appointmentDetails) {
        this.appointmentId = appointmentId;
        this.patientName = patientName;
        this.patientNric = patientNric;
        this.doctorName = doctorName;
        this.doctorNric = doctorNric;
        this.appointmentDate = appointmentDate;
        this.appointmentDetails = appointmentDetails;
    }

    @Override
    public String toString() {
        return "Patient: " + patientName + " (" + patientNric + ")\n"
                + "Doctor: " + doctorName + " (" + doctorNric + ")\n"
                + "Appointment date: " + appointmentDate + "\n"
                + "Appointment details: " + appointmentDetails + "\n";
    }

    public void updateAppointmentDetails() {
        LocalDate localDateNow = LocalDate.now();
        LocalDate localAppointmentDate = LocalDate.parse(this.appointmentDate);
        if (isBeforeOrEqual(localAppointmentDate, localDateNow)) {
            this.appointmentDetails = this.appointmentDetails + " - appointment finished on " + this.appointmentDate;
        }
    }

    private boolean isBeforeOrEqual(LocalDate date, LocalDate compareToDate) {
        if (date == null || compareToDate == null) {
            return false;
        }
        return !compareToDate.isAfter(date);
    }

    public String getAppointmentId() {
        return appointmentId;
    }

    public String getPatientNric() {
        return patientNric;
    }

    public String getPatientName() {
        return patientName;
    }

    public String getDoctorNric() {
        return doctorNric;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public String getAppointmentDate() {
        return appointmentDate;
    }

    public String getAppointmentDetails() {
        return appointmentDetails;
    }

    public String saveString() {
        return patientNric + "," + doctorNric + "," + appointmentDate + "," + appointmentDetails;
    }
}
