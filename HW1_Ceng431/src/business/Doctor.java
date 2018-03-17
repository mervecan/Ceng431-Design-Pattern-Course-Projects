package business;

import java.io.IOException;

public class Doctor extends HospitalStaff {

	
	public Doctor() {
		super();
		setStaff(Staff.DOCTOR);
	}

	public Doctor(IMonitor monitor, String firstName, String lastName) {
		super(monitor, firstName, lastName);
		setStaff(Staff.DOCTOR);
		
	}
	
	public void dismissPatient() {
		this.setPatient(null);
	}
	
}
