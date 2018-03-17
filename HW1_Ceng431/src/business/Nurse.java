package business;

public class Nurse extends HospitalStaff{

	public Nurse() {
		super();
		setStaff(Staff.NURSE);
	}

	public Nurse(IMonitor monitor, String firstName, String lastName) {
		super(monitor, firstName, lastName);
		setStaff(Staff.NURSE);
	}
	
}
