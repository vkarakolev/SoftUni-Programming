package E02_GettersAndSetters;

import reflection.Reflection;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Class clazz = Reflection.class;

        Method[] declaredMethods = clazz.getDeclaredMethods();

        Arrays.stream(declaredMethods)
                .filter(m -> m.getName().contains("get") || m.getName().contains("set"))
                .sorted(Comparator.comparing(Method::getName))
                .forEach(Main::printMethod);

    }

    public static void printMethod (Method method) {
        String out = method.getName().contains("set")
                ? String.format("%s and will set field of class %s", method.getName(),
                method.getParameterTypes()[0].getName())
                : String.format("%s will return class %s", method.getName(), method.getReturnType().getName());
        System.out.println(out);
    }
}
