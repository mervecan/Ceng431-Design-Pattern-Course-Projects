package business;

import java.io.IOException;

public class PatientCompanion extends HospitalStaff{

	public PatientCompanion() {
		super();
		setStaff(Staff.PATIENT_COMPANION);
	}

	public PatientCompanion(IMonitor monitor, String firstName, String lastName) {
		super(monitor, firstName, lastName);
		setStaff(Staff.PATIENT_COMPANION);
	}
}
