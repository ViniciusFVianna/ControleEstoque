/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sudosu.controleestoque.dao;

/**
 *
 * @author Vinicius.Vianna
 */
public class DAOFactory {
    
    private static BancoDAO bancoDAO = new BancoDAO();
    public static BancoDAO getBancoDAO(){
        return bancoDAO;
    }//fecha método
}//fecha classe
