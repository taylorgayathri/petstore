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
	

		String idStr = request.getParameter("id");
		int id = getIntegerParameter(idStr);
		if (id <= 0 ) {
			out.println("ID Not Valid ");
		} else {
			
			String value = PETSTORE_DATABASE.get(id);
			if ("".equals(idStr)) {
				out.println("Error:Value not found");
			} else {
				out.println(id);
				out.println(value);
			}
		}
		
	}

	/**
	 * calling doGet and doPost method error handling
	 * @param request
	 * @param paramName
	 * @return
	 */
	@SuppressWarnings("unused")
	public static int getIntegerParameter(String input) 
	{
		int output=-1;
		
		if (input != null && !"".equals(input)) {
			
			try
			{
				output=Integer.parseInt(input);
			}
			catch(NumberFormatException e)
			{
				
			}
		}
		return output;
	}

	
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException
	{

		String petIDstr = request.getParameter("petID");
		String petname = request.getParameter("petname");
		PrintWriter writer = response.getWriter();
		PrintWriter out = response.getWriter();
		int petID = getIntegerParameter(petIDstr);
		if( petID <=0)
		{
			out.println("fill all the textbox");
		}
		else if(petname == null || "".equals(petname))
		{
			out.println("fill all the textbox");
		}
		else 
		{
			out.println("PetID: " + petID);
			out.println("Petname: " + petname);
			PETSTORE_DATABASE.put(petID, petname);

			String htmlRespone = "<html>";
			htmlRespone += "<h2>Pet ID: " + petID + "<br/>";
			htmlRespone += "Pet Name is: " + petname + "</h2>";
			htmlRespone += "</html>";
			writer.println(htmlRespone);

		}
	}
}

		

	
