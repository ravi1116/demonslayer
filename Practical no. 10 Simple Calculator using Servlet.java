// Practical no. 10 requires creation of 'dynamic web project' and has 3 codes to be written in 3 separate files namely: CalculatorServlet.java (Servlet code), Index.html (HTML code), web.xml (XML code)

//For steps, refer video on link: https://youtu.be/WpyUS272Yvk

// Link to download Apache Tomcat Server: https://tomcat.apache.org/download-80.cgi



//CalculatorServlet.java file

package com;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class CalculatorServlet extends HttpServlet {
public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException {
int result = 0;
try {
String number1 = req.getParameter("num1");
String number2 = req.getParameter("num2");
String operator = req.getParameter("op");
int x = Integer.parseInt(number1);
int y = Integer.parseInt(number2);
if(operator.equals("+")) {
result = x + y;
}
else if(operator .equals("-")) {
result = x - y;
}
else if(operator.equals("*")) {
result = x * y;
}
else if(operator.equals("/")) {
result = x/y;
}
PrintWriter p = res.getWriter();
p.println("<h1> Result= "+result);
}
catch(Exception e) {}
}
}


//index.html file

<html>
<head>
<meta charset="ISO-8859-1">
<title>Calculator Application Using Servlet</title>
</head>
<body>
<form method=get action="./MyServ" >
Enter First Number <input type="text" name="num1"><br>
Enter Second Number <input type="text" name="num2" ><br>
Select an Operation<input type="radio" name="op" value="+">
ADDTION <input type="radio" name="op" value="-">
SUBSTRACTION <input type="radio" name="op" value="*">
MULTIPLY <input type="radio" name="op" value="/">
DIVIDE <br><input type="reset">
<input type="submit" value="Calculate" >
</form>
</body>
</html>


//web.xml file

<web-app>

<servlet>
<servlet-name>calc</servlet-name>
<servlet-class>com.CalculatorServlet</servlet-class>
</servlet>

<servlet-mapping>
<servlet-name>calc</servlet-name>
<url-pattern>/MyServ</url-pattern>
</servlet-mapping>

</web-app>


 