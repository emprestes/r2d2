package tradeforce.starwars.domain;

public interface Domain<D> extends Comparable<D> {

    String getUrl();

    D setUrl(String url);
}
