# 🛫 Mediator Design Pattern

✈️ Gerçek Hayattan Bir Analoji: Hava Kontrol Kuleleri

Havaalanlarında uçakların iniş ve kalkışlarını organize eden kontrol kuleleri vardır.
Bütün pilotlar bu kule ile iletişim kurar ve hareket için havaalanı uygunluğunu öğrenirler.

Eğer bu kuleler bulunmasaydı bütün pilotların birbirleri ile iletişime geçmeleri gerekirdi.
Bu çözüm hem zaman alırdı hem de oldukça karmaşık olacağından dolayı hata riskini artırırdı.

<p align="center"> <img width="275" height="182" alt="image" src="https://github.com/user-attachments/assets/9c84cee6-cb7b-40f6-a180-937d406c131b" /> </p>
🏦 Banka Senaryosu

Bir bankada, müşterilerin sıra numarası alarak çalışanlar ile görüştüğü bir uygulama tasarladığımızı düşünelim.
Temel olarak ihtiyacımız olan bileşenler şunlardır:

👩‍💼 Çalışanlar

🧑‍🤝‍🧑 Müşteriler

🎫 Sıra numarası makinesi

📺 Bilgilendirme ekranı

🔹 Bir banka çalışanı, bir müşteriyi kabul ettiğinde veya müsait olduğunda bilgilendirme ekranındaki bilgiler güncellenmelidir.
🔹 Yeni bir müşteri sıra numarası aldığında ekrandaki “sıradaki müşteri” bilgisi güncellenmelidir.

Görüldüğü üzere kullanacağımız bütün nesneler birbirleri ile yüksek bağımlılığa sahiptir.
Bu durum, ileride gelebilecek gereksinimlerin karşılanmasında ve mevcut sistemin bakımında yüksek maliyet doğurur.

Nesnelerin her işlemde doğrudan birbirleriyle haberleşmesi yerine,
ortak bir kontrol merkezi (Mediator) üzerinden yönetmek çok daha doğru bir yaklaşımdır.

<p align="center"> <img width="310" height="215" alt="image" src="https://github.com/user-attachments/assets/736d8fa5-0184-4a33-a577-f86336ce1994" /> </p>
🤝 Mediator Design Pattern Nedir?

Mediator Design Pattern, çok sayıda nesne bulunan sistemlerde, nesnelerin minimum bağımlılıkla iletişim kurabilmesini sağlar.

🟢 Mediator: “Arabulucu / Aracı” anlamına gelir.

🟢 Behavioral (Davranışsal) tasarım desenleri grubuna dahildir.

Avantajları:

Nesneler arasındaki bağımlılığı azaltır.

Bakım maliyetini düşürür.

Hata riskini azaltır.

📝 Sonuç

Tüm nesnelerin doğrudan haberleşmeleri yerine, iletişimi tek merkezden yöneten bir yapı kurduk.

✅ Bakım maliyeti düşük
✅ Tekrar kullanılabilir nesneler
✅ Yeni ihtiyaçlarda alt sınıf patlaması engellenmiş oldu

Not: Mediator sınıfının sorumluluğu diğer sınıflara göre oldukça yüksektir.
Yazımı daha zor ve bakım maliyeti daha pahalı olabilir.
Ama iletişimi tek merkezden yönetmesi, önlediği karmaşıklık ve hatalara göre kesinlikle değerdir.
