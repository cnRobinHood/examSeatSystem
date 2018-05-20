package servlets;

import services.ExamInfoService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * Created by liu on 18-5-18.
 * Enjoy it.
 */
public class ExamInfoServlet extends HttpServlet {
    private ExamInfoService examInfoService = new ExamInfoService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        String path = this.getServletContext().getRealPath("/WEB-INF/classes/servlets/examid.txt");
        String courseId = req.getParameter("courseid");
        String[] classrooms = req.getParameterValues("classrooms");
        String[] teachers = req.getParameterValues("teacherids");
        String time = req.getParameter("time");
        String instructorId = req.getParameter("instructorid");
        String week = req.getParameter("week");
        String[] classes = req.getParameterValues("classes");
        String examId = new String();
        try {
            FileInputStream fis = new FileInputStream(path);
            BufferedInputStream bis = new BufferedInputStream(fis);
            StringBuilder content = new StringBuilder();
            byte[] buffer = new byte[512];
            int flag;
            while ((flag = bis.read(buffer)) != -1) {
                content.append(new String(buffer, 0, flag));
            }
            bis.close();
            examId = (Integer.parseInt(content.toString()) + 1) + "";
            examInfoService.savaExamInfo(examId, courseId, classrooms, time, teachers, classes, instructorId, week);
        } catch (Exception e)

        {
            e.printStackTrace();
        }
        try {
            FileOutputStream fos = new FileOutputStream(path);
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            bos.write(examId.getBytes(), 0, examId.getBytes().length);
            bos.flush();
            bos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        String courseId = req.getParameter("courseid");
        String[] classrooms = req.getParameterValues("classrooms");
        String[] teachers = req.getParameterValues("teacherids");
        String time = req.getParameter("time");
        String instructorId = req.getParameter("instructorid");
        String week = req.getParameter("week");
        String[] classes = req.getParameterValues("classes");
        String examId = new String();
        try {
            FileInputStream fis = new FileInputStream("src/servlets/examid.txt");
            BufferedInputStream bis = new BufferedInputStream(fis);
            StringBuilder content = new StringBuilder();
            byte[] buffer = new byte[512];
            int flag;
            while ((flag = bis.read(buffer)) != -1) {
                content.append(new String(buffer, 0, flag));
            }
            bis.close();
            examId = (Integer.parseInt(content.toString()) + 1) + "";
            examInfoService.savaExamInfo(examId, courseId, classrooms, time, teachers, classes, instructorId, week);
        } catch (Exception e)

        {
            e.printStackTrace();
        }
        try {
            FileOutputStream fos = new FileOutputStream("src/servlets/examid.txt");
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            bos.write(examId.getBytes(), 0, examId.getBytes().length);
            bos.flush();
            bos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
