package nl.novi.loahy_v3.repositories;

import nl.novi.loahy_v3.models.Address;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AddressRepository extends JpaRepository<Address, Long> {
}
