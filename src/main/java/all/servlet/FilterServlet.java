package all.servlet;

import all.model.User;
import all.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/filter")//переписать через фильтр
public class FilterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserServiceImpl userService = UserServiceImpl.getInstance();
        String name = req.getParameter("name");
        Long password = Long.parseLong(req.getParameter("password"));
        User user = userService.getUser(name, password);
        if (user != null) {
            if (user.getRole().equals("admin")) {
                resp.sendRedirect("/admin");
            } else if (user.getRole().equals("user")) {
                resp.sendRedirect("/user");
            }
        } else {
            resp.sendRedirect("/index");
        }

    }
}
