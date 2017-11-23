/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author rene_araujo
 */
public class Banco extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            try {

                String nome = request.getParameter("nome");
                float preco = Float.parseFloat(request.getParameter("preco"));
                String data = request.getParameter("validade");

                Class.forName("org.apache.derby.jdbc.ClientDriver");

                Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/sample", "app", "app");

                java.sql.Statement comando = con.createStatement();

                //String comandoSQL = "INSERT INTO PRODUTOS VALUES ('nome', 1.2, '2017-11-30')";
                String comandoSQL = "INSERT INTO PRODUTOS VALUES ('" + nome + "'," + preco + ",'" + data + "')";
                System.out.println("Comando: " + comandoSQL);
                comando.executeUpdate(comandoSQL);

                comando.close();
                con.close();

                //out.println("Registro incluido com sucesso");
                request.getRequestDispatcher("confirmaCadastro.jsp").forward(request, response);

            } catch (Exception e) {
                out.println("Algo aconteceu de ruim...");
                e.printStackTrace();
            }
            
            out.println("<a href=\"index.html\"> VOLTAR </a>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
