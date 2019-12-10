package se.lernia.addressbook.javaFX.connectin;

import com.mysql.cj.protocol.Resultset;

import java.sql.Connection;

public abstract class DBAction {
    private String query;

    public abstract Resultset executeFor(Connection conn);
}
