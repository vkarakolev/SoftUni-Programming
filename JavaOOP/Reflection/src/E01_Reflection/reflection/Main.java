package E01_Reflection.reflection;

import reflection.Reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        Class<Reflection> clazz = Reflection.class;

        System.out.println("class " + clazz.getSimpleName());
        System.out.println(clazz.getSuperclass());

        Class<?>[] interfaces = clazz.getInterfaces();
        for (Class<?> i : interfaces) {
            System.out.println(i);
        }

        Constructor<Reflection> ctor = clazz.getDeclaredConstructor();
        Reflection reflection = ctor.newInstance();
        System.out.println(reflection.toString());
    }
}
