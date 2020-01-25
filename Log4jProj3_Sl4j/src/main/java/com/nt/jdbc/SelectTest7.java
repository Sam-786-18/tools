//SelectTest3.java
package com.nt.jdbc;
/* Application to get Emp details from emp table based on given Desgs */
import java.sql.DriverManager;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SelectTest7
{    private static Logger  logger=LoggerFactory.getLogger(SelectTest7.class);
	public static void main(String args[]){
		logger.debug("Log4Proj1.mod1.SelectTest3.main(-):Entered into main(-) method");
		Scanner sc=null;
		String desg1=null,desg2=null,desg3=null;
		String cond=null;
		Connection con=null;
		Statement st=null;
		String query=null;
		ResultSet rs=null;
		boolean flag=false;
		try{
			//read inputs
			sc=new Scanner(System.in);
			if(sc!=null){
				System.out.println("Enter Desg1::");
				desg1=sc.next().toUpperCase();  //gives CLERK
				System.out.println("Enter Desg2::");
				desg2=sc.next().toUpperCase();  //gives MANAGER
				System.out.println("Enter Desg3::");
				desg3=sc.next().toUpperCase();  //gives SALESMAN
			}//if
			logger.debug("Log4Proj1.mod1.SelectTest3.main(-): inputs are read enduser");
			//prepare SQL Query condition ('CLERK','MANAGER','SALESMAN')
		     cond="('"+desg1+"','"+desg2+"','"+desg3+"')";
		     logger.debug("Log4Proj1.mod1.SelectTest3.main(-): inputs are Converted as required for the SQL Query");
			 
		     //register JDBC driver s/w
			 Class.forName("oracle.jdbc.driver.OracleDriver");
			 logger.debug("Log4Proj1.mod1.SelectTest3.main(-): JDBC Driver class is Loaded ");
			 
			 //establish the connection
			 con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
			 logger.info("Log4Proj1.mod1.SelectTest3.main(-): Connection is Established with DB s/w ");
			 
			 //create STatement object
			 if(con!=null)
				 st=con.createStatement();
			 logger.debug("Log4Proj1.mod1.SelectTest3.main(-): JDBC Statement object is created ");
			 //prepare  SQL Query
			 //select empno,ename,job,sal,deptno from emp where job in('CLERK','MANAGER','SALESMAN') order by job;
               query="select eno,ename,job,sal,deptno from emp where job in"+cond+"order by job";
               logger.debug("Log4Proj1.mod1.SelectTest3.main(-): Query is prepared::"+query);
			   
			 //send and execute SQL Query in Db s/w
			 if(st!=null)
				 rs=st.executeQuery(query);
			 logger.debug("Log4Proj1.mod1.SelectTest3.main(-):SQL Query is created and ResultSet obj is created");

			 //process the ResultSet
			 if(rs!=null){
                   while(rs.next()){
                         flag=true;
						 System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getInt(4)+"   "+rs.getInt(5));
				   }//while
			 }//if
			 logger.debug("Log4Proj1.mod1.SelectTest3.main(-):ResultSEt obj is Processed");
			 
			 if(flag==false){
				 System.out.println("Records not found");
				 logger.warn("Log4Proj1.mod1.SelectTest3.main(-):Table is Empty-->check Data once"); 
			 }

		 }//try
        catch(ClassNotFoundException cnf){  //To handle known Exception
		  logger.error("Log4Proj1.mod1.SelectTest3.main(-):"+cnf.getMessage());
		}
		catch(SQLException se) {  //To handle known Excepion
           se.printStackTrace();
           logger.error("Log4Proj1.mod1.SelectTest3.main(-): Internal Problem Code::"+se.getErrorCode()+" Msg::"+se.getMessage());
		}
		catch(Exception e){    // To handle unknown Exception
            e.printStackTrace();
            logger.error("Log4Proj1.mod1.SelectTest3.main(-): Unknown problem::"+e.getMessage());
		}
	 finally{
        try{
          if(rs!=null)
			  rs.close();
            logger.debug("Log4Proj1.mod1.SelectTest3.main(-):ResultSet obj is closed ");
		  }//try
		  catch(SQLException se){
			  logger.error("Log4Proj1.mod1.SelectTest3.main(-): problem in closing ResultSet");
		  }
         try{
          if(st!=null)
			  st.close();
          logger.debug("Log4Proj1.mod1.SelectTest3.main(-):Statement obj is closed ");
		  }//try
		  catch(SQLException se){
			  logger.error("Log4Proj1.mod1.SelectTest3.main(-): problem in closing Statement");

		  }
          try{
          if(con!=null)
			  con.close();
          logger.info("Log4Proj1.mod1.SelectTest3.main(-): Connection obj is closed ");
		  }//try
		  catch(SQLException se){
			  logger.error("Log4Proj1.mod1.SelectTest3.main(-): problem in closing Connection");
		  }
		  try{
          if(sc!=null)
			  sc.close();
          logger.info("Log4Proj1.mod1.SelectTest3.main(-): Scanner obj is closed ");
		  }
		  catch(Exception e){
			  logger.error("Log4Proj1.mod1.SelectTest3.main(-): problem in closing Scanner");
		  }
	  }//finally
	 }//main
}//class
//>javac   -d    .  SelectTest3.java
//>java    com.nt.jdbc.SelectTest3

 

