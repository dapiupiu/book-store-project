package myspring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import myspring.model.Buku;
import myspring.service.BukuService;

@RestController
public class BukuController {

    @Autowired
    private BukuService bukuService;

    @GetMapping("/buku")
    public List<Buku> getAll() {
        return bukuService.getAllBuku();
    }

    @PostMapping("/buku")
    public Buku add(@RequestBody Buku buku) {
        return bukuService.addBuku(buku);
    }

    @GetMapping("/buku/{id}")
    public Buku getById(@PathVariable Integer id) {
        return bukuService.getBukuById(id);
    }

    @PutMapping("/buku/{id}")
    public Buku update(@PathVariable Integer id, @RequestBody Buku bukuBaru) {
        return bukuService.updateBuku(id, bukuBaru);
    }
}
