package cc.aisc.logistics.rest.controller.auth;

import cc.aisc.commons.response.Response;
import cc.aisc.logistics.config.security.CurrentUser;
import cc.aisc.logistics.config.security.CurrentUserDetailsService;
import cc.aisc.logistics.config.security.JwtTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mobile.device.Device;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by sjf on 16-7-7.
 */
@RestController
public class LoginController {

    @Autowired
    private JwtTokenService jwtTokenService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserDetailsService userDetailsService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Response login(@RequestBody final AuthenticationRequest request, Device device) throws Exception{
        // Perform the security
        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // Reload password post-security so we can generate token
        final CurrentUser userDetails = (CurrentUser)userDetailsService.loadUserByUsername(request.getUsername());
        final String token = jwtTokenService.generateToken(userDetails, device);

        // Return the token
        return new Response(200000, true, false, "登陆成功", token);
/*
        if (request.username != null){
            CurrentUser currentUser = currentUserDetailsService.loadUserByUsername(request.username);
            if (null != currentUser) {
                String token = jwtTokenService.generateToken(currentUser, device);
                return new Response(200000, true, "登陆成功", token);
            }
            return new Response(300000, true, "用户不存在", null);
        }
        return new Response(900000, true, "参数错误", null);*/
    }

    @SuppressWarnings("unused")
    private static class AuthenticationRequest {
        public String username;
        public String password;
        public boolean remember;

        public String getUsername() {
            return username;
        }

        public String getPassword() {
            return password;
        }

        public boolean isRemember() {
            return remember;
        }
    }

}
