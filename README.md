# 📚 SI-Buku: Sistem Informasi Pengelolaan Toko Buku (Administrator)

**SI-Buku** adalah aplikasi manajemen inventaris toko buku berbasis web yang dikembangkan menggunakan framework **Java Spring Boot**. Proyek ini merupakan implementasi nyata dari konsep Pemrograman Berorientasi Objek (PBO) dalam arsitektur sistem informasi, yang disusun oleh **Kaka Davi Dharmawan**, mahasiswa Ilmu Komputer semester 6 **UINSU Medan**.

Aplikasi ini menonjolkan fitur manajemen data relasional yang sinkron antara kategori dan koleksi buku.

---

## 🛠️ Tech Stack

Teknologi yang digunakan dalam pengembangan proyek ini meliputi:

* **Bahasa Pemrograman**: Java 23.
* **Framework**: Spring Boot 3.3 (Spring MVC, Spring Data JPA).
* **Template Engine**: Thymeleaf untuk rendering halaman HTML dinamis.
* **CSS Framework**: Bootstrap 5 untuk antarmuka yang responsif.
* **Database**: H2 Database (File-based Engine).
* **Version Control**: Git & GitHub.

---

## 🧠 Implementasi Pilar OOP

Proyek ini dibangun dengan menerapkan prinsip-prinsip utama Pemrograman Berorientasi Objek untuk menjamin kualitas kode:

* **Enkapsulasi (Encapsulation)**: Data pada entitas (Model) dibungkus menggunakan akses `private` dengan aksesibilitas terkontrol melalui *Getter* dan *Setter*.
* **Pewarisan (Inheritance)**: Menggunakan mekanisme *extends* pada kelas Repository terhadap `JpaRepository` untuk mewarisi fungsi-fungsi manipulasi database tanpa menulis query manual.
* **Abstraksi (Abstraction)**: Implementasi *Service Layer* untuk memisahkan logika bisnis dari *Controller*, sehingga detail teknis penyimpanan data disembunyikan dari lapisan antarmuka.
* **Polimorfisme (Polymorphism)**: Pemanfaatan *method overloading/overriding* pada fungsi-fungsi bawaan Spring Data, seperti penggunaan method `save()` yang fleksibel untuk berbagai objek entitas.

---

## 🚀 Fitur Utama

Berdasarkan rancangan Use Case, sistem ini mendukung berbagai tingkatan hak akses:

* **Manajemen User**: Autentikasi sistem melalui *Login* dan *Logout* terintegrasi.
* **Kelola Kategori**: Meliputi fungsionalitas menambah, mencari, merevisi, dan menghapus kategori buku.
* **Kelola Buku**: Manajemen data buku yang mencakup pencarian detail dan revisi informasi.
* **Sinkronisasi Relasional**: Logika otomatis yang memastikan data buku tetap konsisten saat terjadi perubahan pada master data kategori.

---

## 🔧 Cara Menjalankan Project

Ikuti langkah-langkah berikut untuk menjalankan aplikasi di lingkungan lokal:

1.  **Clone Repository**:
    ```bash
    git clone [https://github.com/dapiupiu/book-store-project.git](https://github.com/dapiupiu/book-store-project.git)
    ```
2.  **Import ke IDE**:
    * Buka Eclipse IDE.
    * Pilih **File** > **Import** > **Existing Maven Projects**.
3.  **Update Maven**:
    * Klik kanan pada project > **Maven** > **Update Project**.
4.  **Jalankan Aplikasi**:
    * Cari file utama `Application.java`.
    * Klik kanan > **Run As** > **Java Application**.
5.  **Akses Browser**:
    * Buka alamat `http://localhost:8080` di browser Anda.

---
*Proyek ini merupakan bagian dari pengembangan portofolio akademik di bidang Computer Science.*
