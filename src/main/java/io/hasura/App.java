package io.hasura;

import java.sql.*;

public class App {
    public static void main( String[] args ) throws SQLException {
	if (System.getProperty("jdbc:calcite:model") != null)
	    try (
		var con = DriverManager.getConnection(String.format("jdbc:calcite:model=%s", System.getProperty("jdbc:calcite:model")));
		var stm = con.createStatement();
		var res = stm.executeQuery(args[1]);) {
		var met = res.getMetaData();
		while (res.next())
		    for (int i = 1; i<=met.getColumnCount(); i++)
			System.out.print(String.format("%s,", res.getString(i)));}
	    catch (SQLException e) {
		e.printStackTrace(System.err);}}}
