package rs.controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rs.DAOradnik;
import rs.PrijavaZaPosao;


@WebServlet("/Prijava")
public class Prijava extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public Prijava() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String akcija=request.getParameter("akcija");
		String idradnik=request.getParameter("id");
		if(akcija!=null && akcija.length()>0)
		{
			if(akcija.equals("obrisi"))
			{
				try {
					int id=Integer.parseInt(idradnik);
					DAOradnik dao=new DAOradnik();
					dao.deleteRadnikbyID(id);
					
					ArrayList<PrijavaZaPosao> lp=dao.sortByPlata();
					request.setAttribute("radnici", lp);
					request.getRequestDispatcher("index.jsp").forward(request, response);
			
					
				} catch (Exception e) {
					// TODO: handle exception
					request.setAttribute("errmsg", "pogresan id");
					request.getRequestDispatcher("index.jsp").forward(request, response);
			
				}
			}else if(akcija.equals("izmeni"))
			{
				
				try {
					DAOradnik dao=new DAOradnik();
					int id=Integer.parseInt(idradnik);
					PrijavaZaPosao pr=dao.getRadnikByID(id);
					request.setAttribute("radnik", pr);
					request.getRequestDispatcher("prikaz.jsp").forward(request, response);
			
					
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
			else
			{
				request.setAttribute("errmsg", "pogresna akcija");
				request.getRequestDispatcher("errorpage.jsp").forward(request, response);
			}
			
		}else 
		{
			request.setAttribute("errmsg", "ne postoji akcija");
			request.getRequestDispatcher("errorpage.jsp").forward(request, response);
	
		}
		
}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String akcija=request.getParameter("akcija");
		
		if(akcija!=null && akcija.length()>0)
		{
			if(akcija.equals("prijava"))
			{
				
				String ime=request.getParameter("ime");
				String prezime=request.getParameter("prezime");
				String iskustvo=request.getParameter("god_iskustva");
				String plata=request.getParameter("plata");
				if(ime!=null && ime.length()>0 && prezime!=null && prezime.length()>0 && iskustvo!=null && iskustvo.length()>0 )
				{
					if(plata.isEmpty()==true )
					{
						try {
							
							int god=Integer.parseInt(iskustvo);
							
							DAOradnik dao=new DAOradnik();
							PrijavaZaPosao pr=new PrijavaZaPosao(ime, prezime, god);
					
							//DAOradnik dao=new DAOradnik();
							
							//PrijavaZaPosao pr=new PrijavaZaPosao(ime, prezime,pl, god);
							//PrijavaZaPosao pr=new PrijavaZaPosao(ime, prezime,god);
							dao.insertRadnika(pr);
							ArrayList<PrijavaZaPosao> lp=dao.sortByPlata();
							
							request.setAttribute("radnici", lp);
							request.getRequestDispatcher("index.jsp").forward(request, response);
							/*dao.insertRadnika(r);
							PrijavaZaPosao pr=dao.get*/
						} catch (Exception e) {
							// TODO: handle exception
							request.setAttribute("errmsg", " godine iskustva i plata moraju biti celi brojeviiii");
							request.getRequestDispatcher("index.jsp").forward(request, response);
					
						}
					}else{
						try {
							int god=Integer.parseInt(iskustvo);
						
							int pl=Integer.parseInt(plata);
							DAOradnik dao=new DAOradnik();
						
							PrijavaZaPosao pr=new PrijavaZaPosao(ime, prezime,pl, god);
						//PrijavaZaPosao pr=new PrijavaZaPosao(ime, prezime,god);
							dao.insertRadnika(pr);
							ArrayList<PrijavaZaPosao> lp=dao.sortByPlata();
							request.setAttribute("radnici", lp);
							request.getRequestDispatcher("index.jsp").forward(request, response);
							/*dao.insertRadnika(r);
						PrijavaZaPosao pr=dao.get*/
						} catch (Exception e) {
							// TODO: handle exception
							request.setAttribute("errmsg", " godine iskustva i plata moraju biti celi brojeviaaa");
							request.getRequestDispatcher("index.jsp").forward(request, response);
				
						}
					}
					
				}else
				{
					request.setAttribute("errmsg", "obavezna polja su ime ,prezime i godine iskustva");
					request.getRequestDispatcher("index.jsp").forward(request, response);
				}
			}else if(akcija.equals("izmeni"))
			{
				String ime=request.getParameter("ime");
				String prezime=request.getParameter("prezime");
				String iskustvo=request.getParameter("god_iskustva");
				String plata=request.getParameter("plata");
				String id=request.getParameter("id");
				if(ime!=null && ime.length()>0 && prezime!=null && prezime.length()>0 && iskustvo!=null && iskustvo.length()>0 )
				{
					try {
						int idr=Integer.parseInt(id);
						int god=Integer.parseInt(iskustvo);
						int pl=Integer.parseInt(plata);
						DAOradnik dao=new DAOradnik();
						PrijavaZaPosao pr=new PrijavaZaPosao(ime, prezime, pl, god);
						
						dao.updateRadnikbyID(pr,idr);
						//PrijavaZaPosao pr=dao.getRadnikByID(idr);
					
						ArrayList<PrijavaZaPosao> lp=dao.sortByPlata();
						request.setAttribute("radnici", lp);
						request.getRequestDispatcher("index.jsp").forward(request, response);
						/*dao.insertRadnika(r);
						PrijavaZaPosao pr=dao.get*/
					} catch (Exception e) {
						// TODO: handle exception
						request.setAttribute("errmsg", " godine iskustva i plata moraju biti celi brojevi");
						request.getRequestDispatcher("index.jsp").forward(request, response);
				
					}
				}else
				{
					request.setAttribute("errmsg", "obavezna polja su ime ,prezime i godine iskustva");
					request.getRequestDispatcher("index.jsp").forward(request, response);
				}
			}else
			{
				request.setAttribute("errmsg", "pogresna akcija");
				request.getRequestDispatcher("errorpage.jsp").forward(request, response);
		
			}
	
		
	
		}

	}}
