package emre;

import java.util.HashMap;
import java.util.Map;

public class MetoDepo {
    public Map<Integer, pojoClas> urunler = new HashMap<>();


    public void urunTanimlama(int id, String urunIsmi, String uretici, String birim) {
        pojoClas urun = new pojoClas(id, urunIsmi, uretici, 0, birim, "-");
        System.out.println(urun);

        urunler.put(id, urun);
        System.out.println(urunler);
    }

    public void urunListele() {//printfn ile yapacagim
      //  System.out.println("id\t  urunIsmi\t   uretici\t  miktar\t birim\t raf");
//        System.out.println("===================================================");
        for (pojoClas urun : urunler.values()) {
            System.out.println(urun.getId() + "\t" + urun.getUrunIsmi() + "\t" + urun.getUretici() +
                    "\t" + urun.getMiktar() + "\t" + urun.getBirim() + "\t" + urun.getRaf());
        }
    }

    public void urunGirisi(int id, int miktar) {
        if (urunler.containsKey(id)) {
            pojoClas urun = urunler.get(id);
            int yeniMiktar = urun.getMiktar() + miktar;
            urun.setMiktar(yeniMiktar);
        } else {
            System.out.println("Hatalı ID! Ürün tanımlı değil.");
        }
    }


}

