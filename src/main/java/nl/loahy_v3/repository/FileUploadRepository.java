package nl.loahy_v3.repository;


import nl.loahy_v3.model.FileUploadResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FileUploadRepository extends JpaRepository<FileUploadResponse, Long> {
    Optional<FileUploadResponse> findByFileName(String fileName);
}
