public class Pendaftaran {
    // Semua atribut bersifat private (encapsulation)
    private Siswa siswa;
    private Ekskul ekskul;
    private String tanggalDaftar;
    private boolean statusDiterima;

    // Constructor berparameter
    public Pendaftaran(Siswa siswa, Ekskul ekskul, String tanggalDaftar, boolean statusDiterima) {
        this.siswa = siswa;
        this.ekskul = ekskul;
        this.tanggalDaftar = tanggalDaftar;
        this.statusDiterima = statusDiterima;
    }

    // ===== Getter =====
    public Siswa getSiswa() {
        return siswa;
    }

    public Ekskul getEkskul() {
        return ekskul;
    }

    public String getTanggalDaftar() {
        return tanggalDaftar;
    }

    public boolean isStatusDiterima() {
        return statusDiterima;
    }

    // ===== Setter =====
    public void setSiswa(Siswa siswa) {
        this.siswa = siswa;
    }

    public void setEkskul(Ekskul ekskul) {
        this.ekskul = ekskul;
    }

    public void setTanggalDaftar(String tanggalDaftar) {
        this.tanggalDaftar = tanggalDaftar;
    }

    public void setStatusDiterima(boolean statusDiterima) {
        this.statusDiterima = statusDiterima;
    }

    // Menampilkan ringkasan hasil pendaftaran ke layar
    public void tampilStatus() {
        System.out.println("Nama Siswa    : " + siswa.getNama());
        System.out.println("Ekskul        : " + ekskul.getNamaEkskul());
        System.out.println("Tanggal Daftar: " + tanggalDaftar);

        // Seleksi: cek status pendaftaran diterima atau ditolak
        if (statusDiterima) {
            System.out.println("Status        : DITERIMA");
        } else {
            System.out.println("Status        : DITOLAK (kuota ekskul penuh)");
        }
    }
}
