package myspring.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import myspring.model.Buku;

public interface BukuRepository extends JpaRepository<Buku, Integer> {
    // mencari buku berdasarkan kategori
    List<Buku> findByKategori(String kategori);
}