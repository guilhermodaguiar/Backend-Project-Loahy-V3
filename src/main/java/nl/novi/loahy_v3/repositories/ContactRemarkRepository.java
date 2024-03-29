package nl.novi.loahy_v3.repositories;

import nl.novi.loahy_v3.models.ContactRemark;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRemarkRepository extends JpaRepository<ContactRemark, String> {

}
