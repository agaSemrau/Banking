package src;


public class Lokata extends Konto {
    String name;
    String surname;
    Long id;
    long pesel;
    String waluta;
    long numerKonta;
    String walutaLokaty;
    long numerKontaLokaty;
    int czasTrwaniaLokaty;

    public Lokata( String name, String surname, Long id, Long pesel, String waluta, long numerKonta, String walutaLokaty, long numerKontaLokaty, int czasTrwaniaLokaty) {
        super(name, surname, id, pesel, waluta, numerKonta);
        this.walutaLokaty = waluta;
        this.numerKontaLokaty = numerKontaLokaty;
        this.czasTrwaniaLokaty = czasTrwaniaLokaty;
    }
}
