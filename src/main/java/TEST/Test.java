/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TEST;

import DAO.ClienteJpaController;
import DAO.Conexion;
import DAO.ServicioJpaController;
import DAO.TiendaJpaController;
import DAO.exceptions.NonexistentEntityException;
import DTO.Cliente;
import DTO.Servicio;
import DTO.Tienda;
import java.util.List;

/**
 *
 * @author stive
 */
public class Test {

    
    
    public static void main(String[] args) throws NonexistentEntityException, Exception {
        //Conexion con = Conexion.getConexion();
        
        System.out.println("CREACION DE CLIENTE");
        ClienteJpaController cDao = new ClienteJpaController();
        Cliente c = new Cliente(2,"brayan", "brayanstivenp578@gmil.com", "123456");
        cDao.create(c);
        
        System.out.println("CREACION DE TIENDA");
        TiendaJpaController tDao = new TiendaJpaController();
        Integer n = 4;
        //(Integer id, String nombre, String lema, String email, String clave, String propietario, String facebook, String web, String imagen)
        Tienda t = new Tienda(n,"tienda de brayan","lema de tienda de brayan","brayanstivenp578@gmail.com",
                "1111", "propietario", "facebook", "sitio web", "una imagen");
        tDao.create(t);
        
        Tienda nueva = tDao.findTienda(4);
        System.out.println("CREACION DE SERVICIO");
        ServicioJpaController sDao = new ServicioJpaController();
        Servicio s = new Servicio(10, "servicio nuevo", "descripcion de servicio", nueva);
        sDao.create(s);
        
        System.out.println("SEGUIR UNA TIENDA POR UN CLIENTE");
        
        System.out.println("ACTUALIZAR TIENDA");
        Tienda tn = tDao.findTienda(4);
        tn.setDescripcion("HOLA ESTA ES LA NUEVA DESCRIPCION");
        tDao.edit(tn);
        
    }
}
