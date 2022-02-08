package h5EDULive.config;

import h5EDULive.dao.domain.User;
import h5EDULive.service.impl.AuthUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collection;


/**
 * AuthenticationProvider 提供用户UserDetails的具体验证方式，在这里可以自定义用户密码的加密、验证方式等等
 * 也可以在这里验证验证码
 */
@Service
public class MyAuthenticationProvider implements AuthenticationProvider {

    static Logger log = LoggerFactory.getLogger(MyAuthenticationProvider.class);
    @Resource
    private AuthUserService authUserService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = (String) authentication.getCredentials();
        User user = (User)authUserService.loadUserByUsername(username);
        Collection<? extends GrantedAuthority> authorities = user.getAuthorities();

        if (!new BCryptPasswordEncoder().matches(password,user.getPassword())) {
            throw new BadCredentialsException("Wrong password.");
        }

        Session session = new Session();

        return new UsernamePasswordAuthenticationToken(user, password, authorities);
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return true;
    }
}
