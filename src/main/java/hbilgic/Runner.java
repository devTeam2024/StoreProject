package hbilgic;

import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        secimMenusu();
    }
    public static void secimMenusu() {
        Scanner input = new Scanner(System.in);
        Methotlar methods = new Methotlar();
        while (true) {
            System.out.println("\nDEPO UYGULAMASINA HOŞGELDİNİZ!");
            System.out.println("---------------------------------");
            System.out.println("\t\t MENÜ \n" +
                    "Ürün Tanımlama : 1\n" +
                    "Ürün ekleme çıkarma : 2\n" +
                    "Çıkış: 0");
            String secim = input.nextLine();
            if (secim.equals("0")) {
                break;
            }
            switch (secim) {
                case "1":
                    urunTanimlamaMenu(input, methods);
                    break;
                case "2":
                    urunIslemMenu(input, methods);
                    break;
                default:
                    System.out.println("Geçersiz seçim!");
                    break;
            }
        }
    }
    public static void urunTanimlamaMenu(Scanner input, Methotlar methods) {
        System.out.println("Tanımlanacak ürünün id'sini giriniz");
        int id = input.nextInt();
        input.nextLine();
        System.out.println("Ürün cinsini giriniz");
        String cinsi = input.nextLine();
        System.out.println("Üreticisini giriniz");
        String uretici = input.nextLine();
        System.out.println("Birimini giriniz");
        String birim = input.nextLine();
        methods.urunTanimlama(id, cinsi, uretici, birim);
        methods.urunListele();
    }
    public static void urunIslemMenu(Scanner input, Methotlar methods) {
        System.out.println("İşlem yapmak istediğiniz ürünün id'sini giriniz");
        int id = input.nextInt();
        input.nextLine();
        if (Methotlar.urunlerList.containsKey(id)) {
            System.out.println("\t\t MENÜ \n" +
                    "Ürün Listeleme : 1\n" +
                    "Ürün Girişi : 2\n" +
                    "Ürün Güncelleme : 3\n" +
                    "Ürün Rafa Yerleştirme : 4\n" +
                    "Ürün Çıkış: 5\n" +
                    "Uygulama Çıkış: 0");
            int secim = input.nextInt();
            input.nextLine();
            switch (secim) {
                case 1:
                    methods.urunListele();
                    break;
                case 2:
                    System.out.println("Ne kadar eklemek istersiniz?");
                    int miktar = input.nextInt();
                    input.nextLine();
                    methods.urunGirisi(id, miktar);
                    methods.urunListele();
                    break;
                case 3:
                    methods.urunGuncelleme();
                    break;
                case 4:
                    System.out.println("Hangi rafa koymak istiyorsunuz?");
                    String raf = input.nextLine();
                    methods.urunuRafaKoy(id, raf);
                    methods.urunListele();
                    break;
                case 5:
                    System.out.println("Ne kadar çıkarmak istersiniz?");
                    miktar = input.nextInt();
                    input.nextLine();
                    methods.urunCikisi(id, miktar);
                    methods.urunListele();
                    break;
                default:
                    System.out.println("Geçersiz seçim!");
                    break;
            }
        } else {
            System.out.println("Bu id yok");
        }
    }

}
