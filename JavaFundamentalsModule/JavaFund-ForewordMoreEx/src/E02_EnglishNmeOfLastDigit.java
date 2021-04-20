import java.util.Scanner;

public class E02_EnglishNmeOfLastDigit {
    public static void main(String[] args) {
        String inputLine = new Scanner(System.in).nextLine();

        System.out.println(returnDigitName(inputLine));
    }

    static String returnDigitName(String input){
        String[] digits = input.split("");
        String name = "";
        switch (digits[digits.length - 1]){
            case "1":
                name = "one";
                break;
            case "2":
                name = "two";
                break;
            case "3":
                name = "three";
                break;
            case "4":
                name = "four";
                break;
            case "5":
                name = "five";
                break;
            case "6":
                name = "six";
                break;
            case "7":
                name = "seven";
                break;
            case "8":
                name = "eight";
                break;
            case "9":
                name = "nine";
                break;
            case "0":
                name = "zero";
                break;
        }
        return name;
    }
}
