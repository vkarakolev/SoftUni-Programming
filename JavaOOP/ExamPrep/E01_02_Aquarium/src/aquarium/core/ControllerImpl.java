package aquarium.core;

import aquarium.entities.aquariums.*;
import aquarium.entities.decorations.*;
import aquarium.entities.fish.*;
import aquarium.repositories.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static aquarium.common.ConstantMessages.*;
import static aquarium.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {

    private Repository decorations;
    private List<Aquarium> aquariums;

    public ControllerImpl() {
        this.decorations = new DecorationRepository();
        this.aquariums = new ArrayList<>();
    }

    @Override
    public String addAquarium(String aquariumType, String aquariumName) {
        Aquarium aquarium;

        if (aquariumType.equals("FreshwaterAquarium")) {
            aquarium = new FreshwaterAquarium(aquariumName);
        } else if (aquariumType.equals("SaltwaterAquarium")) {
            aquarium = new SaltwaterAquarium(aquariumName);
        } else {
            throw new NullPointerException(INVALID_AQUARIUM_TYPE);
        }

        aquariums.add(aquarium);

        return String.format(SUCCESSFULLY_ADDED_AQUARIUM_TYPE, aquariumType);
    }

    @Override
    public String addDecoration(String type) {
        Decoration decoration;

        if (type.equals("Ornament")) {
            decoration = new Ornament();
        } else if (type.equals("Plant")) {
            decoration = new Plant();
        } else {
            throw new NullPointerException(INVALID_DECORATION_TYPE);
        }

        decorations.add(decoration);

        return String.format(SUCCESSFULLY_ADDED_DECORATION_TYPE, type);
    }

    @Override
    public String insertDecoration(String aquariumName, String decorationType) {
        Decoration decoration = decorations.findByType(decorationType);

        if(decoration == null) {
            throw new IllegalArgumentException(String.format(NO_DECORATION_FOUND, decorationType));
        }

        decorations.remove(decoration);

        Aquarium aquarium = getAquariumByName(aquariumName);
        aquarium.addDecoration(decoration);

        return String.format(SUCCESSFULLY_ADDED_DECORATION_IN_AQUARIUM, decorationType, aquariumName);
    }

    @Override
    public String addFish(String aquariumName, String fishType, String fishName, String fishSpecies, double price) {
        Fish fish;
        if(fishType.equals("FreshwaterFish")) {
            fish = new FreshwaterFish(fishName, fishSpecies, price);
        } else if (fishType.equals("SaltwaterFish")) {
            fish = new SaltwaterFish(fishName, fishSpecies, price);
        } else {
            throw new IllegalArgumentException(INVALID_FISH_TYPE);
        }

        try {
            Aquarium aquarium = getAquariumByName(aquariumName);
            aquarium.addFish(fish);
        } catch (IllegalStateException | IllegalArgumentException ex) {
            return ex.getMessage();
        }

        return String.format(SUCCESSFULLY_ADDED_FISH_IN_AQUARIUM, fishType, aquariumName);
    }

    @Override
    public String feedFish(String aquariumName) {
        Aquarium aquarium = getAquariumByName(aquariumName);
        aquarium.feed();
        return String.format(FISH_FED, aquarium.getFish().size());
    }

    private Aquarium getAquariumByName(String aquariumName) {
        return aquariums.stream()
                .filter(a -> a.getName().equals(aquariumName))
                .findFirst()
                .orElseThrow();
    }

    @Override
    public String calculateValue(String aquariumName) {
        Aquarium aquarium = getAquariumByName(aquariumName);
        double allFishPrice = aquarium.getFish().stream()
                .mapToDouble(Fish::getPrice)
                .sum();

        double allDecorationsPrice = aquarium.getDecorations().stream()
                .mapToDouble(Decoration::getPrice)
                .sum();

        double aquariumValue = allDecorationsPrice + allFishPrice;
        return String.format(VALUE_AQUARIUM, aquariumName, aquariumValue);
    }

    @Override
    public String report() {

        return aquariums.stream()
                .map(Aquarium::getInfo)
                .collect(Collectors.joining(System.lineSeparator()));
    }
}
