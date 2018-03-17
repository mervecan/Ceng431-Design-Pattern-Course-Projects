package presentation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.TreeSet;

import business.Doctor;
import business.HospitalStaff;
import business.Monitor;
import business.Nurse;
import business.Patient;
import business.Result;
import business.Tasks;


public class App {

	public static void main(String[] args) throws Exception {
		Monitor monitor = new Monitor();
		ArrayList<HospitalStaff> staffList = new ArrayList <HospitalStaff>();
		
		Patient pt1 = new Patient("123456","Merve", "Can", 100);
		Patient pt2 = new Patient("123457","eee", "Can", 200);
		Patient pt3 = new Patient("123459","effe", "Can", 300);
		monitor.addToPatientList(pt1);
		monitor.addToPatientList(pt2);
		monitor.addToPatientList(pt3);
		System.out.println(monitor.getPatientList().size());
		HospitalStaff dt1 = new Doctor(monitor, "dkflk", "Can");
		Doctor dt2 = new Doctor(monitor, "Mkerve", "Can");
		staffList.add(dt1);
		staffList.add(dt2);
		Patient patient = monitor.getPatientBySsn(pt1.getSSN());
		System.out.println(patient.getFirstName());
		Result result = dt1.takeAction(Tasks.DISMISS_PATIENT, monitor.getPatientBySsn(pt1.getSSN()));
		System.out.println(result.toString());
		System.out.println(monitor.getPatientList().size());
		//System.out.println(dt1.getPatient().getCurrentProcess());
		
	}

}
