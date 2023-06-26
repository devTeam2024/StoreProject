package emre;

import java.util.HashMap;
import java.util.Map;

public class MetoDepo {


    protected void urunTanimlama(Map<Integer, PojoClas> urunler, String urunIsmi,
                                 String uretici, String birim) {
        PojoClas urun = new PojoClas(urunIsmi, uretici, 0, birim, null);
        if (!urunler.containsValue(urun)){
        urunler.put(urun.getId(), urun);}else {
            System.out.println("daha once tanimlanmis");
        }
    }

    protected void tanimlananUrunListele(Map<Integer, PojoClas> urunler) {
        System.out.printf("%10s %10s %10s %10s %10s %10s %n", "ID", "Ürün İsmi", "Üretici", "Miktar", "Birim", "Raf");
        System.out.println("===============================================================");
        for (PojoClas urun : urunler.values()) {
            ekranGoruntusu(urun);
        }
    }

    protected void raftakiUrunListele(Map<Integer, PojoClas> urunler) {//printfn ile yapacagim
        System.out.printf("%10s %10s %10s %10s %10s %10s %n", "ID", "Ürün İsmi", "Üretici", "Miktar", "Birim", "Raf");
        System.out.println("==============================================================");
        for (PojoClas urun : urunler.values()) {
            if (urun.getRaf() != null) {
                ekranGoruntusu(urun);
            }
        }
    }


    protected void urunGirisi(Map<Integer, PojoClas> urunler, int id, int miktar) {
        if (urunler.containsKey(id)) {
            PojoClas urun = urunler.get(id);
            int yeniMiktar = urun.getMiktar() + miktar;
            urun.setMiktar(yeniMiktar);
        } else {
            System.out.println("Hatalı ID! Ürün tanımlı değil.");
        }
    }

    protected void tanimliUrunSil(Map<Integer, PojoClas> urunler, int id) {
        if (urunler.containsKey(id)) {
            urunler.remove(id);
        } else {
            System.out.println("Hatalı ID! Ürün tanımlı değil.");
        }

    }

    protected void urunuRafaKoy(Map<Integer, PojoClas> urunler, int id, String raf) {
        if (urunler.containsKey(id)) {
            PojoClas urun = urunler.get(id);
            urun.setRaf(raf);
        } else {
            System.out.println("Hatalı ID! Ürün tanımlı değil.");
        }
    }

    protected void urunCikisi(Map<Integer, PojoClas> urunler, int id, int miktar) {
        PojoClas urun = urunler.get(id);
        if (urun.getRaf() == null) {
            System.out.println("urun rafta degil");
        } else if (miktar <= urun.getMiktar()) {
            int yeniMiktar = urun.getMiktar() - miktar;
            urun.setMiktar(yeniMiktar);
            miktar = 0;
        } else {
            System.out.println("Depoda " + miktar + " " + urun.getBirim() + " \n" +
                    " en fazla " + urun.getMiktar() + " kadar cikti yapilabilir ve \n" +
                    "Rafta urun olmali");
            System.out.println("cikis yapmak icin 0 a basiniz");
        }
    }

    protected void suzmeUrunIsmi(Map<Integer, PojoClas> urunler, String urunIsmi) {
        System.out.printf("%10s %10s %10s %10s %10s %10s %n", "ID", "Ürün İsmi", "Üretici", "Miktar", "Birim", "Raf");
        System.out.println("================================================================");
        for (PojoClas urun : urunler.values()) {
            if (urunIsmi.equalsIgnoreCase(urun.getUrunIsmi())) {
                ekranGoruntusu(urun);
            }
        }

    }

    protected void suzmeUretici(Map<Integer, PojoClas> urunler, String UreticiIsmi) {
        System.out.printf("%-10s %-10s %-10s %-10s %-10s %-10s %n", "ID", "Ürün İsmi", "Üretici", "Miktar", "Birim", "Raf");
        System.out.println("===============================================================");
        for (PojoClas urun : urunler.values()) {
            if (UreticiIsmi.equalsIgnoreCase(urun.getUretici())) {
                ekranGoruntusu(urun);
            }
        }
    }

    protected Map<Integer, PojoClas> fakeUrun(Map<Integer, PojoClas> urunler) {
        PojoClas fake1 = new PojoClas("makarna", "oba", 0, "cuval", null);
        PojoClas fake2 = new PojoClas("un", "oba", 0, "cuval", null);
        PojoClas fake3 = new PojoClas("un", "Hekimoglu", 0, "cuval", null);
        urunler.put(fake1.getId(), fake1);
        urunler.put(fake2.getId(), fake2);
        urunler.put(fake3.getId(), fake3);
        return urunler;
    }

    protected void ekranGoruntusu(PojoClas urun) {



            System.out.printf("%10s %10s %10s %10s %10s %10s %n",
                    urun.getId(),
                    urun.getUrunIsmi(),
                    urun.getUretici(),
                    urun.getMiktar(),
                    urun.getBirim(),
                    urun.getRaf());
        }
    }
