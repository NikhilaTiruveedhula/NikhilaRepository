package com.cg.donorapplictaion.service;

import java.util.ArrayList;

import com.cg.donorapplictaion.dto.Donor;
import com.cg.donorapplictaion.exception.DonorException;

public interface IDonorService{

	public long addDonorDetails(Donor d) throws DonorException;

	public Donor viewDonor(int did) throws DonorException;
	
	public ArrayList<Donor> viewAllDonors() throws DonorException;

}
