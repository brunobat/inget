package io.superbiz.video.rest.client.base;

import org.eclipse.microprofile.rest.client.ext.ResponseExceptionMapper;

import javax.annotation.Generated;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

@Provider()
@Generated("org.tomitribe.client.ClientGenerator")
public class MovieClientExceptionMapper implements ResponseExceptionMapper<MovieClientException> {

    @Override()
    public MovieClientException toThrowable(
            final Response response) {
        switch (response.getStatus()) {
        case 404:
            return new EntityNotFoundException();
        default:
        }
        return null;
    }
}
