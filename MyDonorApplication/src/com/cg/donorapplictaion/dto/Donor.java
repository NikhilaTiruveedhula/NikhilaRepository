package com.cg.donorapplictaion.dto;

import java.time.LocalDate;

public class Donor {
	private int donorid;
	private String donorname;
	private String phonenumber;
	private String address;
	private int amount;
	private LocalDate donationdate;
	
	public int getDonorid() {
		return donorid;
	}
	public void setDonorid(int donorid) {
		this.donorid = donorid;
	}
	public String getDonorname() {
		return donorname;
	}
	public void setDonorname(String donorname) {
		this.donorname = donorname;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public LocalDate getDonationdate() {
		return donationdate;
	}
	public void setDonationdate(LocalDate donationdate) {
		this.donationdate = donationdate;
	}

}

