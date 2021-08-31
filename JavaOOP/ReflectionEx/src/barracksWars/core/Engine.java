package barracksWars.core;

import barracksWars.core.commands.Command;
import barracksWars.interfaces.Repository;
import barracksWars.interfaces.Runnable;
import barracksWars.interfaces.Unit;
import barracksWars.interfaces.UnitFactory;
import jdk.jshell.spi.ExecutionControl;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Locale;

public class Engine implements Runnable {

    private Repository repository;
    private UnitFactory unitFactory;

    public Engine(Repository repository, UnitFactory unitFactory) {
        this.repository = repository;
        this.unitFactory = unitFactory;
    }

    @Override
    public void run() {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));
        while (true) {
            try {
                String input = reader.readLine();
                String[] data = input.split("\\s+");
                String commandName = data[0];
                String result = interpretCommand(data, commandName);
                if (result.equals("fight")) {
                    break;
                }
                System.out.println(result);
            } catch (RuntimeException | ExecutionControl.NotImplementedException e) {
                System.out.println(e.getMessage());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // TODO: refactor for problem 4
    private String interpretCommand(String[] data, String commandName) throws ExecutionControl.NotImplementedException {
        throw new ExecutionControl.NotImplementedException("not implemented");
//        try {
//            Class<?> clazz = Class.forName("barracksWars.core.commands." + getClassName(commandName));
//
//            System.out.println();
//            Class<?>[] classes1 = clazz.getClasses();
//            for (Class<?> c : classes) {
//                if (c.getSimpleName().toLowerCase().startsWith(commandName)) {
//
//                    Constructor<?> constructor = c.getDeclaredConstructor();
//                    Command command = (Command) constructor.newInstance();
//                    Method method = c.getDeclaredMethod("execute");
//                    return (String) method.invoke(command);
//                }
//            }
//        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException |
//                InvocationTargetException | ClassNotFoundException e) {
//
//            e.printStackTrace();
//        }
//
//        throw new RuntimeException("Invalid command!");

//		String result;
//		switch (commandName) {
//			casString result;
//			switch (commandName) {
//				case "add":
//				result = this.addUnitCommand(data);
//				break;
//			case "report":
//				result = this.reportCommand(data);
//				break;
//			case "fight":
//				result = this.fightCommand(data);
//				break;
//			default:
//				throw new RuntimeException("Invalid command!");
//		}
//		return result;
    }

//	private String reportCommand(String[] data) {
//		String output = this.repository.getStatistics();
//		return output;
//	}
//
//	private String addUnitCommand(String[] data) throws ClassNotFoundException, InvocationTargetException,
//			NoSuchMethodException, InstantiationException, IllegalAccessException {
//
//		String unitType = data[1];
//		Unit unitToAdd = this.unitFactory.createUnit(unitType);
//		this.repository.addUnit(unitToAdd);
//		String output = unitType + " added!";
//		return output;
//	}
//
//	private String fightCommand(String[] data) {
//		return "fight";
//	}
}
