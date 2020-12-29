package com.nichi.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
 
import com.nichi.util.FileOperations;
import com.nichi.util.LoggerClass;
import com.nichi.view.ImageSlider;

public class Launcher {
	// adding static block
	static {
		
		SimpleDateFormat dateFormate = new SimpleDateFormat("yyyyMMdd-HHmmss");
		System.setProperty("current.date.time", dateFormate.format(new Date()));
		 
	}

	final static Logger log = Logger.getLogger(Launcher.class);

	public static void main(String[] args) {
		try {
			BasicConfigurator.configure();

			FileOperations fileOperations = new FileOperations();

			String configFile = "application.config.xml";
			if( args.length >= 1) {
				configFile = args[0]; //
			}
			//Start Reading application config file
			LoggerClass.logInfo("Start Reading application config file :" + configFile);
			fileOperations.readConfigFile(configFile);
			LoggerClass.logInfo("End Reading application config file :" + configFile);
			//End Reading application config file
			
			//Start Reading CSS file
			LoggerClass.logInfo("Start Reading CSS file :" + FileOperations.CSSFILEPATH);
			// Check for existence of file
			File csvfile = new File(FileOperations.CSSFILEPATH);
			if (!csvfile.exists()) {
				throw new Exception(FileOperations.CSSFILEPATH + " - > File does not exists ");
			}
			fileOperations.readCSSFile(FileOperations.CSSFILEPATH);

			LoggerClass.logInfo("End Reading CSS file :" + FileOperations.CSSFILEPATH);
			//End Reading CSS file
			
			//Start Reading XML file
			LoggerClass.logInfo("Start Reading XML file :" + FileOperations.XMLFILEPATH);
			// Check for existence of file
			File xmlfile = new File(FileOperations.XMLFILEPATH);
			if (!xmlfile.exists()) {
				throw new Exception(FileOperations.XMLFILEPATH + " - > File does not exists ");
			}
			fileOperations.readAdditionalXMLFile(FileOperations.XMLFILEPATH);
			LoggerClass.logInfo("End Reading XML file :" + FileOperations.XMLFILEPATH);
			//End Reading XML file
			
			//Start of Screen Validation
			LoggerClass.logInfo("Start Screen Validation");
			ImageSlider mageSlider = new ImageSlider();
			mageSlider.createScreen();
			LoggerClass.logInfo("End Screen Validation");
			//End of Screen Validation

		} catch (Exception e) {
			String stackTrace = ExceptionUtils.getStackTrace(e);
			LoggerClass.logError(stackTrace);
			System.exit(0);
		}

	}

}
