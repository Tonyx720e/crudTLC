
package datos;

import org.apache.commons.dbcp2.BasicDataSource;

/**
 *
 * @author tonym
 */
public class Conexion {
    private static final String JDBC_URL = "jdbc:mysql://localhost";
    private static final String BASE_DATOS = "appmvcmodulo3";
    private static final String USER = "root";
    private static final String PASS = "root";
    private static final String URL_KEY = "?useSSL=false&allowPublicKeyRetrieval=true";
    private static final String URL_FINAL = JDBC_URL + "/" + BASE_DATOS + URL_KEY;
    private static  BasicDataSource dataSource; 
    
    
}
