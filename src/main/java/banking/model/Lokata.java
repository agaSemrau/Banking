package banking.basics.model;


public class Lokata extends Client implements Uslugi {
    private String name;
    private String surname;
    private Long id;
    private long pesel;
    private String waluta;
    private long numerKonta;
    private String walutaLokaty;
    private long numerKontaLokaty;
    private int czasTrwaniaLokaty;

    public Lokata( String name, String surname, Long id, Long pesel, String waluta, long numerKonta, String walutaLokaty, long numerKontaLokaty, int czasTrwaniaLokaty) {
        super(name, surname, id, pesel);
        this.czasTrwaniaLokaty = czasTrwaniaLokaty;
        this.numerKontaLokaty = numerKontaLokaty;
        this.numerKonta = numerKonta;
        this.waluta = waluta;
        this.walutaLokaty = walutaLokaty;
        this.numerKontaLokaty = numerKontaLokaty;
        this.czasTrwaniaLokaty = czasTrwaniaLokaty;
    }

    @Override
    public String toString() {
        return "Lokata{" +
                "name='" + super.name + '\'' +
                ", surname='" + super.surname + '\'' +
                ", id=" + super.id +
                ", pesel=" + super.pesel +
                ", waluta='" + waluta + '\'' +
                ", numerKonta=" + numerKonta +
                ", walutaLokaty='" + walutaLokaty + '\'' +
                ", numerKontaLokaty=" + numerKontaLokaty +
                ", czasTrwaniaLokaty=" + czasTrwaniaLokaty +
                '}';
    }

    @Override
    public int getCzasTrwaniaLokaty() {
        return czasTrwaniaLokaty;
    }

    @Override
    public long getNumerKontaLokaty() {
        return numerKontaLokaty;
    }

    @Override
    public String getWalutaLokaty() {
        return walutaLokaty;
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public long getNumerKonta() {
        return numerKonta;
    }

    @Override
    public long getPesel() {
        return pesel;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getSurname() {
        return surname;
    }

    @Override
    public String getWaluta() {
        return waluta;
    }
}
