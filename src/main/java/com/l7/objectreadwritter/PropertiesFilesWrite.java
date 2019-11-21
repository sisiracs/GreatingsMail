package com.l7.objectreadwritter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

import com.l7.dto.TempletDto;

public class PropertiesFilesWrite {

	public boolean templeteConfigWrite(String filepath, TempletDto templetObj) throws IOException {
		OutputStream output = new FileOutputStream(new File(filepath));
		Properties prop = new Properties();
		prop.setProperty("currentTempleteNumber", templetObj.getCurrentTempleteNumber() + "");
		prop.setProperty("TotalNUmberOfTemeplete", templetObj.getTotalNUmberOfTemeplete() + "");
		prop.store(output, null);
		return true;

	}
}
