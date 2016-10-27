package src;

public class Konto extends Client{
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
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getPesel() {
        return pesel;
    }

    public void setPesel(long pesel) {
        this.pesel = pesel;
    }

    public String getWaluta() {
        return waluta;
    }

    public void setWaluta(String waluta) {
        this.waluta = waluta;
    }

    public long getNumerKonta() {
        return numerKonta;
    }

    public void setNumerKonta(long numerKonta) {
        this.numerKonta = numerKonta;
    }
}

