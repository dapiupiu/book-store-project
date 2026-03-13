package myspring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

import myspring.model.Buku;
import myspring.model.User;
import myspring.model.Kategori;
import myspring.model.Stok;
import myspring.service.BukuService;
import myspring.service.UserService;
import myspring.service.KategoriService;
import myspring.service.StokService;

@Controller
public class WebController {

    @Autowired
    private BukuService bukuService;

    @Autowired
    private UserService userService;
    
    @Autowired
    private KategoriService kategoriService;
    
    @Autowired
    private StokService stokService;

    /*@GetMapping("/")
    public String root() {
        return "redirect:/login";
    } */
    
    @GetMapping("/")
    public String index(Model model) {
        // Menampilkan buku di halaman depan untuk publik
        model.addAttribute("listbuku", bukuService.getAllBuku());
        return "index"; 
    }

    @GetMapping("/login")
    public String loginForm() {
        return "login";
    }

    @PostMapping("/login")
    public String prosesLogin(
            @RequestParam String username,
            @RequestParam String password,
            Model model,
            HttpSession session
    ) {
        if (userService.login(username, password)) {
            session.setAttribute("user", username);
            return "redirect:/dashboard";
        }

        model.addAttribute("error", "Username atau password salah");
        return "login";
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model, HttpSession session) {
        if (session.getAttribute("user") == null) {
            return "redirect:/login";
        }

        long totalBuku = bukuService.getTotalBuku();
        long stokHabis = stokService.getStokHabis();

        model.addAttribute("totalBuku", totalBuku);
        model.addAttribute("stokHabis", stokHabis);
        return "dashboard";
    }

    // ====== FITUR BUKU ======

    @GetMapping("/buku/view")
    public String viewBuku(Model model, HttpSession session) {
        if (session.getAttribute("user") == null) {
            return "redirect:/login";
        }

        model.addAttribute("listbuku", bukuService.getAllBuku());
        return "buku/viewbuku";
    }

    @GetMapping("/buku/form")
    public String formTambah(Model model, HttpSession session) {
        if (session.getAttribute("user") == null) {
        	return "redirect:/login";
        }

        model.addAttribute("buku", new Buku());
        model.addAttribute("listkategori", kategoriService.getAllKategori()); 
        return "buku/formbuku";
    }

    @PostMapping("/buku/simpan")
    public String simpan(Buku buku, HttpSession session) {
        if (session.getAttribute("user") == null) {
            return "redirect:/login";
        }

        bukuService.addBuku(buku);
        return "redirect:/buku/view";
    }

    @GetMapping("/buku/edit/{id}")
    public String editForm(@PathVariable Integer id, Model model, HttpSession session) {
        if (session.getAttribute("user") == null) {
        	return "redirect:/login";
        	}
        model.addAttribute("buku", bukuService.getBukuById(id));
        model.addAttribute("listkategori", kategoriService.getAllKategori()); 
        return "buku/editbuku";
    }

    @GetMapping("/buku/delete/{id}")
    public String delete(@PathVariable Integer id, HttpSession session) {
        if (session.getAttribute("user") == null) {
            return "redirect:/login";
        }

        bukuService.deleteBuku(id);
        return "redirect:/buku/view";
    }

    @PostMapping("/buku/update")
    public String update(Buku buku, HttpSession session) {
        if (session.getAttribute("user") == null) {
            return "redirect:/login";
        }

        bukuService.updateBuku(buku.getIdbuku(), buku);
        return "redirect:/buku/view";
    }

    // ====== FITUR USER ======

    @GetMapping("/user/view")
    public String viewUser(Model model, HttpSession session) {
        if (session.getAttribute("user") == null) {
            return "redirect:/login";
        }

        model.addAttribute("listuser", userService.getAllUser());
        return "user/viewuser";
    }

    @GetMapping("/user/form")
    public String formUser(Model model, HttpSession session) {
        if (session.getAttribute("user") == null) {
            return "redirect:/login";
        }

        model.addAttribute("user", new User());
        return "user/formuser";
    }

    @PostMapping("/user/simpan")
    public String simpanUser(User user, HttpSession session) {
        if (session.getAttribute("user") == null) {
            return "redirect:/login";
        }

        userService.save(user);
        return "redirect:/user/view";
    }

    @GetMapping("/user/edit/{id}")
    public String editUser(@PathVariable Integer id, Model model, HttpSession session) {
        if (session.getAttribute("user") == null) {
            return "redirect:/login";
        }

        model.addAttribute("user", userService.getById(id));
        return "user/edituser";
    }

    @GetMapping("/user/delete/{id}")
    public String deleteUser(@PathVariable Integer id, HttpSession session) {
        if (session.getAttribute("user") == null) {
            return "redirect:/login";
        }

        userService.delete(id);
        return "redirect:/user/view";
    }

    @PostMapping("/user/update")
    public String updateUser(User user, HttpSession session) {
        if (session.getAttribute("user") == null) {
            return "redirect:/login";
        }

        userService.save(user);
        return "redirect:/user/view";
    }
    
    // ====== FITUR KATEGORI BUKU =======
    @GetMapping("/kategori/view")
    public String viewKategori(Model model, HttpSession session) {
        if (session.getAttribute("user") == null) {
            return "redirect:/login";
        }
        model.addAttribute("listkategori", kategoriService.getAllKategori());
        return "kategori/viewkategori";
    }

    @GetMapping("/kategori/form")
    public String formKategori(Model model, HttpSession session) {
        if (session.getAttribute("user") == null) {
            return "redirect:/login";
        }
        model.addAttribute("kategori", new Kategori());
        return "kategori/formkategori";
    }

    @PostMapping("/kategori/simpan")
    public String simpanKategori(Kategori kategori, HttpSession session) {
        if (session.getAttribute("user") == null) {
            return "redirect:/login";
        }
        kategoriService.simpan(kategori);
        return "redirect:/kategori/view";
    }
    
    @GetMapping("/kategori/edit/{id}")
    public String editKategori(@PathVariable Integer id, Model model, HttpSession session) {
        if (session.getAttribute("user") == null) return "redirect:/login";
        
        model.addAttribute("kategori", kategoriService.getById(id));
        return "kategori/formkategori_edit"; 
    }

    @PostMapping("/kategori/update")
    public String updateKategori(Kategori kategori, HttpSession session) {
        if (session.getAttribute("user") == null) return "redirect:/login";
        
        kategoriService.updateKategori(kategori.getIdkategori(), kategori);
        return "redirect:/kategori/view";
    }

    @GetMapping("/kategori/delete/{id}")
    public String hapusKategori(@PathVariable Integer id, HttpSession session) {
        if (session.getAttribute("user") == null) {
            return "redirect:/login";
        }
        kategoriService.hapus(id);
        return "redirect:/kategori/view";
    }
    
    // ====== FITUR FILTER BUKU PER KATEGORI ========
    @GetMapping("/kategori/buku/{nama}")
    public String filterBuku(@PathVariable String nama, Model model, HttpSession session) {
        if (session.getAttribute("user") == null) {
            return "redirect:/login";
        }
        model.addAttribute("listbuku", bukuService.getBukuByKategori(nama));
        model.addAttribute("judulHalaman", "Kategori: " + nama);
        return "buku/viewbuku_filter";
    }
    
    // ====== FITUR STOK BUKU ======
    @GetMapping("/stok/view")
    public String viewStok(Model model, HttpSession session) {
        if (session.getAttribute("user") == null) {
            return "redirect:/login";
        }
        model.addAttribute("liststok", stokService.getAllStok());
        return "stok/viewstok";
    }
    
    @GetMapping("/stok/form")
    public String formTambahStok(Model model, HttpSession session) {
        if (session.getAttribute("user") == null) {
            return "redirect:/login";
        }
        model.addAttribute("stok", new Stok());
        model.addAttribute("listbuku", bukuService.getAllBuku()); 
        return "stok/formstok_tambah";
    }

    @GetMapping("/stok/edit/{id}")
    public String editStok(@PathVariable Integer id, Model model, HttpSession session) {
        if (session.getAttribute("user") == null) {
            return "redirect:/login";
        }
        model.addAttribute("stok", stokService.getById(id));
        return "stok/formstok";
    }

    @PostMapping("/stok/update")
    public String updateStok(Stok stok, HttpSession session) {
        if (session.getAttribute("user") == null) {
            return "redirect:/login";
        }
        stokService.simpanStok(stok);
        return "redirect:/stok/view";
    }

    // Logout
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
}