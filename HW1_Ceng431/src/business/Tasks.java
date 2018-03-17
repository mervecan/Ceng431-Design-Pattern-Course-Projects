package business;

public enum Tasks {
	
	
	GO_TO_PATIENT {Staff performedBy() { return Staff.ALL; } },
	PERFORM_OPERATION {Staff performedBy() { return Staff.DOCTOR; } },
	PERFORM_VISIT {Staff performedBy() { return Staff.DOCTOR; } },
	DISMISS_PATIENT {Staff performedBy() { return Staff.DOCTOR; } },
	BRING_MEDICINE {Staff performedBy() { return Staff.NURSE; } },
	TAKE_BLOOD {Staff performedBy() { return Staff.NURSE; } },
	TAKE_PATIENT_MRI {Staff performedBy() { return Staff.PATIENT_COMPANION; } },
	TAKE_PATIENT_XRAY{Staff performedBy() { return Staff.PATIENT_COMPANION; } };

	

	abstract Staff performedBy() ;
	
	
}
