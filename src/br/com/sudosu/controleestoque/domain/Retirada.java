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
public class Retirada {

    private int idRetirada;
    private String data;
    private String conteudo;
    private String local;
    private String enviado;
    private String recebido;

    public Retirada() {
    }//fecha construtor

    public int getIdRetirada() {
        return idRetirada;
    }

    public void setIdRetirada(int idRetirada) {
        this.idRetirada = idRetirada;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
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

    public String getEnviado() {
        return enviado;
    }

    public void setEnviado(String enviado) {
        this.enviado = enviado;
    }

    public String getRecebido() {
        return recebido;
    }

    public void setRecebido(String recebido) {
        this.recebido = recebido;
    }

    public String VerificarLocal(){
        if(local.equals("container")){
            return "CONTAINER";
        }else{
            return "MATRIZ";
        }//fecha metodo
    }
    
    @Override
    public String toString() {
        return "Retirada{" + "idRetirada=" + idRetirada + ", data=" + data + ", conteudo=" + conteudo + ", local=" + local + ", enviado=" + enviado + ", recebido=" + recebido + '}';
    }

}//fecha classe
