package E01_Logger.models.layouts;

import E01_Logger.interfaces.Layout;

public class SimpleLayout implements Layout {

    @Override
    public String getLayout() {
        return "%s - %s - %s";
    }
}
