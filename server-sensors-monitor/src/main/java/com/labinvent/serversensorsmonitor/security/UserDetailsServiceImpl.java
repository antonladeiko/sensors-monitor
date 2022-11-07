package com.labinvent.serversensorsmonitor.security;

import com.labinvent.serversensorsmonitor.model.entity.User;
import com.labinvent.serversensorsmonitor.repository.UserRepository;
import com.labinvent.serversensorsmonitor.web.constant.WebConstant;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("userDetailsServiceImpl")
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(WebConstant.SECURITY_MESSAGE));

        return SecurityUser.fromUser(user);
    }
}
