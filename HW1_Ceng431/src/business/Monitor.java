package business;

import java.io.IOException;
import java.util.ArrayList;

//Concrete Mediator
public class Monitor implements IMonitor{
	ArrayList<Patient> patientList = new ArrayList<Patient>();
	
	public Monitor() {}
	
	
	@Override
	public Result takeAction(HospitalStaff staff, Tasks task, Patient patient) throws Exception, IOException  {
		Result wentToPatient = goToPatient(staff, patient); //"staff" tries to go to patient
		
		//if "staff" was successful to go to the patient, tries to perform the task given. 
		if(wentToPatient.equals(Result.SUCCESS)) {
			if(Tasks.DISMISS_PATIENT.equals(task)) {
				((Doctor) staff).dismissPatient(); //Only the doctors can dismiss a patient
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
		} else{
			System.out.println(staff.getName() + " can not go to the patient to perform the task right now.");
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
			System.out.println("Patient " + patient.getName() + " is dismissed successfully.");
			patientList.remove(patient);
		} else {
			System.out.println("Patient " + patient.getName() + " could not be dismissed.");
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
		System.out.println("This SSN is not registered to the hospital as a patient.");
		return null;
	}

}
