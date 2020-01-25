function validate(form) {
	//change vflag value 'yes' indicating client side form validation are done
	form.vflag.value="yes";
	alert("VoterApp:Client side form validation logics");
	//empthy error message 
	document.getElementById("nameErr").innerHTML="";
	document.getElementById("ageErr").innerHTML="";
	document.getElementById("nameErr").style.color="red";
	document.getElementById("ageErr").style.color="red";
	
	//read form date
	var name=form.pname.value;
	var age=form.page.value;
	//perform client side form validation
	if(name==""){
		//required rule
		document.getElementById("nameErr").innerHTML="<i>persion name is mandatory</i>";
		form.pname.focus();
		return false;
	}
	else{
		//age must be numeric value
		if(isNaN(age)){
			document.getElementById("ageErr").innerHTML="<i>person age must be numeric value<i/>";		
			form.page.focus();
			form.page.value="";
			return false;
		}
	}
	
	
}