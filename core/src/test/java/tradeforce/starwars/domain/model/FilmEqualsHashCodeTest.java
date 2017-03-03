package tradeforce.starwars.domain.model;

import junitx.extensions.EqualsHashCodeTestCase;

public class FilmEqualsHashCodeTest extends EqualsHashCodeTestCase {

    public FilmEqualsHashCodeTest(String name) {
        super(name);
    }

    @Override
    protected Object createInstance() throws Exception {
        return new Film()
                .setTitle("film01")
                .setCreated("film01")
                .setDirector("film01")
                .setEdited("film01")
                .setEpisode_id("1")
                .setOpening_crawl("film01")
                .setProducer("film01")
                .setRelease_date("film01")
                .setUrl("film01");
    }

    @Override
    protected Object createNotEqualInstance() throws Exception {
        return new Film()
                .setTitle("film02")
                .setCreated("film02")
                .setDirector("film02")
                .setEdited("film02")
                .setEpisode_id("2")
                .setOpening_crawl("film02")
                .setProducer("film02")
                .setRelease_date("film02")
                .setUrl("film02");
    }
}
