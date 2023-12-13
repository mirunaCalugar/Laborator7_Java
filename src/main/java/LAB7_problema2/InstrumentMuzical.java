package LAB7_problema2;

abstract class InstrumentMuzical {

    public String producator;
    public Integer pret;

    public InstrumentMuzical(String producator, Integer pret) {
        this.producator = producator;
        this.pret = pret;
    }

    public InstrumentMuzical() {
    }

    public String getProducator() {
        return producator;
    }

    public void setProducator(String producator) {
        this.producator = producator;
    }

    public Integer getPret() {
        return pret;
    }

    public void setPret(Integer pret) {
        this.pret = pret;
    }
}
