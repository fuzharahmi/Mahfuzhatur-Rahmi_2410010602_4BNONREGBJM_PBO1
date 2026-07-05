public class Ekskul {
    // Semua atribut bersifat private (encapsulation)
    private String namaEkskul;
    private int kuotaMaksimal;
    private int jumlahAnggota;
    private Pelatih pelatih;
    private Siswa[] anggotaEkskul; // Array anggota, kapasitas 10, bukan ArrayList

    // Kapasitas tetap untuk array anggota ekskul
    private static final int KAPASITAS_ANGGOTA = 10;

    // Constructor berparameter
    public Ekskul(String namaEkskul, int kuotaMaksimal, Pelatih pelatih) {
        this.namaEkskul = namaEkskul;
        this.kuotaMaksimal = kuotaMaksimal;
        this.pelatih = pelatih;
        this.jumlahAnggota = 0;
        this.anggotaEkskul = new Siswa[KAPASITAS_ANGGOTA];
    }

    // ===== Getter =====
    public String getNamaEkskul() {
        return namaEkskul;
    }

    public int getKuotaMaksimal() {
        return kuotaMaksimal;
    }

    public int getJumlahAnggota() {
        return jumlahAnggota;
    }

    public Pelatih getPelatih() {
        return pelatih;
    }

    public Siswa[] getAnggotaEkskul() {
        return anggotaEkskul;
    }

    // ===== Setter =====
    public void setNamaEkskul(String namaEkskul) {
        this.namaEkskul = namaEkskul;
    }

    public void setKuotaMaksimal(int kuotaMaksimal) {
        this.kuotaMaksimal = kuotaMaksimal;
    }

    public void setJumlahAnggota(int jumlahAnggota) {
        this.jumlahAnggota = jumlahAnggota;
    }

    public void setPelatih(Pelatih pelatih) {
        this.pelatih = pelatih;
    }

    // Menambah anggota baru ke ekskul, mengembalikan true jika berhasil didaftarkan
    public boolean tambahAnggota(Siswa siswaBaru) {
        // Seleksi: cek apakah kuota ekskul masih tersedia atau sudah penuh
        if (jumlahAnggota < kuotaMaksimal && jumlahAnggota < anggotaEkskul.length) {
            anggotaEkskul[jumlahAnggota] = siswaBaru;
            jumlahAnggota++;
            return true; // Kuota tersedia, siswa diterima
        } else {
            return false; // Kuota penuh, siswa ditolak
        }
    }
}
