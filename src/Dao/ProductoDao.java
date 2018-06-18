/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Interfaz.metodos;
import conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import producto.Productos;

/**
 *
 * @author LN710Q
 */
public class ProductoDao implements metodos<Productos> {
    private static final String SQL_INSERT = "INSERT INTO productos (id,nombre,codigo,tipo,cantidad,precio,disponibilidad VALUES (?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE productos SET id = ?,nombre = ?,tipo = ?,cantidad = ?,precio = ?,disponibilidad = ? WHERE codigo=?";
    private static final String SQL_DELETE = "DELETE FROM productos WHERE codigo = ? ";
    private static final String SQL_READ = "SELECT * FROM productos WHERE codigo = ? ";
    private static final String SQL_READALL = "SELECT * FROM productos";
    public static final Conexion con = Conexion.conectar();

    @Override
    public boolean create(Productos g) {
         PreparedStatement ps;
        try {
            ps = con.getCnx().prepareStatement(SQL_INSERT);
            ps.setString(1, g.getNombre());
            ps.setString(2, g.getTipo());
            ps.setInt(3, g.getCantidad());
            ps.setDouble(4, g.getPrecio());
            ps.setBoolean(5, true);
            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            Logger.getLogger(ProductoDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.cerrarConexion();
        }

        return false;
    }

    @Override
    public boolean delete(Object key) {
          PreparedStatement ps;
        try {
            ps = con.getCnx().prepareStatement(SQL_DELETE);
            ps.setString(1, key.toString());

            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            con.cerrarConexion();
        }

        return false;
    }

    @Override
    public boolean update(Productos c) {
  PreparedStatement ps;
        try {
            System.out.println(c.getCodigo());
            ps = con.getCnx().prepareStatement(SQL_UPDATE);
          ps.setString(1, c.getNombre());
            ps.setString(2, c.getTipo());
            ps.setInt(3, c.getCantidad());
            ps.setDouble(4, c.getPrecio());
            ps.setBoolean(5, true);
            if (ps.executeUpdate() > 0) {
                return true;
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            Logger.getLogger(ProductoDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.cerrarConexion();
        }
        return false;
    }

    @Override
    public Productos read(Object key) {
    Productos f = null;
        PreparedStatement ps;
        ResultSet rs;
        try {
            ps = con.getCnx().prepareStatement(SQL_READ);
            ps.setString(1, key.toString());

            rs = ps.executeQuery();
            while (rs.next()) {
                f = new Productos(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getBoolean(5));
            }
            rs.close();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            Logger.getLogger(ProductoDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.cerrarConexion();
        }
        return f;
    }

    @Override
    public ArrayList<Productos> readAll() {
         ArrayList<Productos> all = new ArrayList();
        Statement s;
        ResultSet rs;
        try {
            s = con.getCnx().prepareStatement(SQL_READALL);
            rs = s.executeQuery(SQL_READALL);
            while (rs.next()) {
               all.add(new Productos(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getBoolean(5)));
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProductoDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.cerrarConexion();
        }
        return all;

    }
    }

  
    

