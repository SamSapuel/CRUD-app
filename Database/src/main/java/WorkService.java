import Model.Employees;
import Model.Work;

import java.util.List;

public class WorkService {
    private WorkDao workDao = new WorkDao();

    public WorkService() {

    }

    public Work findWork(int id) {
        return workDao.findWorkById(id);
    }

    public void saveWork(Work work) {
        workDao.save(work);
    }

    public void deleteWork(Work work) {
        workDao.delete(work);
    }
    public void updateWork(Work work) {
        workDao.update(work);
    }
    public List<Work> findAllWorks() {
        return workDao.findAll();
    }
}
