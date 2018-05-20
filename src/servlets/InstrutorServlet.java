package servlets;

import com.alibaba.fastjson.JSON;
import services.InstrutorService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by liu on 18-5-21.
 * Enjoy it.
 */
public class InstrutorServlet extends HttpServlet {
    InstrutorService instrutorService = new InstrutorService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        String op = req.getParameter("op");
        if (!"".equals(op)&&op!=null) {
            switch (op) {
                case "1":
                    resp.getWriter().write(JSON.toJSONString(instrutorService.getInstructorInfo()));
                    break;
                case "2":
                    String instructorId = req.getParameter("instructorid");
                    if (!"".equals(instructorId)) {
                        resp.getWriter().write(JSON.toJSONString(instrutorService.getInstructorJson(instructorId)));
                    }
                    break;
                case "3":
                    String examId = req.getParameter("examid");
                    if (!"".equals(examId)) {
                        instrutorService.randomStudentSeat(Integer.parseInt(examId));
                    }
                    break;
                case "4":
                    String examIdSeat = req.getParameter("examid");
                    String stu1 = (req.getParameter("stu1"));
                    String stu2 = req.getParameter("stu2");
                    if (!"".equals(examIdSeat) && !"".equals(stu1) && !"".equals(stu2)) {
                        instrutorService.changeSeat(Integer.parseInt(examIdSeat), Integer.parseInt(stu1), Integer.parseInt(stu2));
                    }
                    break;
                default:
                    break;
            }
        }
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        String op = req.getParameter("op");
        if (!"".equals(op)&&op!=null) {
            switch (op) {
                case "1":
                    resp.getWriter().write(JSON.toJSONString(instrutorService.getInstructorInfo()));
                    break;
                case "2":
                    String instructorId = req.getParameter("instructorid");
                    if (!"".equals(instructorId)) {
                        resp.getWriter().write(JSON.toJSONString(instrutorService.getInstructorJson(instructorId)));
                    }
                    break;
                case "3":
                    String examId = req.getParameter("examid");
                    if (!"".equals(examId)) {
                        instrutorService.randomStudentSeat(Integer.parseInt(examId));
                    }
                    break;
                case "4":
                    String examIdSeat = req.getParameter("examid");
                    String stu1 = (req.getParameter("stu1"));
                    String stu2 = req.getParameter("stu2");
                    if (!"".equals(examIdSeat) && !"".equals(stu1) && !"".equals(stu2)) {
                        instrutorService.changeSeat(Integer.parseInt(examIdSeat), Integer.parseInt(stu1), Integer.parseInt(stu2));
                    }
                    break;
                default:
                    break;
            }
        }
    }
}
