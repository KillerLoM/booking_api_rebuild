package meu.booking_rebuild.repository;

import meu.booking_rebuild.model.BusTypeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface BusTypeRepo extends JpaRepository<BusTypeModel, UUID> {
    BusTypeModel findBusTypeModelById(UUID id);
}
