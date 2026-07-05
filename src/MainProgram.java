import java.util.Scanner;
import java.util.InputMismatchException;

// Class utama yang menjalankan Sistem Manajemen Ekstrakulikuler Sekolah Menengah Pertama
public class MainProgram {

    // Array menampung data siswa, kapasitas maksimal 20 (bukan ArrayList)
    static Siswa[] daftarSiswa = new Siswa[20];
    static int jumlahSiswaTerdaftar = 0;

    // Array menampung data ekskul, kapasitas maksimal 5 (bukan ArrayList)
    static Ekskul[] daftarEkskul = new Ekskul[5];
    static int jumlahEkskulTerdaftar = 0;

    // Menyimpan sementara pelatih terakhir yang diinput, agar bisa dipakai saat membuat ekskul baru
    static Pelatih pelatihTerakhirDiinput = null;

    static Scanner inputScanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean programMasihBerjalan = true;

        while (programMasihBerjalan) {
            tampilkanMenuUtama();
            try {
                int pilihanMenu = inputScanner.nextInt();
                inputScanner.nextLine(); // Membersihkan sisa buffer newline

                switch (pilihanMenu) {
                    case 1:
                        tambahDataSiswa();
                        break;
                    case 2:
                        tambahDataEkskul();
                        break;
                    case 3:
                        tambahDataPelatih();
                        break;
                    case 4:
                        daftarkanSiswaKeEkskul();
                        break;
                    case 5:
                        tampilkanSemuaSiswa();
                        break;
                    case 6:
                        tampilkanSemuaEkskulBesertaAnggota();
                        break;
                    case 7:
                        System.out.println("\nTerima kasih telah menggunakan program. Sampai jumpa!");
                        programMasihBerjalan = false;
                        break;
                    default:
                        // Seleksi: menangani pilihan menu yang tidak ada di daftar 1-7
                        System.out.println("Pilihan menu tidak valid! Silakan pilih angka 1 sampai 7.");
                }
            } catch (InputMismatchException kesalahanInput) {
                // Error handling: input bukan angka (misalnya huruf) saat memilih menu
                System.out.println("Input salah! Harap masukkan angka sesuai pilihan menu.");
                inputScanner.nextLine(); // Membersihkan buffer agar tidak infinite loop
            }
        }
        inputScanner.close();
    }

    // Menampilkan tampilan menu utama program
    public static void tampilkanMenuUtama() {
        System.out.println("\n======================================");
        System.out.println("  SISTEM EKSTRAKULIKULER");
        System.out.println("  SEKOLAH MENENGAH PERTAMA");
        System.out.println("======================================");
        System.out.println("1. Tambah Data Siswa");
        System.out.println("2. Tambah Data Ekskul");
        System.out.println("3. Tambah Data Pelatih");
        System.out.println("4. Daftarkan Siswa ke Ekskul");
        System.out.println("5. Tampilkan Semua Siswa");
        System.out.println("6. Tampilkan Semua Ekskul & Anggota");
        System.out.println("7. Keluar Program");
        System.out.println("======================================");
        System.out.print("Masukkan pilihan Anda: ");
    }

    // Menambahkan data siswa baru ke dalam array daftarSiswa
    public static void tambahDataSiswa() {
        try {
            // Error handling: cek apakah array daftarSiswa sudah penuh sebelum diisi
            if (jumlahSiswaTerdaftar >= daftarSiswa.length) {
                throw new ArrayIndexOutOfBoundsException();
            }

            System.out.println("\n--- Tambah Data Siswa ---");
            System.out.print("Masukkan Nama Siswa  : ");
            String namaSiswa = inputScanner.nextLine();

            System.out.print("Masukkan Umur Siswa  : ");
            int umurSiswa = inputScanner.nextInt();
            inputScanner.nextLine();

            System.out.print("Masukkan No HP Siswa : ");
            String noHPSiswa = inputScanner.nextLine();

            System.out.print("Masukkan NIS Siswa   : ");
            String nisSiswa = inputScanner.nextLine();

            System.out.print("Masukkan Kelas Siswa : ");
            String kelasSiswa = inputScanner.nextLine();

            // Membuat object baru dari class Siswa lalu menyimpannya ke array
            Siswa siswaBaru = new Siswa(namaSiswa, umurSiswa, noHPSiswa, nisSiswa, kelasSiswa);
            daftarSiswa[jumlahSiswaTerdaftar] = siswaBaru;
            jumlahSiswaTerdaftar++;

            System.out.println("Data siswa berhasil ditambahkan!");
        } catch (InputMismatchException kesalahanInput) {
            // Error handling: umur diisi bukan dengan angka
            System.out.println("Input umur harus berupa angka!");
            inputScanner.nextLine();
        } catch (ArrayIndexOutOfBoundsException kesalahanArray) {
            // Error handling: data siswa sudah mencapai kapasitas maksimal
            System.out.println("Data siswa sudah penuh (maksimal " + daftarSiswa.length + " siswa)!");
        }
    }

    // Meminta input data pelatih dari keyboard lalu mengembalikan object Pelatih
    public static Pelatih inputDataPelatihDariKeyboard() {
        System.out.print("Masukkan Nama Pelatih        : ");
        String namaPelatih = inputScanner.nextLine();

        int umurPelatih = 0;
        try {
            System.out.print("Masukkan Umur Pelatih        : ");
            umurPelatih = inputScanner.nextInt();
            inputScanner.nextLine();
        } catch (InputMismatchException kesalahanInput) {
            // Error handling: umur pelatih diisi bukan dengan angka
            System.out.println("Input umur salah, umur pelatih diset 0 secara default.");
            inputScanner.nextLine();
        }

        System.out.print("Masukkan No HP Pelatih       : ");
        String noHPPelatih = inputScanner.nextLine();

        System.out.print("Masukkan ID Pelatih          : ");
        String idPelatih = inputScanner.nextLine();

        System.out.print("Masukkan Spesialisasi Pelatih: ");
        String spesialisasiPelatih = inputScanner.nextLine();

        return new Pelatih(namaPelatih, umurPelatih, noHPPelatih, idPelatih, spesialisasiPelatih);
    }

    // Menambahkan data pelatih baru (berdiri sendiri lewat menu 3)
    public static void tambahDataPelatih() {
        System.out.println("\n--- Tambah Data Pelatih ---");
        Pelatih pelatihBaru = inputDataPelatihDariKeyboard();
        pelatihTerakhirDiinput = pelatihBaru; // Disimpan agar bisa dipakai saat membuat ekskul

        // Upcasting: object Pelatih disimpan ke dalam variabel bertipe Orang (parent)
        Orang orangHasilUpcasting = pelatihBaru;
        System.out.println("\nData pelatih berhasil ditambahkan!");
        orangHasilUpcasting.tampilInfo(); // Tetap memanggil tampilInfo() milik Pelatih (polymorphism)
    }

    // Menambahkan data ekskul baru ke dalam array daftarEkskul
    public static void tambahDataEkskul() {
        try {
            // Error handling: cek apakah array daftarEkskul sudah penuh sebelum diisi
            if (jumlahEkskulTerdaftar >= daftarEkskul.length) {
                throw new ArrayIndexOutOfBoundsException();
            }

            System.out.println("\n--- Tambah Data Ekskul ---");
            System.out.print("Masukkan Nama Ekskul   : ");
            String namaEkskul = inputScanner.nextLine();

            System.out.print("Masukkan Kuota Maksimal: ");
            int kuotaMaksimal = inputScanner.nextInt();
            inputScanner.nextLine();

            Pelatih pelatihUntukEkskul;
            if (pelatihTerakhirDiinput != null) {
                System.out.print("Gunakan pelatih '" + pelatihTerakhirDiinput.getNama() + "' yang terakhir diinput? (y/t): ");
                String jawabanPakaiPelatihLama = inputScanner.nextLine();
                if (jawabanPakaiPelatihLama.equalsIgnoreCase("y")) {
                    pelatihUntukEkskul = pelatihTerakhirDiinput;
                } else {
                    System.out.println("--- Masukkan Data Pelatih Baru untuk Ekskul Ini ---");
                    pelatihUntukEkskul = inputDataPelatihDariKeyboard();
                }
            } else {
                System.out.println("Belum ada data pelatih tersimpan, silakan input data pelatih baru.");
                pelatihUntukEkskul = inputDataPelatihDariKeyboard();
            }

            // Membuat object baru dari class Ekskul lalu menyimpannya ke array
            Ekskul ekskulBaru = new Ekskul(namaEkskul, kuotaMaksimal, pelatihUntukEkskul);
            daftarEkskul[jumlahEkskulTerdaftar] = ekskulBaru;
            jumlahEkskulTerdaftar++;

            System.out.println("Data ekskul berhasil ditambahkan!");
        } catch (InputMismatchException kesalahanInput) {
            // Error handling: kuota diisi bukan dengan angka
            System.out.println("Input kuota harus berupa angka!");
            inputScanner.nextLine();
        } catch (ArrayIndexOutOfBoundsException kesalahanArray) {
            // Error handling: data ekskul sudah mencapai kapasitas maksimal
            System.out.println("Data ekskul sudah penuh (maksimal " + daftarEkskul.length + " ekskul)!");
        }
    }

    // Mendaftarkan salah satu siswa yang sudah ada ke salah satu ekskul yang sudah ada
    public static void daftarkanSiswaKeEkskul() {
        if (jumlahSiswaTerdaftar == 0 || jumlahEkskulTerdaftar == 0) {
            System.out.println("\nData siswa atau data ekskul masih kosong. Tambahkan data terlebih dahulu.");
            return;
        }

        try {
            System.out.println("\n--- Daftar Siswa Tersedia ---");
            // Perulangan for untuk menampilkan pilihan siswa
            for (int indexSiswa = 0; indexSiswa < jumlahSiswaTerdaftar; indexSiswa++) {
                System.out.println((indexSiswa + 1) + ". " + daftarSiswa[indexSiswa].getNama()
                        + " (NIS: " + daftarSiswa[indexSiswa].getNis() + ")");
            }
            System.out.print("Pilih nomor siswa: ");
            int nomorSiswaDipilih = inputScanner.nextInt();
            inputScanner.nextLine();

            System.out.println("\n--- Daftar Ekskul Tersedia ---");
            // Perulangan for untuk menampilkan pilihan ekskul
            for (int indexEkskul = 0; indexEkskul < jumlahEkskulTerdaftar; indexEkskul++) {
                System.out.println((indexEkskul + 1) + ". " + daftarEkskul[indexEkskul].getNamaEkskul());
            }
            System.out.print("Pilih nomor ekskul: ");
            int nomorEkskulDipilih = inputScanner.nextInt();
            inputScanner.nextLine();

            // Error handling: validasi nomor yang dipilih harus sesuai rentang data yang ada
            if (nomorSiswaDipilih < 1 || nomorSiswaDipilih > jumlahSiswaTerdaftar
                    || nomorEkskulDipilih < 1 || nomorEkskulDipilih > jumlahEkskulTerdaftar) {
                throw new ArrayIndexOutOfBoundsException();
            }

            Siswa siswaTerpilih = daftarSiswa[nomorSiswaDipilih - 1];
            Ekskul ekskulTerpilih = daftarEkskul[nomorEkskulDipilih - 1];

            System.out.print("Masukkan Tanggal Daftar (dd-mm-yyyy): ");
            String tanggalDaftar = inputScanner.nextLine();

            // Seleksi terjadi di dalam method tambahAnggota() milik Ekskul (cek kuota)
            boolean statusDiterima = ekskulTerpilih.tambahAnggota(siswaTerpilih);

            // Membuat object Pendaftaran untuk mencatat hasil pendaftaran
            Pendaftaran pendaftaranBaru = new Pendaftaran(siswaTerpilih, ekskulTerpilih, tanggalDaftar, statusDiterima);

            System.out.println("\n--- Hasil Pendaftaran ---");
            pendaftaranBaru.tampilStatus();

        } catch (InputMismatchException kesalahanInput) {
            // Error handling: nomor siswa/ekskul diisi bukan dengan angka
            System.out.println("Input harus berupa angka!");
            inputScanner.nextLine();
        } catch (ArrayIndexOutOfBoundsException kesalahanArray) {
            // Error handling: nomor yang dipilih di luar jangkauan data yang tersedia
            System.out.println("Nomor yang dipilih tidak valid!");
        }
    }

    // Menampilkan semua data siswa yang sudah terdaftar menggunakan perulangan for
    public static void tampilkanSemuaSiswa() {
        if (jumlahSiswaTerdaftar == 0) {
            System.out.println("\nBelum ada data siswa yang terdaftar.");
            return;
        }

        System.out.println("\n=== DATA SEMUA SISWA TERDAFTAR ===");
        // Perulangan for menampilkan seluruh siswa satu per satu
        for (int indexSiswa = 0; indexSiswa < jumlahSiswaTerdaftar; indexSiswa++) {
            // Upcasting: object Siswa disimpan ke dalam variabel bertipe Orang (parent)
            Orang orangHasilUpcasting = daftarSiswa[indexSiswa];
            System.out.println("\nData ke-" + (indexSiswa + 1) + ":");
            orangHasilUpcasting.tampilInfo(); // Tetap memanggil tampilInfo() milik Siswa (polymorphism)
        }
    }

    // Menampilkan semua data ekskul beserta anggotanya menggunakan perulangan for
    public static void tampilkanSemuaEkskulBesertaAnggota() {
        if (jumlahEkskulTerdaftar == 0) {
            System.out.println("\nBelum ada data ekskul yang terdaftar.");
            return;
        }

        System.out.println("\n=== DATA SEMUA EKSKUL & ANGGOTA ===");
        // Perulangan for terluar untuk setiap ekskul
        for (int indexEkskul = 0; indexEkskul < jumlahEkskulTerdaftar; indexEkskul++) {
            Ekskul ekskulSaatIni = daftarEkskul[indexEkskul];

            System.out.println("\nNama Ekskul  : " + ekskulSaatIni.getNamaEkskul());
            System.out.println("Pelatih      : " + ekskulSaatIni.getPelatih().getNama()
                    + " (" + ekskulSaatIni.getPelatih().getSpesialisasi() + ")");
            System.out.println("Jumlah/Kuota : " + ekskulSaatIni.getJumlahAnggota() + "/" + ekskulSaatIni.getKuotaMaksimal());

            // Seleksi: cek apakah kuota ekskul ini masih tersedia atau sudah penuh
            if (ekskulSaatIni.getJumlahAnggota() >= ekskulSaatIni.getKuotaMaksimal()) {
                System.out.println("Status Kuota : PENUH");
            } else {
                System.out.println("Status Kuota : MASIH TERSEDIA");
            }

            System.out.println("Daftar Anggota:");
            Siswa[] anggotaEkskulIni = ekskulSaatIni.getAnggotaEkskul();

            if (ekskulSaatIni.getJumlahAnggota() == 0) {
                System.out.println("   (Belum ada anggota)");
            } else {
                // Perulangan for terdalam untuk menampilkan setiap anggota ekskul
                for (int indexAnggota = 0; indexAnggota < ekskulSaatIni.getJumlahAnggota(); indexAnggota++) {
                    System.out.println("   " + (indexAnggota + 1) + ". " + anggotaEkskulIni[indexAnggota].getNama()
                            + " - Kelas " + anggotaEkskulIni[indexAnggota].getKelas());
                }
            }
        }
    }
}
