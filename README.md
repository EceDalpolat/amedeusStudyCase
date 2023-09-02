# amedeusStudyCase
# Frontend açıklaması

testDifferentFromToValues(): Bu test, "From" ve "To" alanlarına aynı şehir adının girilmesinin hata mesajını doğru şekilde tetikleyip tetiklemediğini kontrol eder.

testFlightListingCount(): Bu test, belirli bir "From" ve "To" şehri ile yapılan uçuş aramasının sonuç sayısını kontrol eder.

testFlightListingCountSuccess(): Bu test, başarılı bir uçuş aramasının sonuç sayısını kontrol eder.

testFlightListingCountNoFlights(): Bu test, uçuş olmayan bir senaryoyu kontrol eder.

1. FlightAppTests Sınıfı:
setUp(): Her test başlamadan önce WebDriver'ı başlatan ve test sayfasına gitmek için kullanılan metot.
tearDown(): Her test tamamlandığında WebDriver'ı kapatmayı ve temizlemeyi sağlayan metot.

a. testDifferentFromToValues() Metodu:
Bu test, "From" ve "To" alanlarına aynı şehir adının girildiği bir senaryoyu temsil eder.
İlgili alanlara değerler girilir ve ardından "Search" düğmesine tıklanır.
Ardından hata mesajının görünürlüğünün beklenmesi ve bu mesajın "From and To cannot be the same." olup olmadığının kontrol edilmesi gerekmektedir.

b. testFlightListingCount() Metodu:
Bu test, belirli bir "From" ve "To" şehri ile yapılan uçuş aramasının sonuç sayısını kontrol eder.
İlgili alanlara şehirler girilir ve "Search" düğmesine tıklanır.
Ardından sayfa üzerindeki "Found X items" metnindeki X'in beklenen uçuş sayısı ile eşleşip eşleşmediği kontrol edilir.

c. testFlightListingCountSuccess() Metodu:
Bu test, başarılı bir senaryoyu temsil eder.
Belirli bir "From" ve "To" şehri ile yapılan uçuş aramasının sonuç sayısını kontrol eder.
İlgili alanlara şehirler girilir, "Search" düğmesine tıklanır ve beklenen uçuş sayısı ile sonuç karşılaştırılır.

d. testFlightListingCountNoFlights() Metodu:
Bu test, uçuş olmayan bir senaryoyu temsil eder.
İki farklı şehir arasında uçuş olmadığını varsayar ve sonuçların boş olması gerektiğini kontrol eder.


# Backend açıklaması
Bu testleri JSON dosyası içerisinden bulabilirsiniz
Projenin bu kısmında postman kullandım çünkü: Postman gibi araçlar API geliştirme, test etme ve yönetme süreçlerini büyük ölçüde kolaylaştırır. Bu nedenle birçok şirket,
yazılım geliştirme projelerinde Postman'ı tercih eder ve API'larını başarıyla yönetmek için kullanır. Postman, ekipler arasında işbirliğini artırırken aynı zamanda güvenlik 
ve hızlı geliştirme süreçlerine katkı sağlar.

1."Status code is 200" Testi:
Amaç: Bu test, HTTP yanıtının durum kodunun 200 (Başarılı) olup olmadığını kontrol eder.
İşlev: pm.response.to.have.status(200) ifadesi ile HTTP yanıtın durum kodu 200 olup olmadığı kontrol edilir.

2. "Response has valid structure" Testi:
Amaç: Bu test, yanıtın belirli bir yapıya (JSON formatında) sahip olup olmadığını kontrol eder.
İşlev: Aşağıdaki dört ifade ile yanıtın JSON formatında olduğu ve belirli bir yapıya sahip olduğu kontrol edilir:
pm.response.to.have.jsonBody("data[0].id"): Yanıtın içinde "data" dizisinin ilk öğesinin "id" alanı bulunmalı.
pm.response.to.have.jsonBody("data[0].from"): Yanıtın içinde "data" dizisinin ilk öğesinin "from" alanı bulunmalı.
pm.response.to.have.jsonBody("data[0].to"): Yanıtın içinde "data" dizisinin ilk öğesinin "to" alanı bulunmalı.
pm.response.to.have.jsonBody("data[0].date"): Yanıtın içinde "data" dizisinin ilk öğesinin "date" alanı bulunmalı.

4. "Response has correct Content-Type header" Testi:
Amaç: Bu test, HTTP yanıtının "Content-Type" başlığının "application/json" olup olmadığını kontrol eder.
İşlev: pm.response.to.have.header("Content-Type", "application/json") ifadesi ile yanıtın "Content-Type" başlığının "application/json" olarak ayarlanmış olup olmadığı kontrol edilir.

