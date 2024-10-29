package group3.edunext.services.implement;

import group3.edunext.models.Semester;
import group3.edunext.repositories.ISemesterRepository;
import group3.edunext.services.ISemesterService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class SemesterServiceImpl implements ISemesterService {

    private final ISemesterRepository repo;
    @Override
    public List<Semester> getAllSemester() {
        return repo.findAll();
    }
}
