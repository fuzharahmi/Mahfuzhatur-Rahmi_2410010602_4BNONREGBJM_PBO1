# Proyek Akhir Pemrograman Berbasis Objek 1
Proyek ini adalah aplikasi pengolahan data ekstrakulikuler sekolah menggunakan Java sebagai tugas akhir dari mata kuliah Pemrograman Berbasis Objek 1.

## Deskripsi
Aplikasi ini bernama **Sistem Manajemen Ekstrakulikuler Sekolah Menengah Pertama**. Aplikasi ini menerima input berupa data siswa, data pelatih, dan data ekstrakulikuler (ekskul), lalu memproses pendaftaran siswa ke suatu ekskul dengan mengecek secara otomatis apakah kuota ekskul tersebut masih tersedia atau sudah penuh, sehingga sistem dapat menentukan status siswa diterima atau ditolak.
Aplikasi ini mengimplementasikan beberapa konsep penting dalam pemrograman berorientasi objek (OOP) seperti Class, Object, Atribut, Method Constructor, Method Mutator, Method Accessor, Encapsulation, Inheritance, Polymorphism, Seleksi, Perulangan, IO Sederhana, Array, dan Error Handling.

## Penjelasan Kode
Berikut adalah bagian kode yang relevan dengan konsep OOP yang dijelaskan:
1. **Class** adalah template atau blueprint dari object. Pada kode ini, `Orang`, `Siswa`, `Pelatih`, `Ekskul`, `Pendaftaran`, dan `MainProgram` adalah contoh dari class.
```bash
public class Orang {
    ...
}
public class Siswa extends Orang {
    ...
}
public class Pelatih extends Orang {
    ...
}
public class Ekskul {
    ...
}
public class Pendaftaran {
    ...
}
public class MainProgram {
    ...
}
```
2. **Object** adalah instance dari class. Pada kode ini, `Siswa siswaBaru = new Siswa(...)` dan `Ekskul ekskulBaru = new Ekskul(...)` adalah contoh pembuatan object.
```bash
Siswa siswaBaru = new Siswa(namaSiswa, umurSiswa, noHPSiswa, nisSiswa, kelasSiswa);
daftarSiswa[jumlahSiswaTerdaftar] = siswaBaru;
Ekskul ekskulBaru = new Ekskul(namaEkskul, kuotaMaksimal, pelatihUntukEkskul);
daftarEkskul[jumlahEkskulTerdaftar] = ekskulBaru;
```
3. **Atribut** adalah variabel yang ada dalam class. Pada kode ini, `nama`, `umur`, `noHP` (di `Orang`), `nis`, `kelas` (di `Siswa`), dan seterusnya adalah contoh atribut.
```bash
private String nama;
private int umur;
private String noHP;
```
4. **Constructor** adalah method yang pertama kali dijalankan pada saat pembuatan object. Pada kode ini, constructor ada di setiap class, termasuk pemanggilan `super()` pada class turunan.
```bash
public Orang(String nama, int umur, String noHP) {
    this.nama = nama;
    this.umur = umur;
    this.noHP = noHP;
}
public Siswa(String nama, int umur, String noHP, String nis, String kelas) {
    super(nama, umur, noHP);
    this.nis = nis;
    this.kelas = kelas;
}
```
5. **Mutator** atau setter digunakan untuk mengubah nilai dari suatu atribut. Pada kode ini, `setNama`, `setNis`, `setKelas`, dan seterusnya adalah contoh method mutator.
```bash
public void setNama(String nama) {
    this.nama = nama;
}
public void setNis(String nis) {
    this.nis = nis;
}
```
6. **Accessor** atau getter digunakan untuk mengambil nilai dari suatu atribut. Pada kode ini, `getNama`, `getNis`, `getKelas`, `getNamaEkskul`, dan seterusnya adalah contoh method accessor.
```bash
public String getNama() {
    return nama;
}
public String getNis() {
    return nis;
}
```
7. **Encapsulation** adalah konsep menyembunyikan data dengan membuat atribut menjadi private dan hanya bisa diakses melalui method. Pada kode ini, seluruh atribut di semua class dienkapsulasi dan hanya bisa diakses melalui method getter dan setter.
```bash
private String nama;
private int umur;
private String noHP;
private String nis;
private String kelas;
```
8. **Inheritance** adalah konsep di mana sebuah class bisa mewarisi property dan method dari class lain. Pada kode ini, `Siswa` dan `Pelatih` mewarisi `Orang` dengan sintaks `extends`.
```bash
public class Siswa extends Orang {
    ...
}
public class Pelatih extends Orang {
    ...
}
```
9. **Polymorphism** adalah konsep di mana sebuah nama method dapat digunakan untuk merujuk ke beberapa tipe atau bentuk objek berbeda, sehingga metode dengan nama yang sama dapat berperilaku berbeda tergantung tipe objeknya. Pada kode ini, method `tampilInfo()` di-override oleh `Siswa` dan `Pelatih`, dan dipanggil melalui upcasting ke tipe `Orang`.
```bash
// Di class Orang
public void tampilInfo() {
    System.out.println("Nama  : " + nama);
    System.out.println("Umur  : " + umur + " tahun");
    System.out.println("No HP : " + noHP);
}
// Di class Siswa (override)
@Override
public void tampilInfo() {
    System.out.println("======= DATA SISWA =======");
    super.tampilInfo();
    System.out.println("NIS   : " + nis);
    System.out.println("Kelas : " + kelas);
}
// Upcasting saat dipanggil di MainProgram
Orang orangHasilUpcasting = daftarSiswa[indexSiswa];
orangHasilUpcasting.tampilInfo(); // Tetap memanggil versi Siswa
```
10. **Seleksi** adalah statement kontrol yang digunakan untuk membuat keputusan berdasarkan kondisi. Pada kode ini, digunakan seleksi `if else` dalam method `tambahAnggota` di `Ekskul` untuk mengecek kuota, dan dalam method `tampilStatus` di `Pendaftaran` untuk mengecek status diterima/ditolak.
```bash
// Di class Ekskul
public boolean tambahAnggota(Siswa siswaBaru) {
    if (jumlahAnggota < kuotaMaksimal && jumlahAnggota < anggotaEkskul.length) {
        anggotaEkskul[jumlahAnggota] = siswaBaru;
        jumlahAnggota++;
        return true;
    } else {
        return false;
    }
}
// Di class Pendaftaran
if (statusDiterima) {
    System.out.println("Status : DITERIMA");
} else {
    System.out.println("Status : DITOLAK (kuota ekskul penuh)");
}
```
11. **Perulangan** adalah statement kontrol yang digunakan untuk menjalankan blok kode berulang kali. Pada kode ini, digunakan loop `for` untuk menampilkan seluruh data siswa dan seluruh data ekskul beserta anggotanya.
```bash
for (int indexSiswa = 0; indexSiswa < jumlahSiswaTerdaftar; indexSiswa++) {
    Orang orangHasilUpcasting = daftarSiswa[indexSiswa];
    orangHasilUpcasting.tampilInfo();
}
```
12. **Input Output Sederhana** digunakan untuk menerima input dari user dan menampilkan output ke user. Pada kode ini, digunakan class `Scanner` untuk menerima input dan method `System.out.println`/`System.out.print` untuk menampilkan output.
```bash
Scanner inputScanner = new Scanner(System.in);
System.out.print("Masukkan Nama Siswa  : ");
String namaSiswa = inputScanner.nextLine();
System.out.println("Data siswa berhasil ditambahkan!");
```
13. **Array** adalah struktur data yang digunakan untuk menyimpan beberapa nilai dalam satu variabel. Pada kode ini, `Siswa[] daftarSiswa`, `Ekskul[] daftarEkskul`, dan `Siswa[] anggotaEkskul` adalah contoh penggunaan array murni (bukan ArrayList).
```bash
static Siswa[] daftarSiswa = new Siswa[20];
static Ekskul[] daftarEkskul = new Ekskul[5];
// Di dalam class Ekskul
private Siswa[] anggotaEkskul = new Siswa[10];
```
14. **Error Handling** digunakan untuk menangani error yang mungkin terjadi saat runtime. Pada kode ini, digunakan `try catch` untuk menangani `InputMismatchException` (salah format input) dan `ArrayIndexOutOfBoundsException` (data/array penuh atau nomor pilihan tidak valid).
```bash
try {
    if (jumlahSiswaTerdaftar >= daftarSiswa.length) {
        throw new ArrayIndexOutOfBoundsException();
    }
    int umurSiswa = inputScanner.nextInt();
    ...
} catch (InputMismatchException kesalahanInput) {
    System.out.println("Input umur harus berupa angka!");
    inputScanner.nextLine();
} catch (ArrayIndexOutOfBoundsException kesalahanArray) {
    System.out.println("Data siswa sudah penuh (maksimal " + daftarSiswa.length + " siswa)!");
}
```

## Usulan Nilai
| No  | Materi         |  Nilai  |
| :-: | -------------- | :-----: |
|  1  | Class          |    5    |
|  2  | Object         |    5    |
|  3  | Atribut        |    5    |
|  4  | Constructor    |    5    |
|  5  | Mutator        |    5    |
|  6  | Accessor       |    5    |
|  7  | Encapsulation  |    5    |
|  8  | Inheritance    |    5    |
|  9  | Polymorphism   |   10    |
| 10  | Seleksi        |    5    |
| 11  | Perulangan     |    5    |
| 12  | IO Sederhana   |   10    |
| 13  | Array          |   15    |
| 14  | Error Handling |   15    |
|     | **TOTAL**      | **100** |

## Pembuat
Nama: Mahfuzhatur Rahmi
NPM: 2410010602
