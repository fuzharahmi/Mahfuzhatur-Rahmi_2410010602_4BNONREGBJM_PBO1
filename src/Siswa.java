public class Siswa extends Orang {
    // Atribut tambahan khusus milik Siswa, tetap private (encapsulation)
    private String nis;
    private String kelas;

    // Constructor berparameter, memanggil constructor parent dengan super()
    public Siswa(String nama, int umur, String noHP, String nis, String kelas) {
        super(nama, umur, noHP);
        this.nis = nis;
        this.kelas = kelas;
    }

    // ===== Getter =====
    public String getNis() {
        return nis;
    }

    public String getKelas() {
        return kelas;
    }

    // ===== Setter =====
    public void setNis(String nis) {
        this.nis = nis;
    }

    public void setKelas(String kelas) {
        this.kelas = kelas;
    }

    // Override tampilInfo() dengan output khusus siswa (polymorphism)
    @Override
    public void tampilInfo() {
        System.out.println("======= DATA SISWA =======");
        super.tampilInfo(); // Memanggil tampilInfo() milik parent (Orang)
        System.out.println("NIS   : " + nis);
        System.out.println("Kelas : " + kelas);
    }
}
