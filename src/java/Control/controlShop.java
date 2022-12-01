/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Control;

import DAO.DAO;
import Entity.Category;
import Entity.Product;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author TranTrungPhat
 */
@WebServlet(name = "controlShop", urlPatterns = {"/controlShop"})
public class controlShop extends HttpServlet {

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
        String pageid = request.getParameter("pageid");
        if(pageid==null){
            pageid="1";
        }
        int currPage=Integer.parseInt(pageid);
        int nearPage=currPage-1;
        int farPage=currPage+1;
        int pagec = DAO.getAllProduct().size();
        if(pagec%3==0) pagec=pagec/3;
        else pagec=(pagec/3)+1;
        
        if(currPage==1){
            nearPage=currPage;
            farPage=currPage+1;
        }
        if(currPage==pagec){
            nearPage=currPage-1;
            farPage=currPage;
        }

        
        List<Product> Plist = DAO.getProductByPage(currPage);
        List<Category> Clist = DAO.getAllCategory();
        Product latest = DAO.getLast();
        
        request.setAttribute("nearPage", nearPage); 
        request.setAttribute("currPage", currPage); 
        request.setAttribute("farPage", farPage);  
        request.setAttribute("pagec", pagec); 
        request.setAttribute("Plist", Plist);
        request.setAttribute("Clist", Clist);
        request.setAttribute("latest", latest);
        request.getRequestDispatcher("shop.jsp").forward(request, response);
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
