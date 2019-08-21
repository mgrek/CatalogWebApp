package com.dir.Servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dir.Catalog.Organization;
import com.dir.Exceptions.CatalogException;
import com.dir.Model.Model;
import com.dir.Parameters.ParametersDb;

/**
 * Servlet implementation class FindInformationServlet
 */
@WebServlet("/find")
public class FindInformationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindInformationServlet() {
	super();
	// TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	// TODO Auto-generated method stub
	response.setContentType("text/html;charset=utf-8");
	response.setStatus(200);
	RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/FindInformation.jsp");
        requestDispatcher.forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	// TODO Auto-generated method stub
	try {
	    Model model = Model.getInstance();
	    
	    String name = request.getParameter("name");
	    String inn = request.getParameter("inn");
	    String ogrn = request.getParameter("ogrn");
	    String adress = request.getParameter("adress");
	    
	    Map<ParametersDb,String> conditions = new HashMap<>();
	    if (name != "")
		conditions.put(ParametersDb.NAME, name);
	    if (inn != "")
		conditions.put(ParametersDb.INN, inn);
	    if (ogrn != "")
		conditions.put(ParametersDb.OGRN, ogrn);
	    if (adress != "")
		conditions.put(ParametersDb.ADRESS, adress);	    
	    
	    List<Organization> organizations = model.find(conditions);
	    request.setAttribute("organizations", organizations);
	    
	} catch (CatalogException ex) {
	    ex.printStackTrace();
	}
	doGet(request, response);
    }

}
