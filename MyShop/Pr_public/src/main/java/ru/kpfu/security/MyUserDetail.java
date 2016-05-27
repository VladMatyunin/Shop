package ru.kpfu.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import ru.kpfu.entities.MyUser;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class MyUserDetail implements UserDetails {
    private MyUser userInfo;

    public MyUserDetail(MyUser userInfo) {
        this.userInfo = userInfo;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
        grantedAuthorities.add(new SimpleGrantedAuthority(userInfo.getRole()));
        return grantedAuthorities;
    }

    @Override
    public String getPassword() {
        return userInfo.getHashPassword();
    }

    @Override
    public String getUsername() {
        return userInfo.getLogin();
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
        return true;
    }

    public MyUser getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(MyUser userInfo) {
        this.userInfo = userInfo;
    }
}
