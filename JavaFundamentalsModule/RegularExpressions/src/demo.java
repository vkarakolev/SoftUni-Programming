import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class demo {
    public static void main(String[] args) {
        String text = "Hello regular expressions, this is l3cture number 7 in the java fundamentals course 2020.";
        String expression = "[A-Z][A-Za-z]+";

        Pattern pattern = Pattern.compile(expression);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            System.out.println(matcher.group());
        }


        /*StringBuilder currentNumberStr = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char currentChar = text.charAt(i);
           if(Character.isUpperCase(currentChar)){
               currentNumberStr.append(currentChar);
           } else if (Character.isAlphabetic(currentChar) && currentNumberStr.length() > 0){
               currentNumberStr.append(currentChar);
           } else if (currentNumberStr.length() > 0) {
               System.out.println(currentNumberStr);
               currentNumberStr = new StringBuilder();
           }    */

            /*if(Character.isDigit(currentChar)){
                currentNumberStr.append(currentChar);
            } else if (currentNumberStr.length() != 0) {
                System.out.println(currentNumberStr);
                currentNumberStr = new StringBuilder();
            }*/

    }
}
