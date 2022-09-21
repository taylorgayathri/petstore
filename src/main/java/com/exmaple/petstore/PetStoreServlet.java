package com.exmaple.petstore;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet to process all pet related requests.
 * 
 * @author Preethu
 */
@SuppressWarnings("serial")
public class PetStoreServlet extends HttpServlet {

	/**
	 * The PETSTORE database.
	 */
	private static final Map<Integer, String> PETSTORE_DATABASE = new HashMap<>();
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("Hello world");

		String idStr = request.getParameter("id");
		if (idStr == null || "".equals(idStr)) {
			out.println("ID Not Provided ");
		} else {
			int id = Integer.parseInt(idStr);
			String value = PETSTORE_DATABASE.get(id);
			if (value == null) {
				out.println("Error:Value not found");
			} else {
				out.println(id);
				out.println(value);
			}
		}
		
	}
	
	protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {

        String petID = request.getParameter("petID");
        String petname = request.getParameter("petname");
         
        System.out.println("PetID: " + petID);
        System.out.println("Petname: " + petname);
        PETSTORE_DATABASE.put(Integer.parseInt(petID), petname);
        PrintWriter writer = response.getWriter();
         
        String htmlRespone = "<html>";
        htmlRespone += "<h2>Pet ID: " + petID + "<br/>";      
        htmlRespone += "Pet Name is: " + petname + "</h2>";    
        htmlRespone += "</html>";
        writer.println(htmlRespone);
         
    }

}
