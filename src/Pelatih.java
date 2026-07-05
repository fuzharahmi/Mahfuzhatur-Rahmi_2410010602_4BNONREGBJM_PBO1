public class Pelatih extends Orang {
    // Atribut tambahan khusus milik Pelatih, tetap private (encapsulation)
    private String idPelatih;
    private String spesialisasi;

    // Constructor berparameter, memanggil constructor parent dengan super()
    public Pelatih(String nama, int umur, String noHP, String idPelatih, String spesialisasi) {
        super(nama, umur, noHP);
        this.idPelatih = idPelatih;
        this.spesialisasi = spesialisasi;
    }

    // ===== Getter =====
    public String getIdPelatih() {
        return idPelatih;
    }

    public String getSpesialisasi() {
        return spesialisasi;
    }

    // ===== Setter =====
    public void setIdPelatih(String idPelatih) {
        this.idPelatih = idPelatih;
    }

    public void setSpesialisasi(String spesialisasi) {
        this.spesialisasi = spesialisasi;
    }

    // Override tampilInfo() dengan output khusus pelatih (polymorphism)
    @Override
    public void tampilInfo() {
        System.out.println("======= DATA PELATIH =======");
        super.tampilInfo(); // Memanggil tampilInfo() milik parent (Orang)
        System.out.println("ID Pelatih   : " + idPelatih);
        System.out.println("Spesialisasi : " + spesialisasi);
    }
}
