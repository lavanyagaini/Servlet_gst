package gst.servlet;

import java.io.IOException;


import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gst.karnataka;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class KarServlet extends HttpServlet{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	int id=Integer.parseInt(req.getParameter("id"));
	String name=req.getParameter("name");
	
	ServletContext context=getServletContext(); 
	double cgst=Double.parseDouble(context.getInitParameter("cgst"));
	System.out.println(cgst);
	
	ServletConfig config=getServletConfig();
	String sgst=config.getInitParameter("sgstkar");
	System.out.println(sgst);
	
	Double sgst1=Double.parseDouble(sgst);
	System.out.println(sgst1);
	
	karnataka kar=new karnataka();
	kar.setId(id);
	kar.setCgst(cgst);
	kar.setSgst(sgst1);
	kar.setProductName(name);
	

	EntityManagerFactory factory=Persistence.createEntityManagerFactory("Lavanya");
	EntityManager manager=factory.createEntityManager();
	EntityTransaction tx=manager.getTransaction();
	tx.begin();
	manager.persist(kar);
	tx.commit();
}
}
