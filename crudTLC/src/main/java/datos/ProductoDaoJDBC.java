package datos;

public class ProductoDaoJDBC {
    private static final String SELECT = "SELECT idproducto,nombre FROM producto;";
    private static final String INSERT = "INSERT INTO producto(nombre) values(?);";
    private static final String UPDATE = "UPDATE `producto` SET `nombre` = ? WHERE (`idproducto` = ?)";
    private static final String DELETE = "DELETE FROM `appmvcmodulo3`.`producto` WHERE (`idproducto` = ?)";

    }








  



