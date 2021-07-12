package com.qa.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {

	private Properties prop;
	
	/*  This method is used to read the config.properties file */
	public Properties readProp() {
		prop = new Properties();
		FileInputStream fs;
		try {
			fs = new FileInputStream("./src/test/resources/config/config.properties");
			prop.load(fs);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
		
	}
	
}
