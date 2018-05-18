package servlets;

import services.ExamInfoService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by liu on 18-5-18.
 * Enjoy it.
 */
public class ExamInfoServlet extends HttpServlet {
    private ExamInfoService examInfoService = new ExamInfoService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String courseId = req.getParameter("courseid");
        String[] classrooms = req.getParameterValues("classrooms");
        String[] teachers = req.getParameterValues("teacherids");
        String time = req.getParameter("time");
        String instructorId = req.getParameter("instructorid");
        String week = req.getParameter("week");
        String[] classes = req.getParameterValues("classes");
        String examId;
        try {
            FileInputStream fis = new FileInputStream("examid.txt");
            BufferedInputStream bis = new BufferedInputStream(fis);
            StringBuilder content = new StringBuilder();
            byte[] buffer = new byte[512];
            int flag = 0;
            while ((flag = bis.read(buffer)) != -1) {
                content.append(new String(buffer, 0, flag));
            }
            bis.close();
        } catch (
                Exception e)

        {
            e.printStackTrace();
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
