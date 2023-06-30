package emre;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        MetotDepo metotDepo = new MetotDepo();
        Scanner input = new Scanner(System.in);
        Map<Integer, PojoClass> urunler = new HashMap<>();

        metotDepo.fakeUrun(urunler); // test icin Fake urunler eklendi

        while (true) {
            System.out.println("========================== İŞLEMLER =======================");
            System.out.println("   ____________________              ____________________");
            System.out.println("   | 1-URUN TANIMLAMA        |       |  2-URUN GIRISI      |");
            System.out.println("   ¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯             ¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯");
            System.out.println("   | 3-URUN RAFA KOY         |       |  4-URUN CIKISI     |");
            System.out.println("   ¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯             ¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯");
            System.out.println("   |  5-URUN FILTRELE        |       |  6-URETICI FILTRELE |");
            System.out.println("   ¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯             ¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯");
            System.out.println("   |  7-RAFTAKI URUN LISTELE |       |  8-URUN GUNCELLE    |");
            System.out.println("   ¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯             ¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯");
            System.out.println("   |  9-TANIMLI URUN SIL     |       |                     |");
            System.out.println("   ¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯             ¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯");
            System.out.print("ISLEM SECINIZ : ");
            String menuSecim = input.nextLine();

            switch (menuSecim) {
                case "1":
                    System.out.print("Urun cinsini giriniz: ");
                    String cinsi = input.nextLine();
                    System.out.print("Ureticisini giriniz: ");
                    String uretici = input.nextLine();
                    System.out.print("Birimini giriniz: ");
                    String birim = input.nextLine();
                    metotDepo.urunTanimlama(urunler, cinsi, uretici, birim);
                    metotDepo.tanimlananUrunListele(urunler);
                    break;
                case "2":
                    System.out.print("Eklemek istediğiniz urunun ID'sini giriniz: ");
                    int id = input.nextInt();
                    input.nextLine();
                    System.out.print("Ne kadar eklemek istersiniz: ");

                    metotDepo.urunGirisi(urunler, id, input);
                    metotDepo.tanimlananUrunListele(urunler);
                    break;
                case "3":
                    System.out.print("Rafa koymak istediğiniz urunun ID'sini giriniz: ");
                    id = input.nextInt();
                    input.nextLine(); // Yeni satır karakterini tüketmek için kullanılır.

                    metotDepo.urunuRafaKoy(urunler, id, input);
                    metotDepo.raftakiUrunleriListele(urunler);
                    break;
                case "4":
                    System.out.print("Çıkarmak istediğiniz ürünün ID'sini giriniz: ");
                    id = input.nextInt();
                    input.nextLine(); // Yeni satır karakterini tüketmek için kullanılır.
                    System.out.print("Kaç adet çıkarmak istersiniz: ");

                    metotDepo.urunCikisi(urunler, id, input);
                    metotDepo.tanimlananUrunListele(urunler);
                    break;
                case "5":
                    System.out.print("Filtrelemek istediğiniz ürün cinsini giriniz: ");
                    String filterCinsi = input.nextLine();
                    metotDepo.urunFiltrele(urunler, filterCinsi);
                    break;
                case "6":
                    System.out.print("Filtrelemek istediğiniz üreticiyi giriniz: ");
                    String filterUretici = input.nextLine();
                    metotDepo.ureticiFiltrele(urunler, filterUretici);
                    break;
                case "7":
                    metotDepo.raftakiUrunleriListele(urunler);
                    break;
                case "8":
                    System.out.print("Güncellemek istediğiniz ürünün ID'sini giriniz: ");
                    id = input.nextInt();
                    input.nextLine(); // Yeni satır karakterini tüketmek için kullanılır.

                    metotDepo.urunGuncelleme(urunler, id, input);
                    metotDepo.tanimlananUrunListele(urunler);
                    break;
                case "9":
                    System.out.print("Silmek istediğiniz ürünün ID'sini giriniz: ");
                    id = input.nextInt();
                    input.nextLine(); // Yeni satır karakterini tüketmek için kullanılır.
                    metotDepo.urunSil(urunler, id);
                    metotDepo.tanimlananUrunListele(urunler);
                    break;
                default:
                    System.out.println("Geçersiz bir seçim yaptınız!");
                    break;
            }
        }
    }
}
