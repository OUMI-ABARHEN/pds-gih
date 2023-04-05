package ma.uiass.eia.pds.backend.Security;

import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerRequestFilter;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.Provider;
import ma.uiass.eia.pds.backend.Dao.IdentifiantDaoImp;
import ma.uiass.eia.pds.backend.Entite.Identifiant;

import java.io.IOException;
import java.util.List;
import java.util.Base64;

import static ma.uiass.eia.pds.backend.Security.AuthenticationConstants.AUTHORIZATION_HEADER_KEY;


@Provider
public class SecurityFilter implements ContainerRequestFilter {
    private static final String REALM = "example";
    private static final String AUTHENTICATION_SCHEME = "Basic";

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        List<String> authHeader = requestContext.getHeaders().get(AUTHORIZATION_HEADER_KEY);

        if (authHeader != null && authHeader.size() > 0) {
            String authToken = authHeader.get(0).replaceFirst(AUTHENTICATION_SCHEME + " ", "");
            String decodedAuthToken = new String(Base64.getDecoder().decode(authToken.getBytes()));
            String[] credentials = decodedAuthToken.split(":");
            System.out.println(credentials);

            IdentifiantDaoImp identifiantDaoImp = new IdentifiantDaoImp();
            Identifiant user = identifiantDaoImp.findByCode(credentials[0]);

            if (user != null && user.getPassword().equals(credentials[1])) {
                requestContext.setSecurityContext(new ExampleSecurityContext(user.getCode()));
                return;
            }
        }

        Response unauthorizedResponse = Response.status(Response.Status.UNAUTHORIZED)
                .header(AUTHORIZATION_HEADER_KEY, AUTHENTICATION_SCHEME + " realm=\"" + REALM + "\"")
                .build();
        requestContext.abortWith(unauthorizedResponse);
    }
}
