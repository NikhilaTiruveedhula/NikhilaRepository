package com.cg.donorapplication.util;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.cg.donorapplictaion.exception.DonorException;


public class DBUtil {
	private static Connection conn;
	public static Connection getConnection() throws DonorException
	{
	if(conn==null)
	{
		try {
			InitialContext ic=new InitialContext();
			DataSource ds=(DataSource)ic.lookup("java:/jdbc/OracleDS");
			conn=ds.getConnection();
		} 
		catch(NamingException | SQLException e) {
		throw new DonorException("Problem in establishing Reason :"+e.getMessage());
		} 	
	}
	return conn;
	}
}
