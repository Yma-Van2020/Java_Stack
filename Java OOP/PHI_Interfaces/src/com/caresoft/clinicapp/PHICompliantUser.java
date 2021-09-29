package com.caresoft.clinicapp;

public interface PHICompliantUser {

	 abstract boolean assignPin(int pin);
	    
	    // Expected to compare instance id with id passed in. Returns true or false.
	  abstract boolean isAuthorized(Integer confirmedAuthID);

}
