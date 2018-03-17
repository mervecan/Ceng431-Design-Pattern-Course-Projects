package business;

import java.io.IOException;

import business.HospitalStaff;

public interface IMonitor {
	public Result takeAction(HospitalStaff staff, Tasks task, Patient patient) throws Exception, IOException;
	public Result goToPatient(HospitalStaff staff, Patient patient) throws NumberFormatException, IOException;
	public Result dismissPatient(String SSN) throws Exception, IOException;
}
