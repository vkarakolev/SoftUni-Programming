import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class E03_MergingLists {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> firstList = parseLineToInts(scanner);
        List<Integer> secondList = parseLineToInts(scanner);
        List<Integer> mergedList = new ArrayList<>();

        int currentIndex = 0;
        while(currentIndex < firstList.size() || currentIndex < secondList.size()){
            if(currentIndex < firstList.size()) {
                mergedList.add(firstList.get(currentIndex));
            }

            if(currentIndex < secondList.size()) {
                mergedList.add(secondList.get(currentIndex));
            }

            currentIndex++;
        }

        for (Integer num : mergedList) {
            System.out.print(num + " ");
        }


    }

    static List<Integer> parseLineToInts (Scanner scanner){
        String[] inputLine = scanner.nextLine().split(" ");
        List<Integer> inputList = new ArrayList<>();
        for (String s : inputLine) {
            inputList.add(Integer.parseInt(s));
        }

        return (inputList);
    }
}
