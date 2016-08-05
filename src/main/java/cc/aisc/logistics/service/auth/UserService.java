package cc.aisc.logistics.service.auth;

import cc.aisc.commons.base.BaseService;
import cc.aisc.logistics.model.auth.User;

import java.util.List;
import java.util.Optional;

/**
 * Created by sjf on 16-7-4.
 */
public interface UserService extends BaseService<User, Long> {
    Optional<User> findByUsername(String username);
    Optional<User> findDetailedByUsername(String username);
}
