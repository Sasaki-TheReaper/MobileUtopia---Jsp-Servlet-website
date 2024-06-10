package Controller.util;

public class StringUtils {
    // Database connection details
    public static final String DB_URL = "jdbc:mysql://localhost:3306/mydatabase";
    public static final String DB_USER = "username";
    public static final String DB_PASSWORD = "password";

    // Table names
    public static final String USER_TABLE = "users";
    public static final String PRODUCT_TABLE = "products";
    public static final String ORDER_TABLE = "orders";

    // User table columns
    public static final String USER_ID_COLUMN = "user_id";
    public static final String USER_NAME_COLUMN = "username";
    public static final String USER_EMAIL_COLUMN = "email";
    public static final String USER_PASSWORD_COLUMN = "password";

    // Product table columns
    public static final String PRODUCT_ID_COLUMN = "product_id";
    public static final String PRODUCT_NAME_COLUMN = "name";
    public static final String PRODUCT_CODE_COLUMN = "code";
    public static final String PRODUCT_PRICE_COLUMN = "price";

    // Order table columns
    public static final String ORDER_ID_COLUMN = "order_id";
    public static final String ORDER_USER_ID_COLUMN = "user_id";
    public static final String ORDER_PRODUCT_ID_COLUMN = "product_id";
    public static final String ORDER_QUANTITY_COLUMN = "quantity";

    // Constraints
    public static final int MAX_PRODUCT_NAME_LENGTH = 100;
    public static final int MAX_PRODUCT_CODE_LENGTH = 20;
    public static final int MAX_ORDER_QUANTITY = 100;

    // Queries
    public static final String SELECT_USER_BY_EMAIL_QUERY = "SELECT * FROM " + USER_TABLE + " WHERE " + USER_EMAIL_COLUMN + " = ?";
    public static final String INSERT_USER_QUERY = "INSERT INTO " + USER_TABLE + "(" + USER_NAME_COLUMN + ", " + USER_EMAIL_COLUMN + ", " + USER_PASSWORD_COLUMN + ") VALUES (?, ?, ?)";
    public static final String SELECT_PRODUCT_BY_ID_QUERY = "SELECT * FROM " + PRODUCT_TABLE + " WHERE " + PRODUCT_ID_COLUMN + " = ?";
    public static final String INSERT_ORDER_QUERY = "INSERT INTO " + ORDER_TABLE + "(" + ORDER_USER_ID_COLUMN + ", " + ORDER_PRODUCT_ID_COLUMN + ", " + ORDER_QUANTITY_COLUMN + ") VALUES (?, ?, ?)";
    public static final String PURCHASE_PRODUCTS = "insert into orders (email, code, quantity) "
    		+ "values(?,?,?)";
}
