package group3.edunext.services;

import group3.edunext.models.Semester;

import java.util.List;

public interface ISemesterService {
    List<Semester> getAllSemester();
    Semester getSemester(int semesterId);
    boolean addClasses(List<group3.edunext.models.Class> listClasses, int semesterId);
}
