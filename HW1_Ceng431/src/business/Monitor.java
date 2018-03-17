package business;

import java.io.IOException;
import java.util.ArrayList;

public class Monitor implements IMonitor{
	ArrayList<Patient> patientList = new ArrayList<Patient>();
	
	public Monitor() {
		
	}
	
	@Override
	public Result takeAction(HospitalStaff staff, Tasks task, Patient patient) throws Exception, IOException  {

	 if(goToPatient(staff, patient).equals(Result.SUCCESS)) {
			if(Tasks.DISMISS_PATIENT.equals(task)) {
				((Doctor) staff).dismissPatient();
				return dismissPatient(patient.getSSN());		
			}else {
				patient.setCurrentProcess(task.toString());
				return TaskHandler.result(task);
			}	
		}
		return Result.FAILURE;
	}

	@Override
	public Result goToPatient(HospitalStaff staff, Patient patient) throws NumberFormatException, IOException {
		Result result = TaskHandler.result(Tasks.GO_TO_PATIENT);
		if(result == Result.SUCCESS) {
			staff.setPatient(patient);
		}
		return result;	
	}

	@Override
	public Result dismissPatient(String SSN) throws Exception, IOException {
		Patient patient = getPatientBySsn(SSN);
		if(patient==null) {
			return Result.FAILURE;
		}
		Result result = TaskHandler.result(Tasks.DISMISS_PATIENT);
		if(result.equals(Result.SUCCESS)) {
			patientList.remove(patient);
		}
		return result;
	}

	public ArrayList<Patient> getPatientList() {
		return patientList;
	}

	public void setPatientList(ArrayList<Patient> patientList) {
		this.patientList = patientList;
	}

	public void addToPatientList(Patient patient)
	{
		patientList.add(patient);
	}
	
	public Patient getPatientBySsn(String SSN) {
		for(Patient patient : patientList) {
			if(patient.getSSN().equals(SSN)) {
				return patient;
			}
		}
		return null;
	}

}
