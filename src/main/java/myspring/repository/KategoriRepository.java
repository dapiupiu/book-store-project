package myspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import myspring.model.Kategori;

public interface KategoriRepository extends JpaRepository<Kategori, Integer> {
}