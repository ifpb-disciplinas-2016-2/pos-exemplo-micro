package ifpb.ads.exemplo.micro;

import java.io.IOException;
import java.io.PrintWriter;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ricardo Job
 */
@WebServlet(name = "PessoaServlet", urlPatterns = {"/cadastro"})
public class PessoaServlet extends HttpServlet {

    @Inject
    private CadastroPessoa cadastro;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String nome = request.getParameter("nome");
        Pessoa pessoa = new Pessoa();
        pessoa.setNome(nome == null ? "Kiko" : nome);
        cadastro.salvar(pessoa);
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Cadastro</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Cadatro: " + pessoa + "</h1>");
            printTable(out);
            out.println("</body>");
            out.println("</html>");
        }
    }

    private void printTable(final PrintWriter out) {
        printCabecalho(out);
        cadastro.pessoas()
                .stream()
                .forEach(p -> printPessoa(out, p));
        out.println("</table>");

    }

    private void printCabecalho(final PrintWriter out) {
        out.println("<table> "
                + "<tr>"
                + "<th>Codigo</th>"
                + "<th>Nome</th>"
                + "</tr>");
    }

    public void printPessoa(final PrintWriter out, Pessoa pessoa) {
        String insert = String.format("<tr> "
                + "<td>%d</td>"
                + "<td>%s</td>"
                + "</tr>", pessoa.getId(), pessoa.getNome());
        out.println(insert);
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
