package banking.basics.model;

public class Konto extends Client implements Uslugi  {
    private String name;
    private String surname;
    private Long id;
    private long pesel;
    private String waluta;
    private long numerKonta;

    public Konto( String name, String surname, Long id, Long pesel, String waluta, long numerKonta) {
        super(name, surname, id, pesel);
        this.waluta = waluta;
        this.numerKonta = numerKonta;
    }

    public String getName() {
        return name;
    }


    public String getSurname() {
        return surname;
    }

    public long getId() {
        return id;
    }

    public long getPesel() {
        return super.getPesel();
    }



    public String getWaluta() {
        return waluta;
    }
    public long getNumerKonta() {
        return numerKonta;
    }


    @Override
    public String getWalutaLokaty() {
        return null;
    }

    @Override
    public int getCzasTrwaniaLokaty() {
        return 0;
    }

    @Override
    public long getNumerKontaLokaty() {
        return 0;
    }

    @Override
    public String toString() {
        return "Konto{" +
                "name='" + super.name + '\'' +
                ", surname='" + super.surname + '\'' +
                ", id=" + super.id +
                ", pesel=" + super.pesel +
                ", waluta='" + waluta + '\'' +
                ", numerKonta=" + numerKonta +
                '}';
    }
}

