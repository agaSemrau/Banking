package src;

public class Konto extends Client implements Uslugi  {
    String name;
    String surname;
    Long id;
    long pesel;
    String waluta;
    long numerKonta;

    public Konto( String name, String surname, Long id, Long pesel, String waluta, long numerKonta) {
        super(name, surname, id, pesel);
        this.waluta = waluta;
        this.numerKonta = numerKonta;
    }

    public String getName() {
        return super.name;
    }


    public String getSurname() {
        return super.surname;
    }

    public long getId() {
        return super.id;
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

