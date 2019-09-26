package all.servlet;

import all.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/filter")
public class FilterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserServiceImpl userService = UserServiceImpl.getInstance();
        String name = req.getParameter("name");
        Long password = Long.parseLong(req.getParameter("password"));
        if(/*userService.getUser(name, password).getRole().equals("admin")*/true){
            req.getRequestDispatcher("AdminServlet.jsp").forward(req, resp);
        }else {
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        }

    }
}
