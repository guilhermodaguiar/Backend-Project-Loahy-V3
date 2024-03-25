package nl.loahy_v3.repository;

import nl.loahy_v3.model.ContactRemark;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ContactRemarkRepository extends JpaRepository<ContactRemark, Long> {
}
