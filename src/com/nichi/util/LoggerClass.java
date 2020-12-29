package com.nichi.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
 
public class LoggerClass {

	static Logger log = Logger.getLogger(LoggerClass.class.getName());
	static SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yy HH:mm:ss");
	
	static String returnMessage = "";
 
	static public void logInfo(String infoMessage) {
		
		returnMessage = formatter.format(new Date()) +" "+ infoMessage;
		log.info(returnMessage);
	}
 
	static public void logError(String errorMessage) {
		
		returnMessage = formatter.format(new Date())+" "+errorMessage;
		log.error(errorMessage);
	}
}
