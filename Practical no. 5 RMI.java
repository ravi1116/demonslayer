//Practical no. 5 contains 4 files. Code for all 4 is given below. Name the 4 files as per given below.


//one.java

import java.rmi.*;
	
	public interface one extends Remote
	{
	 public int palin(String a) throws RemoteException;
	}
    



//two.java

import java.rmi.*;
import java.lang.*;
import java.rmi.server.*;
public class two extends UnicastRemoteObject implements one{
 public two() throws RemoteException { }
 public int palin(String a) throws RemoteException
 {
 System.out.println("Hello");
 StringBuffer str = new StringBuffer(a);
 String str1 = str.toString();
 System.out.println("Print : " + str1.toString());
 StringBuffer str2 = str.reverse();
 System.out.println("Print : " + str2.toString());
 int b = str1.compareTo(str2.toString());
 System.out.println("Print : " + b);
 if (b == 0)
 return 1;
 else
 return 0;
 }
}





//rmiserver.java

import java.io.*;
import java.lang.invoke.MethodHandles.Lookup;
import java.rmi.*; 
import java.rmi.registry.*; 
import java.rmi.server.*;

import java.net.*;
public class rmiserver
{
 public static void main(String args[]) throws Exception
 {
 try
 {
	 two twox = new two();
	
	 Registry registry = LocateRegistry.createRegistry(1880);

	 String name="palin";
	 registry.rebind(name, twox);
	 System.out.println("Object registered");

 }
 catch(Exception e)
 {
 System.out.println("Exception" + e);
 }
 }
}






//rmiclient.java

import java.io.*;
import java.lang.invoke.MethodHandles.Lookup;// for printing reference of a name in registry
import java.rmi.*; 
import java.rmi.registry.*; 


import java.net.*;
public class rmiclient
{
 public static void main(String args[]) throws Exception
 {
 try
 {
	 String name = "palin";
	 Registry registry = LocateRegistry.getRegistry(1880);
	 one pal = (one)registry.lookup(name);
	 int m = pal.palin("123");
	 System.out.println("Print : " + m);
	 if (m == 1)
 {
 System.out.println("The given string is a Palindrome");
 }
 else
 {
 System.out.println("The given string is not a Palindrome");
 }
 }
 catch (Exception e)
 {
 System.out.println("Exception" + e);
 }
 }
}


