package group3.edunext.services;

import group3.edunext.models.Student;

import java.util.List;

public interface IClassService {
    List<group3.edunext.models.Class> getAllClass();
    boolean enrollStudent(int classId, List<Student> listStudents);
    boolean importClass(String apiUrl);
}
