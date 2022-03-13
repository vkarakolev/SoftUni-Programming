package E00_Accounts.repositories;

import E00_Accounts.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository  extends JpaRepository<User, Long> {
    User getUserByName(String name);

    Optional<User> findUserByName(String name);
}
