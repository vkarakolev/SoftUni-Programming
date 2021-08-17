package E01_Logger.models.appenders;

import E01_Logger.interfaces.File;
import E01_Logger.interfaces.Layout;
import E01_Logger.models.files.LogFile;

public class FileAppender extends BaseAppender {
    private File file;

    public FileAppender(Layout layout) {
        super(layout);
        this.file = new LogFile();
    }

    @Override
    protected void append(String text) {
        this.file.write(text);
    }
}
