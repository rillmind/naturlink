package main;

import java.util.*;

public class Local {
    private int id;
    private String nome;
    private int limitMax;
    private String descricao;
    private String tipo;
    private String pais;
    private String estado;
    private String cidade;

    Scanner s = new Scanner(System.in);

    public Local(int id, String nome, int limitMax, String descricao, String tipo, String pais, String estado, String cidade) {
        this.id = id;
        this.nome = nome;
        this.limitMax = limitMax;
        this.descricao = descricao;
        this.tipo = tipo;
        this.pais = pais;
        this.estado = estado;
        this.cidade = cidade;
    }

    public Local() {
    }

    private static final Local local1 = new Local(1, "Praia do Forte", 500, "Praia paradisíaca com águas cristalinas", "Praia", "Brasil", "Bahia", "Salvador");
    private static final Local local2 = new Local(2, "Cristo Redentor", 1000, "Monumento religioso com vista panorâmica", "Monumento", "Brasil", "Rio de Janeiro", "Rio de Janeiro");
    private static final Local local3 = new Local(3, "Parque Ibirapuera", 2000, "Parque urbano com áreas verdes e lagos", "Parque", "Brasil", "São Paulo", "São Paulo");
    private static final Local local4 = new Local(4, "Chapada Diamantina", 300, "Parque nacional com cachoeiras e trilhas", "Parque Nacional", "Brasil", "Bahia", "Lençóis");
    private static final Local local5 = new Local(5, "Pelourinho", 800, "Centro histórico com arquitetura colonial", "Centro Histórico", "Brasil", "Bahia", "Salvador");

    private static final ArrayList<Local> locais = new ArrayList<Local>(Arrays.asList(
            local1, local2, local3, local4, local5
    ));

    public Local escolher() {
        for (Local local : locais) {
            System.out.print(local.toString() + "\n");
        }
        System.out.print("ID do Local: ");
        int id = s.nextInt();
        for (Local l : locais) {
            if (l.getId() == id) {
                return l;
            }
        }
        return null;
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

    public int getLimitMax() {
        return limitMax;
    }

    public void setLimitMax(int limitMax) {
        this.limitMax = limitMax;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    @Override
    public String toString() {
        return "Local {" +
                "id= " + id +
                ",nome= " + nome +
                ",cidade= " + cidade +
                ",estado= " + estado +
                ",pais= " + pais +
                ",tipo= " + tipo +
                ",descricao= " + descricao +
                ",limite maximo= " + limitMax +
                "}";
    }
}