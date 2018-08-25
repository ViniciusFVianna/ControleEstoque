/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sudosu.controleestoque.servicos;

/**
 *
 * @author Vinicius.Vianna
 */
public class ServicosFactory {

    private static BancoServicos bancoServicos = new BancoServicos();

    public static BancoServicos getBancoServicos() {
        return bancoServicos;
    }//fecha método
}//fecha classe
