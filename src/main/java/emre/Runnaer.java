package emre;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Runnaer {
    public static void main(String[] args) {


        MetoDepo metotDepo = new MetoDepo();
        Scanner input = new Scanner(System.in);
        Map<Integer, PojoClas> urunler = new HashMap<>();

        metotDepo.fakeUrun(urunler);//fake olarak 3 tane urun ekledim ki testlerimizi kolaylikla yapalim
        while (true) {
            System.out.print(
                    "tanimlamak icin           :1 \n" +
                            "urun girisi               :2 \n" +
                            "rafa urun koymak icin     :3 \n" +
                            "nurun cikisi icin         :4 \n" +
                            "urun filtreleme           :5 \n" +
                            "uretici filtreleme        :6 \n" +
                            "Raftaki urunleri listele  :7 \n" +
                            "Tanimli urun sil          :8 \n" +
                            "SECIMINIZ:");
            String menusecim = input.nextLine();
            switch (menusecim) {
                case "1":
                    System.out.print("urun cinsini giriniz :");
                    String cinsi = input.nextLine();
                    System.out.print("ureticisini giriniz :");
                    String uretici = input.nextLine();
                    System.out.print("birimini giriniz :");
                    String birim = input.nextLine();
                    metotDepo.urunTanimlama(urunler, cinsi, uretici, birim);
                    metotDepo.tanimlananUrunListele(urunler);
                    break;
                case "2":
                    System.out.println("eklemek istediginiz urunun id sini giriniz");

                    int id = input.nextInt();
                    System.out.println("ne kadar eklemek istersiniz");
                    input.nextLine();

                    int miktar = input.nextInt();
                    input.nextLine();
                    metotDepo.urunGirisi(urunler, id, miktar);
                    metotDepo.tanimlananUrunListele(urunler);
                    break;
                case "3":
                    System.out.println("rafa koymak istediginiz urunun id sini giriniz");
                    id = input.nextInt();
                    input.nextLine();
                    System.out.println("hangi rafa koymak istersiniz");
                    String rafIsmi = input.nextLine();
                    metotDepo.urunuRafaKoy(urunler, id, rafIsmi);
                    metotDepo.tanimlananUrunListele(urunler);
                    break;
                case "4":
                    do {
                        System.out.println("Cikis yapacaginiz urunun id sini giriniz");

                        id = input.nextInt();

                        System.out.println("Ne kadar cikis yapacaksiniz");
                        miktar = input.nextInt();
                        metotDepo.urunCikisi(urunler, id, miktar);
                        input.nextLine();
                    } while (miktar == 0);
                    metotDepo.tanimlananUrunListele(urunler);
                    break;
                case "5":
                    System.out.println("aramak istediginiz urunu bulunuz");
                    String urun = input.nextLine();
                    metotDepo.suzmeUrunIsmi(urunler, urun);
                    break;
                case "6":
                    System.out.println("aramak istediginiz uretici bulunuz");
                    uretici = input.nextLine();
                    metotDepo.suzmeUretici(urunler, uretici);
                    break;
                case "7":
                    metotDepo.raftakiUrunListele(urunler);
                    break;
                case "8":
                    System.out.println("Silmek istediginiz urunun id sini giriniz");
                    id = input.nextInt();
                    input.nextLine();
                    metotDepo.tanimliUrunSil(urunler, id);
                    metotDepo.tanimlananUrunListele(urunler);
                    break;
                case "0":
                    System.exit(0);
            }
        }
    }
}
