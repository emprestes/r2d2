package tradeforce.starwars.domain.model;

import junitx.extensions.ComparabilityTestCase;

public class FilmComparabilityTest extends ComparabilityTestCase {

    public FilmComparabilityTest(String name) {
        super(name);
    }

    @Override
    protected Comparable createLessInstance() throws Exception {
        return new Film()
                .setUrl("film01");
    }

    @Override
    protected Comparable createEqualInstance() throws Exception {
        return new Film()
                .setUrl("film02");
    }

    @Override
    protected Comparable createGreaterInstance() throws Exception {
        return new Film()
                .setUrl("film03");
    }
}
