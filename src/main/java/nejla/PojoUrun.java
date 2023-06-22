package nejla;

public class PojoUrun { //Bu kısımda özellikleri olusturdum.

    private int ID;
    private String urunIsmi;
    private String uretici;

    private String birim;
    private double miktar;
    private String raf;

    // Bu kısımda getter() ve setter() methodlarını kullanarak değiştirme ve bulup getirme imkanı sağladım.
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getUrunIsmi() {
        return urunIsmi;
    }

    public void setUrunIsmi(String urunIsmi) {
        this.urunIsmi = urunIsmi;
    }

    public String getUretici() {
        return uretici;
    }

    public void setUretici(String uretici) {
        this.uretici = uretici;
    }

    public double getMiktar() {
        return miktar;
    }

    public void setMiktar(double miktar) {
        this.miktar = miktar;
    }

    public String getBirim() {
        return birim;
    }

    public void setBirim(String birim) {
        this.birim = birim;
    }

    public String getRaf() {
        return raf;
    }

    public void setRaf(String raf) {
        this.raf = raf;
    }

    public PojoUrun(int ID, String urunIsmi, String uretici, String birim) { //Objedeki verilerin girişini buradan sağladık.
        this.ID = ID;
        this.urunIsmi = urunIsmi;
        this.uretici = uretici;
        this.birim = birim;
    }

    public PojoUrun(int ID, double miktar) {
        this.ID = ID;
        this.miktar = miktar;
    }


    public PojoUrun(int ID, String raf) {
        this.ID = ID;
        this.raf = raf;
    }
}
