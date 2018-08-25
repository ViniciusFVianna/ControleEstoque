/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sudosu.controleestoque.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author Vinicius.Vianna
 */
public class ConexaoBanco {

    private static final String USER = "root";
    private static final String PASSWORD = "password";
    private static final String URL = "jdbc:mysql://localhost:3305/tbsactrl";

    public static Connection getConexao() throws SQLException {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException se) {
            throw new SQLException("Erro ao conectar! " + se.getMessage());

        }//fecha catch
        return conn;
    }//fecha getConexao
}//fecha classe