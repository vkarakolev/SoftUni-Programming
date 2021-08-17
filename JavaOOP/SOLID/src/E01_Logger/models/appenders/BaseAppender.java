package E01_Logger.models.appenders;

import E01_Logger.enums.ReportLevel;
import E01_Logger.interfaces.Appender;
import E01_Logger.interfaces.Layout;

public abstract class BaseAppender implements Appender {
    private Layout layout;
    private ReportLevel reportLevel;

    public BaseAppender(Layout layout) {
        this.layout = layout;
        this.reportLevel = ReportLevel.INFO;
    }

    protected abstract void append(String text);

    @Override
    public void appendMessage(String dateTime, ReportLevel reportLevel, String message) {
        if(reportLevel.ordinal() >= this.reportLevel.ordinal()) {
            String result = String.format(this.layout.getLayout(), dateTime, reportLevel.toString(), message);
            this.append(result);
        }
    }

    @Override
    public void setReportLevel(ReportLevel reportLevel) {
        this.reportLevel = reportLevel;
    }
}
