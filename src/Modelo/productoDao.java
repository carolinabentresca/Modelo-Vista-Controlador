package Modelo;

import static Modelo.conexion.getConexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class productoDao extends conexion {

    PreparedStatement ps;
    ResultSet rs;
    Connection con = null;

    //Registrar
    public boolean registrar(producto p) {
        String sql = "insert into producto(código,nombre,precio)values(?,?,?)";
        try {
            con = getConexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, p.getCódigo());
            ps.setString(2, p.getNombre());
            ps.setDouble(3, p.getPrecio());
            ps.executeUpdate();
            con.close();
            return true;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return false;
    }

    //Buscar
    public boolean buscar(producto p) {
        String sql = "select * from producto where código = ?";
        try {
            con = getConexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, p.getCódigo());
            rs = ps.executeQuery();
            while (rs.next()) {
                p.setCódigo(rs.getInt("código"));
                p.setNombre(rs.getString("nombre"));
                p.setPrecio(rs.getDouble("precio"));
            }
            con.close();
            return true;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return false;
    }

    //Modificar
    public boolean modificar(producto p) {
        String sql = "update producto set nombre = ? , precio = ? where código = ?";
        try {
            con = getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, p.getNombre());
            ps.setDouble(2, p.getPrecio());
            ps.setInt(3, p.getCódigo());
            ps.executeUpdate();
            con.close();
            return true;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return false;
    }

    //Eliminar
    public boolean eliminar(producto p) {
        String sql = "delete from producto where código = ?";
        try {
            con = getConexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, p.getCódigo());
            ps.executeUpdate();
            con.close();
            return true;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return false;
    }
}
