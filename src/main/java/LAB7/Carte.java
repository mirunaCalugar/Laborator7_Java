package LAB7;

public record Carte(String titlul,String autorul,Integer anul) {

    public Carte(String titlul, String autorul, Integer anul) {
        this.titlul = titlul;
        this.autorul = autorul;
        this.anul = anul;
    }


}
