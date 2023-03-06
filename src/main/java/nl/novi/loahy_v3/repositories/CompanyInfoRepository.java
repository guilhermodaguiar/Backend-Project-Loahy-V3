package nl.novi.loahy_v3.repositories;

import nl.novi.loahy_v3.models.CompanyInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CompanyInfoRepository extends JpaRepository<CompanyInfo, String> {

    Optional<CompanyInfo> findCompanyInfoByName(String name);
}

