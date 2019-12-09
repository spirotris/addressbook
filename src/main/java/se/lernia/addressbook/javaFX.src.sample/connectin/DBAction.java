package main.java.se.lernia.addressbook.javaFX.src.sample.connectin;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.mysql.cj.protocol.Resultset;

public abstract class DBAction {
	private String query;
	public abstract Resultset executeFor(Connection conn);
}
