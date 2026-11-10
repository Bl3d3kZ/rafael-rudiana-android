# RAFAEL RUDIANA — Android APK wrapper

Aplikasi Android ini membuka situs RAFAEL RUDIANA dari Netlify dalam WebView.
Package ID: `com.rafael.komik`

## Catatan penting
- APK ini memerlukan internet dan memuat situs live: https://heroic-nougat-89739d.netlify.app/
- Perubahan pada situs akan tampil di aplikasi setelah halaman dimuat ulang.
- Katalog otomatis dari Supabase hanya akan berfungsi jika versi situs yang dipublikasikan memang sudah terhubung ke Supabase.
- Fitur pemilih file disertakan agar upload cover/halaman dari admin web dapat digunakan di dalam aplikasi.
- Build GitHub Actions menghasilkan debug APK yang dapat dipasang untuk uji coba. Untuk rilis Play Store diperlukan APK/AAB release yang ditandatangani dengan kunci milik pemilik aplikasi.

## Cara membuat APK dari HP
1. Buat repository baru di GitHub, misalnya `rafael-rudiana-android`.
2. Ekstrak ZIP ini, lalu unggah seluruh isi folder ke repository (bukan folder ZIP-nya).
3. Pastikan branch bernama `main`.
4. Buka tab **Actions** pada repository.
5. Jika diminta, izinkan GitHub Actions.
6. Jalankan workflow **Build RAFAEL RUDIANA APK** melalui tombol **Run workflow**. Workflow juga berjalan otomatis saat ada push ke `main`.
7. Setelah selesai, buka hasil run workflow, gulir ke **Artifacts**, lalu unduh `RAFAEL-RUDIANA-APK`.
8. Ekstrak ZIP artifact dan pasang `app-debug.apk` di Android. Izinkan instalasi dari sumber tersebut jika Android memintanya.

## Pengaturan aplikasi
- Nama: RAFAEL RUDIANA
- Application ID: `com.rafael.komik`
- Orientasi: portrait
- Tema: gelap
- Bahasa: mengikuti situs web.
