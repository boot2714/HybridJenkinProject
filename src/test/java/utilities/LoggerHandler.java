package utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class LoggerHandler {

	static Logger logger;

	public static Logger InitLogger() 
	{
		try {
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss");
				System.setProperty("current.date.time", dateFormat.format(new Date()));
				logger = Logger.getLogger("LoggerHandler.class");
				String path = System.getProperty("user.dir")+"/Logs/log.properties";
		       PropertyConfigurator.configure(path);
	
		} 
		catch (Exception e) {
				e.printStackTrace();
		}
		return logger;
	}

	public static void logInfo(String message) {
	    logger.info(message);
	}

	public static void logDebug(String message) {
	    logger.debug(message);
	}

	public static void logWarn(String message) {
	    logger.warn(message);
	}

	public static void logError(String message) {
	    logger.error(message);
	}

	public static void logFatal(String message) {
	    logger.fatal(message);
	}

	public static void logTrace(String message) {
	    logger.trace(message);
	}
}
