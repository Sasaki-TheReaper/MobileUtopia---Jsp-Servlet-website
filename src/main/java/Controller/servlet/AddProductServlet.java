package Controller.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import Controller.DatabaseController;
import model.ProductModel;

/**
 * Servlet implementation class AddProductServlet
 */

@WebServlet(asyncSupported = true, urlPatterns = { "/AddProductServlet" })
//@MultipartConfig

@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 10,
maxFileSize = 1024 * 1024 * 50,
maxRequestSize = 1024 * 1024 * 100)
public class AddProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DatabaseController controller = new DatabaseController();

    /**
     * Default constructor. 
     */
    public AddProductServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Extract data from the request parameters
//        String image = request.getParameter("image");
//		String image = "txt.img";
		Part productImagePart = request.getPart("productImage");
		String image = productImagePart.getSubmittedFileName();
//		Part productImage = request.getPart("productImage");
        String name = request.getParameter("name");
        String code = request.getParameter("code");
        String ram = request.getParameter("ram");
        String brand = request.getParameter("brand");
        String storage = request.getParameter("storage");
        String camera = request.getParameter("camera");
        String processor = request.getParameter("processor");
//        float price = Float.parseFloat(request.getParameter("price"));
        String priceParam = request.getParameter("price");
        float price;

        
        if (priceParam != null && !priceParam.trim().isEmpty()) {
            try {
                price = Float.parseFloat(priceParam);
            } catch (NumberFormatException e) {
                // Handle parsing error
                e.printStackTrace();
                // Set a default value or handle differently in case of parsing error
                price = 0.0f; // Default value
            }
        } else {
            // Handle case where price parameter is null or empty
            // Set a default value or handle differently if null is not acceptable
            price = 0.0f; // Default value
        }
        String battery = request.getParameter("battery");
        String description = request.getParameter("description");
//        int stock = Integer.parseInt(request.getParameter("stock"));
        
        String stockParam = request.getParameter("stock");
        int stock;

        if (stockParam != null && !stockParam.trim().isEmpty()) {
            try {
                stock = Integer.parseInt(stockParam);
            } catch (NumberFormatException e) {
                // Handle parsing error
                e.printStackTrace();
                // Set a default value or handle differently in case of parsing error
                stock = 0; // Default value
            }
        } else {
            // Handle case where price parameter is null or empty
            // Set a default value or handle differently if null is not acceptable
            stock = 0; // Default value
        }

        // Create a ProductModel object with the extracted data
        ProductModel productModel = new ProductModel(image, name, code, ram, brand, storage, camera, processor, price, battery, description, stock);

        // Call the addProduct method to insert the product into the database
        int result = controller.addProduct(productModel);

        // Set response content type
        response.setContentType("text/html");

        // Get PrintWriter object for writing response
        PrintWriter out = response.getWriter();

        // Process the result and send response back to the client
        if (result == 1) {
            out.println("<h2>Product added successfully!</h2>");
        } else if (result == 0) {
            out.println("<h2>Error occurred while adding the product!</h2>");
        } else {
            out.println("<h2>Error occurred during database operation!</h2>");
        }
    }
}
