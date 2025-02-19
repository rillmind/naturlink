package main;

import java.util.*;

class Pacote {
    private int id;
    private ArrayList<Atividade> atividades = new ArrayList<>();
    private ArrayList<Guia> guias = new ArrayList<>();
    private Local local;
    private String dataInicio;
    private String dataTermino;

    public Pacote(int id, Local local, String dataInicio, String dataTermino) {
        this.id = id;
        this.local = local;
        this.dataInicio = dataInicio;
        this.dataTermino = dataTermino;
        this.atividades = new ArrayList<>();
        this.guias = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Atividade> getAtividades() {
        return atividades;
    }

    public void setAtividades(ArrayList<Atividade> atividades) {
        this.atividades = atividades;
    }

    public List<Guia> getGuias() {
        return guias;
    }

    public void setGuias(ArrayList<Guia> guias) {
        this.guias = guias;
    }

    public Local getLocal() {
        return local;
    }

    public void setLocal(Local local) {
        this.local = local;
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