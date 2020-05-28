/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NEGOCIO;

import DAO.ClienteJpaController;
import DAO.Conexion;
import DAO.TiendaJpaController;
import DTO.Cliente;
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
    ClienteJpaController clienteDAO = new ClienteJpaController(con.getBd());
    List<Cliente> clientes = clienteDAO.findClienteEntities();

    //Integer id, String nombre, String lema, String descripcion, String email,String clave, String propietario, String facebook, String web, String imagen
    public boolean registrarTienda(String nombre, String lema, String descripcion, String email, String clave, String propietario, String facebook, String web, String imagen) {
        boolean exito = false;
        Tienda ti = new Tienda();
        ti = buscarTiendaPorEmail(email);
        Cliente cl = new Cliente();
        cl = buscarClientePorEmail(email);
        if (ti == null && cl == null) {
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
        } else {
            System.err.println("Ese email no esta disponible");
        }
        return exito;
    }

    public boolean login(String email, String clave) {
        boolean exito = false;
        Tienda ti = new Tienda();
        ti = buscarTiendaPorEmail(email);
        Cliente cl = new Cliente();
        cl = buscarClientePorEmail(email);

        return exito;
    }

    public Tienda buscarTiendaPorEmail(String email) {
        for (Tienda t : tiendas) {
            if (t.getEmail().equalsIgnoreCase(email)) {
                return t;
            }
        }
        return null;
    }

    public Cliente buscarClientePorEmail(String email) {
        for (Cliente c : clientes) {
            if (c.getEmail().equalsIgnoreCase(email)) {
                return c;
            }
        }
        return null;
    }
}
