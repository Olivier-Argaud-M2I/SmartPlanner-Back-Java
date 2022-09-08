package ressources;

import fr.m2i.smartplanner.models.JwtResponse;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.Assert.assertThat;

import java.io.IOException;

@ExtendWith(MockitoExtension.class)
public class JwtRessourceTest {




    @Test
    public void log() throws ClientProtocolException, IOException {

        // Given

        HttpUriRequest request = RequestBuilder.create("POST")
                .setUri("http://localhost:8080/smartplanner/api/jwt/log")
                .setEntity(new StringEntity("{\"userName\":\"admin\",\"password\":\"admin\"}", ContentType.APPLICATION_JSON))
                .build();

        // When
        HttpResponse response = HttpClientBuilder.create().build().execute( request );

        // Then
        JwtResponse jwtResponse = RetrieveUtil.retrieveResourceFromResponse(response, JwtResponse.class);
        assertThat( "admin", Matchers.is( jwtResponse.getUser().getUserName() ) );
    }



}
