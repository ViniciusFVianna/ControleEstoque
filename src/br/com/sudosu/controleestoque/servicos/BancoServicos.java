/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sudosu.controleestoque.servicos;


import br.com.sudosu.controleestoque.dao.BancoDAO;
import br.com.sudosu.controleestoque.dao.DAOFactory;
import br.com.sudosu.controleestoque.domain.Bkup;
import br.com.sudosu.controleestoque.domain.Equipamento;
import br.com.sudosu.controleestoque.domain.OrdemServico;
import br.com.sudosu.controleestoque.domain.Retirada;
import java.sql.SQLException;
import java.util.ArrayList;


/**
 *
 * @author Vinicius.Vianna
 */
public class BancoServicos {

//    Emissão de Relatório
    public void imprimirRelatorioEquipamento() throws SQLException {
        BancoDAO bancoDAO = DAOFactory.getBancoDAO();
        bancoDAO.imprimirRelatorioEquipamento();
    }//fecha método
    public void filtrarRelatorioEquipamento() throws SQLException {
        BancoDAO bancoDAO = DAOFactory.getBancoDAO();
        bancoDAO.filtrarRelatorioEquipamento();
    }//fecha método

    public void imprimirRelatorioBkup() throws SQLException {
        BancoDAO bancoDAO = DAOFactory.getBancoDAO();
        bancoDAO.imprimirRelatorioBkup();
    }//fecha método

    public void imprimirRelatorioOrdemServico() throws SQLException {
        BancoDAO bancoDAO = DAOFactory.getBancoDAO();
        bancoDAO.imprimirRelatorioOrdemServico();
    }//fecha método

    public void imprimirRelatorioRetirada() throws SQLException {
        BancoDAO bancoDAO = DAOFactory.getBancoDAO();
        bancoDAO.imprimirRelatorioRetirada();
    }//fecha método

//  MANIPULAÇÃO DO BANCO DE DADOS DA TABELA EQUIPAMENTO
    public void cadastrarEquipamento(Equipamento equip) throws SQLException {
        BancoDAO bancoDAO = DAOFactory.getBancoDAO();
        bancoDAO.cadastrarEquipamento(equip);
    }//fecha metodo

    public void alterarEquipamento(Equipamento equip) throws SQLException {
        BancoDAO bancoDAO = DAOFactory.getBancoDAO();
        bancoDAO.alterarEquipamento(equip);
    }//fecha metodo

    public ArrayList<Equipamento> buscarEquipamento() throws SQLException {
        BancoDAO bancoDAO = DAOFactory.getBancoDAO();
        return bancoDAO.bucarEquipamento();
    }//fecha metodo

    public ArrayList<Equipamento> filtrarEquipamento(String query) throws SQLException {
        BancoDAO bancoDAO = DAOFactory.getBancoDAO();
        return bancoDAO.filtrarEquipamento(query);
    }//fecha metodo

//  MANIPULAÇÃO DO BANCO DE DADOS DA TABELA BKUP
    public void cadastrarBkup(Bkup bkup) throws SQLException {
        BancoDAO bancoDAO = DAOFactory.getBancoDAO();
        bancoDAO.cadastrarBkup(bkup);
    }//fecha metodo

    public void alterarBkup(Bkup bkup) throws SQLException {
        BancoDAO bancoDAO = DAOFactory.getBancoDAO();
        bancoDAO.alterarBkup(bkup);
    }//fecha metodo

    public ArrayList<Bkup> buscarBkup() throws SQLException {
        BancoDAO bancoDAO = DAOFactory.getBancoDAO();
        return bancoDAO.bucarBkup();
    }//fecha metodo

    public ArrayList<Bkup> filtrarBkup(String query) throws SQLException {
        BancoDAO bancoDAO = DAOFactory.getBancoDAO();
        return bancoDAO.filtrarBkup(query);
    }//fecha metodo

//    MANIPULAÇÃO DO BANCO DE DADOS DA TABELA ORDEM DE SERVIÇO
    public void cadastrarOrdemServico(OrdemServico servico) throws SQLException {
        BancoDAO bancoDAO = DAOFactory.getBancoDAO();
        bancoDAO.cadastrarOrdemServico(servico);
    }//fecha metodo

    public void alterarOrdemServico(OrdemServico servico) throws SQLException {
        BancoDAO bancoDAO = DAOFactory.getBancoDAO();
        bancoDAO.alterarOremservico(servico);
    }//fecha metodo

    public ArrayList<OrdemServico> buscarOrdemServicos() throws SQLException {
        BancoDAO bancoDAO = DAOFactory.getBancoDAO();
        return bancoDAO.bucarOrdemServico();
    }//fecha metodo

    public ArrayList<OrdemServico> filtrarOS(String query) throws SQLException {
        BancoDAO bancoDAO = DAOFactory.getBancoDAO();
        return bancoDAO.filtrarOS(query);
    }//fecha metodo

//    MANIPULAÇÃO DO BANCO DE DADOS DA TABELA RETIRADA
    public void cadastrarRetirada(Retirada retirada) throws SQLException {
        BancoDAO bancoDAO = DAOFactory.getBancoDAO();
        bancoDAO.cadastrarRetirada(retirada);
    }//fecha metodo

    public void alterarRetirada(Retirada retirada) throws SQLException {
        BancoDAO bancoDAO = DAOFactory.getBancoDAO();
        bancoDAO.alterarRetirada(retirada);
    }//fecha metodo

    public ArrayList<Retirada> filtrarRetirada(String query) throws SQLException {
        BancoDAO bancoDAO = DAOFactory.getBancoDAO();
        return bancoDAO.filtrarRetirada(query);
    }//fecha metodo
    
   public ArrayList<Retirada> buscarRetirada() throws SQLException {
        BancoDAO bancoDAO = DAOFactory.getBancoDAO();
        return bancoDAO.bucarRetirada();
    }//fecha metodo
   
   public void buscarUsuario() throws SQLException{
       BancoDAO bancoDAO = DAOFactory.getBancoDAO();
       bancoDAO.buscarUsuario();
   }

}//fecha classe
