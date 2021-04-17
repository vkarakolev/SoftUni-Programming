import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class E06_VehicleCatalogue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Vehicle> vehicles = new ArrayList<>();
        int carsHpSum = 0;
        int trucksHpSum = 0;
        int carsCount = 0;
        int trucksCount = 0;

        String command = scanner.nextLine();
        while(!command.equals("End")){
            String[] vehicleData = command.split(" ");
            Vehicle vehicle = new Vehicle(vehicleData);

            if(vehicle.type.equals("car")){
                carsHpSum += vehicle.getHorsepower();
                carsCount++;
            } else {
                trucksHpSum += vehicle.getHorsepower();
                trucksCount++;
            }

            vehicles.add(vehicle);

            command = scanner.nextLine();
        }

        command = scanner.nextLine();
        while(!command.equals("Close the Catalogue")){

            for (Vehicle vehicle : vehicles) {
                if(vehicle.getModel().equals(command)){
                    vehicle.printVehicleData(vehicle);
                }
            }

            command = scanner.nextLine();
        }

        double carsAvgHp = 0;
        if(carsCount != 0){
            carsAvgHp = 1.0 * carsHpSum / carsCount;
        } else {
            carsAvgHp = 0;
        }

        double trucksAvgHp = 0;
        if(trucksCount != 0){
            trucksAvgHp = 1.0 * trucksHpSum / trucksCount;
        } else {
            trucksAvgHp = 0;
        }

        String output = String.format("Cars have average horsepower of: %.2f.%n" +
                "Trucks have average horsepower of: %.2f.", carsAvgHp, trucksAvgHp);

        System.out.println(output);
    }

    static class Vehicle {
        String type;
        String model;
        String color;
        int horsepower;

        public Vehicle (String[] input){
            this.type = input[0];
            this.model = input[1];
            this.color = input[2];
            this.horsepower = Integer.parseInt(input[3]);
        }

        public int getHorsepower(){
            return horsepower;
        }

        public String getModel() {
            return model;
        }

        static void printVehicleData(Vehicle vehicle){
            String output = String.format("Type: %s%n" +
                    "Model: %s%n" +
                    "Color: %s%n" +
                    "Horsepower: %d%n", capitalize(vehicle.type), capitalize(vehicle.model),
                    vehicle.color, vehicle.horsepower);
            System.out.print(output);
        }
    }

    static String capitalize (String str){
        if(str == null || str.isEmpty()){
            return str;
        }

        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }
}
