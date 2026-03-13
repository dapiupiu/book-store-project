package myspring.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import myspring.model.Stok;
import myspring.repository.StokRepository;

@Service
public class StokService {
    @Autowired
    private StokRepository stokRepository;

    public List<Stok> getAllStok() {
        return stokRepository.findAll();
    }

    public void simpanStok(Stok s) {
        stokRepository.save(s);
    }

    public Stok getById(Integer id) {
        return stokRepository.findById(id).orElse(null);
    }
    
    public long getStokHabis() {
    	return stokRepository.countByJumlah(0);
    }
}