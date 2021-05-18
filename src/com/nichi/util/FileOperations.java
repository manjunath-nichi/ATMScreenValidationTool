package com.nichi.util;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class FileOperations {
	static public String XMLFILEPATH;
	static public String CSSFILEPATH;
	static public String OUTPUTPATH;
	static public String IMAGEFOLDERPATH;
	static public String CORRECTIONSCREENTAG;

	static public int BTNFDK1keyLEFT;
	static public int BTNFDK1keyTOP;
	static public int BTNFDK2keyLEFT;
	static public int BTNFDK2keyTOP;
	static public int BTNFDK3keyLEFT;
	static public int BTNFDK3keyTOP;
	static public int BTNFDK4keyLEFT;
	static public int BTNFDK4keyTOP;
	static public int BTNFDK5keyLEFT;
	static public int BTNFDK5keyTOP;
	static public int BTNFDK6keyLEFT;
	static public int BTNFDK6keyTOP;
	static public int BTNFDK7keyLEFT;
	static public int BTNFDK7keyTOP;
	static public int BTNFDK8keyLEFT;
	static public int BTNFDK8keyTOP;
	static public int BTN_WIDTH;
	static public int BTN_HEIGHT;
	public static int PANEL_HEIGHT = 768;
	public static int PANEL_WIDTH = 1024;

	public void readConfigFile(String configFile) throws Exception {
		// creating a constructor of file class and parsing an XML file
		File file = new File(configFile);

		// Check for existence of file
		if (!file.exists()) {
			throw new Exception(configFile + " - > File does not exists ");
		}
		// an instance of factory that gives a document builder
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		// an instance of builder to parse the specified xml file
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.parse(file);
		doc.getDocumentElement().normalize();
		NodeList nodeList = doc.getElementsByTagName("PARAM");
		// nodeList is not iterable, so we are using for loop
		for (int itr = 0; itr < nodeList.getLength(); itr++) {
			Node node = nodeList.item(itr);
			System.out.println("\nPARENT Node :" + node.getNodeName());
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) node;
				if (eElement.getElementsByTagName("XMLFILEPATH").getLength() > 0) {
					LoggerClass.logInfo(
							"XMLFILEPATH: " + eElement.getElementsByTagName("XMLFILEPATH").item(0).getTextContent());
					XMLFILEPATH = eElement.getElementsByTagName("XMLFILEPATH").item(0).getTextContent();
				} else {
					throw new Exception("missing XMLFILEPATH setting in config file: " + configFile);
				}
				if (eElement.getElementsByTagName("CSSFILEPATH").getLength() > 0) {
					LoggerClass.logInfo(
							"CSSFILEPATH: " + eElement.getElementsByTagName("CSSFILEPATH").item(0).getTextContent());
					CSSFILEPATH = eElement.getElementsByTagName("CSSFILEPATH").item(0).getTextContent();
				} else {
					throw new Exception("missing CSSFILEPATH setting in config file: " + configFile);
				}
				if (eElement.getElementsByTagName("IMAGEFOLDERPATH").getLength() > 0) {
					LoggerClass.logInfo("IMAGEFOLDERPATH: "
							+ eElement.getElementsByTagName("IMAGEFOLDERPATH").item(0).getTextContent());
					IMAGEFOLDERPATH = eElement.getElementsByTagName("IMAGEFOLDERPATH").item(0).getTextContent();
				} else {
					throw new Exception("missing IMAGEFOLDERPATH setting in config file: " + configFile);
				}
				if (eElement.getElementsByTagName("OUTPUTPATH").getLength() > 0) {
					LoggerClass.logInfo(
							"OUTPUTPATH: " + eElement.getElementsByTagName("OUTPUTPATH").item(0).getTextContent());
					OUTPUTPATH = eElement.getElementsByTagName("OUTPUTPATH").item(0).getTextContent();
				} else {
					throw new Exception("missing OUTPUTPATH setting in config file: " + configFile);
				}
				if (eElement.getElementsByTagName("CORRECTIONSCREENTAG").getLength() > 0) {
					LoggerClass.logInfo("CORRECTIONSCREENTAG: "
							+ eElement.getElementsByTagName("CORRECTIONSCREENTAG").item(0).getTextContent());
					CORRECTIONSCREENTAG = eElement.getElementsByTagName("CORRECTIONSCREENTAG").item(0).getTextContent();
				} else {
					throw new Exception("missing CORRECTIONSCREENTAG setting in config file: " + configFile);
				}

				File f = new File(FileOperations.OUTPUTPATH);
				// check for folder existence
				if (!f.exists()) {
					throw new Exception(FileOperations.OUTPUTPATH + "-> path not found");
				}

			}
		}

	}

	public void readCSSFile(String cssFilepath) throws Exception {
		boolean BTNFDK1keyStyleStarted = false;
		boolean BTNFDK2keyStyleStarted = false;
		boolean BTNFDK3keyStyleStarted = false;
		boolean BTNFDK4keyStyleStarted = false;
		boolean BTNFDK5keyStyleStarted = false;
		boolean BTNFDK6keyStyleStarted = false;
		boolean BTNFDK7keyStyleStarted = false;
		boolean BTNFDK8keyStyleStarted = false;
		boolean BTNFDKSizeStarted = false;

		FileInputStream fis = new FileInputStream(cssFilepath);
		InputStreamReader isr = new InputStreamReader(fis, "UTF16");
		BufferedReader reader = new BufferedReader(isr);

		String line;
		while ((line = reader.readLine()) != null) {

			///////// #BTNFDK1key Start////////////////////////////////
			System.out.println(line);
			if (line.trim().equals("#BTNFDK1key")) {
				BTNFDK1keyStyleStarted = true;
				continue;
			}
			if (BTNFDK1keyStyleStarted) {
				if (line.contains("LEFT:")) {
					String tempvalue = line.substring(line.indexOf(":") + 1, line.indexOf("px"));
					BTNFDK1keyLEFT = Integer.parseInt(tempvalue);
					continue;
				} else if (line.contains("TOP:")) {
					String tempvalue = line.substring(line.indexOf(":") + 1, line.indexOf("px"));
					BTNFDK1keyTOP = Integer.parseInt(tempvalue);
					continue;
				}
				if (line.indexOf("}") >= 0) {
					BTNFDK1keyStyleStarted = false;
					continue;
				}
			}
			/////////// #BTNFDK1key End/////////////////////////////////
			///////// #BTNFDK2key Start////////////////////////////////
			if (line.trim().equals("#BTNFDK2key")) {
				BTNFDK2keyStyleStarted = true;
				continue;
			}
			if (BTNFDK2keyStyleStarted) {
				if (line.contains("LEFT:")) {
					String tempvalue = line.substring(line.indexOf(":") + 1, line.indexOf("px"));
					BTNFDK2keyLEFT = Integer.parseInt(tempvalue);
					continue;
				} else if (line.contains("TOP:")) {
					String tempvalue = line.substring(line.indexOf(":") + 1, line.indexOf("px"));
					BTNFDK2keyTOP = Integer.parseInt(tempvalue);
					continue;
				}
				if (line.indexOf("}") >= 0) {
					BTNFDK2keyStyleStarted = false;
					continue;
				}
			}
			/////////// #BTNFDK2key End/////////////////////////////////
			///////// #BTNFDK3key Start////////////////////////////////
			if (line.trim().equals("#BTNFDK3key")) {
				BTNFDK3keyStyleStarted = true;
				continue;
			}
			if (BTNFDK3keyStyleStarted) {
				if (line.contains("LEFT:")) {
					String tempvalue = line.substring(line.indexOf(":") + 1, line.indexOf("px"));
					BTNFDK3keyLEFT = Integer.parseInt(tempvalue);
					continue;
				} else if (line.contains("TOP:")) {
					String tempvalue = line.substring(line.indexOf(":") + 1, line.indexOf("px"));
					BTNFDK3keyTOP = Integer.parseInt(tempvalue);
					continue;
				}
				if (line.indexOf("}") >= 0) {
					BTNFDK3keyStyleStarted = false;
					continue;
				}
			}
			/////////// #BTNFDK3key End/////////////////////////////////
			///////// #BTNFDK4key Start////////////////////////////////
			if (line.trim().equals("#BTNFDK4key")) {
				BTNFDK4keyStyleStarted = true;
				continue;
			}
			if (BTNFDK4keyStyleStarted) {
				if (line.contains("LEFT:")) {
					String tempvalue = line.substring(line.indexOf(":") + 1, line.indexOf("px"));
					BTNFDK4keyLEFT = Integer.parseInt(tempvalue);
					continue;
				} else if (line.contains("TOP:")) {
					String tempvalue = line.substring(line.indexOf(":") + 1, line.indexOf("px"));
					BTNFDK4keyTOP = Integer.parseInt(tempvalue);
					continue;
				}
				if (line.indexOf("}") >= 0) {
					BTNFDK4keyStyleStarted = false;
					continue;
				}
			}
			/////////// #BTNFDK4key End/////////////////////////////////
			///////// #BTNFDK5key Start////////////////////////////////
			if (line.trim().equals("#BTNFDK5key")) {
				BTNFDK5keyStyleStarted = true;
				continue;
			}
			if (BTNFDK5keyStyleStarted) {
				if (line.contains("LEFT:")) {
					String tempvalue = line.substring(line.indexOf(":") + 1, line.indexOf("px"));
					BTNFDK5keyLEFT = Integer.parseInt(tempvalue);
					continue;
				} else if (line.contains("TOP:")) {
					String tempvalue = line.substring(line.indexOf(":") + 1, line.indexOf("px"));
					BTNFDK5keyTOP = Integer.parseInt(tempvalue);
					continue;
				}
				if (line.indexOf("}") >= 0) {
					BTNFDK5keyStyleStarted = false;
					continue;
				}
			}
			/////////// #BTNFDK5key End/////////////////////////////////
			///////// #BTNFDK6key Start////////////////////////////////
			if (line.trim().equals("#BTNFDK6key")) {
				BTNFDK6keyStyleStarted = true;
				continue;
			}
			if (BTNFDK6keyStyleStarted) {
				if (line.contains("LEFT:")) {
					String tempvalue = line.substring(line.indexOf(":") + 1, line.indexOf("px"));
					BTNFDK6keyLEFT = Integer.parseInt(tempvalue);
					continue;
				} else if (line.contains("TOP:")) {
					String tempvalue = line.substring(line.indexOf(":") + 1, line.indexOf("px"));
					BTNFDK6keyTOP = Integer.parseInt(tempvalue);
					continue;
				}
				if (line.indexOf("}") >= 0) {
					BTNFDK6keyStyleStarted = false;
					continue;
				}
			}
			/////////// #BTNFDK6key End/////////////////////////////////
			///////// #BTNFDK7key Start////////////////////////////////
			if (line.trim().equals("#BTNFDK7key")) {
				BTNFDK7keyStyleStarted = true;
				continue;
			}
			if (BTNFDK7keyStyleStarted) {
				if (line.contains("LEFT:")) {
					String tempvalue = line.substring(line.indexOf(":") + 1, line.indexOf("px"));
					BTNFDK7keyLEFT = Integer.parseInt(tempvalue);
					continue;
				} else if (line.contains("TOP:")) {
					String tempvalue = line.substring(line.indexOf(":") + 1, line.indexOf("px"));
					BTNFDK7keyTOP = Integer.parseInt(tempvalue);
					continue;
				}
				if (line.indexOf("}") >= 0) {
					BTNFDK7keyStyleStarted = false;
					continue;
				}
			}
			/////////// #BTNFDK7key End/////////////////////////////////
			///////// #BTNFDK8key Start////////////////////////////////
			if (line.trim().equals("#BTNFDK8key")) {
				BTNFDK8keyStyleStarted = true;
				continue;
			}
			if (BTNFDK8keyStyleStarted) {
				if (line.contains("LEFT:")) {
					String tempvalue = line.substring(line.indexOf(":") + 1, line.indexOf("px"));
					BTNFDK8keyLEFT = Integer.parseInt(tempvalue);
					continue;
				} else if (line.contains("TOP:")) {
					String tempvalue = line.substring(line.indexOf(":") + 1, line.indexOf("px"));
					BTNFDK8keyTOP = Integer.parseInt(tempvalue);
					continue;
				}
				if (line.indexOf("}") >= 0) {
					BTNFDK8keyStyleStarted = false;
					continue;
				}
			}
			/////////// #BTNFDK8key End/////////////////////////////////
			///////// #BTNWidth Start////////////////////////////////
			if (line.trim().indexOf("#BTNFDK8key00IMG") >= 0) {
				BTNFDKSizeStarted = true;
				continue;
			}
			if (BTNFDKSizeStarted) {
				if (line.contains("WIDTH:")) {
					String tempvalue = line.substring(line.indexOf(":") + 1, line.indexOf("px"));
					BTN_WIDTH = Integer.parseInt(tempvalue);
					continue;
				} else if (line.contains("HEIGHT:")) {
					String tempvalue = line.substring(line.indexOf(":") + 1, line.indexOf("px"));
					BTN_HEIGHT = Integer.parseInt(tempvalue);
					continue;
				}
				if (line.indexOf("}") >= 0) {
					BTNFDKSizeStarted = false;
					continue;
				}
			}
			/////////// #BTNFDK8key End/////////////////////////////////

		}
		reader.close(); // closes the stream and release the resources
		isr.close();
		fis.close();

	}

	public void readAdditionalXMLFile(String xmlFilepath) throws Exception {
		boolean fdk1reset = false;
		boolean fdk2reset = false;
		boolean fdk3reset = false;
		boolean fdk4reset = false;
		boolean fdk5reset = false;
		boolean fdk6reset = false;
		boolean fdk7reset = false;
		boolean fdk8reset = false;

		final String[] encodings = { "UTF-16LE", "UTF-16", "UTF-8", "US-ASCII", "ISO-8859-1", "UTF-16BE" };

		for (String encoding : encodings) {
			FileInputStream fis = new FileInputStream(xmlFilepath);
			InputStreamReader isr = new InputStreamReader(fis, encoding);
			BufferedReader reader = new BufferedReader(isr);

			String line;
			boolean canReadData = false;
			boolean commentedpart = false;

			while ((line = reader.readLine()) != null) {

				////// Start skiping unwanted string

				// Check if its commented
				if (line.indexOf("<!--") >= 0) {
					commentedpart = true;
				}
				if (line.indexOf("-->") >= 0) {
					commentedpart = false;
					continue;
				}
				// skip line if its commented
				if (commentedpart == true) {
					continue;
				}

				if (line.indexOf("<screen id = \"" + CORRECTIONSCREENTAG + "\">") >= 0) {
					canReadData = true;
					continue;
				}
				if (line.indexOf("</screen>") >= 0) {
					canReadData = false;
					continue;
				}
				// skip line if its inside screen tag
				if (canReadData == false) {
					continue;
				}
				// Skip line other than _correctData
				if (line.indexOf("_correctData") < 0) {
					continue;
				}

				///// end of skiping unwanted string

				if (line.indexOf("fdkA_correctData") > 0 && fdk1reset == false) {
					BTNFDK1keyTOP = BTNFDK1keyTOP + resetYPositionForFDK(line, "F");
					fdk1reset = true;
				} else if (line.indexOf("fdkB_correctData") >= 0 && fdk2reset == false) {
					BTNFDK2keyTOP = BTNFDK2keyTOP + resetYPositionForFDK(line, "I");
					fdk2reset = true;
				} else if (line.indexOf("fdkC_correctData") >= 0 && fdk3reset == false) {
					BTNFDK3keyTOP = BTNFDK3keyTOP + resetYPositionForFDK(line, "L");
					fdk3reset = true;
				} else if (line.indexOf("fdkD_correctData") >= 0 && fdk4reset == false) {
					BTNFDK4keyTOP = BTNFDK4keyTOP + resetYPositionForFDK(line, "O");
					fdk4reset = true;
				} else if (line.indexOf("fdkF_correctData") >= 0 && fdk5reset == false) {
					BTNFDK5keyTOP = BTNFDK5keyTOP + resetYPositionForFDK(line, "O");
					fdk5reset = true;
				} else if (line.indexOf("fdkG_correctData") >= 0 && fdk6reset == false) {
					BTNFDK6keyTOP = BTNFDK6keyTOP + resetYPositionForFDK(line, "L");
					fdk6reset = true;
				} else if (line.indexOf("fdkH_correctData") >= 0 && fdk7reset == false) {
					BTNFDK7keyTOP = BTNFDK7keyTOP + resetYPositionForFDK(line, "I");
					fdk7reset = true;
				} else if (line.indexOf("fdkI_correctData") >= 0 && fdk8reset == false) {
					BTNFDK8keyTOP = BTNFDK8keyTOP + resetYPositionForFDK(line, "F");
					fdk8reset = true;
				}

			}

			if (fdk1reset == true && fdk2reset == true && fdk3reset == true && fdk4reset == true && fdk5reset == true
					&& fdk6reset == true && fdk7reset == true && fdk8reset == true) {
				break;
			}

			reader.close(); // closes the stream and release the resources
			isr.close();
			fis.close();

		}

		if (fdk1reset == false || fdk2reset == false || fdk3reset == false || fdk4reset == false || fdk5reset == false
				|| fdk6reset == false || fdk7reset == false || fdk8reset == false) {
			LoggerClass.logInfo("WARNING:  No correction data been applied ! Correction data with give screen id:'"
					+ CORRECTIONSCREENTAG + "' may not be found !");
		}

	}

	//2021-05-13 1338-2 Add START change request
	private int resetYPositionForFDK(String targetLine, String buttonType) {
		int extraTop = 0;

		String[] column = targetLine.split("/");

		for (int i = 0; i < column.length; i++) {

			String columnValue = column[i];

			if (columnValue.contains(">")) {
				columnValue = columnValue.substring(columnValue.indexOf(">") + 1, columnValue.length());
			}

			if (columnValue.contains("<")) {
				columnValue = columnValue.substring(0, columnValue.indexOf("<"));
			}
			
			if (columnValue.indexOf(",") >= 0) {
				String[] values = columnValue.split(",");				
				extraTop = Integer.parseInt(values[2].substring(0, values[2].length()));
			}

			if (columnValue.startsWith("F") && buttonType.equals("F")) {
				return extraTop;
			} else if (columnValue.startsWith("I") && buttonType.equals("I")) {
				return extraTop;
			} else if (columnValue.startsWith("L") && buttonType.equals("L")) {
				return extraTop;
			} else if (columnValue.startsWith("O") && buttonType.equals("O")) {
				return extraTop;
			} 

		}

		return 0;
	}
	//2021-05-13 1338-2 Add END change request 

//2021-05-13 1338-2 delete START change request 
//	private int resetYPositionForFDK(String targetLine) {
//		int extraTop = 0;
//
//		if (targetLine.indexOf(",") >= 0) {
//			String[] values = targetLine.split(",");
//			if (values[2].indexOf("<") > 0) {
//				extraTop = Integer.parseInt(values[2].substring(0, values[2].indexOf("<")));
//			} else {
//				extraTop = Integer.parseInt(values[2].substring(0, values[2].indexOf("/")));
//			}
//		}
//
//		return extraTop;
//	}
//2021-05-13 1338-2 delete END change request
}
