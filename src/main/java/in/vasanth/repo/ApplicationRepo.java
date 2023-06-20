package in.vasanth.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.vasanth.entity.Application;
@Repository
public interface ApplicationRepo extends JpaRepository<Application, Integer>{

}
