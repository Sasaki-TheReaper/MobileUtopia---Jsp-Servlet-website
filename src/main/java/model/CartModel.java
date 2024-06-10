
package model;

public class CartModel {

	private String userEmail;
	private String productCode;
	private int quantity;

	public CartModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CartModel(String userEmail, String productCode, int quantity) {
		super();
		this.userEmail = userEmail;
		this.productCode = productCode;
		this.quantity = quantity;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "CartModel [userEmail=" + userEmail + ", productCode=" + productCode + ", quantity=" + quantity + "]";
	}

}
