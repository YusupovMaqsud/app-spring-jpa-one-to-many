package uz.pdp.appspringjpaonetomany.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.pdp.appspringjpaonetomany.entity.Address;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<Address,Integer> {
}
