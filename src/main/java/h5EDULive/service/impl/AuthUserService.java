package h5EDULive.service.impl;

import h5EDULive.dao.UserRepository;
import h5EDULive.dao.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthUserService implements UserDetailsService {
    static Logger log = LoggerFactory.getLogger(AuthUserService.class);

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        log.info("param--username===>" + username);
        User user = userRepository.findByUsername(username);
        if(user == null){
            throw new UsernameNotFoundException("用户名不存在");
        }
//        log.info("user===>" + user);
//        log.info("username===>" + user.getUsername());
        log.info("password===>" + user.getPassword());
        return user;
    }
}
