package uz.pdp.appspringjpaonetomany.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.pdp.appspringjpaonetomany.entity.University;
@Repository
public interface UniversityRepository extends JpaRepository<University,Integer> {
}
