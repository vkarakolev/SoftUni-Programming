package bg.softuni.BarrelWineCornerApp.service.impl;

import bg.softuni.BarrelWineCornerApp.model.dto.AddEventDTO;
import bg.softuni.BarrelWineCornerApp.model.dto.view.EventViewDTO;
import bg.softuni.BarrelWineCornerApp.model.entity.Event;
import bg.softuni.BarrelWineCornerApp.repository.EventRepository;
import bg.softuni.BarrelWineCornerApp.service.EventService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<EventViewDTO> getAll() {
        // TO DO: find all where date not in the past
        return eventRepository.findAll().stream()
                .map(event -> modelMapper.map(event, EventViewDTO.class))
                .toList();
    }

    @Override
    public void addEvent(AddEventDTO addEventDTO) {
        Event event = modelMapper.map(addEventDTO, Event.class);
        eventRepository.save(event);
    }
}
