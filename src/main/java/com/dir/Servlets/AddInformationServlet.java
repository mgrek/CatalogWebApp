package com.dir.Servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dir.Catalog.Organization;
import com.dir.Exceptions.CatalogException;
import com.dir.Model.Model;

/**
 * Servlet implementation class AddInformation
 */
@WebServlet("/add")
public class AddInformationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddInformationServlet() {
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
	RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/AddInformation.jsp");
	requestDispatcher.forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	// TODO Auto-generated method stub
	String name = request.getParameter("name");
	String inn = request.getParameter("inn");
	String ogrn = request.getParameter("ogrn");
	String adress = request.getParameter("adress");
	try {
	    Organization organization = Organization.newBuilder()
		    .setName(name)
		    .setINN(inn)
		    .setOGRN(ogrn)
		    .setAdress(adress).build();
	    Model model = Model.getInstance();
	    model.add(organization);
	    
	    List<Organization> organizations = model.show();
	    request.setAttribute("organizations", organizations);
	} catch (CatalogException ex) {
	    ex.printStackTrace();
	}
	doGet(request, response);
    }

}
