<%
//reading form data
String uname=request.getParameter("uname");
String pwd=request.getParameter("pwd");
//form validation
if(uname.equalsIgnoreCase("")||pwd.equalsIgnoreCase("")){
	out.println("Provide Inputs");
	return;
}
//place Authentication
if(uname.equalsIgnoreCase("satish")&& pwd.equalsIgnoreCase("meena")){
	out.println("Valid Crendtial");
}
	else{
		out.println("Invalid Crendtial");
	}
		


%>