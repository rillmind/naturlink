package main;

class Atividade {
    private int id;
    private String nome;
    private int limiteParticipantes;

    public Atividade(int id, String nome, int limiteParticipantes) {
        this.id = id;
        this.nome = nome;
        this.limiteParticipantes = limiteParticipantes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getLimiteParticipantes() {
        return limiteParticipantes;
    }

    public void setLimiteParticipantes(int limiteParticipantes) {
        this.limiteParticipantes = limiteParticipantes;
    }
}