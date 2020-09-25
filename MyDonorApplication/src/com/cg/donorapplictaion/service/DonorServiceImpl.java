package com.cg.donorapplictaion.service;

import java.util.ArrayList;

import com.cg.donorapplication.dao.DonorApplicationDaoImpl;
import com.cg.donorapplication.dao.IDonorApplicationDao;
import com.cg.donorapplictaion.dto.Donor;
import com.cg.donorapplictaion.exception.DonorException;

public class DonorServiceImpl implements IDonorService{

	IDonorApplicationDao dao=new DonorApplicationDaoImpl();
	@Override
	public long addDonorDetails(Donor d) throws DonorException {
		// TODO Auto-generated method stub
		return dao.addDonorDetails(d);
	}
	@Override
	public Donor viewDonor(int did) throws DonorException {
		return dao.viewDonor(did);
	}
	
	public ArrayList<Donor> viewAllDonors() throws DonorException {
		ArrayList<Donor> r2=(ArrayList<Donor>)dao.viewAllDonors();
		return r2;
	}
}
