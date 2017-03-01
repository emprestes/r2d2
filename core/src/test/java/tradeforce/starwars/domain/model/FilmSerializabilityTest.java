package tradeforce.starwars.domain.model;

import java.io.Serializable;

import junitx.extensions.SerializabilityTestCase;

public class FilmSerializabilityTest extends SerializabilityTestCase {

    public FilmSerializabilityTest(String name) {
        super(name);
    }

    @Override
    protected Serializable createInstance() throws Exception {
        return new Film()
                .setTitle("film01")
                .setCreated("film01")
                .setDirector("film01")
                .setEdited("film01")
                .setEpisode_id(1)
                .setOpening_crawl("film01")
                .setProducer("film01")
                .setRelease_date("film01")
                .setUrl("film01");
    }
}
