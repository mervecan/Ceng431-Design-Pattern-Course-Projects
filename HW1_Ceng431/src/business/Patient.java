package business;

import com.sun.xml.internal.ws.util.StringUtils;

public class Patient {
	private String SSN;
	private String firstName;
	private String lastName;
	private int roomNo;
	private String currentProcess;
	
	public Patient() {}

	public Patient(String SSN, String firstName, String lastName, int roomNo) {
		super();
		this.SSN = SSN;
		this.firstName = firstName;
		this.lastName = lastName;
		this.roomNo = roomNo;
		this.currentProcess = "New Patient";
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
	
	public String getName(){
		return firstName + " " + lastName;
	}

	public int getRoomNo() {
		return roomNo;
	}

	public void setRoomNo(int roomNo) {
		this.roomNo = roomNo;
	}

	public String getCurrentProcess() {
		return currentProcess;
	}

	public void setCurrentProcess(String currentProcess) {
		this.currentProcess = currentProcess;
	}

	public String getSSN() {
		return SSN;
	}

	public void setSSN(String SSN) {
		this.SSN = SSN;
	}
		
	@Override
	public String toString() {
		return String.format("%1$-25s%2$18s", SSN, getName(), Integer.toString(roomNo), currentProcess);
	}
	
}
