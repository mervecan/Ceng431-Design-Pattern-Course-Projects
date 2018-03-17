package business;

import java.io.IOException;

public abstract class HospitalStaff {
	private String firstName;
	private String lastName; 
	private Staff staff;
	private Patient patient;
	private IMonitor monitor;
	
	public HospitalStaff() {
		
	}
	
	public HospitalStaff(IMonitor monitor, String firstName, String lastName) {
		super();
		this.monitor = monitor;
		this.firstName = firstName;
		this.lastName = lastName;
		
	}
	

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	
	public Staff getStaff() {
		return staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

	
	public Result takeAction(Tasks task, Patient patient) throws IOException, Exception {
		if(task.performedBy().equals(this.staff)) {
			return this.monitor.takeAction(this, task, patient);
		}
		return Result.FAILURE;
	}
}
