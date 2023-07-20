package com.ecommerce.security.keycloak;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.HttpURLConnection;
import java.net.URL;


@Component
public class KeycloakLogoutHandler implements LogoutHandler {

    private static final Logger logger = LoggerFactory.getLogger(KeycloakLogoutHandler.class);

    @Override
    public void logout(HttpServletRequest request, HttpServletResponse response,
                       Authentication auth) {
        try {
            logoutFromKeycloak((OidcUser) auth.getPrincipal());
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }

    private void logoutFromKeycloak(OidcUser user) throws Exception {
        String endSessionEndpoint = user.getIssuer() + "/protocol/openid-connect/logout";
        String idTokenHint = user.getIdToken().getTokenValue();
        URL url = new URL(endSessionEndpoint + "?id_token_hint=" + idTokenHint);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

        conn.setRequestMethod("GET");
        int responseCode = conn.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            logger.info("User '"+user.getName()+"'"+" has successfully logged out from Keycloak");
        } else {
            logger.error("Could not log out from Keycloak: Http status code -> "+responseCode);
        }
    }
}