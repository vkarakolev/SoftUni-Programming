package E01_Logger;

import E01_Logger.enums.ReportLevel;
import E01_Logger.interfaces.Appender;
import E01_Logger.interfaces.Layout;
import E01_Logger.interfaces.Logger;
import E01_Logger.models.appenders.ConsoleAppender;
import E01_Logger.models.layouts.SimpleLayout;
import E01_Logger.models.loggers.MessageLogger;

public class Main {
    public static void main(String[] args) {
        Layout simpleLayout = new SimpleLayout();
        Appender consoleAppender = new ConsoleAppender(simpleLayout);
        consoleAppender.setReportLevel(ReportLevel.ERROR);

        Logger logger = new MessageLogger(consoleAppender);

        logger.logInfo("3/31/2015 5:33:07 PM", "Everything seems fine");
        logger.logWarning("3/31/2015 5:33:07 PM", "Warning: ping is too high - disconnect imminent");
        logger.logError("3/31/2015 5:33:07 PM", "Error parsing request");
        logger.logCritical("3/31/2015 5:33:07 PM", "No connection string found in App.config");
        logger.logFatal("3/31/2015 5:33:07 PM", "mscorlib.dll does not respond");
    }
}
