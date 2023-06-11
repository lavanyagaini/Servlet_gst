package gst.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gst.Maharashta;
import gst.karnataka;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class MahServlet extends HttpServlet{

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
		

		Maharashta mah=new Maharashta();
		mah.setId(id);
		mah.setName(name);
		mah.setCgst(cgst);
		mah.setSgst(cgst);
		
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("Lavanya");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(mah);
		entityTransaction.commit();
	}
}
