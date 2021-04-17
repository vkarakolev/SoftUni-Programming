import java.util.Scanner;

public class P01_ActivationKeys {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String activationKey = scanner.nextLine();

        String command = scanner.nextLine();
        while (!command.equals("Generate")){
            String[] operations = command.split(">>>");

            switch (operations[0]){
                case "Contains":
                    String substring = operations[1];
                    if(activationKey.contains(substring)){
                        System.out.println(activationKey + " contains " + substring);
                    } else {
                        System.out.println("Substring not found!");
                    }
                    break;
                case "Flip":
                    String upperOrLower = operations[1];
                    int startIndex = Integer.parseInt(operations[2]);
                    int endIndex = Integer.parseInt(operations[3]);

                    StringBuilder transformed = new StringBuilder();
                    for (int i = startIndex; i < endIndex; i++) {
                        if (Character.isLetter(activationKey.charAt(i))){
                            switch (upperOrLower){
                                case "Upper":
                                    transformed.append(Character.toUpperCase(activationKey.charAt(i)));
                                    break;
                                case "Lower":
                                    transformed.append(Character.toLowerCase(activationKey.charAt(i)));
                                    break;
                            }
                        }else {
                            transformed.append(activationKey.charAt(i));
                        }
                    }
                    activationKey = activationKey.substring(0, startIndex) + transformed + activationKey.substring(endIndex);

                    System.out.println(activationKey);
                    break;
                case "Slice":
                    int delFromIndex = Integer.parseInt(operations[1]);
                    int delToIndex = Integer.parseInt(operations[2]);

                    activationKey = activationKey.substring(0, delFromIndex) + activationKey.substring(delToIndex);

                    System.out.println(activationKey);
                    break;
            }

            command = scanner.nextLine();
        }

        System.out.println("Your activation key is: " + activationKey);
    }
}
