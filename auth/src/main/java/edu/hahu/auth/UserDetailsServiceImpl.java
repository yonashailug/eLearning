package edu.hahu.auth;

import edu.hahu.auth.model.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // return fromDTO(username);
        return getDummyUsername(username);
    }


    public UserDetails fromDTO(String username){
        AppUser user =  restTemplate.postForObject("http://user-service/username", username, AppUser.class);

        if(user == null){
            throw new UsernameNotFoundException("Username: " + username + " not found");
        }

        List<GrantedAuthority> grantedAuthorities = AuthorityUtils
                .commaSeparatedStringToAuthorityList("ROLE_" + user.getRole());

        return new User(user.getUsername(), user.getPassword(), grantedAuthorities);


    }


    public UserDetails getDummyUsername(String username){

        final List<edu.hahu.auth.AppUser> users = Arrays.asList(
                new edu.hahu.auth.AppUser(1L, "user", encoder.encode("user"), "USER"),
                new edu.hahu.auth.AppUser(2L, "admin", encoder.encode("admin"), "ADMIN")
        );

        for(edu.hahu.auth.AppUser appUser: users) {
            if(appUser.getUsername().equals(username)) {

                List<GrantedAuthority> grantedAuthorities = AuthorityUtils
                        .commaSeparatedStringToAuthorityList("ROLE_" + appUser.getRole());

                return new User(appUser.getUsername(), appUser.getPassword(), grantedAuthorities);
            }
        }

        throw new UsernameNotFoundException("Username: " + username + " not found");
    }
}
