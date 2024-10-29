package group3.edunext.services.implement;

import group3.edunext.models.Student;
import group3.edunext.models.User;
import group3.edunext.repositories.IStudentRepository;
import group3.edunext.repositories.IUserRepository;
import group3.edunext.services.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements IUserService {

    private final IUserRepository userRepository;
    private final IStudentRepository studentRepository;

    @Override
    public Optional<User> getUserByLoginInfo(String username, String password) {
        try {
            return userRepository.findByUsernameAndPassword(username, password);
        }
        catch (Exception e) {
            return Optional.empty();
        }
    }

    @Override
    public Student getStudent(int userId) {
        return studentRepository.findStudentByUserID(userId);
    }


}
