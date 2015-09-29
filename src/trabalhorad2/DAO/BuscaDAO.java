/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package trabalhorad2.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import trabalhorad2.model.Busca;
import trabalhorad2.model.Cliente;
import trabalhorad2.util.ConexaoUtil;

/**
 *
 * @author USER
 */
public class BuscaDAO {
    Connection conexao;

    public BuscaDAO() {
        //conexao = ConexaoUtil.getConnection();
    }
    public List<Busca> buscarTodos(Integer id) {
        String sql = "SELECT C.nome, P.codPedido, P.dataPEDIDO, P.evento, P.dataEvento, IP.qtde, IP.nomeproduto, IP.valorTotal from Cliente C JOIN Pedido P ON C.codCliente =? AND  P.codCliente=? Join Itempedido IP ON P.codPedido = IP.codPedido";
        try {
            PreparedStatement preparadorSQL = conexao.prepareStatement(sql);
            preparadorSQL.setInt(1, id);
            preparadorSQL.setInt(2, id);
            //Armazenando Resultado da consulta
            ResultSet resultado = preparadorSQL.executeQuery();
            List<Busca> lista = new ArrayList<>();
            while (resultado.next()) {
                //Instancia de busca
                Busca bus = new Busca();

                //Atribuindo dados do resultado no objeto cliente
                bus.setNome(resultado.getString("nome"));
                bus.setCodPedido(resultado.getInt("codPedido"));
                bus.setDataContrato(resultado.getString("dataPEDIDO"));
                bus.setEvento(resultado.getString("evento"));
                bus.setDataEvento(resultado.getString("dataEvento"));
                bus.setQtde(resultado.getInt("qtde"));
                bus.setProduto(resultado.getString("nomeProduto"));
                bus.setValor(resultado.getDouble("valorTotal"));
                
                //Adicionando cliente na lista
                lista.add(bus);
            }
            
            preparadorSQL.close();
            return lista;
        } catch (SQLException ex) {

            Logger.getLogger(BuscaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }
     public List<Busca> buscarPorEvento(LocalDate dataIni,LocalDate dataFim) {
        String sql = "SELECT C.nome, P.codPedido, P.dataPEDIDO, P.evento, P.dataEvento, IP.qtde, IP.nomeproduto, IP.valorTotal from Cliente C JOIN Pedido P ON C.codCliente = P.codCliente Join Itempedido IP ON P.codPedido = IP.codPedido where p.dataEvento >=? and p.dataEvento<=?";
        try {
            PreparedStatement preparadorSQL = conexao.prepareStatement(sql);
            Date dataIni1 = Date.from(dataIni.atStartOfDay(ZoneId.systemDefault()).toInstant());
            preparadorSQL.setDate(1, new java.sql.Date(dataIni1.getTime())); 
            Date dataFim1 = Date.from(dataFim.atStartOfDay(ZoneId.systemDefault()).toInstant());
            preparadorSQL.setDate(2, new java.sql.Date(dataFim1.getTime())); 
            //Armazenando Resultado da consulta
            ResultSet resultado = preparadorSQL.executeQuery();
            List<Busca> lista = new ArrayList<>();
            while (resultado.next()) {
                //Instancia de busca
                Busca bus = new Busca();

                //Atribuindo dados do resultado no objeto cliente
                bus.setNome(resultado.getString("nome"));
                bus.setCodPedido(resultado.getInt("codPedido"));
                bus.setDataContrato(resultado.getString("dataPEDIDO"));
                bus.setEvento(resultado.getString("evento"));
                bus.setDataEvento(resultado.getString("dataEvento"));
                bus.setQtde(resultado.getInt("qtde"));
                bus.setProduto(resultado.getString("nomeProduto"));
                bus.setValor(resultado.getDouble("valorTotal"));
                
                //Adicionando cliente na lista
                lista.add(bus);
            }
            
            preparadorSQL.close();
            return lista;
        } catch (SQLException ex) {

            Logger.getLogger(BuscaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }
     
     public List<Busca> buscarPorPedido(LocalDate dataIni,LocalDate dataFim) {
        String sql = "SELECT C.nome, P.codPedido, P.dataPEDIDO, P.evento, P.dataEvento, IP.qtde, IP.nomeproduto, IP.valorTotal from Cliente C JOIN Pedido P ON C.codCliente = P.codCliente Join Itempedido IP ON P.codPedido = IP.codPedido where p.dataPedido >=? and p.dataPedido<=?";
        try {
            PreparedStatement preparadorSQL = conexao.prepareStatement(sql);
            Date dataIni1 = Date.from(dataIni.atStartOfDay(ZoneId.systemDefault()).toInstant());
            preparadorSQL.setDate(1, new java.sql.Date(dataIni1.getTime())); 
            Date dataFim1 = Date.from(dataFim.atStartOfDay(ZoneId.systemDefault()).toInstant());
            preparadorSQL.setDate(2, new java.sql.Date(dataFim1.getTime())); 
            //Armazenando Resultado da consulta
            ResultSet resultado = preparadorSQL.executeQuery();
            List<Busca> lista = new ArrayList<>();
            while (resultado.next()) {
                //Instancia de busca
                Busca bus = new Busca();

                //Atribuindo dados do resultado no objeto cliente
                bus.setNome(resultado.getString("nome"));
                bus.setCodPedido(resultado.getInt("codPedido"));
                bus.setDataContrato(resultado.getString("dataPEDIDO"));
                bus.setEvento(resultado.getString("evento"));
                bus.setDataEvento(resultado.getString("dataEvento"));
                bus.setQtde(resultado.getInt("qtde"));
                bus.setProduto(resultado.getString("nomeProduto"));
                bus.setValor(resultado.getDouble("valorTotal"));
                
                //Adicionando cliente na lista
                lista.add(bus);
            }
            
            preparadorSQL.close();
            return lista;
        } catch (SQLException ex) {

            Logger.getLogger(BuscaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }
}
