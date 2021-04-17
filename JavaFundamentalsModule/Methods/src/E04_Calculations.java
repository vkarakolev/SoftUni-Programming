import java.util.Scanner;

public class E04_Calculations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        int firstNum = Integer.parseInt(scanner.nextLine());
        int secondNum = Integer.parseInt(scanner.nextLine());

        switch(command){
            case "add":
                addAndPrintNumbers(firstNum, secondNum);
                break;
            case "subtract":
                subtractAndPrintNumbers(firstNum, secondNum);
                break;
            case "multiply":
                multiplyAndPrintNumbers(firstNum, secondNum);
                break;
            case "divide":
                divideAndPrintNumbers(firstNum, secondNum);
                break;
        }
    }

    static void addAndPrintNumbers(int first, int second){
        System.out.println(first + second);
    }

    static void subtractAndPrintNumbers(int first, int second){
        System.out.println(first - second);
    }

    static void multiplyAndPrintNumbers(int first, int second){
        System.out.println(first * second);
    }

    static void divideAndPrintNumbers(int first, int second){
        System.out.println(first / second);
    }
}
