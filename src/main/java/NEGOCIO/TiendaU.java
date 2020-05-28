/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NEGOCIO;

import DAO.Conexion;
import DAO.TiendaJpaController;
import DTO.Tienda;
import java.util.List;

/**
 *
 * @author stive
 */
public class TiendaU {

    Conexion con = Conexion.getConexion();
    TiendaJpaController tiendaDAO = new TiendaJpaController(con.getBd());
    List<Tienda> tiendas = tiendaDAO.findTiendaEntities();

    //Integer id, String nombre, String lema, String descripcion, String email,String clave, String propietario, String facebook, String web, String imagen
    public boolean registrarTienda(String nombre, String lema, String descripcion, String email, String clave, String propietario, String facebook, String web, String imagen) {
        boolean exito = false;
        Tienda ti = new Tienda();
        ti = buscarTiendaPorEmail(email);
        if (ti == null) {
            try {
                Tienda t = new Tienda();
                t.setNombre(nombre);
                t.setLema(lema);
                t.setDescripcion(descripcion);
                t.setEmail(email);
                t.setClave(clave);
                t.setPropietario(propietario);
                t.setFacebook(facebook);
                t.setWeb(web);
                t.setImagen(imagen);
                tiendaDAO.create(t);
                exito = true;
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.err.println(e.getMessage());
            }
        }
        return exito;
    }

    private Tienda buscarTiendaPorEmail(String email) {
        for (Tienda t : tiendas) {
            if (t.getEmail().equalsIgnoreCase(email)) {
                return t;
            }
        }
        return null;
    }
}
