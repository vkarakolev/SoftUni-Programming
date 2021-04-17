import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class E01_SumAdjacentEqualNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Double> inputList = parseLineOfInts(scanner);

        int i = 0;
        while(i < inputList.size() - 1){
            double current = inputList.get(i);
            double next = inputList.get(i + 1);
            if(current == next){
                inputList.remove(i);
                inputList.set(i, current + next);
                i = 0;
            } else {
                i++;
            }
        }

        for (Double number : inputList) {
            System.out.print(new DecimalFormat("0.#").format(number) + " ");
        }

    }

    static List parseLineOfInts(Scanner scanner){
        String[] inputLine = scanner.nextLine().split(" ");
        List<Double> list = new ArrayList<>();
        for (String s : inputLine) {
            list.add(Double.parseDouble(s));
        }
        return list;
    }
}
