# amedeusStudyCase
# Frontend açıklaması

testDifferentFromToValues(): Bu test, "From" ve "To" alanlarına aynı şehir adının girilmesinin hata mesajını doğru şekilde tetikleyip tetiklemediğini kontrol eder.

testFlightListingCount(): Bu test, belirli bir "From" ve "To" şehri ile yapılan uçuş aramasının sonuç sayısını kontrol eder.

testFlightListingCountSuccess(): Bu test, başarılı bir uçuş aramasının sonuç sayısını kontrol eder.

testFlightListingCountNoFlights(): Bu test, uçuş olmayan bir senaryoyu kontrol eder.

# Backend açıklaması
Bu testleri JSON dosyası içerisinden bulabilirsiniz
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

Projenin bu kısmında postman kullandım çünkü: Postman gibi araçlar API geliştirme, test etme ve yönetme süreçlerini büyük ölçüde kolaylaştırır. Bu nedenle birçok şirket,
yazılım geliştirme projelerinde Postman'ı tercih eder ve API'larını başarıyla yönetmek için kullanır. Postman, ekipler arasında işbirliğini artırırken aynı zamanda güvenlik 
ve hızlı geliştirme süreçlerine katkı sağla
