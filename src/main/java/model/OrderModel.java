package model;

public class OrderModel {
	private String email;
	private String code;
	private int quantity;
	private String status;

	public OrderModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderModel(String email, String code, int quantity, String status) {
		super();
		this.email = email;
		this.code = code;
		this.quantity = quantity;
		this.status = status;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	@Override
    public String toString() {
        return "OrderModel{" +
                "email='" + email + '\'' +
                ", code='" + code + '\'' +
                ", quantity=" + quantity +
                ", status='" + status + '\'' +
                '}';
    }

}
