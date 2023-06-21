package emre;

import java.util.Scanner;

public class Runnaer {
    public static void main(String[] args) {
        MetoDepo metotDepo = new MetoDepo();
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("tanimlamak icin\t\t\t:1" + "\n" + "urun girisi\t\t\t\t:2" + "\n" + "rafa urun koymak icin :3" +
                    "\n" + "urun cikisi icin\t \t:4" + " basiniz");
            String menusecim = input.nextLine();
            switch (menusecim) {
                case "1":
                    System.out.println("TAnimlanacak urunun id sini giriniz");
                    int id = input.nextInt();
                    System.out.println("urun cinsini giriniz");
                    input.nextLine();
                    String cinsi = input.nextLine();
                    System.out.println("ureticisini giriniz");
                    String uretici = input.nextLine();
                    System.out.println("birimini giriniz");
                    String birim = input.nextLine();
                    metotDepo.urunTanimlama(id, cinsi, uretici, birim);
                    metotDepo.urunListele();
                    break;
                case "2":
                    System.out.println("eklemek istediginiz urunun id sini giriniz");
                    id=input.nextInt();
                    System.out.println("ne kadar eklemek istersiniz");
                 int   miktar=input.nextInt();
                    metotDepo.urunGirisi(id,miktar);
                    metotDepo.urunListele();
                    break;
                case "3":
                    metotDepo.urunListele();
                    break;
                case "4":
                    break;

                case "5":
                    System.exit(0);
            }
        }
    }
}
