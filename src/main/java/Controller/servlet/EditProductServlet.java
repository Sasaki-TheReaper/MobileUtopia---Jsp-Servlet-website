package Controller.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.DatabaseController;
import model.ProductModel;

/**
 * Servlet implementation class EditProductServlet
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/EditProductServlet" })
public class EditProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DatabaseController controller = new DatabaseController();

    /**
     * Default constructor. 
     */
    public EditProductServlet() {
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
	        String code = request.getParameter("code");
	        String name = request.getParameter("name");
	        String ram = request.getParameter("ram");
	        String brand = request.getParameter("brand");
	        String storage = request.getParameter("storage");
	        String camera = request.getParameter("camera");
	        String processor = request.getParameter("processor");
	        float price = Float.parseFloat(request.getParameter("price"));
	        String battery = request.getParameter("battery");
	        String description = request.getParameter("description");
	        int stock = Integer.parseInt(request.getParameter("stock"));

	        // Create a ProductModel object with the extracted data
	        ProductModel updatedProduct = new ProductModel();
	        updatedProduct.setCode(code);
	        updatedProduct.setName(name);
	        updatedProduct.setRam(ram);
	        updatedProduct.setBrand(brand);
	        updatedProduct.setStorage(storage);
	        updatedProduct.setCamera(camera);
	        updatedProduct.setProcessor(processor);
	        updatedProduct.setPrice(price);
	        updatedProduct.setBattery(battery);
	        updatedProduct.setDescription(description);
	        updatedProduct.setStock(stock);

	        // Call the editProduct method to update the product in the database
	        
	        int result = controller.editProduct(updatedProduct);

	        // Set response content type
	        response.setContentType("text/html");

	        // Get PrintWriter object for writing response
	        PrintWriter out = response.getWriter();

	        // Process the result and send response back to the client
	        if (result == 1) {
	            out.println("<h2>Product updated successfully!</h2>");
	        } else if (result == 0) {
	            out.println("<h2>Error occurred while updating the product!</h2>");
	        } else {
	            out.println("<h2>Error occurred during database operation!</h2>");
	        }
	    }

}
