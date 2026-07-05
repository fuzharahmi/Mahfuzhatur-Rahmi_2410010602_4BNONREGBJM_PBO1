public class Orang {
    // Semua atribut bersifat private (encapsulation)
    private String nama;
    private int umur;
    private String noHP;

    // Constructor berparameter
    public Orang(String nama, int umur, String noHP) {
        this.nama = nama;
        this.umur = umur;
        this.noHP = noHP;
    }

    // ===== Getter (accessor) =====
    public String getNama() {
        return nama;
    }

    public int getUmur() {
        return umur;
    }

    public String getNoHP() {
        return noHP;
    }

    // ===== Setter (mutator) =====
    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setUmur(int umur) {
        this.umur = umur;
    }

    public void setNoHP(String noHP) {
        this.noHP = noHP;
    }

    // Method ini akan di-override oleh class turunan (mendukung polymorphism)
    public void tampilInfo() {
        System.out.println("Nama  : " + nama);
        System.out.println("Umur  : " + umur + " tahun");
        System.out.println("No HP : " + noHP);
    }
}
