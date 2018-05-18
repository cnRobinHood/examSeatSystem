package servlets;

import com.alibaba.fastjson.JSON;
import entities.CourseInfo;
import services.CourseInfoService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by liu on 18-5-18.
 * Enjoy it.
 */
public class CourseInfoServlet extends HttpServlet {
    private CourseInfoService courseInfoService = new CourseInfoService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       resp.getWriter().write(JSON.toJSONString(courseInfoService.getCourseInfos()));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write(JSON.toJSONString(courseInfoService.getCourseInfos()));

    }
}
