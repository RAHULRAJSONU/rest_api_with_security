package pl.cyfronet.ltos.repository;

import java.util.Arrays;

import org.springframework.security.authentication.TestingAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import pl.cyfronet.ltos.security.PortalUser;

public class AuthenticationMocks {

	private AuthenticationMocks() {
	}

	public static Authentication userAuthentication(Long id) {
		PortalUser user = new PortalUser(Arrays.asList(new SimpleGrantedAuthority("ROLE_USER")), "user1", "userpass", id);
		return new TestingAuthenticationToken(user, null, "ROLE_USER");
	}

	public static Authentication adminAuthentication(Long id) {
		PortalUser user = new PortalUser(Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN")), "admin", "adminpass", id);
		return new TestingAuthenticationToken(user, null, "ROLE_ADMIN");
	}
	
}