import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class E02_RawData {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lines = Integer.parseInt(scanner.nextLine());
        List<Car> cars = new ArrayList<>();

        for (int i = 0; i < lines; i++) {
            String[] carData = scanner.nextLine().split(" ");
            Car car = new Car(carData);
            cars.add(car);
        }

        String command = scanner.nextLine();
        switch (command){
            case "fragile":
                cars.stream()
                        .filter(e -> e.getCargo().type.equals(command)
                        && Car.getAvgPressure(e.getTires()) < 1)
                        .forEach(c -> System.out.println(c.getModel()));
                break;
            case "flamable":
                cars.stream()
                        .filter(e -> e.getCargo().type.equals(command)
                                && e.getEngine().power > 250)
                        .forEach(c -> System.out.println(c.getModel()));
                break;
        }
    }

    static class Car {
        String model;
        Engine engine;
        Cargo cargo;
        List<Tire> tires;

        public Car (String[] carData){
            this.model = carData[0];
            this.engine = new Engine (Integer.parseInt(carData[1]), Integer.parseInt(carData[2]));
            this.cargo = new Cargo (Integer.parseInt(carData[3]), carData[4]);
            this.tires = new ArrayList<>(4);
            for (int i = 0; i < 4; i++){
               Tire tire = new Tire (Double.parseDouble(carData[i * 2 + 5]), Integer.parseInt(carData[i * 2 + 6]));
               tires.add(tire);
            }
        }

        static double getAvgPressure (List<Tire> tires){
            double avgPressure = 0;
            for (Tire tire : tires) {
                avgPressure += tire.getTirePressure();
            }
            return avgPressure / tires.size();
        }

        public String getModel() {
            return model;
        }

        public Engine getEngine() {
            return engine;
        }

        public Cargo getCargo() {
            return cargo;
        }

        public List<Tire> getTires() {
            return tires;
        }
    }

    static class Engine {
        int speed;
        int power;

        public Engine (int speed, int power){
            this.speed = speed;
            this.power = power;
        }
    }

    static class Cargo {
        int weight;
        String type;

        public Cargo (int weight, String type){
            this.weight = weight;
            this.type = type;
        }
    }

    static class Tire {
        double tirePressure;
        int tireAge;

        public Tire (double tirePressure, int tireAge){
            this.tirePressure = tirePressure;
            this.tireAge = tireAge;
        }

        public double getTirePressure() {
            return tirePressure;
        }
    }
}
