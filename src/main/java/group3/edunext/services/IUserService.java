package group3.edunext.services;

import group3.edunext.models.Student;
import group3.edunext.models.User;

import java.util.Optional;

public interface IUserService {
    Optional<User> getUserByLoginInfo(String username, String password);
    Student getStudent(int userId);
}
