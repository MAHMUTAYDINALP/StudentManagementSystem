# 🎓 Öğrenci ve Akademisyen Yönetim Sistemi (Student Management System)

Bu proje, üniversitelerdeki öğrenci-akademisyen ilişkilerini, ders seçim süreçlerini ve kullanıcı yönetimini dijitalleştirmek amacıyla geliştirilmiş tam kapsamlı bir otomasyon sistemidir. Projenin temel odak noktası; **İlişkisel Veritabanı Mimarisi (RDBMS)** kurgulamak ve **RESTful API** standartlarına uygun CRUD operasyonları geliştirmektir.

> **📌 Akademik Bilgi:**
> Bu proje, yazılım öğrencisi **Mahmut Aydınalp** tarafından, Karadeniz Teknik Üniversitesi (KTÜ) 1. Sınıf **Veritabanı Yönetim Sistemleri** dersi kapsamında dönem projesi olarak tasarlanmış ve geliştirilmiştir.

---

## 🛠️ Temel Özellikler ve İş Mantığı

### 1. Rol Bazlı Kullanıcı Deneyimi (RBAC)
Sistemde Öğrenci, Akademisyen ve Admin (Kullanıcı Yöneticisi) olmak üzere farklı yetki seviyeleri bulunmaktadır:
* **Öğrenci Modülü:** Sisteme giriş yapan öğrenci; kişisel bilgilerini, atanan danışman akademisyenini görebilir ve yeni dönem için ders seçimi yaparak onaya gönderebilir.
* **Akademisyen Modülü:** Akademisyenler, kendi sorumluluğundaki (danışmanlık yaptığı) öğrencileri listeleyebilir ve bu öğrencilerin seçtiği dersleri inceleyerek "Onaylama" veya "Reddetme" işlemlerini gerçekleştirebilir.

### 2. İlişkisel Veritabanı Mimarisi (ER Diagram)
Sistem, veri tekrarını önlemek ve tutarlılığı sağlamak için normalize edilmiş 5 temel tablodan oluşur:
* **Students (Öğrenciler) & Academicians (Akademisyenler):** `N-1` ilişki. Her öğrencinin bir danışman akademisyeni vardır.
* **Courses (Dersler) & Academicians:** `N-1` ilişki. Her ders bir akademisyen tarafından verilir.
* **StudentSelectedCourses (Seçilen Dersler):** `1-N` ilişkilerle (Öğrenci-Ders-Akademisyen) ders onay mekanizmasını birbirine bağlayan "Köprü (Junction)" tablosudur.
* **Users:** Tüm sistemin giriş bilgilerini güvenli bir şekilde merkezde tutan kimlik doğrulama tablosu.

### 3. RESTful API Altyapısı
Backend tarafında, her bir varlık (Student, Academician, Course, User) için standartlara uygun **GET, POST, PUT, DELETE** uç noktaları (endpoints) yazılmış ve Postman üzerinden test edilerek dökümante edilmiştir.

---

## 📸 Uygulama Görselleri

> **Not:** Gerekli tanıtım,görsel ve anlatımlar ana klasördeki sunum içinde mevcuttur .
> <img width="1413" height="746" alt="E-R diyagramı" src="https://github.com/user-attachments/assets/3e2b0f21-75ce-4e80-a28d-13fc7224b329" />
<img width="1529" height="861" alt="Giriş ekranı" src="https://github.com/user-attachments/assets/43fdb2c2-0f49-4ff3-a923-1d5803787cfa" />
<img width="1586" height="862" alt="ögrenci ekranı" src="https://github.com/user-attachments/assets/64a53bee-f94f-4834-8b64-4d61f6f01bf8" />
<img width="1532" height="860" alt="akademisyen ekranı" src="https://github.com/user-attachments/assets/26829449-c45f-4ce3-a902-ae93b54fd83f" />
<img width="1540" height="884" alt="students get api test" src="https://github.com/user-attachments/assets/a2795a74-8d72-4e37-b1c5-003569ecbfab" />
<img width="1536" height="869" alt="students post api test " src="https://github.com/user-attachments/assets/ee52fea9-2962-4528-81a1-33b7d21d18ee" />
<img width="1533" height="862" alt="academicians put api test " src="https://github.com/user-attachments/assets/9465496e-27fa-4b31-934f-55ec8a8f0340" />
<img width="1536" height="866" alt="academicians delete api test" src="https://github.com/user-attachments/assets/4c6e0c29-b36a-447e-a793-2d2d485f3d64" />
<img width="1867" height="1044" alt="klasör yapısı" src="https://github.com/user-attachments/assets/9c9411fb-9ff0-4cda-91ea-fdccf5d1122d" />







---

## 🚀 Kurulum ve Çalıştırma Rehberi

Projeyi kendi bilgisayarınızda test etmek için aşağıdaki adımları izleyebilirsiniz:

### 1. Veritabanı Hazırlığı (SQL)
1. Bilgisayarınızda (MySQL/PostgreSQL) yeni bir veritabanı oluşturun.
2. `database` klasörünün içindeki SQL scriptini çalıştırarak tabloları ve test verilerini içeri aktarın.
3. Backend klasöründeki `src/main/resources/application.properties` dosyasına giderek veritabanı url, kullanıcı adı ve şifrenizi kendi sisteminize göre güncelleyin.

### 2. Backend'i Başlatma (Java Spring Boot)
Backend servisi **Maven** ile yönetilmektedir. Terminali açın ve şu komutları girin:
```bash
# Proje dizinine gidin
cd backend

# Maven kullanarak Spring Boot uygulamasını başlatın
mvn spring-boot:run
(Sunucu başarıyla çalıştığında API'ler http://localhost:8080 adresinden dinlemeye başlayacaktır.)

3. Frontend'i Çalıştırma
Arayüz statik web dosyalarından (HTML/CSS/JS) oluşmaktadır. Ekstra bir Node.js kurulumuna gerek yoktur:

frontend klasörüne gidin.

index.html dosyasını doğrudan tarayıcıda açın veya VS Code Live Server eklentisi ile başlatın.


---

## 📡 API Uç Noktaları (Endpoints) Topolojisi
Uygulamanın arka yüzü `localhost:8080/api/` üzerinden hizmet vermektedir:
* `/api/students` ➔ Öğrencileri listele (GET), Yeni ekle (POST), Güncelle (PUT), Sil (DELETE)
* `/api/academicians` ➔ Akademisyen operasyonları
* `/api/courses` ➔ Ders kataloğu yönetimi
* `/api/users` ➔ Sisteme erişim yapacak kullanıcıların kimlik yönetimi

---
Geliştiren: Mahmut AydınAlp

https://www.linkedin.com/in/mahmut-ayd%C4%B1nalp-659875282/

https://github.com/MAHMUTAYDINALP
