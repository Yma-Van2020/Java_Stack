package com.caresoft.clinicapp;

import java.util.ArrayList;
import java.util.Date;

public class AdminUser extends User implements PHICompliantUser, PHIAdminCompliant {
    private Integer employeeID;
    private String role;
    private ArrayList<String> securityIncidents;
    
    @Override
	public boolean assignPin(int pin) {
    	int length = String.valueOf(pin).length();
    	if (length < 6) {
		return false;
    	}
    	super.setPin(pin);
    	return true;
	}
    
    @Override
   	public ArrayList<String> reportSecurityIncidents() {
   		return securityIncidents;
   	}
    
    @Override
	public void printSecurityIncidents() {
    	PHIAdminCompliant.super.printSecurityIncidents();
    }

	@Override
	public boolean isAuthorized(Integer confirmedAuthID) {
		if (confirmedAuthID.equals(this.id)) {
			return true;
		}
		authIncident();
		return false;
	}
	
	@Override
	public boolean adminQATest(ArrayList<String> expectedIncidents) {
		return PHIAdminCompliant.super.adminQATest(expectedIncidents);
	}

	 public void newIncident(String notes) {
	        String report = String.format(
	            "Datetime Submitted: %s \n,  Reported By ID: %s\n Notes: %s \n", 
	            new Date(), this.id, notes
	        );
	        securityIncidents.add(report);
	    }
	    public void authIncident() {
	        String report = String.format(
	            "Datetime Submitted: %s \n,  ID: %s\n Notes: %s \n", 
	            new Date(), this.id, "AUTHORIZATION ATTEMPT FAILED FOR THIS USER"
	        );
	        securityIncidents.add(report);
	    }
}



