package blackBoxInteger;

import javax.management.ObjectInstance;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        Scanner scanner = new Scanner(System.in);

        Class<BlackBoxInt> clazz = BlackBoxInt.class;
        Constructor<BlackBoxInt> ctor = clazz.getDeclaredConstructor();
        ctor.setAccessible(true);
        BlackBoxInt blackBoxInt = ctor.newInstance();
        Field innerValue = blackBoxInt.getClass().getDeclaredField("innerValue");
        innerValue.setAccessible(true);


        String input = scanner.nextLine();
        while (!input.equals("END")) {
            String command = input.split("_")[0];
            int value = Integer.parseInt(input.split("_")[1]);

            Method currentMethod = getCurrentMethod(clazz, command);
            currentMethod.setAccessible(true);
            currentMethod.invoke(blackBoxInt, value);

            System.out.println(innerValue.get(blackBoxInt));

            input = scanner.nextLine();
        }
    }

    private static Method getCurrentMethod(Class<BlackBoxInt> clazz, String command) {
        return Arrays.stream(clazz.getDeclaredMethods())
                .filter(m -> m.getName().equals(command))
                .findFirst()
                .orElseThrow();
    }
}
