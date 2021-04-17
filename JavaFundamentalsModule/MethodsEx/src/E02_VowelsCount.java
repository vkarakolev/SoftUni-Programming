import java.util.Scanner;

public class E02_VowelsCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println(countVowels(input));
    }

    static int countVowels(String string){
        int vowelsSum = 0;
        for (int i = 0; i < string.length(); i++) {
            switch(string.toLowerCase().charAt(i)){
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u':
                    vowelsSum++;
                    break;
            }
        }
        return vowelsSum;
    }
}
