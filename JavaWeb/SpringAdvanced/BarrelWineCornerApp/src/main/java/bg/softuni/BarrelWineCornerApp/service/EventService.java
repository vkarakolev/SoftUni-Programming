package bg.softuni.BarrelWineCornerApp.service;

import bg.softuni.BarrelWineCornerApp.model.dto.AddEventDTO;
import bg.softuni.BarrelWineCornerApp.model.dto.view.EventViewDTO;

import java.util.List;

public interface EventService {
    List<EventViewDTO> getAll();

    void addEvent(AddEventDTO addEventDTO);
}
