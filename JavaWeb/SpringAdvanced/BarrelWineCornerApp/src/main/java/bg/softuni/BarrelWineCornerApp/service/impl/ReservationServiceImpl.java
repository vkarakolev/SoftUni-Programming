package bg.softuni.BarrelWineCornerApp.service.impl;

import bg.softuni.BarrelWineCornerApp.model.dto.AddReservationDTO;
import bg.softuni.BarrelWineCornerApp.model.dto.view.ReservationViewDTO;
import bg.softuni.BarrelWineCornerApp.model.entity.Reservation;
import bg.softuni.BarrelWineCornerApp.repository.ReservationRepository;
import bg.softuni.BarrelWineCornerApp.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservationServiceImpl implements ReservationService {

    private final ReservationRepository reservationRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<ReservationViewDTO> getAll() {
        // TO DO: find all where date not in the past
        return reservationRepository.findAll().stream()
                .map(reservation -> modelMapper.map(reservation, ReservationViewDTO.class))
                .toList();
    }

    @Override
    public void addReservation(AddReservationDTO addReservationDTO) {
        Reservation reservation = modelMapper.map(addReservationDTO, Reservation.class);
        reservationRepository.save(reservation);
    }

    @Override
    public void approve(Long id) {
        Reservation reservation = reservationRepository.findById(id).orElseThrow();
        reservation.setApproved(true);
        reservationRepository.save(reservation);
    }
}
