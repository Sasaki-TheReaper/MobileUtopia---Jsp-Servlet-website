package model;

import java.io.File;

import javax.servlet.http.Part;

public class ProductModel {

	private String image;
	private String name;
	private String code;
	private String ram;
	private String brand;
	private String storage;
	private String camera;
	private String processor;
	private float price;
	private String battery;
	private String description;
	private int stock;
	
	public static final String PRODUCT_PIC_DIR = "\\Users\\anmol\\eclipse-workspace\\Fridge_Shop\\src\\main\\webapp\\Uploads\\Products\\";
	public static final String PRODUCT_PIC_SAVE_DIR = "C:" + File.separator + PRODUCT_PIC_DIR;

	public ProductModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProductModel(String image, String name, String code, String ram, String brand, String storage, String camera,
			String processor, float price, String battery, String description, int stock) {
		super();
		this.image = image;
		this.name = name;
		this.code = code;
		this.ram = ram;
		this.brand = brand;
		this.storage = storage;
		this.camera = camera;
		this.processor = processor;
		this.price = price;
		this.battery = battery;
		this.description = description;
		this.stock = stock;
	}
	
	

	
	private String getProductPicName(Part part) {
		String imagePath = PRODUCT_PIC_SAVE_DIR;
		File imageSaveDir = new File(imagePath);
		String productPicUrlFromPath = null;
		if(!imageSaveDir.exists()) {
			imageSaveDir.mkdir();
		}
		String contentDisp = part.getHeader("content-disposition");
		String []items = contentDisp.split(";");
		for(String s : items) {
			if(s.trim().startsWith("filename")) {
				productPicUrlFromPath = s.substring(s.indexOf("=") + 2, s.length() -1);
			}
		}
		if(productPicUrlFromPath  == null || productPicUrlFromPath .isEmpty()) {
			productPicUrlFromPath = "defaultpp.png";
		}
		return productPicUrlFromPath;
	}

	public ProductModel(String name, String description, float price, int quantity, String brand, String ram,
			String camera, String storage, String processor, String battery,
			Part product_image) {
		super();
		this.name = name;
		this.description = description;
		this.price = price;
		this.stock = quantity;
		this.brand = brand;
		this.ram = ram;
		this.camera = camera;
		this.storage = storage;
		this.processor = processor;
		this.battery = battery;
		this.image = getProductPicName(product_image);
		
		
	}
	
	
	public String getImage() {
		return image;
	}
	
	

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getRam() {
		return ram;
	}

	public void setRam(String ram) {
		this.ram = ram;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getStorage() {
		return storage;
	}

	public void setStorage(String storage) {
		this.storage = storage;
	}

	public String getCamera() {
		return camera;
	}

	public void setCamera(String camera) {
		this.camera = camera;
	}

	public String getProcessor() {
		return processor;
	}

	public void setProcessor(String processor) {
		this.processor = processor;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getBattery() {
		return battery;
	}

	public void setBattery(String battery) {
		this.battery = battery;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "ProductModel [image=" + image + ", name=" + name + ", code=" + code + ", ram=" + ram + ", brand="
				+ brand + ", storage=" + storage + ", camera=" + camera + ", processor=" + processor + ", price="
				+ price + ", battery=" + battery + ", description=" + description + "]";
	}

}
