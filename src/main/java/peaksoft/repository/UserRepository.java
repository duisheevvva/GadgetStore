package peaksoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import peaksoft.dto.response.UserResponse;
import peaksoft.dto.response.UserResponses;
import peaksoft.entity.User;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> getUserByEmail(String email);

    boolean existsByEmail(String email);

    @Query("select new peaksoft.dto.response.UserResponses(u.id,u.firstName,u.lastName,u.email,u.password,u.role)from User u")
    public UserResponses getAllUser();

}
