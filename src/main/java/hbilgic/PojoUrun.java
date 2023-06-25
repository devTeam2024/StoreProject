package hbilgic;

public class PojoUrun {
    private    int Id;
    private String UrunIsmi;
    private String Uretici;
    private int miktar;
    private String birim;
    private String raf;
    public PojoUrun(int id, String urunIsmi, String uretici, int miktar, String birim, String raf) {
        Id = id;
        UrunIsmi = urunIsmi;
        Uretici = uretici;
        this.miktar = miktar;
        this.birim = birim;
        this.raf = raf;
    }
    public int getId() {
        return Id;
    }
    public void setId(int id) {
        Id = id;
    }
    public String getUrunIsmi() {
        return UrunIsmi;
    }
    public void setUrunIsmi(String urunIsmi) {
        UrunIsmi = urunIsmi;
    }
    public String getUretici() {
        return Uretici;
    }
    public void setUretici(String uretici) {
        Uretici = uretici;
    }
    public int getMiktar() {
        return miktar;
    }
    public void setMiktar(int miktar) {
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
    @Override
    public String toString() {
        return "PojoUrun{" +
                "Id=" + Id +
                ", UrunIsmi='" + UrunIsmi + '\'' +
                ", Uretici='" + Uretici + '\'' +
                ", miktar=" + miktar +
                ", birim='" + birim + '\'' +
                ", raf='" + raf + '\'' +
                '}';
    }
}
