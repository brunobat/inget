package io.superbiz.video.model.rest.cmd;

import io.airlift.airline.Arguments;
import io.airlift.airline.Command;
import io.superbiz.video.model.rest.client.MovieClient;
import io.superbiz.video.model.rest.client.base.ClientConfiguration;
import io.superbiz.video.rest.cmd.base.DefaultCommand;

@Command(name = "find")
public class MoviesResourceClientFindCmd extends DefaultCommand {

    @Override
    public void run(
            final ClientConfiguration clientConfiguration) {
        System.out.println(new org.apache.johnzon.mapper.MapperBuilder().setPretty(true).build()
                .writeObjectAsString(new MovieClient(clientConfiguration).moviesresourceclient().find(id)));
    }

    @Arguments(required = true)
    private java.lang.Long id;
}