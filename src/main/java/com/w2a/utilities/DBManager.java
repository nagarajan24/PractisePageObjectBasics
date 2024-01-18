package com.w2a.utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DBManager {
	
public Connection con;
	
	public void getCon()
	{
		try {
			Class.forName(DBConfig.driverClass);  
			con=DriverManager.getConnection(  
			DBConfig.conString,DBConfig.userName,DBConfig.password);  
			if(!con.isClosed())
			{
				System.out.println("DB connection is established successfully");
			}
		}
		catch(Exception e)
		{
			System.out.println("DB con is not established successfully. Exception msg :- "+e);
		}
	}
	
	public List<String> executeQuery(String query)
	{
		List<String> data=null;
		try {
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery(query); 
			data = new ArrayList<String>();
			while(rs.next())  
			data.add(rs.getString(1));
			
		}
		catch(Exception e)
		{
			System.out.println("Query did not execute successfully due to exception:- "+e);
		}
		
		return data;
	}

}
