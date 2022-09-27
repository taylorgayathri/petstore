package com.exmaple.petstore;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
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
	
		request.setAttribute("petList", PETSTORE_DATABASE);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/Petstore.jsp");
		dispatcher.forward(request, response);
		
	}


	/**
	 * calling doGet and doPost method error handling
	 * @param request
	 * @param paramName
	 * @return
	 */
	
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

		String petIDstr = request.getParameter("id");
		String petname = request.getParameter("name");
		int petID = getIntegerParameter(petIDstr);
		if( petID <=0)
		{
			System.out.println("fill all the textbox");
		}
		else if(petname == null || "".equals(petname))
		{
			System.out.println("fill all the textbox");
		}
		else 
		{
			System.out.println("PetID: " + petID);
			System.out.println("Petname: " + petname);
			PETSTORE_DATABASE.put(petID, petname);
			response.sendRedirect(request.getContextPath()+"/pet");

		}
	}
}

		

	
