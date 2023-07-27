package mx.com.gm.dao;

import mx.com.gm.domain.Scanner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScannerDao extends JpaRepository<Scanner, Long> {
    Scanner findBySeriescanner(String seriescanner);
}
