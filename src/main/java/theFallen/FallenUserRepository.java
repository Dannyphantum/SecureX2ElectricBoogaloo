package theFallen;

import org.springframework.data.repository.CrudRepository;

public interface FallenUserRepository extends CrudRepository<FallenUser, Long> {
	
	FallenUser findByusername(String username);

}