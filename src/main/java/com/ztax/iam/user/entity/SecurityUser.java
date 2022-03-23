package com.ztax.iam.user.entity;

import com.ztax.common.utils.ObjectUtils;
import com.ztax.iam.auth.constants.AuthConstants;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 登录用户信息
 */
@Data
@NoArgsConstructor
public class SecurityUser implements UserDetails {

    private String id;

    private String username;

    private String password;

    private Boolean enabled;

    private String clientId;

    private Collection<SimpleGrantedAuthority> authorities;

    public SecurityUser(UserDTO user) {
        this.setId(user.getUserId());
        this.setUsername(user.getUsername());
//        this.setPassword(AuthConstants.BCRYPT + user.getPassword());
        this.setPassword(user.getPassword());
        this.setEnabled(user.getEnabled());
        this.setClientId(user.getClientId());
        if (ObjectUtils.isNotBlank(user.getModuleIds())) {
            authorities = new ArrayList<>();
            user.getModuleIds().forEach(roleId -> authorities.add(new SimpleGrantedAuthority(String.valueOf(roleId))));
        }
        if (ObjectUtils.isBlank(user.getModuleIds())) {
            authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority("USER"));
        }
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return this.enabled;
    }
}