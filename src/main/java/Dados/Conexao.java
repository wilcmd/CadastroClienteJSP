package Dados;

import java.sql.*;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;

/**
 *
 * @author wilqu
 */
public class Conexao {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/cadastro?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrival=true";
    private static final String JSBC_USER = "root";
    private static final String JSBC_PASSWROD = "lled";

    public static DataSource getDataSource() {
        BasicDataSource ds = new BasicDataSource();
        ds.setUrl(JDBC_URL);
        ds.setUsername(JSBC_USER);
        ds.setPassword(JSBC_PASSWROD);
        ds.setInitialSize(50);
        return ds;
    }

    public static Connection getConnection() throws SQLException {
        return getDataSource().getConnection();
    }

    public static void close(ResultSet rs) {
        try {
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }

    }

    public static void close(PreparedStatement stmt) {
        try {
            stmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }

    public static void close(Connection com) {
        try {
            com.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }

    }

    
}
