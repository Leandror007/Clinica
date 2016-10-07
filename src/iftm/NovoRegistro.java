package iftm;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/marcar")
public class NovoRegistro extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter saida = response.getWriter();
		response.getWriter().print("Alterar o código para cadastrar novo nome e slot " + request.getParameter("slot"));
		response.setContentType("text/html");
		saida.print("<a href=index.html>Inicio</a><hr>");
		
		//String nome = request.getParameter("nome");
		
		String id  = request.getParameter("slot");
		int idSlot  = Integer.parseInt(id);
		
		List<Dados> lista = Banco.listaTodos();
		for (Dados dados : lista) {
			if(idSlot == dados.getSlot()){	
			
			saida.print("<form action=\"novo\">");		
			saida.print("Slot: <input name=\"slot\" value="+dados.getSlot()+" >");
			saida.print("Nome:<input name=\"nome\" + value="+dados.getNome()+">");
			saida.print("<input type=submit>");
			}else{}
		}
	}
	

}
