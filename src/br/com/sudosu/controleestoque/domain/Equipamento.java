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
public class Equipamento {

    private int idEquipamento;
    private int patrimonio;
    private String descricao;
    private String tipo;
    private int quantidade;

    public Equipamento() {
    }//fecha construtor

    public int getIdEquipamento() {
        return idEquipamento;
    }

    public void setIdEquipamento(int idEquipamento) {
        this.idEquipamento = idEquipamento;
    }

    public int getPatrimonio() {
        return patrimonio;
    }

    public void setPatrimonio(int patrimonio) {
        this.patrimonio = patrimonio;
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

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "Equipamento{" + "idEquipamento=" + idEquipamento + ", patrimonio=" + patrimonio + ", descricao=" + descricao + ", tipo=" + tipo + ", quantidade=" + quantidade + '}';
    }

}//fecha classe
