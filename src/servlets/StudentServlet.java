package servlets;

import com.alibaba.fastjson.JSON;
import services.StudentService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by liu on 18-5-21.
 * Enjoy it.
 */
public class StudentServlet extends HttpServlet {
    StudentService studentService = new StudentService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        String stuId = req.getParameter("stuid");
        if (!"".equals(stuId)) {
            resp.getWriter().write(JSON.toJSONString(studentService.getStudentSeatJson(stuId)));
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        String stuId = req.getParameter("stuid");
        if (!"".equals(stuId)) {
            resp.getWriter().write(JSON.toJSONString(studentService.getStudentSeatJson(stuId)));
        }
    }
}
