package pl.cyfronet.ltos.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.oauth2.common.exceptions.InvalidRequestException;
import org.springframework.security.oauth2.common.exceptions.UserDeniedAuthorizationException;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import com.agreemount.bean.identity.provider.IdentityProvider;

/**
 * Created by km on 04.08.16.
 */
public class OpenIDConnectAuthenticationFilter extends AbstractAuthenticationProcessingFilter {

    @Value("${unity.unauthorizedAction}")
    private String unauthorizedAction;

    @Autowired
    IdentityProvider identityProvider;

    @Autowired
    private AuthenticationService authenticationService;

    protected OpenIDConnectAuthenticationFilter(String defaultFilterProcessesUrl) {
        super(defaultFilterProcessesUrl);

        SavedRequestAwareAuthenticationSuccessHandler successHandler = new SavedRequestAwareAuthenticationSuccessHandler();
        successHandler.setDefaultTargetUrl("/");
        successHandler.setAlwaysUseDefaultTargetUrl(true);

        setAuthenticationSuccessHandler(successHandler);
        setAuthenticationFailureHandler(new OpenIDConnectAuthenticationFailureHandler());

        setAuthenticationManager(authentication -> authentication);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException, IOException, ServletException {
        try {
            PortalUser portalUser = authenticationService.getPortalUser();
            authenticationService.engineLogin(portalUser.getUserBean());

            return portalUser;
        } catch (UserDeniedAuthorizationException | InvalidRequestException ex) {
            RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
            redirectStrategy.sendRedirect(request, response, unauthorizedAction);
        }

        return null;
    }
}

