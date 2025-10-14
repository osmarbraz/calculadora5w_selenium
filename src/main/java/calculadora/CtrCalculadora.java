package calculadora;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CtrCalculadora extends HttpServlet {

    private static final Logger LOGGER = Logger.getLogger(CtrCalculadora.class.getName());

    private static final long serialVersionUID = 1L;

    private static final String OPERACAO = "operacao";

    public double getValorReal(String valorString) {
        double valor = 0;
        try {
            valor = Double.parseDouble(valorString);
        } catch (NumberFormatException e) {
            LOGGER.log(Level.SEVERE, "Problema de conversão do valor {0}", e.toString());
        }
        return valor;
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            response.setContentType("text/html");

            try ( PrintWriter out = response.getWriter()) {
                out.println("<!DOCTYPE html><html lang=\"pt-br\" xml:lang=\"pt-br\">");
                out.println("<html><head><title>Calculadora</title></head><body>");
                out.println("<h1>Calculadora</h1>");

                // Instancia o objeto Calculadora
                Calculadora calculadora = new Calculadora();
                //Recupera os parâmetros
                calculadora.setValorA(getValorReal(request.getParameter("ValorA")));
                calculadora.setValorB(getValorReal(request.getParameter("ValorB")));
                    
                if (request.getParameter(OPERACAO).equals("adicao")) {
                    out.print("A soma de " + calculadora.getValorA() + " + " + calculadora.getValorB() + " = " + calculadora.getSoma() + " <p>");
                } else {
                    if (request.getParameter(OPERACAO).equals("subtracao")) {
                        out.print("A diferenca de " + calculadora.getValorA() + " - " + calculadora.getValorB() + " = " + calculadora.getDiferenca() + " <p>");
                    } else {
                        if (request.getParameter(OPERACAO).equals("multiplicacao")) {
                            out.print("O produto de " + calculadora.getValorA() + " * " + calculadora.getValorB() + " = " + calculadora.getProduto() + " <p>");
                        } else {
                            if (request.getParameter(OPERACAO).equals("divisao")) {
                                out.print("O quociente de " + calculadora.getValorA() + " / " + calculadora.getValorB() + " = " + calculadora.getQuociente() + " <p>");
                            } else {
                                out.print("Operação inválida! <p>");
                            }
                        }
                    }
                }                
                out.print("<a href=\"" + request.getContextPath() + "/FrmCalculadora.jsp\"> Novo cálculo </a><p></body></html>");
            }
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Problema E/S {0}", e.toString());
        }
    }
}
