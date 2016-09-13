package com.mahmud.db;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;

public interface TweetDAO {
    @SqlUpdate("create table if not exists tweets (id integer primary key, body varchar)")
    void ensureSchema();

    @SqlUpdate("INSERT INTO tweets(id, body) VALUES (:id, :body)")
    void insert(@Bind("id") long id, @Bind("body") String body);
}
