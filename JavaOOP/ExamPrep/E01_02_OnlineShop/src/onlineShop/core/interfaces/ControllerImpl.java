package onlineShop.core.interfaces;

import onlineShop.models.products.Product;
import onlineShop.models.products.components.*;
import onlineShop.models.products.computers.Computer;
import onlineShop.models.products.computers.DesktopComputer;
import onlineShop.models.products.computers.Laptop;
import onlineShop.models.products.peripherals.*;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

import static onlineShop.common.constants.ExceptionMessages.*;
import static onlineShop.common.constants.OutputMessages.*;

public class ControllerImpl implements Controller {
    Map<Integer, Computer> computers;
    Map<Integer, Component> components;
    Map<Integer, Peripheral> peripherals;

    public ControllerImpl() {
        this.computers = new HashMap<>();
        this.components = new HashMap<>();
        this.peripherals = new HashMap<>();
    }

    @Override
    public String addComputer(String computerType, int id, String manufacturer, String model, double price) {
        if (computers.containsKey(id)) {
            throw new IllegalArgumentException(EXISTING_COMPUTER_ID);
        }

        Computer computer;
        if (computerType.equals("Laptop")) {
            computer = new Laptop(id, manufacturer, model, price);
        } else if (computerType.equals("DesktopComputer")) {
            computer = new DesktopComputer(id, manufacturer, model, price);
        } else {
            throw new IllegalArgumentException(INVALID_COMPUTER_TYPE);
        }

        computers.put(id, computer);
        return String.format(ADDED_COMPUTER, id);
    }

    @Override
    public String addPeripheral(int computerId, int id, String peripheralType, String manufacturer, String model, double price, double overallPerformance, String connectionType) {
        if(peripherals.containsKey(id)) {
            throw new IllegalArgumentException(EXISTING_PERIPHERAL_ID);
        }

        Peripheral peripheral;
        switch (peripheralType) {
            case "Headset":
                peripheral = new Headset(id, manufacturer, model, price, overallPerformance, connectionType);
                break;
            case "Keyboard":
                peripheral = new Keyboard(id, manufacturer, model, price, overallPerformance, connectionType);
                break;
            case "Monitor":
                peripheral = new Monitor(id, manufacturer, model, price, overallPerformance, connectionType);
                break;
            case "Mouse":
                peripheral = new Mouse(id, manufacturer, model, price, overallPerformance, connectionType);
                break;
            default:
                throw new IllegalArgumentException(INVALID_PERIPHERAL_TYPE);
        }

        isValid(computers, computerId);
        computers.get(computerId).addPeripheral(peripheral);
        peripherals.put(id, peripheral);
        return String.format(ADDED_PERIPHERAL, peripheralType, id, computerId);
    }

    @Override
    public String removePeripheral(String peripheralType, int computerId) {
        isValid(computers, computerId);
        Computer computer = computers.get(computerId);
        Peripheral removedPeripheral = computer.removePeripheral(peripheralType);
        peripherals.remove(removedPeripheral.getId());
        return String.format(REMOVED_PERIPHERAL, peripheralType, removedPeripheral.getId());
    }

    @Override
    public String addComponent(int computerId, int id, String componentType, String manufacturer, String model, double price, double overallPerformance, int generation) {
        if (components.containsKey(id)) {
            throw new IllegalArgumentException(EXISTING_COMPONENT_ID);
        }

        Component component;
        switch (componentType) {
            case "CentralProcessingUnit":
                component = new CentralProcessingUnit(id, manufacturer, model, price, overallPerformance, generation);
                break;
            case "Motherboard":
                component = new Motherboard(id, manufacturer, model, price, overallPerformance, generation);
                break;
            case "PowerSupply":
                component = new PowerSupply(id, manufacturer, model, price, overallPerformance, generation);
                break;
            case "RandomAccessMemory":
                component = new RandomAccessMemory(id, manufacturer, model, price, overallPerformance, generation);
                break;
            case "SolidStateDrive":
                component = new SolidStateDrive(id, manufacturer, model, price, overallPerformance, generation);
                break;
            case "VideoCard":
                component = new VideoCard(id, manufacturer, model, price, overallPerformance, generation);
                break;
            default:
                throw new IllegalArgumentException(INVALID_COMPONENT_TYPE);
        }

        isValid(computers, computerId);
        computers.get(computerId).addComponent(component);
        components.put(id, component);
        return String.format(ADDED_COMPONENT, componentType, id, computerId);
    }

    @Override
    public String removeComponent(String componentType, int computerId) {
        isValid(computers, computerId);
        Computer computer = computers.get(computerId);
        Component removedComponent = computer.removeComponent(componentType);
        components.remove(removedComponent.getId());
        return String.format(REMOVED_COMPONENT, componentType, removedComponent.getId());
    }

    @Override
    public String buyComputer(int id) {
        isValid(computers, id);
        Computer removedComputer = computers.get(id);
        computers.remove(id);
        return removedComputer.toString();
    }

    @Override
    public String BuyBestComputer(double budget) {
        Computer removedComputer = computers.values().stream()
                .filter(c -> c.getPrice() <= budget)
                .max(Comparator.comparingDouble(Product::getOverallPerformance))
                .orElse(null);

        if(removedComputer == null) {
            throw new IllegalArgumentException(String.format(CAN_NOT_BUY_COMPUTER, budget));
        }

        computers.remove(removedComputer.getId());
        return removedComputer.toString();
    }

    @Override
    public String getComputerData(int id) {
        isValid(computers, id);
        return computers.get(id).toString();
    }

    private static void isValid(Map<Integer, Computer> map, int id) {
        if(map.get(id) == null) {
            throw new IllegalArgumentException(NOT_EXISTING_COMPUTER_ID);
        }
    }
}
