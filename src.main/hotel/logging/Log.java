package hotel.logging;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Log {
	//private static Log log = null;
	private static Logger _log = Logger.getLogger(Log.class.getName());
	public enum eLogLevel {ERROR,WARN,DEBUG,FATAL,ALL};
		
	private Log()
	{
		
	}
	
	/*private Log(Logger objLog)	
	{
		this();
		setLogger(objLog);
	}
	
	private void setLogger(Logger objLog) {
		// TODO Auto-generated method stub
		_log = objLog;
	}

	public static Log getInstance(){
		if (log==null)
			log = new Log(Logger.getLogger(Log.class.getName()));
		return log;			 
	}
	
	*/
	public static void write(eLogLevel logLevel, String message)
	{		
		switch(logLevel)
		{
		case ERROR:
			_log.error(message);
			break;
		case WARN:
			_log.warn(message);
			break;
		case DEBUG:
			_log.debug(message);
			break;
		case FATAL:
			_log.fatal(message);
			break;
		default:
			_log.info(message);
		}
		
	}


}
