package bg.softuni.BarrelWineCornerApp.repository;

import bg.softuni.BarrelWineCornerApp.model.entity.Partner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartnerRepository extends JpaRepository<Partner, Long> {
}
