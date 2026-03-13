package myspring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import myspring.model.Buku;
import myspring.repository.BukuRepository;

@Service
public class BukuService {

    @Autowired
    private BukuRepository bukuRepository;
    
    public List<Buku> getBukuByKategori(String k) {
        return bukuRepository.findByKategori(k);
    }

    public List<Buku> getAllBuku() {
        if (bukuRepository.count() == 0) {
            Buku b1 = new Buku();
            b1.setJudul("Pemrograman Berorientasi Objek");
            b1.setPenulis("Armansyah");
            b1.setPenerbit("Informatika");
            b1.setTahun(2022);
            b1.setHarga(Double.valueOf(75000));
            b1.setKategori("Pendidikan");
            b1.setIsbn("978-602-0000-01-1");
            b1.setDeskripsi("Buku pengantar konsep OOP untuk pemula.");

            Buku b2 = new Buku();
            b2.setJudul("Jaringan Saraf Tiruan");
            b2.setPenulis("Armansyah");
            b2.setPenerbit("DeepTech Press");
            b2.setTahun(2023);
            b2.setHarga(Double.valueOf(98000));
            b2.setKategori("Teknologi");
            b2.setIsbn("978-602-0000-02-8");
            b2.setDeskripsi("Pembahasan dasar hingga lanjutan tentang neural network.");

            bukuRepository.save(b1);
            bukuRepository.save(b2);
        }

        return bukuRepository.findAll();
    }

    public Buku addBuku(Buku buku) {
        return bukuRepository.save(buku);
    }

    public Buku getBukuById(Integer id) {
        return bukuRepository.findById(id).orElse(null);
    }
    
    public long getTotalBuku() {
    	return bukuRepository.count();
    }

    public Buku updateBuku(Integer id, Buku bukuBaru) {
        return bukuRepository.findById(id)
                .map(buku -> {
                    buku.setJudul(bukuBaru.getJudul());
                    buku.setPenulis(bukuBaru.getPenulis());
                    buku.setPenerbit(bukuBaru.getPenerbit());
                    buku.setTahun(bukuBaru.getTahun());
                    buku.setHarga(bukuBaru.getHarga());
                    buku.setKategori(bukuBaru.getKategori());
                    buku.setIsbn(bukuBaru.getIsbn());
                    buku.setDeskripsi(bukuBaru.getDeskripsi());
                    return bukuRepository.save(buku);
                })
                .orElse(null);
    }

    public void deleteBuku(Integer id) {
        bukuRepository.deleteById(id);
    }
}
