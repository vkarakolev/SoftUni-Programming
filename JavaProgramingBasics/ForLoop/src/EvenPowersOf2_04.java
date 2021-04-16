import java.util.Scanner;

public class EvenPowersOf2_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int powered2 = 0;

        for(int i = 0; i <= n; i++){
            if(i == 0){
                powered2 = 1;
                System.out.println(powered2);
            }else{
                powered2 *= 2;
                if(i % 2 == 0){
                    System.out.println(powered2);
                }
            }
        }
    }
}
