package bg.softuni.BarrelWineCornerApp.service;

import bg.softuni.BarrelWineCornerApp.model.dto.AddReservationDTO;
import bg.softuni.BarrelWineCornerApp.model.dto.view.ReservationViewDTO;

import java.util.List;

public interface ReservationService {

    List<ReservationViewDTO> getAll();

    void addReservation(AddReservationDTO addReservationDTO);

    void approve(Long id);
}
