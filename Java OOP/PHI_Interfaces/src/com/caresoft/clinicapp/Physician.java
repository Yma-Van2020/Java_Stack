package com.caresoft.clinicapp;
import java.util.Date;
import java.util.ArrayList;
import java.util.HashSet;

public class Physician extends User implements PHIAdminCompliant, PHICompliantUser {
	 private HashSet<Patient> patients;
	 private ArrayList<String> securityIncidents;
	 
	 
	 public Physician(HashSet<Patient> patients, ArrayList<String> securityIncidents) {
			super();
			this.patients = patients;
			this.securityIncidents = securityIncidents;
		}

	    
	@Override
	public boolean assignPin(int pin) {
		int length = String.valueOf(pin).length();
		if(length >= 6) {
			super.setPin(pin);
	    	return true;
		}
		return false;
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
		public ArrayList<String> reportSecurityIncidents() {
			// TODO Auto-generated method stub
			return securityIncidents;
		}
	  
	  
		@Override
		public void printSecurityIncidents() {
			// TODO Auto-generated method stub
			PHIAdminCompliant.super.printSecurityIncidents();
		}
		@Override
		public boolean adminQATest(ArrayList<String> expectedIncidents) {
			// TODO Auto-generated method stub
			return PHIAdminCompliant.super.adminQATest(expectedIncidents);
		}
		
		
	
	public void prescribeRXTo(Patient patient, Integer rxNumber) {
        patient.currentPrescriptionsByRX.add(rxNumber);
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

    //Setters & Getters
	public HashSet<Patient> getPatients() {
		return patients;
	}


	public void setPatients(HashSet<Patient> patients) {
		this.patients = patients;
	}


	public ArrayList<String> getSecurityIncidents() {
		return securityIncidents;
	}


	public void setSecurityIncidents(ArrayList<String> securityIncidents) {
		this.securityIncidents = securityIncidents;
	}
    
  
    
}


