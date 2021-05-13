import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class E03_TakeOrSkipRope {
    public static void main(String[] args) {
        String inputText = new Scanner(System.in).nextLine();

        List<Integer> numbers = new ArrayList<>();
        List<Character> nonNumbers = new ArrayList<>();

        for (int i = 0; i < inputText.length(); i++) {
            if (Character.isDigit(inputText.charAt(i))) {
                numbers.add(Integer.parseInt(String.valueOf(inputText.charAt(i))));
            } else {
                nonNumbers.add(inputText.charAt(i));
            }
        }

        StringBuilder result = new StringBuilder();
        int fromIndex = 0;
        for (int i = 0; i < numbers.size(); i++) {
            int toIndex = fromIndex + numbers.get(i);

            if (i % 2 == 0) {
                for (int j = fromIndex; j < toIndex; j++){
                    if(j >= nonNumbers.size()){
                        break;
                    }
                    result.append(nonNumbers.get(j));
                }
            }
            fromIndex = toIndex;
        }

        System.out.println(result);
    }
}
