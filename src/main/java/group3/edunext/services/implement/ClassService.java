package group3.edunext.services.implement;

import com.fasterxml.jackson.databind.JsonSerializable;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import group3.edunext.models.Course;
import group3.edunext.models.Student;
import group3.edunext.repositories.IClassReposotory;
import group3.edunext.repositories.IStudentRepository;
import group3.edunext.services.IClassService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.web.reactive.function.client.WebClientAutoConfiguration;
import org.springframework.boot.autoconfigure.web.reactive.function.client.WebClientSsl;
import org.springframework.boot.web.reactive.function.client.WebClientCustomizer;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
@Service
@RequiredArgsConstructor
public class ClassService implements IClassService {
    private final IClassReposotory classRepository;
    private final IStudentRepository studentRepository;
    @Override
    public List<group3.edunext.models.Class> getAllClass() {
        return classRepository.findAll();
    }

    @Override
    public boolean enrollStudent(int classId, List<Student> listStudents) {
        try{
            boolean exist = true;
            if (!classRepository.existsById(classId)) {
                exist = false;
            }
            for (Student student : listStudents) {
                if (!studentRepository.existsById(student.getId())) {
                    exist = false;
                }
            }
            if (exist) {
                group3.edunext.models.Class chosenClass = classRepository.findById(classId).get();
                chosenClass.setCourseID(new Course());
                classRepository.save(chosenClass);
            }
            return true;
        }catch (Exception e){}
        return false;
    }

    @Override
    public boolean importClass(String apiUrl) {
        try{
            List<group3.edunext.models.Class> listClass = new ArrayList<>();
            // Lay du lieu API
            classRepository.saveAll(listClass);
            return true;
        }catch (Exception e){}

        return false;
    }
}
