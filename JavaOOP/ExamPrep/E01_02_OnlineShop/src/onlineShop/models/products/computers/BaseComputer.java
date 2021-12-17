package onlineShop.models.products.computers;

import onlineShop.models.products.BaseProduct;
import onlineShop.models.products.Product;
import onlineShop.models.products.components.Component;
import onlineShop.models.products.peripherals.Peripheral;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static onlineShop.common.constants.ExceptionMessages.*;
import static onlineShop.common.constants.OutputMessages.*;

public abstract class BaseComputer extends BaseProduct implements Computer {
    private List<Component> components;
    private List<Peripheral> peripherals;

    public BaseComputer(int id, String manufacturer, String model, double price, double overallPerformance) {
        super(id, manufacturer, model, price, overallPerformance);
        components = new ArrayList<>();
        peripherals = new ArrayList<>();
    }

    @Override
    public String toString() {
        return String.format(PRODUCT_TO_STRING + "%n %s%n %s",
                this.getOverallPerformance(), this.getPrice(), this.getClass().getSimpleName(),
                this.getManufacturer(), this.getModel(), this.getId(), getComponentsInfo(components),
                getPeripheralsInfo(peripherals));
    }

    private static String getPeripheralsInfo(List<Peripheral> peripherals) {
        double avgOverallPerformance = peripherals.stream()
                .mapToDouble(Product::getOverallPerformance)
                .average()
                .orElse(0);

        String peripheralsInfo = peripherals.stream()
                .map(Object::toString)
                .collect(Collectors.joining(System.lineSeparator() + "  "));

        String output = String.format(COMPUTER_PERIPHERALS_TO_STRING, peripherals.size(), avgOverallPerformance);

        if(peripherals.size() > 0) {
            output = String.format("%s%n  %s", output, peripheralsInfo);
        }

        return output;
    }

    private static String getComponentsInfo(List<Component> components) {
        String componentsInfo = components.stream()
                .map(Object::toString)
                .collect(Collectors.joining(System.lineSeparator() + "  "));

        String output = String.format(COMPUTER_COMPONENTS_TO_STRING, components.size());

        if(components.size() != 0) {
            output = String.format("%s%n  %s", output, componentsInfo);
        }

        return output;
    }

    @Override
    public double getOverallPerformance() {
        if(!components.isEmpty()) {
            return super.getOverallPerformance() + avgComponentOverallPerformance(components);
        }
        return super.getOverallPerformance();
    }

    private double avgComponentOverallPerformance(List<Component> components) {
        return components.stream()
                .mapToDouble(Product::getOverallPerformance)
                .average()
                .orElse(0);
    }

    @Override
    public List<Component> getComponents() {
        return this.components;
    }

    @Override
    public List<Peripheral> getPeripherals() {
        return this.peripherals;
    }

    @Override
    public void addComponent(Component component) {
        String type = component.getClass().getSimpleName();
        Component existingComponent = components.stream()
                .filter(c -> c.getClass().getSimpleName().equals(type))
                .findFirst()
                .orElse(null);

        if(existingComponent != null) {
            throw new IllegalArgumentException(String.format(EXISTING_COMPONENT,
                    component.getClass().getSimpleName(), this.getClass().getSimpleName(), this.getId()));
        }

        components.add(component);
    }

    @Override
    public Component removeComponent(String componentType) {
        Component removableComponent = components.stream()
                .filter(c -> c.getClass().getSimpleName().equals(componentType))
                .findFirst()
                .orElse(null);

        if(components.isEmpty() || removableComponent == null) {
            throw new IllegalArgumentException(String.format(NOT_EXISTING_COMPONENT,
                    componentType, this.getClass().getSimpleName(), this.getId()));
        }

        components.remove(removableComponent);
        return removableComponent;
    }

    @Override
    public void addPeripheral(Peripheral peripheral) {
        String type = peripheral.getClass().getSimpleName();
        Peripheral existingPeripheral = peripherals.stream()
                .filter(p -> p.getClass().getSimpleName().equals(type))
                .findFirst()
                .orElse(null);

        if(existingPeripheral != null) {
            throw new IllegalArgumentException(String.format(EXISTING_PERIPHERAL,
                    peripheral.getClass().getSimpleName(), this.getClass().getSimpleName(), this.getId()));
        }

        peripherals.add(peripheral);
    }

    @Override
    public Peripheral removePeripheral(String peripheralType) {
        Peripheral removablePeripheral = peripherals.stream()
                .filter(p -> p.getClass().getSimpleName().equals(peripheralType))
                .findFirst()
                .orElse(null);

        if(peripherals.isEmpty() || removablePeripheral == null) {
            throw new IllegalArgumentException(String.format(NOT_EXISTING_PERIPHERAL,
                    peripheralType, this.getClass().getSimpleName(), this.getId()));
        }

        peripherals.remove(removablePeripheral);
        return removablePeripheral;
    }

    @Override
    public double getPrice() {
        double componentsPrice = components.stream().mapToDouble(Product::getPrice).sum();
        double peripheralsPrice = peripherals.stream().mapToDouble(Product::getPrice).sum();
        return super.getPrice() + componentsPrice + peripheralsPrice;
    }
}
