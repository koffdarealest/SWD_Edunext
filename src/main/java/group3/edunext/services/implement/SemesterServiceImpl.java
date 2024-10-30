package group3.edunext.services.implement;

import group3.edunext.models.Class;
import group3.edunext.models.Semester;
import group3.edunext.repositories.IClassReposotory;
import group3.edunext.repositories.ISemesterRepository;
import group3.edunext.services.IClassService;
import group3.edunext.services.ISemesterService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class SemesterServiceImpl implements ISemesterService {

    private final ISemesterRepository repo;
    private final IClassReposotory classReposotory;
    @Override
    public List<Semester> getAllSemester() {
        return repo.findAll();
    }

    @Override
    public Semester getSemester(int semesterId) {
        return repo.findById(semesterId).get();
    }

    @Override
    public boolean addClasses(List<Class> listClasses, int semesterId) {
        boolean exists = true;
        if (repo.existsById(semesterId)) {exists=false; }
        for (Class c : listClasses) {
                   if (classReposotory.existsById(c.getId())) {exists=false; }
        }
        if (exists){
            Semester setUpSemester = repo.findById(semesterId).get();
            for (Class c : listClasses) {
                c.setSemesterID(setUpSemester);
            }
            classReposotory.saveAll(listClasses);
        }
        return false;
    }
}
