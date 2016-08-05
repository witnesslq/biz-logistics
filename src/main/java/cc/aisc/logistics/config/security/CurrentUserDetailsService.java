package cc.aisc.logistics.config.security;

import cc.aisc.logistics.model.auth.Role;
import cc.aisc.logistics.model.auth.User;
import cc.aisc.logistics.model.auth.dto.Authority;
import cc.aisc.logistics.service.auth.RoleService;
import cc.aisc.logistics.service.auth.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by sjf on 16-7-6.
 */
@Service("userDetailsService")
public class CurrentUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

    @Override
    //@Cacheable(value = "userDetailsLoadUserByUsername", keyGenerator = "redisKeyGenerator")
    public CurrentUser loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<User> user = userService.findDetailedByUsername(s);
        Set<Authority> authorities = new HashSet<>();
        if (user.isPresent()){
            for (Role r : user.get().getRoles()) {
                authorities.addAll(r.getPermissions().stream().map(Authority::new).collect(Collectors.toList()));
            }
            return CurrentUserFactory.create(user.get(),authorities);
        }else{
            throw new UsernameNotFoundException(String.format("User with username=%s was not found", s));
        }
    }
}
