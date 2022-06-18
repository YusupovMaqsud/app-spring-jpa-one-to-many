package uz.pdp.appspringjpaonetomany.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.appspringjpaonetomany.entity.Student;
import uz.pdp.appspringjpaonetomany.entity.Subject;

import java.util.List;
import java.util.Optional;

public interface SubjectRepository extends JpaRepository<Subject,Integer> {
    boolean existsByName(String name);

    Optional<Student> findById(List<Integer> subjectId);
}
