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
public class Editar extends HttpServlet {

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
                Class.forName("org.apache.derby.jdbc.ClientDriver");

                Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/sample", "app", "app");

                java.sql.Statement comando = con.createStatement();

                String sql = "UPDATE PRODUTOS "
                        + "SET PRECO=@@PRECO@@, "
                        + "VALIDADE='@@VALIDADE@@' "
                        + "WHERE NOME='@@NOME@@'";

                String nome = request.getParameter("nome");
                String validade = request.getParameter("validade");
                String preco = request.getParameter("preco");

                sql = sql.replace("@@PRECO@@", preco);
                sql = sql.replace("@@VALIDADE@@", validade);
                sql = sql.replace("@@NOME@@", nome);

                System.out.println("sql:" + sql);
                int linhas = comando.executeUpdate(sql);
                if (linhas != 1) {
                    out.print("Algum erro aconteceu. Fiz mais updates do que deveria, ou nenhum!");
                }

                request.getRequestDispatcher("Listar")
                        .forward(request, response);

            } catch (Exception e) {
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
