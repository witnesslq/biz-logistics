package cc.aisc.logistics.model.auth.dto;

import cc.aisc.logistics.model.auth.Permission;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * Created by sjf on 16-7-6.
 */
public class Authority {

    private String auth;

    public Authority(Permission perm) {
        this.auth = String.valueOf(perm.getResource().getId() * 100 + perm.getPermType().ordinal());

    }

    public String getAuth() {
        return auth;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Authority authority = (Authority) o;

        return new EqualsBuilder()
                .append(auth, authority.auth)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(auth)
                .toHashCode();
    }
}
