/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sudosu.controleestoque.dao;

import br.com.sudosu.controleestoque.domain.Bkup;
import br.com.sudosu.controleestoque.domain.Equipamento;
import br.com.sudosu.controleestoque.domain.OrdemServico;
import br.com.sudosu.controleestoque.domain.Retirada;
import br.com.sudosu.controleestoque.domain.Usuario;
import br.com.sudosu.controleestoque.persistencia.ConexaoBanco;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Vinicius.Vianna
 */
public class BancoDAO {

//    Emissão de relatórios
    public void imprimirRelatorioEquipamento() throws SQLException {
        Connection conn = ConexaoBanco.getConexao();

        int confirma = JOptionPane.showConfirmDialog(null, "Confirma a emissão dete relatório?", "Atenção", JOptionPane.YES_NO_OPTION);
        if (confirma == JOptionPane.YES_OPTION) {
            //imprimindo o relatorio com jasperReport
            try {
                //usando JasperPrint
                JasperPrint print = JasperFillManager.fillReport("br/com/sudosu/controleestoque/reports/equipament.jasper", null, conn);
                JasperViewer.viewReport(print, false);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }//catch
        }//fecha if
    }//fecha método

    public void filtrarRelatorioEquipamento() throws SQLException {
        Connection conn = ConexaoBanco.getConexao();
        String busca = JOptionPane.showInputDialog("Imforme a descrição do equipamento \ncom % no final!");

        int confirma = JOptionPane.showConfirmDialog(null, "Confirma a emissão dete relatório?", "Atenção", JOptionPane.YES_NO_OPTION);
        if (confirma == JOptionPane.YES_OPTION) {
            //imprimindo o relatorio com jasperReport
            try {
                //usando JasperPrint
                HashMap filtro = new HashMap();
                filtro.put("descricao", busca);

                JasperPrint print = JasperFillManager.fillReport("br/com/sudosu/controleestoque/reports/equipaments.jasper", filtro, conn);
                JasperViewer.viewReport(print, false);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }//catch
        }//fecha if
    }//fecha método

    public void imprimirRelatorioBkup() throws SQLException {
        Connection conn = ConexaoBanco.getConexao();

        int confirma = JOptionPane.showConfirmDialog(null, "Confirma a emissão dete relatório?", "Atenção", JOptionPane.YES_NO_OPTION);
        if (confirma == JOptionPane.YES_OPTION) {
            //imprimindo o relatorio com jasperReport
            try {
                //usando JasperPrint

                JasperPrint print = JasperFillManager.fillReport("br/com/sudosu/controleestoque/reports/BKUP.jasper", null, conn);
                JasperViewer.viewReport(print, false);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }//catch
        }//fecha if
    }//fecha método

    public void imprimirRelatorioOrdemServico() throws SQLException {
        Connection conn = ConexaoBanco.getConexao();
        String numOs = JOptionPane.showInputDialog("Imforme o número do OS");

        int confirma = JOptionPane.showConfirmDialog(null, "Confirma a emissão dete relatório?", "Atenção", JOptionPane.YES_NO_OPTION);
        if (confirma == JOptionPane.YES_OPTION) {
            //imprimindo o relatorio com jasperReport
            try {
                HashMap filtro = new HashMap();
                filtro.put("os", Integer.parseInt(numOs));

                //usando JasperPrint
                JasperPrint print = JasperFillManager.fillReport("br/com/sudosu/controleestoque/reports/ordemServicos.jasper", filtro, conn);
                JasperViewer.viewReport(print, false);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }//catch
        }//fecha if
    }//fecha método

    public void imprimirRelatorioRetirada() throws SQLException {
        Connection conn = ConexaoBanco.getConexao();
        String numOs = JOptionPane.showInputDialog("Imforme o número da retirada");

        int confirma = JOptionPane.showConfirmDialog(null, "Confirma a emissão dete relatório?", "Atenção", JOptionPane.YES_NO_OPTION);
        if (confirma == JOptionPane.YES_OPTION) {
            //imprimindo o relatorio com jasperReport
            try {
                HashMap filtro = new HashMap();
                filtro.put("retirada", Integer.parseInt(numOs));

                //usando JasperPrint
                JasperPrint print = JasperFillManager.fillReport("br/com/sudosu/controleestoque/reports/retirada2.jasper", filtro, conn);
                JasperViewer.viewReport(print, false);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }//catch
        }//fecha if
    }//fecha método

//    MANUPULAÇÃO DO BANCO DE DADOS TABELA EQUIPAMENTO
    public void cadastrarEquipamento(Equipamento equip) throws SQLException {
        Connection conn = ConexaoBanco.getConexao();
        Statement stat = conn.createStatement();
        try {

            String sql = "insert into equipamentos(patrimonio, descricao, tipo, quantidade) "
                    + "values(" + equip.getPatrimonio() + ",'" + equip.getDescricao() + "','" + equip.getTipo() + "'," + equip.getQuantidade() + ")";

            stat.execute(sql);
        } catch (SQLException e) {
            throw new SQLException("Erro ao cadastrar Equipamento!" + e.getMessage());
        } finally {
            conn.close();
            stat.close();
        }//fecha finally
    }//fecha método

    public void alterarEquipamento(Equipamento equip) throws SQLException {
        Connection conn = ConexaoBanco.getConexao();
        Statement stat = conn.createStatement();
        try {

            String sql = "update equipamentos set descricao = '" + equip.getDescricao() + "', tipo = '" + equip.getTipo() + "', quantidade = " + equip.getQuantidade() + " where patrimonio = " + equip.getPatrimonio() + "";

            stat.execute(sql);
        } catch (SQLException e) {
            throw new SQLException("Erro ao alterar Equipamento!" + e.getMessage());
        } finally {
            conn.close();
            stat.close();
        }
    }//fecha metodo

    public ArrayList<Equipamento> bucarEquipamento() throws SQLException {
        Connection conn = ConexaoBanco.getConexao();
        Statement stat = conn.createStatement();

        try {
            String sql = "select * from equipamentos";
            ResultSet rs = stat.executeQuery(sql);
            ArrayList<Equipamento> equip = new ArrayList<>();

            while (rs.next()) {
                Equipamento e = new Equipamento();
                e.setPatrimonio(rs.getInt("patrimonio"));
                e.setDescricao(rs.getString("descricao"));
                e.setTipo(rs.getString("tipo"));
                e.setQuantidade(rs.getInt("quantidade"));

                equip.add(e);
            }//fecha while
            return equip;
        } catch (SQLException e) {
            throw new SQLException("Erro ao buscar equipamentos!" + e.getMessage());
        } finally {
            conn.close();
            stat.close();
        }//fecha finally
    }//fecha metodo

    public ArrayList<Equipamento> filtrarEquipamento(String query) throws SQLException {
        Connection conn = ConexaoBanco.getConexao();
        Statement stat = conn.createStatement();

        try {
            String sql;
            sql = "select * from equipamentos " + query;

            ResultSet rs = stat.executeQuery(sql);
            ArrayList<Equipamento> equip = new ArrayList<>();

            while (rs.next()) {
                Equipamento e = new Equipamento();
                e.setPatrimonio(rs.getInt("patrimonio"));
                e.setDescricao(rs.getString("descricao"));
                e.setTipo(rs.getString("tipo"));
                e.setQuantidade(rs.getInt("quantidade"));

                equip.add(e);
            }//fecha while
            return equip;
        } catch (SQLException e) {
            throw new SQLException("Erro ao filtrar equipamentos! " + e.getMessage());
        } finally {
            conn.close();
            stat.close();
        }//fecha finally
    }//fecha metodo

//  MANUPULAÇÃO DA TABELA BUKP
    public void cadastrarBkup(Bkup bkup) throws SQLException {
        Connection conn = ConexaoBanco.getConexao();
        Statement stat = conn.createStatement();

        try {

            String sql = "insert into bckup(midia, conteudo, local, observacoes) "
                    + "values('" + bkup.getMidia() + "','" + bkup.getConteudo() + "','" + bkup.getLocal() + "','" + bkup.getObservacoes() + "')";

            stat.execute(sql);
        } catch (SQLException e) {
            throw new SQLException("Erro ao cadastrar Bkups! " + e.getMessage());
        } finally {
            conn.close();
            stat.close();
        }//fecha finally
    }//fecha método

    public void alterarBkup(Bkup bkup) throws SQLException {
        Connection conn = ConexaoBanco.getConexao();
        Statement stat = conn.createStatement();
        try {

            String sql = "update bckup set midia = '" + bkup.getMidia() + "', conteudo = '" + bkup.getConteudo() + "', local = '" + bkup.getLocal() + "', observacoes='" + bkup.getObservacoes() + "' where id_bkup = " + bkup.getIdBkup() + "";

            stat.execute(sql);
        } catch (SQLException e) {
            throw new SQLException("Erro ao cadastrar Bkups! " + e.getMessage());
        } finally {
            conn.close();
            stat.close();
        }//fecha finally
    }//fecha metodo

    public ArrayList<Bkup> bucarBkup() throws SQLException {
        Connection conn = ConexaoBanco.getConexao();
        Statement stat = conn.createStatement();

        try {
            String sql = "select * from bckup";
            ResultSet rs = stat.executeQuery(sql);
            ArrayList<Bkup> bkup = new ArrayList<>();

            while (rs.next()) {
                Bkup b = new Bkup();
                b.setIdBkup(rs.getInt("idBckup"));
                b.setMidia(rs.getString("midia"));
                b.setConteudo(rs.getString("conteudo"));
                b.setLocal(rs.getString("local"));
                b.setObservacoes(rs.getString("observacoes"));

                bkup.add(b);
            }//fecha while
            return bkup;
        } catch (SQLException e) {
            throw new SQLException("Erro ao buscar equipamentos!" + e.getMessage());
        } finally {
            conn.close();
            stat.close();
        }//fecha finally
    }//fecha metodo

    public ArrayList<Bkup> filtrarBkup(String query) throws SQLException {
        Connection conn = ConexaoBanco.getConexao();
        Statement stat = conn.createStatement();

        try {
            String sql;
            sql = "select * from bckup " + query;

            ResultSet rs = stat.executeQuery(sql);
            ArrayList<Bkup> bkup = new ArrayList<>();

            while (rs.next()) {
                Bkup b = new Bkup();
                b.setIdBkup(rs.getInt("idBckup"));
                b.setMidia(rs.getString("midia"));
                b.setConteudo(rs.getString("conteudo"));
                b.setLocal(rs.getString("local"));
                b.setObservacoes(rs.getString("observacoes"));
                bkup.add(b);
            }//fecha while
            return bkup;
        } catch (SQLException e) {
            throw new SQLException("Erro ao filtrar Bkup! " + e.getMessage());
        } finally {
            conn.close();
            stat.close();
        }//fecha finally
    }//fecha metodo

//    MANIPULAÇÃO DA TEBELA DE ORDEM DE SERVIÇO
    public void cadastrarOrdemServico(OrdemServico servico) throws SQLException {
        Connection conn = ConexaoBanco.getConexao();
        Statement stat = conn.createStatement();

        try {

            String sql = "insert into ordemServico(patrimonio, chamado, contato, defeito, tecnico) "
                    + "values(" + servico.getPatrimonio() + "," + servico.getChamado() + ",'" + servico.getContato() + "','" + servico.getDefeito() + "','" + servico.getTecnico() + "')";

            stat.execute(sql);
        } catch (SQLException e) {
            throw new SQLException("Erro ao cadastrar Servico! " + e.getMessage());
        } finally {
            conn.close();
            stat.close();
        }//fecha finally
    }//fecha método

    public void alterarOremservico(OrdemServico servico) throws SQLException {
        Connection conn = ConexaoBanco.getConexao();
        Statement stat = conn.createStatement();
        try {

            String sql = "update ordem_servico set contato = '" + servico.getContato() + "', defeito = '" + servico.getDefeito() + "', tecnico = '" + servico.getTecnico() + "' where patrimonio = " + servico.getPatrimonio() + "";

            stat.execute(sql);
        } catch (SQLException e) {
            throw new SQLException("Erro ao alterar OS! " + e.getMessage());
        } finally {
            conn.close();
            stat.close();
        }//fecha finally
    }//fecha metodo

    public ArrayList<OrdemServico> bucarOrdemServico() throws SQLException {
        Connection conn = ConexaoBanco.getConexao();
        Statement stat = conn.createStatement();

        try {
            String sql = "select * from ordemServico";
            ResultSet rs = stat.executeQuery(sql);
            ArrayList<OrdemServico> servico = new ArrayList<>();

            while (rs.next()) {
                OrdemServico os = new OrdemServico();

                os.setIdServico(rs.getInt("idOs"));
                os.setPatrimonio(rs.getInt("patrimonio"));
                os.setChamado(rs.getInt("chamado"));
                os.setContato(rs.getString("contato"));
                os.setDefeito(rs.getString("defeito"));
                os.setTecnico(rs.getString("tecnico"));

                servico.add(os);
            }//fecha while
            return servico;
        } catch (SQLException e) {
            throw new SQLException("Erro ao buscar OS!" + e.getMessage());
        } finally {
            conn.close();
            stat.close();
        }//fecha finally
    }//fecha metodo

    public ArrayList<OrdemServico> filtrarOS(String query) throws SQLException {
        Connection conn = ConexaoBanco.getConexao();
        Statement stat = conn.createStatement();

        try {
            String sql;
            sql = "select * from ordem_servico " + query;

            ResultSet rs = stat.executeQuery(sql);
            ArrayList<OrdemServico> servico = new ArrayList<>();

            while (rs.next()) {
                OrdemServico os = new OrdemServico();
                os.setIdServico(rs.getInt("id_servico"));
                os.setPatrimonio(rs.getInt("patrimonio"));
                os.setChamado(rs.getInt("chamado"));
                os.setContato(rs.getString("contato"));
                os.setDefeito(rs.getString("defeito"));
                os.setTecnico(rs.getString("tecnico"));
                servico.add(os);
            }//fecha while
            return servico;
        } catch (SQLException e) {
            throw new SQLException("Erro ao filtrar OS! " + e.getMessage());
        } finally {
            conn.close();
            stat.close();
        }//fecha finally
    }//fecha metodo

//    MANIPULAÇÃO DA TABELA RETIRADA
    public void cadastrarRetirada(Retirada retirada) throws SQLException {
        Connection conn = ConexaoBanco.getConexao();
        Statement stat = conn.createStatement();

        try {

            String sql = "insert into retirada(conteudo, loca, enviado, recebido) "
                    + "values('" + retirada.getConteudo() + "','" + retirada.getLocal() + "','" + retirada.getEnviado() + "','" + retirada.getRecebido() + "')";

            stat.execute(sql);
        } catch (SQLException e) {
            throw new SQLException("Erro ao cadastrar retirada! " + e.getMessage());
        } finally {
            conn.close();
            stat.close();
        }//fecha finally
    }//fecha método

    public void alterarRetirada(Retirada retirada) throws SQLException {
        Connection conn = ConexaoBanco.getConexao();
        Statement stat = conn.createStatement();
        try {

            String sql = "update retirada set conteudo = '" + retirada.getConteudo() + "', loca = '" + retirada.getLocal() + "', enviado = '" + retirada.getEnviado() + "', recebido = '" + retirada.getRecebido() + "' where id_retirada = " + retirada.getIdRetirada() + "";

            stat.execute(sql);
        } catch (SQLException e) {
            throw new SQLException("Erro ao alterar Retirada! " + e.getMessage());
        } finally {
            conn.close();
            stat.close();
        }//fecha finally
    }//fecha metodo

    public ArrayList<Retirada> filtrarRetirada(String query) throws SQLException {
        Connection conn = ConexaoBanco.getConexao();
        Statement stat = conn.createStatement();

        try {
            String sql;
            sql = "select * from retirada " + query;

            ResultSet rs = stat.executeQuery(sql);
            ArrayList<Retirada> retirada = new ArrayList<>();

            while (rs.next()) {
                Retirada r = new Retirada();
                r.setConteudo(rs.getString("conteudo"));
                r.setLocal(rs.getString("loca"));
                r.setEnviado(rs.getString("enviado"));
                r.setRecebido(rs.getString("recebido"));

                retirada.add(r);
            }//fecha while
            return retirada;
        } catch (SQLException e) {
            throw new SQLException("Erro ao filtrar equipamentos! " + e.getMessage());
        } finally {
            conn.close();
            stat.close();
        }//fecha finally
    }//fecha metodo

    public ArrayList<Retirada> bucarRetirada() throws SQLException {
        Connection conn = ConexaoBanco.getConexao();
        Statement stat = conn.createStatement();

        try {
            String sql = "select * from retirada";
            ResultSet rs = stat.executeQuery(sql);
            ArrayList<Retirada> retirada = new ArrayList<>();

            while (rs.next()) {
                Retirada rt = new Retirada();

                rt.setIdRetirada(rs.getInt("idRetirada"));
                rt.setConteudo(rs.getString("conteudo"));
                rt.setLocal(rs.getString("loca"));
                rt.setEnviado(rs.getString("enviado"));
                rt.setRecebido(rs.getString("recebido"));

                retirada.add(rt);
            }//fecha while
            return retirada;
        } catch (SQLException e) {
            throw new SQLException("Erro ao buscar OS!" + e.getMessage());
        } finally {
            conn.close();
            stat.close();
        }//fecha finally
    }//fecha metodo

    public void buscarUsuario() throws SQLException {

        Connection conn = ConexaoBanco.getConexao();
        Statement stat = conn.createStatement();
        try {
        String sql = "select * from usuario where login=? and senha=?";
        ResultSet rs = stat.executeQuery(sql);

            Usuario u = new Usuario();
            
            u.setUsuario(rs.getString("nome"));
            u.setSenha(rs.getString("senha"));
            u.setCondicao(rs.getString("condicao"));

        
        } catch (SQLException e){
             throw new SQLException("Erro ao buscar logar!" + e.getMessage());
        }finally{
            conn.close();
            stat.close();
        }//fecha logar
}

//    AUTENTICAÇÃO DE USUARIO NA BASE DE DADOS DO RM
//   public void getUsuario(Usuario usuario){
//       Hashtable env = new Hashtable();
//       env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
//       env.put(Context.PROVIDER_URL, "ldap://tbsabrt101:389");
//       env.put(Context.SECURITY_AUTHENTICATION,"simple");
//       env.put(Context.SECURITY_PRINCIPAL, "cn=Directory Manager");
//       env.put(Context.SECURITY_CREDENTIALS, "password");
//       DirContext ctx = new InitialDirContext(env);
//   }//fecha metodo
}//fecha classe
