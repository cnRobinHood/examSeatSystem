package servlets;

import com.alibaba.fastjson.JSON;
import entities.ClassInfo;
import services.ClassInfoService;

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
public class ClassInfoServlet extends HttpServlet {
    private ClassInfoService classInfoService = new ClassInfoService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userTime = req.getParameter("time");
        List<ClassInfo> classInfos = classInfoService.availableClassInfo(userTime);
        resp.getWriter().write(JSON.toJSONString(classInfos));

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userTime = req.getParameter("time");
        List<ClassInfo> classInfos = classInfoService.availableClassInfo(userTime);
        resp.getWriter().write(JSON.toJSONString(classInfos));
    }
}
