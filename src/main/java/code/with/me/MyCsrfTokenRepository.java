package code.with.me;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.csrf.DefaultCsrfToken;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

/**
 * @author andong@xiaomalixing.com
 */
@Component
@RequiredArgsConstructor
public class MyCsrfTokenRepository implements CsrfTokenRepository {

    private final JpaTokenRepository jpaTokenRepository;

    @Override
    public CsrfToken generateToken(HttpServletRequest request) {
        String uuid = UUID.randomUUID().toString();
        return new DefaultCsrfToken("X-CSRF-TOKEN", "_csrf", uuid);
    }

    @Override
    public void saveToken(CsrfToken csrfToken, HttpServletRequest request, HttpServletResponse response) {
        String identifier = request.getHeader("X-IDENTIFIER");

        Optional<Token> t = jpaTokenRepository.findByIdentifier(identifier);

        if (t.isPresent()) {
            t.get().setToken(csrfToken.getToken());
            jpaTokenRepository.save(t.get());
        } else {
            Token token = new Token();
            token.setIdentifier(identifier);
            token.setToken(csrfToken.getToken());
            jpaTokenRepository.save(token);
        }
    }

    @Override
    public CsrfToken loadToken(HttpServletRequest request) {
        String identifier = request.getHeader("X-IDENTIFIER");
        Optional<Token> byIdentifier = jpaTokenRepository.findByIdentifier(identifier);
        return byIdentifier
                .map(token -> new DefaultCsrfToken("X-CSRF-TOKEN", "_csrf", token.getToken()))
                .orElse(null);

    }
}
