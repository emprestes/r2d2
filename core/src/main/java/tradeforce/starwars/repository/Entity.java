package tradeforce.starwars.repository;

import java.io.Serializable;

public interface Entity<PK> extends Serializable {

    String _ID = "_id";

    boolean hasId();

    PK getId();

    void setId(PK id);
}
