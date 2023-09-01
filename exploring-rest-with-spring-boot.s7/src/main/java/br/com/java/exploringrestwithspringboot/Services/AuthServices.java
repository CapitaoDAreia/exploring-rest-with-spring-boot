package br.com.java.exploringrestwithspringboot.Services;


import br.com.java.exploringrestwithspringboot.Repositories.UserRepository;
import br.com.java.exploringrestwithspringboot.Security.JWT.JwtTokenProvider;
import br.com.java.exploringrestwithspringboot.VO.v1.AccountCredentialsVOv1;
import br.com.java.exploringrestwithspringboot.VO.v1.TokenVOv1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthServices {

    @Autowired
    private JwtTokenProvider tokenProvider;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository repository;

    public ResponseEntity signin(AccountCredentialsVOv1 data) {
        try {
            var username = data.getUsername();
            var password = data.getPassword();

            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));

            var user = repository.findByUsername(username);

            var tokenResponse = new TokenVOv1();

            if (user != null) {
                tokenResponse = tokenProvider.createAccessToken(username, user.getRoles());
            } else {
                throw new UsernameNotFoundException("username " + username + " not found");
            }
            return ResponseEntity.ok(tokenResponse);
        } catch (Exception e) {
            throw new BadCredentialsException("invalid username or password");
        }
    }

}
