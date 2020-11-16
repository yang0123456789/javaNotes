import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * # @author  chilcyWind
 * # @Time   2020/11/16 11:19
 * # @version 1.0
 * # @File : ${NAME}.java
 * # @Software: IntelliJ IDEA
 */
public class helloworld extends HttpServlet {
    private String message;
    public void init() throws ServletException
    {
        // 初始化
        message = "Hello, First Servlet!";
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response)
            throws javax.servlet.ServletException, IOException {
        response.setContentType("text/html");

        // 输出文本
        PrintWriter out = response.getWriter();
        out.write("<h1> " + message + " </h1>");

    }
}
