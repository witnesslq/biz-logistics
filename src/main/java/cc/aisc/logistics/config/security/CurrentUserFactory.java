package cc.aisc.logistics.config.security;

import cc.aisc.logistics.model.auth.User;
import cc.aisc.logistics.model.auth.dto.Authority;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by sjf on 16-7-4.
 */
public class CurrentUserFactory {
    private CurrentUserFactory() {
    }

    public static CurrentUser create(User user) {
        return new CurrentUser(
                user.getId(),
                user.getUsername(),
                user.getNicename(),
                user.getMobile(),
                user.getPassword(),
                null,
                user.getStatus() == 1,
                user.getRestPswAt()
        );
    }

    private static List<GrantedAuthority> mapToGrantedAuthorities(List<Authority> authorities) {
        return authorities.stream()
                .map(authority -> new SimpleGrantedAuthority(authority.getAuthName()))
                .collect(Collectors.toList());
    }
}
