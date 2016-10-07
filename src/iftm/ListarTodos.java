package iftm;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/listar")
public class ListarTodos extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter saida = response.getWriter();
		
		response.setContentType("text/html");
		saida.print("<a href=index.html>Inicio</a><hr>");
		List<Dados> lista = Banco.listaTodos();
		saida.print("<table border=1><tr><th style=\"width: 150px\">Segunda</th> <th style=\"width: 150px\">Terça</th><th style=\"width: 150px\">Quarta</th><th style=\"width: 150px\">Quinta</th><th style=\"width: 150px\">Sexta</th></tr>");
		int cont = 0;
		
		for (int linha = 1; linha < 5; linha++) {	
			saida.print("<tr>");
		for (int coluna = 1; coluna < 6; coluna++) {	
			saida.print("<td>");
			
				for (Dados dados : lista) { 	
	/**/			if(((linha - 1) * 5 + coluna) == dados.getSlot() ){					
						saida.print(dados.getSlot() + " - "
							+  dados.getNome() 	+ " - "			
							+ "<a href=marcar?slot=" + ((linha - 1) * 5 + coluna) 
							+ ">Alterar</a> "
							+ "<a href=excluir?id=" + ((linha - 1) * 5 + coluna) 
							+ ">Excluir</a></td>");	
						
						break;						
				}				
		}	
				saida.print("<a href=marcar?slot=" + ((linha - 1) * 5 + coluna) + "><center> Marcar </center></a></td>");	
			}
		 saida.print("</tr>");
		}
		saida.print("</table>");
	}

}