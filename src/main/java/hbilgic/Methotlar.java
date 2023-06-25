package hbilgic;

import java.util.HashMap;
import java.util.Map;

public class Methotlar {
    static Map<Integer, PojoUrun> urunlerList=new HashMap<Integer,PojoUrun>();

    public void urunTanimlama(int id, String urunIsmi, String uretici, String birim) {

        boolean urunVar = false;

        for (PojoUrun pojoUrun : urunlerList.values()) {
            if (pojoUrun.getUrunIsmi().contains(urunIsmi) && pojoUrun.getUretici().contains(uretici) && pojoUrun.getBirim().contains(birim)) {
                urunVar = true;
                break;
            }
        }

        if (urunVar) {
            System.out.println("Girmiş olduğunuz ürün ve özellikleri listede var.");
        } else {
            PojoUrun urun = new PojoUrun(id, urunIsmi, uretici, 0, birim, "-");
            urunlerList.put(id,urun);
        }
    }

    public  void urunListele(){
        System.out.printf("%-13s  %-15s   %-15s  %-10s   %-4s   %-4s \n","Id","Ürünİsmi","üretici","Miktar","Birimi","Raf");
        for (PojoUrun pojoUrun :urunlerList.values()){
            System.out.printf("%-13s  %-15s   %-15s  %-10s   %4s   %4s \n", pojoUrun.getId(), pojoUrun.getUrunIsmi(), pojoUrun.getUretici(), pojoUrun.getMiktar(), pojoUrun.getBirim(), pojoUrun.getRaf());
        }
    }

    public  void urunGirisi(int id,int miktar){
        PojoUrun urun = urunlerList.get(id);
        urun.setMiktar(urun.getMiktar()+miktar);
        urunlerList.replace(id, urun);

    }

    public void urunuRafaKoy(int id,String raf){
        PojoUrun urun = urunlerList.get(id);
        urun.setRaf(raf);
        urunlerList.replace(id,urun);
    }

    public void urunGuncelleme(){

    }
    public void urunCikisi(int id , int miktar){
        PojoUrun urun = urunlerList.get(id);
        if (urun.getMiktar()>miktar){
            urun.setMiktar(urun.getMiktar()-miktar);
            urunlerList.replace(id, urun);
        }else {
            System.out.println("yeterli ürün yok");
        }
    }


}
