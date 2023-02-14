package com.fullstack.backend.service.impls;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fullstack.backend.dto.auth.AuthenticationRequest;
import com.fullstack.backend.dto.auth.AuthenticationResponse;
import com.fullstack.backend.service.JwtAuthenticationService;
import com.fullstack.backend.service.auth.AppUserDetailsService;
import com.fullstack.backend.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Component
public class JwtAuthenticationServiceIpml extends UsernamePasswordAuthenticationFilter implements JwtAuthenticationService {
    private final AuthenticationManager vAuthenticationManager;
    private final AppUserDetailsService vAppUserDetailsService;
    private final JwtUtil vJwtUtil;

    public JwtAuthenticationServiceIpml(AuthenticationManager authenticationManager, AppUserDetailsService vAppUserDetailsService, JwtUtil vJwtUtil) {
        this.vAuthenticationManager = authenticationManager;
        this.vAppUserDetailsService = vAppUserDetailsService;
        this.vJwtUtil = vJwtUtil;
    }
    @Override
    @Autowired
    public void setAuthenticationManager(AuthenticationManager authenticationManager) {
        super.setAuthenticationManager(authenticationManager);
    }
    @Override
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request) {
        final UserDetails vUserDetails = vAppUserDetailsService.loadUserByUsername(request.getLogin());
        vAuthenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getLogin(),
                        request.getPassword()
                )
        );
        final AuthenticationResponse vIdToken = vJwtUtil.generateIdToken(vUserDetails);
        return ResponseEntity.ok(AuthenticationResponse.builder()
                .accesToken(vIdToken.getAccesToken())
                .refreshToken(vIdToken.getRefreshToken()).build());
    }
    @Override
    public void refreshToken(HttpServletRequest request, HttpServletResponse response){
        try {
            Map<String, String> vValidateHeader = vJwtUtil.validateHeader(request);
            String refreshToken = vValidateHeader.get("authToken");
            String vUsername = vValidateHeader.get("username");
            if(StringUtils.hasLength(vUsername)) {
                UserDetails vUserDetails = vAppUserDetailsService.loadUserByUsername(vUsername);
                final AuthenticationResponse vIdToken = vJwtUtil.refreshToken(vUserDetails, refreshToken);
                response.setContentType("application/json");
                new ObjectMapper().writeValue(response.getOutputStream(), vIdToken);
            }
        } catch (Exception e) {
            throw new RuntimeException("Token Invalid !", e);
        }

    }
}
