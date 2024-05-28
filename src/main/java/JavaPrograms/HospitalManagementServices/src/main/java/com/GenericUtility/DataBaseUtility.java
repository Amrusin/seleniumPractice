package com.GenericUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class DataBaseUtility {

	Connection con=null;
	
	public void ConnectDB()throws SQLException
	{
		
	//step1: Register Database
	Driver driver=new Driver();
	DriverManager.registerDriver(driver);
	
	//step2: Get the connection from Database
	con=DriverManager.getConnection(IpathConstant.DBURL, IpathConstant.DBUsr, IpathConstant.DBPW);
	}
	
	public void ExecuteAndGetData(String query, String expdata, int colIndex) throws SQLException
	{
		
	//step3: Create the statement
	Statement state=con.createStatement();
	
	//step4: Execute/Update Query
	ResultSet result = state.executeQuery(query);
	boolean flag=false;
	while(result.next())
	{
		String actual=result.getString(colIndex);
		if(actual.contains(expdata))
		{
			flag=true;
			break;
		}
	}
	if(flag==true)
	{
		System.out.println("-- data is verified--");
	}
	else
	{
		System.out.println("-- data is not verified--");
		
	}
	}
	
	//step5: Close the connection
	public void closeConnection() throws SQLException
	{
		con.close();
}
}