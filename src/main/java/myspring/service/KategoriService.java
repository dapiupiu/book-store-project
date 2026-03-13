package myspring.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import myspring.model.Kategori;
import myspring.model.Buku;
import myspring.repository.KategoriRepository;
import myspring.repository.BukuRepository;

@Service
public class KategoriService {
    @Autowired
    private KategoriRepository kategoriRepository;
    
    @Autowired
    private BukuRepository bukuRepository;

    public List<Kategori> getAllKategori() {
        return kategoriRepository.findAll();
    }
    
    public Kategori getById(Integer id) {
        return kategoriRepository.findById(id).orElse(null);
    }

    public void simpan(Kategori k) {
        kategoriRepository.save(k);
    }
    
    public void updateKategori(Integer id, Kategori kategoriBaru) {
        Kategori lama = kategoriRepository.findById(id).orElse(null);
        if (lama != null) {
            String namaLama = lama.getNamakategori();
            String namaBaru = kategoriBaru.getNamakategori();

            // update nama kategori itu sendiri
            lama.setNamakategori(namaBaru);
            kategoriRepository.save(lama);

            // update semua buku yang pakai nama lama
            List<Buku> daftarBuku = bukuRepository.findByKategori(namaLama);
            for (Buku b : daftarBuku) {
                b.setKategori(namaBaru);
                bukuRepository.save(b);
            }
        }
    }

    public void hapus(Integer id) {
        kategoriRepository.deleteById(id);
    }
}