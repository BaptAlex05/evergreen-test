package com.evergreen.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.evergreen.bean.GreenPoint;
import com.evergreen.dao.GreenPointDao;


public class GreenPointController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    private static String INSERT_OR_EDIT = "/greenPoint.jsp";

    private static String LIST_GREEN_POINT = "/listGreenPoint.jsp";

    private GreenPointDao dao;
	public GreenPointController() {

        super();

        dao = new GreenPointDao();

    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String forward="";

        String action = request.getParameter("action");

        if(action.equalsIgnoreCase("apiMaps")){
        	PrintWriter out = response.getWriter();
        	response.setContentType("application/json");
        	response.setCharacterEncoding("UTF-8");
        	out.print(dao.getAllGreenPoints());
        	out.flush();
        	
        }
        else{

	        if (action.equalsIgnoreCase("delete")){
	
	            int greenPointId = Integer.parseInt(request.getParameter("greenPointId"));
	
	            dao.deleteGreenPoint(greenPointId);
	
	            forward = LIST_GREEN_POINT;
	
	            request.setAttribute("greenPoints", dao.getAllGreenPoints());   
	
	        } else if (action.equalsIgnoreCase("edit")){
	
	            forward = INSERT_OR_EDIT;
	
	            int greenPointId = Integer.parseInt(request.getParameter("greenPointId"));
	
	            GreenPoint greenPoint = dao.getGreenPointById(greenPointId);
	
	            request.setAttribute("greenPoint", greenPoint);
	
	        } else if (action.equalsIgnoreCase("listGreenPoint")){
	
	            forward = LIST_GREEN_POINT;
	
	            request.setAttribute("greenPoints", dao.getAllGreenPoints());
	
	        }
	        else {
	
	            forward = INSERT_OR_EDIT;
	
	        }
	
	        RequestDispatcher view = request.getRequestDispatcher(forward);
	
	        view.forward(request, response);
        }

    }



    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        GreenPoint greenPoint = new GreenPoint();
        greenPoint.setId_emetteur(Integer.parseInt(request.getParameter("id_emetteur")));
    	greenPoint.setId_nettoyeur(Integer.parseInt(request.getParameter("id_nettoyeur")));
    	greenPoint.setImage_apres(request.getParameter("image_apres"));
    	greenPoint.setImage_avant(request.getParameter("image_avant"));
    	greenPoint.setLatitude(Float.parseFloat(request.getParameter("latitude")));
    	greenPoint.setLongitude(Float.parseFloat(request.getParameter("longitude")));
    	greenPoint.setDescription(request.getParameter("description"));

  

        String greenPointId = request.getParameter("greenPointId");

        if(greenPointId == null || greenPointId.isEmpty())

        {

            dao.addGreenPoint(greenPoint);

        }

        else

        {

        	greenPoint.setGreenPointId(Integer.parseInt(greenPointId));

            dao.updateGreenPoint(greenPoint);

        }

        RequestDispatcher view = request.getRequestDispatcher(LIST_GREEN_POINT);

        request.setAttribute("greenPoints", dao.getAllGreenPoints());

        view.forward(request, response);

    }

}
