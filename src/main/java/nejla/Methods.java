package nejla;

import java.util.HashMap;
import java.util.Map;

public class Methods {
    Map<Integer, PojoUrun> depo; //Map kullanarak urunleri kaydedecegiz.

    public Methods() {//constructor olusturarak map'i initialize ediyoruz
        depo = new HashMap<Integer,PojoUrun>();
    }

    public void urunTanimlama(int ID, String s1, String s2, String s3) {
        PojoUrun pju1 = new PojoUrun(ID, s1, s2, s3);
        depo.put(ID, pju1);

    }

    public void urunListele() {
        System.out.printf("%10s %10s %10s %10s %10s %10s %n", "ID", "Ürün İsmi", "Üretici", "Miktar", "Birim", "Raf");
        System.out.print("-------------------------------------------------------------------------");
        for (PojoUrun w : depo.values()) {
            System.out.printf("\n%10s %10s %10s %10s %10s %10s %n", w.getID(), w.getUrunIsmi(), w.getUretici(), w.getMiktar(), w.getBirim(), w.getRaf());
        }

    }


    public void urunGirisi(int ID, double adet) {
        PojoUrun pju1 = depo.get(ID); //id'ye gore urunu bulduk.

        if (pju1 != null){ //urun bulunursa, giris yaparak miktar yazdırdık.
            pju1.setMiktar(pju1.getMiktar()+ adet);
            depo.replace(ID,pju1);
        } else { //urun bulunmuyorsa bunu yazdırdık.
            System.out.println("Aradığınız ürün bulunamadı.");
        }
    }


    public  void urunuRafaKoy(int ID, String raf){
        PojoUrun pju1 = depo.get(ID); //id'ye gore urunu bulduk.
            pju1.setRaf(raf);
            depo.replace(ID,pju1);
    }




}

