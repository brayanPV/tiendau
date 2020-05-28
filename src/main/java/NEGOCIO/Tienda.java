/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NEGOCIO;

import DAO.Conexion;

/**
 *
 * @author stive
 */
public class Tienda {
    Conexion con = Conexion.getConexion();
    TiendaJpaController tiendaDAO = new TiendaJpaController(con.getBd());
}
