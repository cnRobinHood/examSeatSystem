package services;

import dao.SupervisorDao;
import entities.SupervisorInfo;
import entities.jsonEntities.SupervisorJson;

import java.util.List;

/**
 * Created by liu on 18-5-18.
 * Enjoy it.
 */
public class SupervisorService {
    private SupervisorDao supervisorDao = new SupervisorDao();

    public List<SupervisorInfo> availableSupervisor(String userTime) {
        return supervisorDao.availableSupervisor(userTime);
    }

    public List<SupervisorJson> getSupervisorJson(String teacherId) {
        return supervisorDao.getSupervisorJson(teacherId);
    }
}
