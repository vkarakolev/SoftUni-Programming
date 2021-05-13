import java.util.*;
import java.util.stream.Collectors;

public class E04_MixedUpLists {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> first = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        List<Integer> second = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int firstElement;
        int secondElement;

        if(first.size() > second.size()){
            firstElement = first.get(first.size() - 1);
            secondElement = first.get(first.size() - 2);
        } else {
            firstElement = second.get(0);
            secondElement = second.get(1);
        }

        int rangeFrom;
        int rangeTo;

        if(firstElement > secondElement){
            rangeFrom = secondElement;
            rangeTo = firstElement;
        } else {
            rangeFrom = firstElement;
            rangeTo = secondElement;
        }

        List<Integer> resultList = new ArrayList<>();
        for (int i = 0; i < second.size(); i++) {
            if(first.get(i) > rangeFrom && first.get(i) < rangeTo){
                resultList.add(first.get(i));
            }
            if(second.get(i) > rangeFrom && second.get(i) < rangeTo){
                resultList.add(second.get(i));
            }
        }

        Collections.sort(resultList);
        for (Integer i : resultList) {
            System.out.print(i + " ");
        }
    }
}
