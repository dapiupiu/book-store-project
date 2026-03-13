package myspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import myspring.model.Stok;

public interface StokRepository extends JpaRepository<Stok, Integer> {
    // fungsi untuk menghitung stok 0
    long countByJumlah(Integer jumlah);
}