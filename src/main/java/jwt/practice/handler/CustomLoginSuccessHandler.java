package jwt.practice.handler;

import jwt.practice.app.user.domain.MyUserDetails;
import jwt.practice.app.user.domain.User;
import jwt.practice.constants.AuthConstants;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CustomLoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {


    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException {
        User user =((MyUserDetails) authentication.getPrincipal()).getUser();
//        String token = Token
    }
}
