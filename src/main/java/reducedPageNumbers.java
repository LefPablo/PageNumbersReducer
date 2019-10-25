import java.io.IOException;
import java.io.PrintWriter;

public class reducedPageNumbers extends javax.servlet.http.HttpServlet {
    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        PrintWriter writer = response.getWriter();

        String source = request.getParameter("reducedPageNumbers");
        String result = "";

        try {
            result = PageNumbersReducer.pageNumbersReducer(source);
        } catch (Exception e) {
            writer.println(e);
            response.setStatus(400);
            return;
        }
        try {
            writer.println("HTTP/1.1 " + response.getStatus() + " OK");
            writer.println(result);
        } finally {
            writer.close();
        }
    }
}
