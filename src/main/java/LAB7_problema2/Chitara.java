package LAB7_problema2;

public class Chitara extends InstrumentMuzical{
    public TipChitara tipChitara;
    public Integer nr_corzi;

    public Chitara(String producator, Integer pret, TipChitara tipChitara, Integer nr_corzi) {
        super(producator, pret);
        this.tipChitara = tipChitara;
        this.nr_corzi = nr_corzi;
    }

    public Chitara() {
    }

    public TipChitara getTipChitara() {
        return tipChitara;
    }

    public void setTipChitara(TipChitara tipChitara) {
        this.tipChitara = tipChitara;
    }

    public Integer getNr_corzi() {
        return nr_corzi;
    }

    public void setNr_corzi(Integer nr_corzi) {
        this.nr_corzi = nr_corzi;
    }
}
