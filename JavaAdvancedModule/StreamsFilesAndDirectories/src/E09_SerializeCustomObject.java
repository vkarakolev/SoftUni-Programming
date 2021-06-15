import java.io.*;

public class E09_SerializeCustomObject {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Cube cube = new Cube("green", 15.3, 12.4, 3.0);

        ObjectOutputStream outputStream = new ObjectOutputStream(
                new FileOutputStream("obj.txt")
        );

        outputStream.writeObject(cube);
        outputStream.close();

        ObjectInputStream inputStream = new ObjectInputStream(
                new FileInputStream("obj.txt")
        );

        Cube savedCube = (Cube) inputStream.readObject();
        System.out.println();
    }

    public static class Cube implements Serializable{
        private String color;
        private double width;
        private double height;
        private double depth;

        public Cube(String color, double width, double height, double depth) {
            this.color = color;
            this.width = width;
            this.height = height;
            this.depth = depth;
        }
    }
}
