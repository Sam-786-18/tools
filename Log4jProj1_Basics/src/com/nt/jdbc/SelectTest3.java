package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import org.apache.log4j.FileAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.XMLLayout;

public class SelectTest3 {
private static Logger logger=Logger.getLogger(SelectTest3.class);
static {
	XMLLayout layout=null;
	FileAppender appender=null;
	//create layout obj
	layout=new XMLLayout();
	try {
		//create appender obj
		appender=new FileAppender(layout,"mylogs.xml",true);
		//add appender to logger
		logger.addAppender(appender);
		logger.info("Log4jProj1.mod1.SelectTest3.static block:Log4j cfgs is done Successfully");
		//set logger level
		logger.setLevel((Level)Level.INFO);
	}//try
	catch(Exception e) {
		logger.error("Log4jProj1.mod1.SelectTest3.static block: log4j configuration error");
	}//catch
}//static
	public static void main(String[] args) {
		
		logger.debug("Log4jProj1.mod1.SelectTest3.main(-)method:");
		Scanner sc=null;
		String desg1=null,desg2=null,desg3=null;
		String cond=null;
		Connection con=null;
		Statement st=null;
		String query=null;
		ResultSet rs=null;
		boolean flag=false;
		try {
			sc=new Scanner(System.in);
			if(sc!=null) {
				System.out.println("Enter the desg1");
				desg1=sc.next();
				System.out.println("Enter the desg2");
				desg2=sc.next();
				System.out.println("Enter the desg3");
				desg3=sc.next();
				}
			logger.debug("Log4jProj1.mod1.SelectTest3.main(-):input are read by enduser");
			//prepared the sql query condition('salesman','manager','admin')
			cond="('"+desg1+"','"+desg2+"','"+desg3+"')";
			logger.debug("Log4jProj1.mod1.SelectTest3.main(-):inputs are converted as required for Sql Query");
			//register the driver s/w
			Class.forName("oracle.jdbc.driver.OracleDriver");
			logger.debug("Log4jProj1.mod1.SelectTest3.main(-):jdbc driver are loaded");
			//establish the connection
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
			logger.debug("Log4jProj1.mod1.SelectTest3.main(-):jdbc connection establish successfully");
			//create Statament obj
			if(con!=null) 
			st=con.createStatement();
			logger.debug("cstatement obj is creaed");
		
			query="select eno,ename,job,sal,deptno from emp1 where job in" +cond+"order by job";
			logger.debug("Log4jProj1.mod1.SelectTest3.main(-):query is prepared"+query);
			
			//send and execute query to db s/w
			System.out.println(st.getMaxRows());
			if(st!=null)
				
				rs=st.executeQuery(query);
			logger.debug("Log4jProj1.mod1.SelectTest3.main(-):resultset object is created");
			//process resultset
			if(rs!=null) {
				while(rs.next()) {
					flag=true;
					System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4)+" "+rs.getInt(5));
				}//while
			}//if
			if(flag==false) {
				System.out.println("Rcord not found");
				logger.warn("Log4jProj1.mod1.SelectTest3.main(-):check the data once db");
			}
			
		}
		catch(ClassNotFoundException cnf) {
			
			logger.error("Log4jProj1.mod1.SelectTest3.main(-):"+cnf.getMessage());
		}
		catch(SQLException se) {
			se.printStackTrace();
			logger.error("cnf.printStackTrace():Driver not there: internal problem"+se.getErrorCode()+"Msg"+se.getMessage());
		}
		catch(Exception e) {
			e.printStackTrace();
			logger.fatal("cnf.printStackTrace():Unknow exception problem"+e.getMessage());
		}
		finally {
			try {
				if(rs!=null) 
					rs.close();
				logger.debug("log4jProj1.mod1.SelectTest3.main()::ResultSet obje i closed");
			}
			catch(SQLException se) {
				logger.error("log4jProj1.mod1.SelectTest3.main()::problem in closing resultSet");
			}
			try {
				if(st!=null)
					st.close();
				logger.debug("log4jProj1.mod1.SelectTest3.main()::Statment obje i closed");
			}
			catch(SQLException se) {
				logger.error("log4jProj1.mod1.SelectTest3.main()::problem in closing statment obj");
			}
			try {
				if(con!=null)
					con.close();
				logger.info("log4jProj1.mod1.SelectTest3.main()::Connection obj is closed");
			}
			catch(SQLException se) {
				logger.error("log4jProj1.mod1.SelectTest3.main()::problem in closing connection obj");
			}
			try {
				if(sc!=null)
					sc.close();
				logger.info("log4jProj1.mod1.SelectTest3.main()::Scanner obje is closed");
			}
			catch(Exception e) {
				logger.error("log4jProj1.mod1.SelectTest3.main()::prbolem in  closing scanner obj");
			}
		}

	}

}
