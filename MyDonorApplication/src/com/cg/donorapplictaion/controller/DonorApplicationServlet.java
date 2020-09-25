package com.cg.donorapplictaion.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cg.donorapplictaion.dto.Donor;
import com.cg.donorapplictaion.exception.DonorException;
import com.cg.donorapplictaion.service.DonorServiceImpl;
import com.cg.donorapplictaion.service.IDonorService;

@WebServlet(urlPatterns={"/addDonorServlet","/viewDonorServlet","/viewAllDonor"})
public class DonorApplicationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url=request.getServletPath();
		IDonorService ids=new DonorServiceImpl();
		if(url.equals("/addDonorServlet"))
		{ 	Donor d=new Donor();
			d.setDonorname(request.getParameter("donorName"));
			d.setPhonenumber(request.getParameter("phoneNumber"));
			d.setAddress(request.getParameter("address"));
			d.setAmount(Integer.parseInt(request.getParameter("amount")));
			d.setDonationdate(LocalDate.now());
			/*String datestr=request.getParameter("donationdate");
			DateTimeFormatter format=DateTimeFormatter.ofPattern("dd-MM-yyyy");
			d.setDonationdate(LocalDate.parse(datestr,format));*/
			try {
				ids.addDonorDetails(d);
				HttpSession sess=request.getSession(true);
			    sess.setAttribute("d",d);
				RequestDispatcher disp=request.getRequestDispatcher("SuccessServlet.jsp");
		        disp.forward(request, response);
				
			} catch (DonorException e) {
				request.setAttribute("error",e.getMessage());
				RequestDispatcher disp=request.getRequestDispatcher("ErrorServlet.jsp");
		        disp.forward(request, response);
			}
		}
		else if(url.equals("/viewDonorServlet")){
		   int did=Integer.parseInt(request.getParameter("donorId"));
	       try
	       {
	       Donor d=ids.viewDonor(did);
	       HttpSession sess=request.getSession(true);
	       sess.setAttribute("d",d);
           RequestDispatcher disp=request.getRequestDispatcher("viewDonor.jsp");
           disp.forward(request, response);
		}
		catch(DonorException e)
		{
			request.setAttribute("error",e.getMessage());
			RequestDispatcher disp=request.getRequestDispatcher("ErrorServlet.jsp");
			disp.forward(request, response);
		}
	}
		else if(url.equals("/viewAllDonor"))
		{
		try {
			ArrayList<Donor> d1=ids.viewAllDonors();
			System.out.println("list"+d1);
			HttpSession sess=request.getSession(true);
			sess.setAttribute("d1", d1);
			RequestDispatcher disp=request.getRequestDispatcher("viewAllDonors.jsp");
	        disp.forward(request, response);
		} catch (DonorException e) {
			request.setAttribute("error",e.getMessage());
			RequestDispatcher disp=request.getRequestDispatcher("ErrorServlet.jsp");
			disp.forward(request, response);
		}

}
}
}