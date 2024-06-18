package by.kovalyov.diplomgym.config;

import by.kovalyov.diplomgym.entities.UserGym;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

public class UserGymDetails implements UserDetails {

    private UserGym userGym;

    public UserGymDetails(UserGym userGym) {
        this.userGym = userGym;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(userGym.getRole());
    }

    @Override
    public String getPassword() {
        return userGym.getPassword();
    }

    @Override
    public String getUsername() {
        return userGym.getPhoneNumber();
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
}
