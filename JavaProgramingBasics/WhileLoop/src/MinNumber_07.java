import java.util.Scanner;

public class MinNumber_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int min = Integer. MAX_VALUE;

        while(true){
            String input = scanner.nextLine();
            if(!input.equals("Stop")){
                int value = Integer.parseInt(input);

                if(value < min){
                    min = value;
                }
            } else {
                System.out.println(min);
                break;
            }
        }
    }
}
