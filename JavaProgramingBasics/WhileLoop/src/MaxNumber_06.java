import java.util.Scanner;

public class MaxNumber_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int max = Integer. MIN_VALUE;

        while(true){
            String input = scanner.nextLine();
            if(!input.equals("Stop")){
                int value = Integer.parseInt(input);

                if(value > max){
                    max = value;
                }
            } else {
                System.out.println(max);
                break;
            }
        }
    }
}
