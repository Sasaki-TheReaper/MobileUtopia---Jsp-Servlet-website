package Controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Controller.util.StringUtils;
import model.CartModel;
import model.OrderModel;
import model.ProductModel;
import model.UserModel;

public class DatabaseController {

	public Connection getConnection() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/mobile_utopia";
		String user = "root";
		String pass = "";
		return DriverManager.getConnection(url, user, pass);
	}

	public int addUser(UserModel userModel) {
		try (Connection con = getConnection()) {
			// Prepare SQL queries
			String insertUserQuery = "INSERT INTO users (username, address, contact, email, password) VALUES (?, ?, ?, ?, ?)";
			String checkUsernameQuery = "SELECT COUNT(*) FROM users WHERE username = ?";
			String checkEmailQuery = "SELECT COUNT(*) FROM users WHERE email = ?";

			// Check if username already exists
			try (PreparedStatement checkUsernameSt = con.prepareStatement(checkUsernameQuery)) {
				checkUsernameSt.setString(1, userModel.getUsername());
				try (ResultSet checkUsernameRs = checkUsernameSt.executeQuery()) {
					checkUsernameRs.next();
					if (checkUsernameRs.getInt(1) > 0) {
						return -2; // Username already exists
					}
				}
			}

			// Check if email already exists
			try (PreparedStatement checkEmailSt = con.prepareStatement(checkEmailQuery)) {
				checkEmailSt.setString(1, userModel.getEmail());
				try (ResultSet checkEmailRs = checkEmailSt.executeQuery()) {
					checkEmailRs.next();
					if (checkEmailRs.getInt(1) > 0) {
						return -3; // Email already exists
					}
				}
			}

			// Insert user into the database
			try (PreparedStatement st = con.prepareStatement(insertUserQuery)) {
				st.setString(1, userModel.getUsername());
				st.setString(2, userModel.getAddress());
				st.setString(3, userModel.getContact());
				st.setString(4, userModel.getEmail());
				st.setString(5, userModel.getPassword());

				int result = st.executeUpdate();
				return result > 0 ? 1 : 0;
			}
		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace(); // Log the exception for debugging
			return -1;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}

	public int loginUser(String email, String password) {
		try (Connection con = getConnection()) {
			String selectUserQuery = "SELECT * FROM users WHERE email = ? AND password = ?";
			try (PreparedStatement st = con.prepareStatement(selectUserQuery)) {
				st.setString(1, email);
				st.setString(2, password);

				try (ResultSet rs = st.executeQuery()) {
					if (rs.next()) {
						return 1; // Successful login
					} else {
						return 0; // Username or password incorrect
					}
				}
			}
		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace(); // Log the exception for debugging
			return -1; // Error occurred during login
		} catch (Exception e) {
			e.printStackTrace();
			return -1; // Error occurred during login
		}
	}

	public int addProduct(ProductModel productModel) {
		try (Connection con = getConnection()) {
			String insertProductQuery = "INSERT INTO products (image, name, code, ram, brand, storage, camera, processor, price, battery, description, stock) VALUES (?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

			try (PreparedStatement st = con.prepareStatement(insertProductQuery)) {
				st.setString(1, productModel.getImage());
				st.setString(2, productModel.getName());
				st.setString(3, productModel.getCode());
				st.setString(4, productModel.getRam());
				st.setString(5, productModel.getBrand());
				st.setString(6, productModel.getStorage());
				st.setString(7, productModel.getCamera());
				st.setString(8, productModel.getProcessor());
				st.setFloat(9, productModel.getPrice());
				st.setString(10, productModel.getBattery());
				st.setString(11, productModel.getDescription());
				st.setInt(12, productModel.getStock());

				int result = st.executeUpdate();
				return result > 0 ? 1 : 0;
			}
		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace(); // Log the exception for debugging
			return -1;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}

	public List<ProductModel> viewProducts() {
		List<ProductModel> productList = new ArrayList<>();
		try (Connection con = getConnection()) {
			String selectProductsQuery = "SELECT * FROM products";

			try (PreparedStatement st = con.prepareStatement(selectProductsQuery)) {
				try (ResultSet rs = st.executeQuery()) {
					while (rs.next()) {
						ProductModel product = new ProductModel(rs.getString("image"), rs.getString("name"),
								rs.getString("code"), rs.getString("ram"), rs.getString("brand"),
								rs.getString("storage"), rs.getString("camera"), rs.getString("processor"),
								rs.getFloat("price"), rs.getString("battery"), rs.getString("description"),
								rs.getInt("stock"));
						productList.add(product);
					}
				}
			}
		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace(); // Log the exception for debugging
		} catch (Exception e) {
			e.printStackTrace();
		}
		return productList;
	}

	public int removeProduct(String productCode) {
		try (Connection con = getConnection()) {
			String deleteProductQuery = "DELETE FROM products WHERE code = ?";

			try (PreparedStatement st = con.prepareStatement(deleteProductQuery)) {
				st.setString(1, productCode);

				int result = st.executeUpdate();
				return result > 0 ? 1 : 0;
			}
		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace(); // Log the exception for debugging
			return -1;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}

	public int editProduct(ProductModel updatedProduct) {
		try (Connection con = getConnection()) {
			String updateProductQuery = "UPDATE products SET name=?, ram=?, brand=?, storage=?, camera=?, processor=?, price=?, battery=?, stock=?, description=? WHERE code=?";

			try (PreparedStatement st = con.prepareStatement(updateProductQuery)) {
				st.setString(1, updatedProduct.getName());
				st.setString(2, updatedProduct.getRam());
				st.setString(3, updatedProduct.getBrand());
				st.setString(4, updatedProduct.getStorage());
				st.setString(5, updatedProduct.getCamera());
				st.setString(6, updatedProduct.getProcessor());
				st.setFloat(7, updatedProduct.getPrice());
				st.setString(8, updatedProduct.getBattery());
				st.setInt(9, updatedProduct.getStock());
				st.setString(10, updatedProduct.getDescription());
				st.setString(11, updatedProduct.getCode());

				int result = st.executeUpdate();
				return result > 0 ? 1 : 0;
			}
		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace(); // Log the exception for debugging
			return -1;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}

	public int addToCart(CartModel cartModel) {
		try (Connection con = getConnection()) {
			// Check if an entry exists for the same email and code
			String checkEntryQuery = "SELECT COUNT(*) FROM carts WHERE email = ? AND code = ?";

			try (PreparedStatement checkEntrySt = con.prepareStatement(checkEntryQuery)) {
				checkEntrySt.setString(1, cartModel.getUserEmail());
				checkEntrySt.setString(2, cartModel.getProductCode());

				try (ResultSet checkEntryRs = checkEntrySt.executeQuery()) {
					checkEntryRs.next();
					if (checkEntryRs.getInt(1) > 0) {
						// Entry already exists, update its quantity
						String updateQuantityQuery = "UPDATE carts SET quantity = quantity + ? WHERE email = ? AND code = ?";

						try (PreparedStatement updateQuantitySt = con.prepareStatement(updateQuantityQuery)) {
							updateQuantitySt.setInt(1, cartModel.getQuantity());
							updateQuantitySt.setString(2, cartModel.getUserEmail());
							updateQuantitySt.setString(3, cartModel.getProductCode());

							int updateResult = updateQuantitySt.executeUpdate();
							return updateResult > 0 ? 1 : 0;
						}
					} else {
						// Entry does not exist, insert a new entry
						String addToCartQuery = "INSERT INTO carts (email, code, quantity) VALUES (?, ?, ?)";

						try (PreparedStatement st = con.prepareStatement(addToCartQuery)) {
							st.setString(1, cartModel.getUserEmail());
							st.setString(2, cartModel.getProductCode());
							st.setInt(3, cartModel.getQuantity());

							int insertResult = st.executeUpdate();
							return insertResult > 0 ? 1 : 0;
						}
					}
				}
			}
		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace(); // Log the exception for debugging
			return -1;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}

	/*
	 * public ArrayList<ProductModel> getCartItems(String userEmail) {
	 * ArrayList<ProductModel> cartItems = new ArrayList<>();
	 * 
	 * try (Connection con = getConnection()) { String getCartItemsQuery =
	 * "SELECT * FROM carts WHERE email = ?"; try (PreparedStatement st =
	 * con.prepareStatement(getCartItemsQuery)) { st.setString(1, userEmail); try
	 * (ResultSet rs = st.executeQuery()) { while (rs.next()) { String productCode =
	 * rs.getString("code"); int quantity = rs.getInt("quantity");
	 * 
	 * // Fetch product details from products table using product code String
	 * getProductDetailsQuery = "SELECT * FROM products WHERE code = ?"; try
	 * (PreparedStatement getProductStmt =
	 * con.prepareStatement(getProductDetailsQuery)) { getProductStmt.setString(1,
	 * productCode); try (ResultSet productRs = getProductStmt.executeQuery()) { if
	 * (productRs.next()) { ProductModel product = new ProductModel();
	 * product.setCode(productRs.getString("code"));
	 * product.setName(productRs.getString("name"));
	 * product.setRam(productRs.getString("ram"));
	 * product.setBrand(productRs.getString("brand"));
	 * product.setStorage(productRs.getString("storage"));
	 * product.setCamera(productRs.getString("camera"));
	 * product.setProcessor(productRs.getString("processor"));
	 * product.setPrice(productRs.getFloat("price"));
	 * product.setBattery(productRs.getString("battery"));
	 * product.setDescription(productRs.getString("description"));
	 * product.setStock(quantity); // Set quantity in the product model
	 * 
	 * cartItems.add(product); // Add product to the cart items list } } } } } } }
	 * catch (SQLException | ClassNotFoundException ex) { ex.printStackTrace(); //
	 * Log the exception for debugging } catch (Exception e) { e.printStackTrace();
	 * } return cartItems; }
	 */
	public ArrayList<CartModel> getCartItems(String userEmail) {
		ArrayList<CartModel> cartItems = new ArrayList<>();

		try (Connection con = getConnection()) {
			String getCartItemsQuery = "SELECT * FROM carts WHERE email = ?";
			try (PreparedStatement st = con.prepareStatement(getCartItemsQuery)) {
				st.setString(1, userEmail);
				try (ResultSet rs = st.executeQuery()) {
					while (rs.next()) {
						String productCode = rs.getString("code");
						int quantity = rs.getInt("quantity");

						// Create a CartModel object
						CartModel cartModel = new CartModel(userEmail, productCode, quantity);
						cartItems.add(cartModel);
					}
				}
			}
		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace(); // Log the exception for debugging
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cartItems;
	}

	private ProductModel getProductDetails(String productCode) {
		ProductModel product = null;

		try (Connection con = getConnection()) {
			String getProductDetailsQuery = "SELECT * FROM products WHERE code = ?";
			try (PreparedStatement st = con.prepareStatement(getProductDetailsQuery)) {
				st.setString(1, productCode);
				try (ResultSet rs = st.executeQuery()) {
					if (rs.next()) {
						product = new ProductModel();
						product.setImage(rs.getString("image"));
						product.setName(rs.getString("name"));
						product.setCode(rs.getString("code"));
						product.setRam(rs.getString("ram"));
						product.setBrand(rs.getString("brand"));
						product.setStorage(rs.getString("storage"));
						product.setCamera(rs.getString("camera"));
						product.setProcessor(rs.getString("processor"));
						product.setPrice(rs.getFloat("price"));
						product.setBattery(rs.getString("battery"));
						product.setDescription(rs.getString("description"));
//                        product.setStock(rs.getInt("stock"));
					}
				}
			}
		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace(); // Log the exception for debugging
		} catch (Exception e) {
			e.printStackTrace();
		}

		return product;
	}

	public int removeFromCart(String userEmail, String productCode) {
		try (Connection con = getConnection()) {
			// Step 1: Retrieve the quantity from the cart
			String getQuantityQuery = "DELETE FROM carts WHERE email = ? AND code = ?";
			int quantityInCart = 0;
			try (PreparedStatement st = con.prepareStatement(getQuantityQuery)) {
				st.setString(1, userEmail);
				st.setString(2, productCode);

				int result = st.executeUpdate();

			}

			// Step 2: Remove the item from the cart
			String removeFromCartQuery = "DELETE FROM carts WHERE email = ? AND code = ?";

			try (PreparedStatement st = con.prepareStatement(removeFromCartQuery)) {
				st.setString(1, userEmail);
				st.setString(2, productCode);

				int result = st.executeUpdate();
				if (result <= 0) {
					// No item was removed from the cart
					return 0;
				}
			}

			// Step 3: Add the quantity back to the product stock
			String updateProductStockQuery = "UPDATE products SET stock = stock + ? WHERE code = ?";

			try (PreparedStatement st = con.prepareStatement(updateProductStockQuery)) {
				st.setInt(1, quantityInCart);
				st.setString(2, productCode);

				int result = st.executeUpdate();
				return result > 0 ? 1 : 0;
			}
		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace(); // Log the exception for debugging
			return -1;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}

	public int addToOrders(CartModel cartModel) {
		try (Connection con = getConnection()) {
			// Insert into orders table
			String addToOrdersQuery = "INSERT INTO orders (email, code, quantity) VALUES (?, ?, ?)";

			try (PreparedStatement addToOrdersSt = con.prepareStatement(addToOrdersQuery)) {
				addToOrdersSt.setString(1, cartModel.getUserEmail());
				addToOrdersSt.setString(2, cartModel.getProductCode());
				addToOrdersSt.setInt(3, cartModel.getQuantity());

				int addToOrdersResult = addToOrdersSt.executeUpdate();
				if (addToOrdersResult <= 0) {
					// Insertion into orders failed
					return 0;
				}
			}

			// Remove from carts table
			String removeFromCartsQuery = "DELETE FROM carts WHERE email = ? AND code = ?";

			try (PreparedStatement removeFromCartsSt = con.prepareStatement(removeFromCartsQuery)) {
				removeFromCartsSt.setString(1, cartModel.getUserEmail());
				removeFromCartsSt.setString(2, cartModel.getProductCode());

				int removeFromCartsResult = removeFromCartsSt.executeUpdate();
				return removeFromCartsResult > 0 ? 1 : 0;
			}
		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace(); // Log the exception for debugging
			return -1;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}

	/*
	 * public List<OrderModel> getOrderHistory(String userEmail) { List<OrderModel>
	 * orderHistory = new ArrayList<>();
	 * 
	 * try (Connection con = getConnection()) { String getOrderHistoryQuery =
	 * "SELECT * FROM orders WHERE email = ?";
	 * 
	 * try (PreparedStatement st = con.prepareStatement(getOrderHistoryQuery)) {
	 * st.setString(1, userEmail);
	 * 
	 * try (ResultSet rs = st.executeQuery()) { while (rs.next()) { OrderModel order
	 * = new OrderModel(); order.setEmail(rs.getString("email"));
	 * order.setCode(rs.getString("code"));
	 * order.setQuantity(rs.getInt("quantity"));
	 * order.setStatus(rs.getString("status")); orderHistory.add(order); } } } }
	 * catch (SQLException | ClassNotFoundException ex) { ex.printStackTrace(); //
	 * Log the exception for debugging } catch (Exception e) { e.printStackTrace();
	 * }
	 * 
	 * return orderHistory; }
	 */
	public ArrayList<OrderModel> getOrderHistory(String userEmail) throws ClassNotFoundException {
		ArrayList<OrderModel> orderHistory = new ArrayList<>();

		try (Connection con = getConnection()) {
			String getOrderHistoryQuery = "SELECT * FROM orders WHERE email = ?";
			try (PreparedStatement st = con.prepareStatement(getOrderHistoryQuery)) {
				st.setString(1, userEmail);
				try (ResultSet rs = st.executeQuery()) {
					while (rs.next()) {
						OrderModel order = new OrderModel();
						order.setEmail(rs.getString("email"));
						order.setCode(rs.getString("code"));
						order.setQuantity(rs.getInt("quantity"));
						order.setStatus(rs.getString("status"));
						orderHistory.add(order);
					}
				}
			}
		} catch (SQLException ex) {
			ex.printStackTrace(); // Log the exception for debugging
		}
		return orderHistory;
	}

	public ArrayList<OrderModel> getAllOrders() {
		ArrayList<OrderModel> orders = new ArrayList<>();

		try (Connection con = getConnection()) {
			String getAllOrdersQuery = "SELECT * FROM orders";
			try (PreparedStatement st = con.prepareStatement(getAllOrdersQuery)) {
				try (ResultSet rs = st.executeQuery()) {
					while (rs.next()) {
						OrderModel order = new OrderModel();
						order.setEmail(rs.getString("email"));
						order.setCode(rs.getString("code"));
						order.setQuantity(rs.getInt("quantity"));
						order.setStatus(rs.getString("status"));
						orders.add(order);
					}
				}
			}
		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		return orders;
	}

	public ProductModel getProductDetailsByCode(String code) {
		ProductModel product = null;

		try (Connection con = getConnection()) {
			String selectProductsQuery = "SELECT * FROM products where code=?";

			try (PreparedStatement st = con.prepareStatement(selectProductsQuery)) {
				st.setString(1, code);
				try (ResultSet rs = st.executeQuery()) {
					while (rs.next()) {
						product = new ProductModel(rs.getString("image"), rs.getString("name"), rs.getString("code"),
								rs.getString("ram"), rs.getString("brand"), rs.getString("storage"),
								rs.getString("camera"), rs.getString("processor"), rs.getFloat("price"),
								rs.getString("battery"), rs.getString("description"), rs.getInt("stock"));
					}
				}
			}
		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace(); // Log the exception for debugging
		} catch (Exception e) {
			e.printStackTrace();
		}

		return product;
	}

	public ArrayList<ProductModel> searchByPrice(String query) {
		float queryF = Float.parseFloat(query);
		ArrayList<ProductModel> list = new ArrayList<ProductModel>();
		try (Connection con = getConnection()) {
			String selectProductsQuery = "SELECT * FROM products where price=?";

			try (PreparedStatement st = con.prepareStatement(selectProductsQuery)) {
				st.setFloat(1, queryF);
				try (ResultSet rs = st.executeQuery()) {
					while (rs.next()) {
						ProductModel product = new ProductModel(rs.getString("image"), rs.getString("name"),
								rs.getString("code"), rs.getString("ram"), rs.getString("brand"),
								rs.getString("storage"), rs.getString("camera"), rs.getString("processor"),
								rs.getFloat("price"), rs.getString("battery"), rs.getString("description"),
								rs.getInt("stock"));
						list.add(product);
					}
				}
			}
		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace(); // Log the exception for debugging
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	public int saveFeedback(String email, String feedback, String phone) {
		int result = -1;
		try (Connection con = getConnection()) {
			String query = "INSERT into feedback(email, Feedback, contact) values (?,?,?)";
			PreparedStatement st = con.prepareStatement(query);
			st.setString(1, email);
			st.setString(2, feedback);
			st.setString(3, phone);

			st.executeUpdate();
			result = 0;

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return result;
	}

	public UserModel getUserByEmail(String email) {
		UserModel user = null;
		try (Connection con = getConnection()) {
			String query = "SELECT * FROM users where email = ?";
			PreparedStatement st = con.prepareStatement(query);
			st.setString(1, email);
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				user = new UserModel();
				user.setUsername(rs.getString("username"));
				user.setEmail(rs.getString("email"));
				user.setAddress(rs.getString("address"));
				user.setContact(rs.getString("contact"));
				user.setPassword(rs.getString("password"));

			}

			return user;

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return user;
	}

	public int updateUser(UserModel user, String userEmail) {
		int result = -1; // Default value for errors

		try (Connection con = getConnection()) {
			String query = "UPDATE users SET username=?, email=?, address=?, contact=?, password=? WHERE email=?";
			try (PreparedStatement st = con.prepareStatement(query)) {
				st.setString(1, user.getUsername());
				st.setString(2, user.getEmail());
				st.setString(3, user.getAddress());
				st.setString(4, user.getContact());
				st.setString(5, user.getPassword());
				st.setString(6, userEmail); // Use userEmail to identify the user to update

				int rowsAffected = st.executeUpdate();
				if (rowsAffected > 0) {
					// Update successful
					result = 0;
				} else {
					// No rows were updated (possibly because the user email doesn't exist)
					result = 1;
				}
			}
		} catch (SQLException e) {
			// Handle database errors
			e.printStackTrace();
			// Return -1 for database errors
		} catch (Exception e) {
			// Handle other types of errors
			e.printStackTrace();
			// Return -1 for other types of errors
		}

		return result;
	}

	public int purchaseProducts(String userEmail, String productCode, int quantity) {
		try(Connection con = getConnection()){
			PreparedStatement statement = con.prepareStatement(StringUtils.PURCHASE_PRODUCTS);
			statement.setString(1, userEmail);
			statement.setString(2, productCode);
			statement.setInt(3, quantity);
			int result = statement.executeUpdate();
			System.out.println("Purchase product result in db controller is : " + result);
			return result;
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}
		
	}

	public ArrayList<ProductModel> searchProductsByName(String productName) {
		ArrayList<ProductModel> products = new ArrayList<>();
	    String query = "SELECT * FROM products WHERE name LIKE ?";
	    // Execute the query and populate the products list
	    // Don't forget to handle exceptions
	    return products;
	}

}

