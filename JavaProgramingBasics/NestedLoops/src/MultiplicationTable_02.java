public class MultiplicationTable_02 {
    public static void main(String[] args) {

        for (int n1 = 1; n1 <= 10; n1++) {
            for (int n2 = 1; n2 <= 10; n2++) {
                System.out.printf("%d * %d = %d%n", n1, n2, n1 * n2);
            }
        }
    }
}
