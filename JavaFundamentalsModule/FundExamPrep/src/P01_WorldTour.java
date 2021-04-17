import java.util.Scanner;

public class P01_WorldTour {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder stops = new StringBuilder(scanner.nextLine());

        String command = scanner.nextLine();
        while(!command.equals("Travel")){
            String[] commands = command.split(":");

            int startIndex;
            String newString = commands[2];
            switch(commands[0]){
                case "Add Stop":
                    startIndex = Integer.parseInt(commands[1]);
                    if(isValidIndex(stops, startIndex)) {
                        stops.insert(startIndex, newString);
                    }
                    break;
                case "Remove Stop":
                    startIndex = Integer.parseInt(commands[1]);
                    int endIndex =  Integer.parseInt(commands[2]);
                    if(isValidIndex(stops, startIndex) && isValidIndex(stops, endIndex)) {
                        stops.replace(startIndex, endIndex + 1, "");
                    }
                    break;
                case "Switch":
                    String oldString = commands[1];
                    if(String.valueOf(stops).contains(oldString)){
                        stops = new StringBuilder(stops.toString().replace(oldString, newString));
                    }
                    break;
            }
            System.out.println(stops);
            command = scanner.nextLine();
        }

        System.out.println("Ready for world tour! Planned stops: " + stops);
    }

    static boolean isValidIndex(StringBuilder s, int index){
        return (index >= 0 && index < s.length());
    }
}
