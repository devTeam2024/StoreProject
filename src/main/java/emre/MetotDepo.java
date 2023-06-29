package emre;

import java.util.Map;
import java.util.Scanner;

public class MetotDepo {

    protected void urunTanimlama(Map<Integer, PojoClass> urunler, String urunIsmi, String uretici, String birim) {
        boolean urunYok = true;

        // urunler map'indeki her bir PojoClass nesnesi üzerinde döngü oluşturulur
        for (PojoClass urun : urunler.values()) {
            // urunIsmi, uretici ve birim değerleriyle eşleşen ürün kontrol edilir
            if (urun.getUrunIsmi().equalsIgnoreCase(urunIsmi)
                    && urun.getUretici().equalsIgnoreCase(uretici)
                    && urun.getBirim().equalsIgnoreCase(birim)) {
                urunYok = false;
                System.out.println("Ürün zaten ekli.");
                break;
            }
        }

        // urunYok değişkeni hala true ise, yeni bir ürün eklenir
        if (urunYok) {
            PojoClass urun = new PojoClass(urunIsmi, uretici, 0, birim, null);
            urunler.put(urun.getId(), urun);
        }
    }

    protected void tanimlananUrunListele(Map<Integer, PojoClass> urunler) {
        System.out.printf("%-10s %-10s %-10s %-10s %-10s %-10s %n", "ID", "Ürün İsmi", "Üretici", "Miktar", "Birim", "Raf");
        System.out.println("===============================================================");
        for (PojoClass urun : urunler.values()) {
            ekranGoruntusu(urun);
        }
    }

    protected void raftakiUrunleriListele(Map<Integer, PojoClass> urunler) {
        System.out.printf("%-10s %-10s %-10s %-10s %-10s %-10s %n", "ID", "Ürün İsmi", "Üretici", "Miktar", "Birim", "Raf");
        System.out.println("==============================================================");
        for (PojoClass urun : urunler.values()) {
            if (urun.getRaf() != null) {
                ekranGoruntusu(urun);
            }
        }
    }

    protected void urunGirisi(Map<Integer, PojoClass> urunler, int id,Scanner input) {
        if (urunler.containsKey(id)) {
            int miktar = input.nextInt();
            input.nextLine(); // Consume the new line character
            PojoClass urun = urunler.get(id);
            int yeniMiktar = urun.getMiktar() + miktar;
            urun.setMiktar(yeniMiktar);
        } else {
            System.out.println("Hatalı ID! Ürün tanımlı değil.");
        }
    }

    protected void urunSil(Map<Integer, PojoClass> urunler, int id) {
        if (urunler.containsKey(id)) {
            urunler.remove(id);
        } else {
            System.out.println("Hatalı ID! Ürün tanımlı değil.");
        }
    }

    protected void urunuRafaKoy(Map<Integer, PojoClass> urunler, int id, Scanner input) {
        if (urunler.containsKey(id)) {
            System.out.print("Hangi rafa koymak istersiniz: ");
            String rafIsmi = input.nextLine();
            PojoClass urun = urunler.get(id);
            urun.setRaf(rafIsmi);
        } else {
            System.out.println("Hatalı ID! Ürün tanımlı değil.");
        }
    }

    protected void urunCikisi(Map<Integer, PojoClass> urunler, int id,Scanner input) {
        if (urunler.containsKey(id)) {
            int miktar = input.nextInt();
            input.nextLine(); // Consume the new line character
            PojoClass urun = urunler.get(id);
            int mevcutMiktar = urun.getMiktar();
            if (miktar <= mevcutMiktar) {
                urun.setMiktar(mevcutMiktar - miktar);
                System.out.println("Ürün çıkışı başarıyla yapıldı.");
            } else {
                System.out.println("Hatalı miktar! Yeterli stok bulunmamaktadır.");
                System.out.println("Stok miktarı: " + urun.getMiktar() + " " + urun.getBirim());
            }
        } else {
            System.out.println("Hatalı ID! Ürün tanımlı değil.");
        }
    }

    protected void urunFiltrele(Map<Integer, PojoClass> urunler, String urunIsmi) {
        System.out.printf("%-10s %-10s %-10s %-10s %-10s %-10s %n", "ID", "Ürün İsmi", "Üretici", "Miktar", "Birim", "Raf");
        System.out.println("================================================================");
        for (PojoClass urun : urunler.values()) {
            if (urunIsmi.equalsIgnoreCase(urun.getUrunIsmi())) {
                ekranGoruntusu(urun);
            }
        }
    }

    protected void ureticiFiltrele(Map<Integer, PojoClass> urunler, String ureticiIsmi) {
        System.out.printf("%-10s %-10s %-10s %-10s %-10s %-10s %n", "ID", "Ürün İsmi", "Üretici", "Miktar", "Birim", "Raf");
        System.out.println("===============================================================");
        for (PojoClass urun : urunler.values()) {
            if (ureticiIsmi.equalsIgnoreCase(urun.getUretici())) {
                ekranGoruntusu(urun);
            }
        }
    }

    protected Map<Integer, PojoClass> fakeUrun(Map<Integer, PojoClass> urunler) {
        PojoClass fake1 = new PojoClass("makarna", "oba", 0, "cuval", null);
        PojoClass fake2 = new PojoClass("un", "oba", 0, "cuval", null);
        PojoClass fake3 = new PojoClass("un", "Hekimoglu", 0, "cuval", null);
        urunler.put(fake1.getId(), fake1);
        urunler.put(fake2.getId(), fake2);
        urunler.put(fake3.getId(), fake3);
        return urunler;
    }

    protected void ekranGoruntusu(PojoClass urun) {
        System.out.printf("%-10s %-10s %-10s %-10s %-10s %-10s %n",
                urun.getId(),
                urun.getUrunIsmi(),
                urun.getUretici(),
                urun.getMiktar(),
                urun.getBirim(),
                urun.getRaf());
    }

    protected void urunGuncelleme(Map<Integer, PojoClass> urunler, int id, Scanner input) {
        if (urunler.containsKey(id)) {
            PojoClass urun = urunler.get(id);System.out.println("========================== GUNCELLEMELER =======================");
            System.out.println("   ____________________              ____________________");
            System.out.println("   | 1-URUN ISMI        |       |  2-URUNRETICI ISMI      |");
            System.out.println("   ¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯             ¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯");
            System.out.println("   | 3-BIRIM ISMI       |       |                          ");
            String secim = input.nextLine();
            switch (secim) {
                case "1":
                    System.out.println("Yeni ürün ismi: ");
                    String urunIsmi = input.nextLine();
                    urun.setUrunIsmi(urunIsmi);
                    break;
                case "2":
                    System.out.println("Yeni üretici ismi: ");
                    String uretici = input.nextLine();
                    urun.setUretici(uretici);
                    break;
                case "3":
                    System.out.println("Yeni birim ismi: ");
                    String birim = input.nextLine();
                    urun.setBirim(birim);
                    break;
                default:
                    System.out.println("Geçersiz seçim!");
                    break;
            }
            System.out.println("Ürün güncelleme başarıyla yapıldı.");
        } else {
            System.out.println("Hatalı ID! Ürün tanımlı değil.");
        }
    }
}
