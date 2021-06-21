import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class E08_CustomComparator {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.stream(new Scanner(System.in).nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Comparator<Integer> comparator = ((first, second) -> {
          if(first % 2 == 0 && second % 2 != 0){
              return -1;
          } else if (first % 2 != 0 && second % 2 == 0){
              return 1;
          } else {
              if (first <= second){
                  return -1;
              } else {
                  return 1;
              }
          }
        });

        numbers.sort(comparator);
        numbers.forEach(e -> System.out.print(e + " "));
    }
}
