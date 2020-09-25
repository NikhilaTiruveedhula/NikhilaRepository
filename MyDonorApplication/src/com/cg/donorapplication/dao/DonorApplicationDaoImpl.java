package com.cg.donorapplication.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import com.cg.donorapplication.util.DBUtil;
import com.cg.donorapplictaion.dto.Donor;
import com.cg.donorapplictaion.exception.DonorException;

public class DonorApplicationDaoImpl implements IDonorApplicationDao{
	Connection con;
	public long addDonorDetails(Donor d) throws DonorException
	{
		con=DBUtil.getConnection();
		try {
		String query="insert into donor values(seq_donor_id.nextval,?,?,?,?,sysdate)";
		PreparedStatement ps=con.prepareStatement(query);
		ps.setString(1,d.getDonorname());
		ps.setString(2,d.getPhonenumber());
		ps.setString(3,d.getAddress());
		ps.setInt(4,d.getAmount());
		int r=ps.executeUpdate();
		if(r==1)
		{
		int n=getDonorId();
		d.setDonorid(n);
		return n;
		}
		}         
		catch (SQLException e) {
		throw new DonorException(e.getMessage());
		}
		return 0;
	}
	
	public int getDonorId() throws DonorException
	{
		try {
			PreparedStatement ps;
			String query="select seq_donor_id.currval from dual";	
			ps=con.prepareStatement(query);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
			int donorid=rs.getInt(1);
			return donorid;
			}
		    }
		catch (SQLException e) {
			throw new DonorException(e.getMessage());
	    }
	return 0;
	}

	
	@Override
	public Donor viewDonor(int did) throws DonorException {
		con=DBUtil.getConnection();
		try
			{   
			String query="select * from donor where donor_id=?";
			PreparedStatement ps=con.prepareStatement(query);
			ps.setInt(1,did);
			ResultSet rs=ps.executeQuery();
			int d1=getDonorId();
			if(d1!=0)
			{
			while(rs.next())
			{
			Donor d=new Donor();
			d.setDonorid(rs.getInt("donor_id"));
			d.setDonorname(rs.getString("donor_name"));
			d.setPhonenumber(rs.getString("phone_number"));
			d.setAddress(rs.getString("address"));
			d.setAmount(rs.getInt("amount"));
			d.setDonationdate(LocalDate.now());
			return d;
			}
			}
			else
			throw new DonorException("Please enter valid DonorId");	
			}
			catch(SQLException e)
			{
			throw new DonorException(e.getMessage());
			}
		return null;	
	}
	
	
	
	@Override
	public ArrayList<Donor> viewAllDonors() throws DonorException {

		ArrayList<Donor> list=new ArrayList<Donor>();
		con=DBUtil.getConnection();
		try
		{
		String query="select * from donor";
	    PreparedStatement ps=con.prepareStatement(query);
	    ResultSet rs=ps.executeQuery();
	    while(rs.next())
	    {
	    Donor d=new Donor();
	    d.setDonorid(rs.getInt("donor_id"));
	    d.setDonorname(rs.getString("donor_name"));
	    d.setPhonenumber(rs.getString("phone_number"));
	    d.setAddress(rs.getString("address"));
	    d.setAmount(rs.getInt("amount"));
	    d.setDonationdate(rs.getDate("donation_date").toLocalDate());
	    list.add(d);
	    }
	    }
		catch (SQLException e) {
		throw new DonorException(e.getMessage());
		}
		return list;
	}
		
}
