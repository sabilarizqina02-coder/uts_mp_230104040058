# Ujian Tengah Semester (UTS) – Pemrograman Mobile

## Identitas
Nama          : Sabila Rizqina Majid  
NIM           : 230104040058  
Mata Kuliah   : Pemrograman Mobile  
Program Studi : Teknologi Informasi  
Dosen         : Bapak Muhayat, M.I.T

## Deskripsi UTS
Ujian Tengah Semester (UTS) Pemrograman Mobile ini bertujuan untuk menguji pemahaman
mahasiswa terhadap konsep dasar pengembangan aplikasi Android menggunakan
Jetpack Compose, yang meliputi keterhubungan UI dengan logic, navigasi antar screen,
serta penyimpanan data sederhana.  
Pada UTS ini, mahasiswa diminta mengerjakan soal teori dan mengimplementasikan
sebuah mini-aplikasi sesuai paket soal yang ditentukan berdasarkan NIM.

## Paket UTS
Berdasarkan ketentuan pembagian paket UTS, NIM **230104040058** termasuk ke dalam  
**Paket C (NIM akhir 2, 5, 8)** dengan judul tugas:

**“Form Login Palsu + Remember Me”**

## Fitur Aplikasi
Aplikasi UTS yang dibuat memiliki beberapa fitur utama sebagai berikut:
1. Screen 1 – Splash / Welcome  
   Menampilkan halaman awal aplikasi dan melakukan pengecekan data login yang
   tersimpan. Jika data tersedia, pengguna langsung diarahkan ke Dashboard.
2. Screen 2 – Form Login  
   Menyediakan form input username dan password dengan opsi “Ingat Saya”.
   Jika login berhasil dan checkbox dicentang, data username disimpan ke storage lokal.
3. Screen 3 – Dashboard  
   Menampilkan pesan selamat datang kepada pengguna serta tombol untuk menghapus
   data login dan keluar dari aplikasi.

## Teknologi yang Digunakan
Bahasa Pemrograman : Kotlin  
IDE                : Android Studio  
UI                 : Jetpack Compose  
Navigasi           : NavHost dan NavController  
Penyimpanan Data   : SharedPreferences

## Mekanisme Kerja Aplikasi
- Aplikasi melakukan pengecekan data login tersimpan saat pertama kali dijalankan.
- Jika data login tersedia, pengguna langsung diarahkan ke Dashboard tanpa perlu login ulang.
- Proses login dilakukan dengan validasi sederhana (username dan password statis).
- Opsi “Ingat Saya” digunakan untuk menentukan apakah data login disimpan ke storage lokal.
- Pengguna dapat menghapus data login sehingga aplikasi kembali ke Form Login.

## Screenshot Hasil UTS
Screenshot hasil aplikasi & Jawaban UTS dapat diakses melalui link Google Drive berikut:

(https://drive.google.com/file/d/1_1wc5GT29ylmGF0xjwbB8B9CzKEhBaZ_/view?usp=drive_link)

## Kesimpulan
Melalui UTS Pemrograman Mobile ini dapat disimpulkan bahwa integrasi antara UI,
logic, navigasi, dan penyimpanan data sederhana merupakan komponen penting dalam
pengembangan aplikasi Android. Implementasi fitur login dengan konsep Remember Me
membantu memahami bagaimana data dapat dipertahankan meskipun aplikasi ditutup,
sehingga meningkatkan pengalaman pengguna.
