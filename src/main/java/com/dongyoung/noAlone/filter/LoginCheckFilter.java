package com.dongyoung.noAlone.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.log4j.Log4j2;
import org.springframework.util.PatternMatchUtils;

import java.io.IOException;

@Log4j2
public class LoginCheckFilter implements Filter {
    private static final String[] whitelist = {"/", "/com/*", "/error", "*.ico", "/css/*", "/js/*", "/img/*", "/scss/*", "/vendor/*"};

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {



        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String requestURI = httpRequest.getRequestURI();
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        log.info("=======requestURI========={}",requestURI);
        try {
            if (isLoginCheckPath(requestURI)) {
                HttpSession session = httpRequest.getSession(false);

                if (session == null) {
                    log.info("미인증 사용자 요청 {}", requestURI);

                    //로그인으로 redirect
                    httpResponse.sendRedirect("/member/login?redirectURL=" + requestURI);
                    return;
                }
            }

            chain.doFilter(request, response);
        } catch (Exception e) {
            throw e; //예외 로깅 가능 하지만, 톰캣까지 보내주어야 함
        }
    }

    /**
     * 화이트 리스트의 경우 인증체크 X
     */
    private boolean isLoginCheckPath(String requestURI) {
        return !PatternMatchUtils.simpleMatch(whitelist, requestURI);
    }



}
