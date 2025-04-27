
# EasyCalculator - Aplikasi Mobile Kalkulator

## Deskripsi Project
EasyCalculator adalah aplikasi kalkulator sederhana berbasis Android, dibuat untuk menghitung operasi matematika dasar seperti penjumlahan, pengurangan, perkalian, dan pembagian.
Aplikasi ini juga menyimpan riwayat perhitungan ke database lokal (SQLite) dan memungkinkan pengguna untuk melihat dan menghapus riwayat tersebut.

## Fitur Utama
- Kalkulator untuk operasi dasar.
- Riwayat perhitungan disimpan secara otomatis.
- Menghapus riwayat perhitungan satu per satu.
- Desain antarmuka sederhana dan mudah digunakan.

## Storyboard

### 1. Halaman Kalkulator (Calculator Screen)
- Input ekspresi matematika.
- Tampilkan hasil perhitungan.
- Tombol angka, operator, clear, dan sama dengan.
- Ikon untuk membuka halaman History.

### 2. Halaman Riwayat (History Screen)
- List RecyclerView untuk semua perhitungan sebelumnya.
- Hapus riwayat satu per satu melalui tombol Delete.

### 3. Alur Penggunaan
- Buka aplikasi → Masukkan ekspresi → Hitung hasil → Riwayat tersimpan → Lihat atau hapus riwayat.

## Wireframe (Sketsa Tampilan)

[ Calculator Screen ]
+-------------------------------+
|    Expression (5+7×2)          |
|    Result (19)                 |
|-------------------------------|
| 7 | 8 | 9 | ÷                 |
| 4 | 5 | 6 | ×                 |
| 1 | 2 | 3 | -                 |
| 0 | . | = | +                 |
|        [History Icon]         |
+-------------------------------+

[ History Screen ]
+--------------------------------+
| 5+7×2 = 19         [Delete]    |
| 9-2 = 7            [Delete]    |
| 8÷4 = 2            [Delete]    |
+--------------------------------+

## Teknologi yang Digunakan
- Java (Android Studio)
- SQLite Database
- RecyclerView
- Material Design Components

## Pembagian Tugas (Untuk 4 Orang)

| Nama | Tugas |
|------|-------|
| Wahyu | UI/UX Design (Membuat tampilan kalkulator dan history) |
| Watmah | Pembuatan Kalkulasi dan Logika Event pada tombol |
| Wulan Oktavia | Pembuatan Database Helper dan CRUD SQLite untuk Riwayat |
| [Nama Ke-4] | Integrasi RecyclerView + Tombol Delete di Riwayat |

*(Silakan ganti [Nama Ke-4] dengan nama temanmu yang keempat.)*

## Link Repository
> [Link Github kamu di sini]

## Link Trello Board (SCRUM Management)
> [Link Trello kamu di sini]
