package servlets;

import com.alibaba.fastjson.JSON;
import services.SupervisorService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by liu on 18-5-21.
 * Enjoy it.
 */
public class SupervisorServlet extends HttpServlet {
    SupervisorService supervisorService = new SupervisorService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        String op = req.getParameter("op");
        switch (op) {
            case "1":
                String time = req.getParameter("time");
                if (!"".equals(time)) {
                    resp.getWriter().write(JSON.toJSONString(supervisorService.availableSupervisor(time)));
                }
                break;
            case "2":
                String teacherId = req.getParameter("teacherid");
                if (!"".equals(teacherId)) {
                    resp.getWriter().write(JSON.toJSONString(supervisorService.getSupervisorJson(teacherId)));
                }
                break;
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        String op = req.getParameter("op");
        switch (op) {
            case "1":
                String time = req.getParameter("time");
                if (!"".equals(time)) {
                    resp.getWriter().write(JSON.toJSONString(supervisorService.availableSupervisor(time)));
                }
                break;
            case "2":
                String teacherId = req.getParameter("teacherid");
                if (!"".equals(teacherId)) {
                    resp.getWriter().write(JSON.toJSONString(supervisorService.getSupervisorJson(teacherId)));
                }
                break;
        }
    }
}
