# UAS Project - IT Helpdesk Ticketing System 🛠️

Project ini adalah aplikasi Backend (RESTful API) untuk sistem pelaporan masalah IT. Sistem ini menerapkan **BPM Lifecycle** yang lengkap, dimana setiap tiket harus melalui tahapan proses dari pelaporan (`OPEN`), penugasan teknisi (`IN_PROGRESS`), hingga penyelesaian (`CLOSED`).

**Tugas Akhir / UAS**
* **Mata Kuliah:** Rekayasa Perangkat Lunak Lanjut
* **Nama:** Syifa Auliyah Kusumawardani
* **NIM:** 11230910000114

---

## 🚀 Teknologi yang Digunakan
* **Java 21**
* **Spring Boot 3** (Spring Web, Spring Data JPA)
* **H2 Database** (In-Memory Database)
* **Maven** (Build Tool)
* **Railway** (Cloud Deployment)

---

## 🌐 Live Demo (Cloud)
Aplikasi ini sudah online dan siap diuji:
* **Base URL:** `uashelpdesk-production.up.railway.app`
* **Cek Data:** `uashelpdesk-production.up.railway.app/api/helpdesk/list`

---

## 📝 Dokumentasi API (Panduan Testing)

Gunakan **Postman** untuk menguji alur bisnis (BPM) berikut:

### 1. Melaporkan Masalah (User)
* **Method:** `POST`
* **URL:** `/api/helpdesk/lapor`
* **Body (JSON):**
    ```json
    {
        "pelapor": "Syifa",
        "deskripsi": "Wifi di Lantai 3 Mati Total",
        "prioritas": "HIGH"
    }
    ```
* **Output:** Status tiket otomatis `OPEN`.

### 2. Menugaskan Teknisi (Manager)
Manager menunjuk teknisi untuk menangani tiket tersebut.
* **Method:** `PUT`
* **URL:** `/api/helpdesk/assign/{id}?teknisi=PakBudi`
    * Ganti `{id}` dengan ID tiket (contoh: `1`).
* **Output:** Status berubah jadi `IN_PROGRESS`, nama teknisi terisi.

### 3. Menyelesaikan Tiket (Teknisi)
Teknisi mengonfirmasi perbaikan selesai.
* **Method:** `PUT`
* **URL:** `/api/helpdesk/close/{id}`
* **Output:** Status berubah jadi `CLOSED`.

### 4. Lihat Semua Tiket
* **Method:** `GET`
* **URL:** `/api/helpdesk/list`

---

## ⚙️ Cara Menjalankan (Lokal)
1.  Clone repository ini.
2.  Buka di Spring Tool Suite (STS).
3.  Run `UasHelpdeskApplication.java`.
4.  Akses API via Postman di `http://localhost:8080`.

