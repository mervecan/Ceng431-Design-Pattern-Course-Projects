package business;

import com.sun.xml.internal.ws.util.StringUtils;

//To specify titles of hospital staff
public enum Staff {
	
		DOCTOR,
		NURSE,
		PATIENT_COMPANION,
		ALL;
	
	@Override
	public String toString() {
		return StringUtils.capitalize((this.name().replace('_', ' ').toLowerCase()));
	}
}
