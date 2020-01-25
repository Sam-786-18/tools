package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;

public class SelectTest1 {

	private static Logger logger=Logger.getLogger(SelectTest1.class);
	static {
		SimpleLayout layout=null;
		ConsoleAppender appender=null;
		//create layout obj
		layout=new SimpleLayout();
		//create Appender obj
		appender=new ConsoleAppender(layout);
		//add appender to logger
		logger.addAppender(appender);
		//set logger level
		logger.setLevel((Level)Level.INFO);
	}
	
	public static void main(String[] args) {
		logger.debug("log4jProj1.mod1.SelectTest1.main(-):Enter Into Main method");
		Scanner sc=null;
		String cond=null;
		Connection con=null;
		Statement st=null;
		String query=null;
		ResultSet rs=null;
		boolean flag=false;
		String desg1=null,desg2=null,desg3=null;
		try {
			
			//read input 
			sc=new Scanner(System.in);
			if(sc!=null) {
				System.out.println("Enter the Desg1::");
				desg1=sc.next();
				System.out.println("Enter the Desg2::");
				desg2=sc.next();
				System.out.println("Enter the Desg3::");
				desg3=sc.next();
			}//if
			logger.debug("log4jProj1.mod1.SelectTest1.main(-)::Input are reade enduser");
			//Prepared Sql Query condition
			cond="('"+desg1+"','"+desg2+"','"+desg3+"')";
			logger.debug("log4jProj1.mod1.SelectTest1.main(-):inputs are converted as required for sql query");
			//register jdbc driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			logger.debug("log4jProj1.mod1.SelectTest1.main(-):jdbc driver class i loaded");
			//etablish the connetion
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
			logger.info("log4jProj1.mod1.SelectTest1.main(-):Connection is etablish with DB s/w");
			//create statement object
			if(con!=null) 
				st=con.createStatement();
				logger.debug("log4jProj1.mod1.SelectTest1.main():jdbc Statment object is created");
				//prepared sql query
				query="select eno,ename,job,sal,deptno from emp1 where job in"+cond+"order by job";
				logger.debug("log4jProj1.mod1.SelectTest1.main():query is prepared"+query);
				//send  and execute the query in db s/w
				if(st!=null) 
					rs=st.executeQuery(query);
					logger.debug("log4jProj1.mod1.SelectTest1.main():Sql query is created and Resultset obj is created");

				if(rs!=null) {
					while(rs.next()) {
						flag=true;
						System.out.println("emno ename job sal");
						System.out.println("Retriving::"+rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4)+" "+rs.getInt(5));
					}//while
				}//if
				System.out.println(rs.getFetchSize());
				logger.debug("log4jProj1.mod1.SelectTest1.main():ResulSet object processed");
				if(flag==false) {
					System.out.println("Record not found");
					logger.warn("log4jProj1.mod1.SelectTest1.main()::table is empty!check data once");
					
				}//if
			
		}//try
		catch(ClassNotFoundException cnf) {
		logger.error("log4jProj1.mod1.SelectTest1.main()::"+cnf.getMessage());	
		}
		catch(SQLException se) {
			se.printStackTrace();
			logger.error("log4jProj1.mod1.SelectTest1.main()::"+"Internal problem code:"+se.getErrorCode()+"Msg"+se.getMessage());
			
		}
		catch(Exception e) {
			e.printStackTrace();
			logger.fatal("log4jProj1.mod1.SelectTest1.main()::Unknown PROBLEM::"+e.getMessage());
		}
		finally {
			try {
				if(rs!=null) 
					rs.close();
				logger.debug("log4jProj1.mod1.SelectTest1.main()::ResultSet obje i closed");
			}
			catch(SQLException se) {
				logger.error("log4jProj1.mod1.SelectTest1.main()::problem in closing resultSet");
			}
			try {
				if(st!=null)
					st.close();
				logger.debug("log4jProj1.mod1.SelectTest1.main()::Statment obje i closed");
			}
			catch(SQLException se) {
				logger.error("log4jProj1.mod1.SelectTest1.main()::problem in closing statment obj");
			}
			try {
				if(con!=null)
					con.close();
				logger.info("log4jProj1.mod1.SelectTest1.main()::Connection obj is closed");
			}
			catch(SQLException se) {
				logger.error("log4jProj1.mod1.SelectTest1.main()::problem in closing connection obj");
			}
			try {
				if(sc!=null)
					sc.close();
				logger.info("log4jProj1.mod1.SelectTest1.main()::Scanner obje is closed");
			}
			catch(Exception e) {
				logger.error("log4jProj1.mod1.SelectTest1.main()::prbolem in  closing scanner obj");
			}
		}
		
	}

}
