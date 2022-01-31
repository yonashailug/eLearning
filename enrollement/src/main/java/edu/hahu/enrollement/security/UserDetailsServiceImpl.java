package edu.hahu.enrollement.security;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    private final RestTemplate restTemplate;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
         return fromDTO(username);
       // return getDummyUsername(username);
    }

    public UserDetails fromDTO(String username){

        String url = "http://user-service/username";

        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url)
                .queryParam("username", username);

        ResponseEntity<User> response =  restTemplate.exchange(builder.toUriString(), HttpMethod.POST,null, User.class);
        User user = response.getBody();
        if(user == null){
            throw new UsernameNotFoundException("Username: " + username + " not found");
        }

        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority( "ROLE_" + user.getRole()));
        return new UserMoreDetails(
                user.getId(),
                user.getUsername(),
                user.getEmail(),
                user.isEnabled(),
                user.getPassword(),
                authorities
        );
    }
}
