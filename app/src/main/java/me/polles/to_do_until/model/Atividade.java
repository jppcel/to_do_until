package me.polles.to_do_until.model;

import java.util.Date;

/**
 * Created by joaop on 29/09/2017.
 */

public class Atividade {
    private int id;
    private String descricao;
    private Date limite;
    private Date criacao;

    public int getId(){
        return this.id;
    }
    public void setId(int id){
        this.id = id;
    }

    public String getDescricao(){
        return this.descricao;
    }
    public void setDescricao(String descricao){
        this.descricao = descricao;
    }

    public Date getLimite(){
        return this.limite;
    }
    public void setLimite(Date limite){
        this.limite = limite;
    }

    public Date getCriacao(){
        return this.criacao;
    }
    public void setCriacao(Date criacao){
        this.criacao = criacao;
    }

    public String toString(){
        return descricao + "\n Limite: ";
    }
}
