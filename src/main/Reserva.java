package main;

public class Reserva {
    private int id;
    private Turista turista;
    private Pacote pacote;
    private String dataInicio;
    private String dataTermino;

    public Reserva(int id, Turista turista, Pacote pacote, String dataInicio, String dataTermino) {
        this.id = id;
        this.turista = turista;
        this.pacote = pacote;
        this.dataInicio = dataInicio;
        this.dataTermino = dataTermino;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Turista getTurista() {
        return turista;
    }

    public void setTurista(Turista turista) {
        this.turista = turista;
    }

    public Pacote getPacote() {
        return pacote;
    }

    public void setPacote(Pacote pacote) {
        this.pacote = pacote;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getDataTermino() {
        return dataTermino;
    }

    public void setDataTermino(String dataTermino) {
        this.dataTermino = dataTermino;
    }
}