package nejla;

import java.util.*;

public class Runner {
    public static void main(String[] args) {

        Methods methods = new Methods();

        System.out.println("\nDEPO UYGULAMASINA HOŞGELDİNİZ!");
        System.out.println("---------------------------------");
        System.out.println("\t\t MENÜ \n" +
                "Ürün Tanımlama : 1\n" +
                "Ürün Listeleme : 2\n" +
                "Ürün Girişi : 3\n" +
                "Ürün Güncelleme : 4\n" +
                "Ürün Rafa Yerleştirme : 5\n" +
                "Ürün Çıkış: 6\n" +
                "Uygulama Çıkış: 0"
        );
        System.out.println("---------------------------------");
        Scanner input = new Scanner(System.in);
        int sec = -1;

        while (sec != 0) {
            System.out.print("Yapmak istediğiniz işlem: ");
            sec = input.nextInt();

            switch (sec) {
                case 1:
                    System.out.print("Ürün ID giriniz: ");
                    int id = input.nextInt();
                    System.out.print("Ürün ismini giriniz: ");
                    input.nextLine();
                    String urunIsim = input.nextLine();
                    System.out.print("Ürün üreticisini giriniz: ");
                    String ureticiIsim = input.nextLine();
                    System.out.print("Ürün birimini giriniz: ");
                    String birim = input.nextLine();
                    methods.urunTanimlama(id,urunIsim,ureticiIsim,birim);
                    break;

                case 2:
                    methods.urunListele();
                        break;

                case 3:
                    System.out.print("Ürün ID giriniz: ");
                    id = input.nextInt();
                    System.out.print("Ürün miktarını giriniz: ");
                    double urunSayi= input.nextDouble();
                    methods.urunListele();
                    methods.urunGirisi(id,urunSayi);
                    break;

                case 4:
                    break;

                case 5:
                    System.out.print("Ürün ID giriniz: ");
                    id = input.nextInt();
                    System.out.print("Ürünün rafını giriniz: ");
                    input.nextLine();
                    String rafHarf = input.nextLine();
                    methods.urunuRafaKoy(id,rafHarf);
                    break;



            }
        }

    }
}

