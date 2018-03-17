package presentation;

import java.util.ArrayList;
import java.util.Random;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

import business.Doctor;
import business.HospitalStaff;
import business.Monitor;
import business.Nurse;
import business.Patient;
import business.PatientCompanion;
import business.Result;
import business.Tasks;

public class App {
	
	
	public static void main(String[] args) throws Exception {
		Monitor monitor = new Monitor();
		ArrayList<HospitalStaff> staffList = new ArrayList <HospitalStaff>();
		initialize(monitor, staffList);
		
		HospitalStaff dt1 = staffList.get(new Random().nextInt(staffList.size()));
		Patient pt1 = monitor.getPatientList().get(0);
		Patient patient = monitor.getPatientBySsn(pt1.getSSN());
		System.out.println(patient.getFirstName());
		Result result = dt1.takeAction(Tasks.PERFORM_OPERATION, monitor.getPatientBySsn(pt1.getSSN()));
		System.out.println(result.toString());
		System.out.println(monitor.getPatientList().size());
		System.out.println(Tasks.TAKE_BLOOD.toString());
		listHospitalStaff(staffList);
	}
	
	//Function to gather initialization of "sample objects" together to simplify the main function.
	public static void initialize(Monitor monitor, ArrayList<HospitalStaff> staffList){
		Patient pt1 = new Patient("123456","Ali", "Veli", 100);
		Patient pt2 = new Patient("123457","Bill", "Wilson", 200);
		Patient pt3 = new Patient("123459","Will", "Bilson", 300);
		Patient pt4 = new Patient("123459","Legolas", "Greenleaf", 300);
		Patient pt5 = new Patient("123459","Bilbo", "Baggins", 300);
		Patient pt6 = new Patient("123459","Frodo", "Baggins", 300);
		monitor.addToPatientList(pt1);
		monitor.addToPatientList(pt2);
		monitor.addToPatientList(pt3);
		monitor.addToPatientList(pt4);
		monitor.addToPatientList(pt5);
		monitor.addToPatientList(pt6);
		System.out.println(monitor.getPatientList().size());
		HospitalStaff dt1 = new Doctor(monitor, "Gregory", "House");
		HospitalStaff dt2 = new Doctor(monitor, "Merve", "Can");
		HospitalStaff nurse1 = new Nurse(monitor, "Ayse", "Ev");
		HospitalStaff nurse2 = new Nurse(monitor, "Susan", "Diaz");
		HospitalStaff pc1 = new PatientCompanion(monitor, "Aydin", "Aydin");
		HospitalStaff pc2 = new PatientCompanion(monitor, "Aydin", "Aydin");
		staffList.add(dt1);
		staffList.add(dt2);
		staffList.add(nurse1);
		staffList.add(nurse2);
		staffList.add(pc1);
		staffList.add(pc2);
	}

	public static void listHospitalStaff(ArrayList<HospitalStaff> staffList){
		String header = String.format("%1$-25s%2$18s", "Name", "Title");
		System.out.println(header);
		for(HospitalStaff staff: staffList){
			System.out.println(staff);
		}
	}
}
