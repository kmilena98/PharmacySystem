package ISA.Team54.users.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ISA.Team54.users.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByEmail( String email );
	List<User> findByName(String name);
	List<User> findBySurname(String surname);
}
