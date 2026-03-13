package myspring.model;

import jakarta.persistence.*;

@Entity
public class Stok {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idstok;

    @OneToOne
    @JoinColumn(name = "idbuku")
    private Buku buku;

    private Integer jumlah;

    public Stok() {}

    // Getter dan Setter
    public Integer getIdstok() { return idstok; }
    public void setIdstok(Integer idstok) { this.idstok = idstok; }

    public Buku getBuku() { return buku; }
    public void setBuku(Buku buku) { this.buku = buku; }

    public Integer getJumlah() { return jumlah; }
    public void setJumlah(Integer jumlah) { this.jumlah = jumlah; }
}