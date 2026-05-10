// Practical no. 7 requires creation of 'dynamic web project' and has 3 codes to be written in 3 separate files.


// Link to download Apache Tomcat Server: https://tomcat.apache.org/download-80.cgi

// Windows----- Show View------------other ------------ server------------Apache Tomcat Server 8.5v-
// ----------browse and select the folder where you have downloaded and extracted the Tomcat Server------finish

// -----file ----------other----- dynamic web project------enter project name and click finish-----next ----next ----check box-----finish
// java/src/main ----------package ------under it create new class file --------name Validation----
//Validation.java file

package com.servlet;

import java.io.*; 
import java.util.*; 
import javax.servlet.*; 
public class Validation extends GenericServlet 
{ 
public void service(ServletRequest req,ServletResponse res)throws 
ServletException,IOException 
{ 
PrintWriter pw=res.getWriter(); 
String x=req.getParameter("user"); 
String y=req.getParameter("pwd"); 
if(x.equals("admin")&&y.equals("admin")) 
pw.println("<font color='green' size='5'>Welcome to this webpage</font>"); 
else 
pw.println("<font color='red' size='5'>Invalid username or password</font>"); 
pw.close(); 
} 
}

// copy above code in same project 
//then src----- main ------webapp------right click and create html file--------name Login.html and copy below code in it
//if server in use ------cmd-----run as admin-----netstat -ano | findstr :8080------note the PID number----
// --taskkill /PID 1234 /F (replace 1234 with your PID number)------then run the server again
//youll get code running 


//Login.html file

<html> 
<head><title>login</title></head> 
<body> 
<form name="login form" method="get" 
action="http://localhost:8080/examples/servlet/Validation"> 
<br/><br/><br/><br/><br/> 
<table align="center" border="3" border color="blue" cellspacing="0"height="120"> 
<tr></font></td></trtd align="center"><font color="blue" size="4">LOGIN FORM<> 
<tr><td><table><tr><td>UserName</td><td><input type="text" name="user"/></td></tr> 
<tr><td>Password</td><td><input type="password" name="pwd"/></td></tr> 
<tr><td align="center"><input type="submit" value="Submit"/></td><td 
align="center"><input type="Reset" value="RESET"/></td></tr> 
</table></td></tr></table></form></body> 
</html>

 youll find web.info folder in your project----- under it create new file named web.xml and copy below code in it
 my  srv scene  
//web.xml file

<web-app>
	
 <servlet>
 <servlet-name>logindemo</servlet-name>
 <servlet-class>com.servlet.Validation</servlet-class>
 </servlet>
 
 <servlet-mapping>
 <servlet-name>logindemo</servlet-name>
 <url-pattern>/MySrv</url-pattern>
 </servlet-mapping>

</web-app>

