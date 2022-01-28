package edu.hahu.auth;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private BCryptPasswordEncoder encoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final List<AppUser> users = Arrays.asList(
                new AppUser(1L, "omar", encoder.encode("12345"), "USER"),
                new AppUser(2L, "admin", encoder.encode("12345"), "ADMIN")
        );

        for(AppUser appUser: users) {
            if(appUser.getUsername().equals(username)) {

                List<GrantedAuthority> grantedAuthorities = AuthorityUtils
                        .commaSeparatedStringToAuthorityList("ROLE_" + appUser.getRole());

                return new User(appUser.getUsername(), appUser.getPassword(), grantedAuthorities);
            }
        }

        throw new UsernameNotFoundException("Username: " + username + " not found");
    }
}
