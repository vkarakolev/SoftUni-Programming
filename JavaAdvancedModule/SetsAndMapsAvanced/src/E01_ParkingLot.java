import java.util.LinkedHashSet;
import java.util.Scanner;

public class E01_ParkingLot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashSet<String> parkingLot = new LinkedHashSet<>();

        String commandData = scanner.nextLine();
        while (!commandData.equals("END")){
            String command = commandData.split(", ")[0];
            String carID = commandData.split(", ")[1];

            switch (command){
                case "IN" :
                    parkingLot.add(carID);
                    break;
                case "OUT" :
                    parkingLot.remove(carID);
                    break;
            }

            commandData = scanner.nextLine();
        }

        if(parkingLot.isEmpty()){
            System.out.println("Parking Lot is Empty");
        } else {
            for (String s : parkingLot) {
                System.out.println(s);
            }
        }
    }
}
