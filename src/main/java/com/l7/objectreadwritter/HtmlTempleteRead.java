package com.l7.objectreadwritter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class HtmlTempleteRead {
	
	public static void main(String[] args) {
		HtmlTempleteRead o = new HtmlTempleteRead();
		try {										
			System.out.println(o.readHTMLtemplete("data/htmlTemplete/templete_1.txt"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String readHTMLtemplete(String filename) throws IOException {
		
		String fileString = new String(Files.readAllBytes(Paths.get(filename))); //, StandardCharsets.UTF_8
             
		return fileString;
		
	}

}
