package code.with.me;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author andong@xiaomalixing.com
 */
public interface JpaTokenRepository extends JpaRepository<Token, Long> {
    Optional<Token> findByIdentifier(String identifier);
}
