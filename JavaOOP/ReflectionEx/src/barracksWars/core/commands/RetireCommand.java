package barracksWars.core.commands;

import barracksWars.interfaces.Repository;
import barracksWars.interfaces.UnitFactory;

import java.lang.reflect.Field;

public class RetireCommand extends Command {
    protected RetireCommand(String[] data, Repository repository, UnitFactory unitFactory) {
        super(data, repository, unitFactory);
    }

    @Override
    public String execute() {

        String unitType = super.getData()[1];
        try {
            Field amountOfUnits = super.getRepository().getClass().getDeclaredField("amountOfUnits");
            amountOfUnits.setAccessible(true);
            Integer unitsAmount = (Integer) amountOfUnits.get(unitType);
            if (unitsAmount == null || unitsAmount <= 0) {
                throw new IllegalArgumentException("No such units in repository");
            }
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

        super.getRepository().removeUnit(unitType);
        return unitType + " retired!";
    }
}
