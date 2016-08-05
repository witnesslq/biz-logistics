package cc.aisc.logistics.config.security;

import cc.aisc.logistics.model.auth.User;
import cc.aisc.logistics.model.auth.dto.Authority;
import org.joda.time.DateTime;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by sjf on 16-7-4.
 */
public class CurrentUserFactory {

    private CurrentUserFactory() {
    }

    public static CurrentUser create(User user, Set<Authority> authorities) {
        DateTime dt = new DateTime();
        return new CurrentUser(
                user.getId(),
                user.getUsername(),
                user.getNicename(),
                user.getMobile(),
                user.getPassword(),
                grantedAuthorities(authorities),
                user.getExpiryAt().after(dt.toDate()),
                user.getStatus() % 10 > 0,
                user.getLastLogin().before(dt.plusMonths(1).toDate()),
                user.getStatus() > 10,
                user.getRestPswAt()
        );
    }

    private static List<GrantedAuthority> grantedAuthorities(Set<Authority> authorities) {
        return authorities.stream()
                .map(authority -> new SimpleGrantedAuthority(authority.getAuth()))
                .collect(Collectors.toList());
    }
}
