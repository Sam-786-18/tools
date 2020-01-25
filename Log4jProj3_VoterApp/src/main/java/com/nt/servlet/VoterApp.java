package com.nt.servlet;



import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class VoterApp extends HttpServlet{
	Logger logger=Logger.getLogger(VoterApp.class);
	
	public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
		logger.debug("Enter into doGet(-,-)method(-)");
		PrintWriter pw=null;
		String name=null,tage=null;
		int age=0;
		List<String> errList=null;
		String vstatus=null;
		//get PrintWriter
		pw=res.getWriter();
		name=req.getParameter("pname");
		tage=req.getParameter("page");
		logger.debug("REad from in doGet(-,-)method(-)");
		//read vflag value to enable or server
		vstatus=req.getParameter("vflag");
		if(vstatus.equalsIgnoreCase("no"));
		//form Validation logic (server side)
		logger.debug("enabling server side form valodatiom in doGet(-,)");
		errList=new ArrayList<>();
		if(name==null||name.equals("")||name.length()==0) {
			errList.add("Person name is manadatory");
		
		if(tage==null||tage.equals("")||tage.length()==0) {
			errList.add("Person age is manadatory");
		}
		else {
			try {
				age=Integer.parseInt(tage);
			}
			catch(Exception e) {
				errList.add("Person age must be numeric value");
			}
		}
		
		if(errList.size()!=0) {
			logger.debug("Displaying validation error message in doGet()");
			//display error message
			for(String err:errList) {
			pw.println("<p style='color:maroon'</p>");
			
			}
			return;
		}//for
		
	}//if
		
	else {
		age=Integer.parseInt(tage);
	
		//process the req (b.logics)
		logger.debug("Executing b.logic in doget(-,-)");
		if(age<18)
			pw.println("<h1 style='color:red'><center>"+name+"u r not eligible to vote</center></h1>");
		else 
			pw.println("<h1 style='color:blue'><center>\"+name+\"u r  eligible to vote</center></h1>");
		//add graphical hyperlink
		pw.println("<a href='input.html'><img src='tips.gif'><a/>");
		//close stream
		pw.close();
			
		}//else
		
	}//doget()
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		logger.debug("Entered into doPost(-,-)");
		doPost(req, res);
	}
}
