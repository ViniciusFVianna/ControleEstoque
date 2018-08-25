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
public class OrdemServico {

    private int idServico;
    private int patrimonio;
    private int chamado;
    private String contato;
    private String defeito;
    private String tecnico;

    public OrdemServico() {
    }//fecha construtor

    public int getIdServico() {
        return idServico;
    }

    public void setIdServico(int idServico) {
        this.idServico = idServico;
    }

    public int getPatrimonio() {
        return patrimonio;
    }

    public void setPatrimonio(int patrimonio) {
        this.patrimonio = patrimonio;
    }

    public int getChamado() {
        return chamado;
    }

    public void setChamado(int chamado) {
        this.chamado = chamado;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public String getDefeito() {
        return defeito;
    }

    public void setDefeito(String defeito) {
        this.defeito = defeito;
    }

    public String getTecnico() {
        return tecnico;
    }

    public void setTecnico(String tecnico) {
        this.tecnico = tecnico;
    }

    @Override
    public String toString() {
        return "OrdemServico{" + "idServico=" + idServico + ", patrimonio=" + patrimonio + ", chamado=" + chamado + ", contato=" + contato + ", defeito=" + defeito + ", tecnico=" + tecnico + '}';
    }

}//fecha classe
