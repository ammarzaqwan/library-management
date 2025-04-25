package com.portfolio.library_management.middleware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class AuthInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        System.out.println("JWT FILTER HIT: " + request.getRequestURI());
        String authHeader = request.getHeader("Authorization");

        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            String token = authHeader.substring(7);
            // TODO: validate the token
            return true;
        }

        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        return true;
    }



//    public boolean preHandle(HttpServletRequest req,
//                             HttpServletResponse res,
//                             Object handler) throws Exception {
//
//        // Has Spring Security accepted Basic‑Auth?
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        if (auth != null && auth.isAuthenticated()) {
//            return true;          // ✔ allow /api/books, /api/users, …
//        }
//
//        // ‑‑‑‑ otherwise run your own checks here (JWT, API key, etc.) ‑‑‑‑
//        // if those fail:
//        res.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
//        return false;
//    }
}
