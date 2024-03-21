package devmaster.vn.repository;

import devmaster.vn.Entity.Clazz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClazzRepository extends JpaRepository<Clazz, Integer> {
}
