package com.l7.pegasus.templete;

import java.io.IOException;

public class Templetes {

	public String templete(double current) throws IOException {
		
		int ou=(int)current ;
		String result="";
		switch(ou) {
		case 1:
			result=templet1();
			break;
		case 2:
			result=templet2();
			break;
		case 3:
			result=templet3();
			break;
		default:
				result=templet1();
			break;
		
		}
		
		
		return result;
	}
	
	public String templet1() {
		String body="<body>\r\n" + 
				"\r\n" + 
				"  <div style=\"position: relative; left: 0; top: 0;  background-image:url(https://images.unsplash.com/photo-1499781749692-e8274262c718?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60); background-repeat: no-repeat; background-position: center;background-size: cover;\">\r\n" + 
				"\r\n" + 
				"    <img style=\"position: relative;top:0;left:0;right: 0;bottom:0;margin:auto;display:block;\" src=\"__####---####__\" height=\"200\" />\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"    <h1 style=\"position: relative; text-align: center;\">happy birthday __###---###__</h1>\r\n" + 
				"  </div>\r\n" + 
				"\r\n" + 
				"</body>";
		
		
		return body;
	}
	public String templet2() {
		String body="<body>\r\n" + 
				"\r\n" + 
				"  <div style=\"position: relative; left: 0; top: 0;  background-image:url(https://images.unsplash.com/photo-1530103862676-de8c9debad1d?ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=60); background-repeat: no-repeat; background-position: center;background-size: cover;\">\r\n" + 
				"\r\n" + 
				"    <img style=\"position: relative;top:0;left:0;right: 0;bottom:0;margin:auto;display:block;\" src=\"__####---####__\" height=\"200\" />\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"    <h1 style=\"position: relative; text-align: center;\">happy birthday __###---###__</h1>\r\n" + 
				"  </div>\r\n" + 
				"\r\n" + 
				"</body>";
		return body;
	}
	//
	
	public String templet3() {
		String body="<body>\r\n" + 
				"\r\n" + 
				"  <div style=\"position: relative; left: 0; top: 0;  background-image:url(https://images.unsplash.com/photo-1525268771113-32d9e9021a97?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60); background-repeat: no-repeat; background-position: center;background-size: cover;\">\r\n" + 
				"\r\n" + 
				"    <img style=\"position: relative;top:0;left:0;right: 0;bottom:0;margin:auto;display:block;\" src=\"__####---####__\" height=\"200\" />\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"    <h1 style=\"position: relative; text-align: center;\">happy birthday __###---###__</h1>\r\n" + 
				"  </div>\r\n" + 
				"\r\n" + 
				"</body>";
		return body;
	}
	
	
}
