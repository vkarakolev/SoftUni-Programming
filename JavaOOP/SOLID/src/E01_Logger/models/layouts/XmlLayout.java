package E01_Logger.models.layouts;

import E01_Logger.interfaces.Layout;

public class XmlLayout implements Layout {

    @Override
    public String getLayout() {
        StringBuilder sb = new StringBuilder();
        sb.append("<log>%n")
                .append("   <date>%s</date>%n")
                .append("   <level>%s</level>%n")
                .append("   <message>%s</message>%n")
                .append("</log>");

        return sb.toString();
    }
}
