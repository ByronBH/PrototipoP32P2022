
package modelo;

  import controlador.clsClientes;
import java.sql.*;
import java.util.ArrayList;
import java.util.List; 

/**
 *
 * @author Byron
 */
public class daoClientes {
     private static final String SQL_SELECT = "SELECT idClientes, Nombre, NIt FROM clientes";
    private static final String SQL_INSERT = "INSERT INTO clientes(Nombre,Nit) VALUES(?, ?)";
    private static final String SQL_UPDATE = "UPDATE clientes SET Nombre=?, Nit=? WHERE Nombre = ?";
    private static final String SQL_DELETE = "DELETE FROM clientes WHERE Nombre=?";
    private static final String SQL_QUERY = "SELECT Nombre, Nombre, Nit FROM clientes WHERE Nombre = ?";
    public List<clsClientes> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        clsClientes usuario = null;
        List<clsClientes> usuarios = new ArrayList<clsClientes>();
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id_clientes = rs.getInt("idClientes");
                String Nombre = rs.getString("Nombre");
                String Nit = rs.getString("Nit");

                usuario = new clsClientes();
                usuario.setId_clientes(id_clientes);
                usuario.setnombre(Nombre);
                usuario.setnit(Nit);

                usuarios.add(usuario);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexion.close(rs);
            clsConexion.close(stmt);
            clsConexion.close(conn);
        }

        return usuarios;
    }
 public int insert(clsClientes clientes) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, clientes.getnombre());
            stmt.setString(2, clientes.getnit());

            System.out.println("ejecutando query:" + SQL_INSERT);
            rows = stmt.executeUpdate();
            System.out.println("Registros afectados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexion.close(stmt);
            clsConexion.close(conn);
        }

        return rows;
    }

    public int update(clsClientes clientes) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, clientes.getnombre());
            stmt.setString(2, clientes.getnit());
            stmt.setInt(3, clientes.getId_clientes());

            rows = stmt.executeUpdate();
            System.out.println("Registros actualizado:" + rows);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexion.close(stmt);
            clsConexion.close(conn);
        }

        return rows;
    }

    public int delete(clsClientes clientes) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, clientes.getId_clientes());
            rows = stmt.executeUpdate();
            System.out.println("Registros eliminados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexion.close(stmt);
            clsConexion.close(conn);
        }

        return rows;
    }

    public clsClientes query(clsClientes clientes) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setString(1, clientes.getnombre());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id_Clientes = rs.getInt("idClientes");
                String Nombre = rs.getString("Nombre");
                String Nit = rs.getString("Nit");

                clientes = new clsClientes();
                clientes.setId_clientes(id_Clientes);
                clientes.setnombre(Nombre);
                clientes.setnit(Nit);
            }
            //System.out.println("Registros buscado:" + persona);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexion.close(rs);
            clsConexion.close(stmt);
            clsConexion.close(conn);
        }

        //return personas;  // Si se utiliza un ArrayList
        return clientes;
    }
}
