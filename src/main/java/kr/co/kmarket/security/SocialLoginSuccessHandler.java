package kr.co.kmarket.security;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import kr.co.kmarket.dto.MemberDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Slf4j
@Component
public class SocialLoginSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {

        // 소셜 로그인 전용 principal 처리
        CustomOauth2UserDetails oauthUser = (CustomOauth2UserDetails) authentication.getPrincipal();
        MemberDTO member = oauthUser.getMember();

        // 세션 저장
        HttpSession session = request.getSession();
        session.setAttribute("cust_number", member.getCust_number());
        session.setAttribute("user_id", member.getCustid());
        session.setAttribute("member", member);

        log.info("Social login successful: {}", member);

        // 리다이렉트 처리
        RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
        if (member.getAuth() == 2 || member.getAuth() == 3) {
            redirectStrategy.sendRedirect(request, response, "/admin");
        } else {
            redirectStrategy.sendRedirect(request, response, "/");
        }
    }
}
