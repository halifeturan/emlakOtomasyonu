	package dal;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import forms.frmIlanOlustur;


public class Helper {

	public static FileInputStream fin=null;
	public static File file=null;
	public static ResultSet rsltst;
public static void executeQuery(String query) {
		
		Connector connector = new Connector();
		Connection conn = null;
		
		
		try 
		{
			conn = connector.connect();
			conn.setAutoCommit(false);
		}
		catch (SQLException | ClassNotFoundException e) 
		{
			e.printStackTrace();	
		}		
		
		PreparedStatement ps = null;
		
		try {	
			ps = conn.prepareStatement(query);	
		
				rsltst = ps.executeQuery();	
			
		
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();		
		}
		finally 
		{
			try 
			{
				conn.close();
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
	}
	public static void executeNonQuery(String cmd, String params, ArrayList dataList) throws IOException, SQLException {
		
		Connector connector = new Connector();
		Connection conn = null;
		
		
		try 
		{
			conn = connector.connect();
			conn.setAutoCommit(false);
		}
		catch (SQLException | ClassNotFoundException e) 
		{
			e.printStackTrace();	
		}	
		
		try 
		{
			PreparedStatement ps = null;
			ps = conn.prepareStatement(cmd);
			
			for (int i = 0; i < params.length(); i++) {
				if (params.charAt(i) == 's') {
					
					ps.setString(i+1, String.valueOf(dataList.get(i)));
					
				}
				else if (params.charAt(i) == 'i') {
					
					ps.setInt(i+1, Integer.parseInt(dataList.get(i).toString()));
					
				}
				else if(params.charAt(i) == 'f') {
					ps.setFloat(i+1, Float.parseFloat(dataList.get(i).toString()));
				}
				else if(params.charAt(i)=='b')
				{
					ps.setBoolean(i+1, Boolean.parseBoolean(dataList.get(i).toString()));
				}
				else if(params.charAt(i)=='x')
				{
					FileInputStream fin = new FileInputStream(frmIlanOlustur.file);
					ps.setBinaryStream(i+1, fin,(int)frmIlanOlustur.file.length());
				}
				
				
			}
			ps.executeUpdate();		
			conn.commit();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();		
		}
		finally {
			try 
			{
				conn.close();
				
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
		
	}

	public static void executeQuery(String query, String params, ArrayList dataList) {
		

		Connector connector = new Connector();
		Connection conn = null;
		
		
		try 
		{
			conn = connector.connect();
			conn.setAutoCommit(false);
		}
		catch (SQLException | ClassNotFoundException e) 
		{
			e.printStackTrace();	
		}	
		
		
		PreparedStatement ps = null;
		
		try {	
			ps = conn.prepareStatement(query);	
			
			for (int i = 0; i < params.length(); i++) {
				if (params.charAt(i) == 's') {
					
					ps.setString(i+1, String.valueOf(dataList.get(i)));
					
				}
				else if (params.charAt(i) == 'i') {
					
					ps.setInt(i+1, Integer.parseInt(dataList.get(i).toString()));
					
				}
				else if(params.charAt(i) == 'f') {
					ps.setFloat(i+1, Float.parseFloat(dataList.get(i).toString()));
				}
				else if(params.charAt(i)=='b')
				{
					ps.setBoolean(i+1, Boolean.parseBoolean(dataList.get(i).toString()));
				}

				
			}
			rsltst = ps.executeQuery();	
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();		
		}
		finally 
		{
			try 
			{
				conn.close();
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
	}
	
	
}
