import java.util.Scanner;

public class E01_DataTypeFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        while(!input.equals("END")){
            String type;
            if(Character.isLetter(input.charAt(0))){
                if(input.length() == 1){
                    type = "character";
                } else if (input.equals("true") || input.equals("false")){
                    type = "boolean";
                } else {
                    type = "string";
                }
            } else if (Character.isDigit(input.charAt(0))
                    || input.charAt(0) == '-' && Character.isDigit(input.charAt(1))){
                if(input.contains(".")){
                    type = "floating point";
                } else {
                    type = "integer";
                }

                for (int i = 2; i < input.length(); i++) {
                    if(!Character.isDigit(input.charAt(i)) && input.charAt(i) != '.'){
                        type = "string";
                    }
                }
            } else {
                if(input.length() > 1){
                    type = "string";
                } else {
                    type = "character";
                }
            }
            System.out.printf("%s is %s type%n", input, type);

            input = scanner.nextLine();
        }
    }
}
