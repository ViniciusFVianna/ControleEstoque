/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sudosu.controleestoque.domain;

/**
 *
 * @author Vinicius.Vianna
 */
public class Bkup {

    private int idBkup;
    private String midia;
    private String conteudo;
    private String local;
    private String observacoes;

    public Bkup() {
    }//fecha construtor

    public int getIdBkup() {
        return idBkup;
    }

    public void setIdBkup(int idBkup) {
        this.idBkup = idBkup;
    }

    public String getMidia() {
        return midia;
    }

    public void setMidia(String midia) {
        this.midia = midia;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    @Override
    public String toString() {
        return "Bkup{" + "idBkup=" + idBkup + ", midia=" + midia + ", conteudo=" + conteudo + ", local=" + local + ", observacoes="+observacoes+'}';
    }

}//fecha classe
