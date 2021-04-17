import java.util.Scanner;

public class E02_CharacterMultiplier {
    public static void main(String[] args) {
        String[] input = new Scanner(System.in).nextLine().split(" ");

        int sum = multiplyCharCodes(input[0], input[1]);
        System.out.println(sum);
    }

    static int multiplyCharCodes (String first, String second){
        int sum = 0;

        for (int i = 0; i < Math.min(first.length(), second.length()); i++) {
            sum += first.charAt(i) * second.charAt(i);
        }

        if(first.length() > second.length()){
            for (int i = second.length(); i < first.length(); i++) {
                sum += first.charAt(i);
            }
        } else {
            for (int i = first.length(); i < second.length(); i++) {
                sum += second.charAt(i);
            }
        }

        return sum;
    }
}
