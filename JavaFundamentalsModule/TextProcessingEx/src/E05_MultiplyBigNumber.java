import java.util.Scanner;

public class E05_MultiplyBigNumber {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String bigNum = scanner.nextLine().replaceFirst("^0+", "");
        int multiplier = Integer.parseInt(scanner.nextLine());

        if (multiplier == 0) {
            System.out.println(0);
            return;
        }

        StringBuilder result = new StringBuilder();
        int carry = 0;

        for (int i = bigNum.length() - 1; i >= 0; i--) {
            int currentNum = Integer.parseInt(String.valueOf(bigNum.charAt(i)));
            int currentResult = currentNum * multiplier + carry;

            int entities = currentResult % 10;
            carry = currentResult / 10;
            result.insert(0, entities);

            if(i == 0){
                if(carry != 0){
                    result.insert(0, carry);
                }
            }
        }

        System.out.println(result);
    }
}
