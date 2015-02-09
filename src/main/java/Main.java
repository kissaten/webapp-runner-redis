import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.nio.charset.Charset;
import java.util.Date;

public class Main extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    HttpSession session = req.getSession();
    resp.getWriter().println("Session ID: " + session.getId());
    resp.getWriter().println("Session Created: " + new Date(session.getCreationTime()));
    resp.getWriter().println("Session Last Accessed " + new Date(session.getLastAccessedTime()));
    resp.getWriter().println("Session Attribute: " + session.getAttribute("my-attr"));

    session.setAttribute("my-attr", "foobar");

    resp.getWriter().print("Hello from Java! Charset: " + Charset.defaultCharset());
  }
}
