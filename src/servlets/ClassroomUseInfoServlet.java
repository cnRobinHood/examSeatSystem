package servlets;

import com.alibaba.fastjson.JSON;
import entities.Classroom;
import services.ClassroomUseInfoService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by liu on 18-5-18.
 * Enjoy it.
 */
public class ClassroomUseInfoServlet extends HttpServlet {
    private ClassroomUseInfoService classroomUseInfoService = new ClassroomUseInfoService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userTime = req.getParameter("time");
        List<Classroom> classrooms = classroomUseInfoService.availableClassroom(userTime);
        resp.getWriter().write(JSON.toJSONString(classrooms));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userTime = req.getParameter("time");
        List<Classroom> classrooms = classroomUseInfoService.availableClassroom(userTime);
        resp.getWriter().write(JSON.toJSONString(classrooms));
    }
}
