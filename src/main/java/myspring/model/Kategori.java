package myspring.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Kategori {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idkategori;
    private String namakategori;

    public Kategori() {} // Wajib ada untuk JPA

    // Getter & Setter
    public Integer getIdkategori() {
        return idkategori;
    }
    public void setIdkategori(Integer idkategori) {
        this.idkategori = idkategori;
    }
    public String getNamakategori() {
        return namakategori;
    }
    public void setNamakategori(String namakategori) {
        this.namakategori = namakategori;
    }
}