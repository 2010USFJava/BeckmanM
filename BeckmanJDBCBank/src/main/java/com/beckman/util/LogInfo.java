package com.beckman.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LogInfo {
	static Logger logger = LogManager.getLogger();
	//static Logger log = Logger.getLogger(LogInfo.class.getName())
	
	public static void LogIt(String level, String message) {
		switch(level) {
		case "debug":
			logger.debug(message);
			break;
		case "warn":
			logger.warn(message);
			break;
		case "fatal":
			logger.fatal(message);
			break;
		case "info":
			logger.info(message);
			break;
		case "trace":
			logger.trace(message);
			break;
		default:
			System.out.println("logger dumb");
		}
	}
	

}
