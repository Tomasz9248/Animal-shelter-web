package com.tomek.util;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.rmi.Naming;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionProvider {

    private static DataSource dataSource;

    public static Connection getConnection () throws SQLException {
        return getDSInstance().getConnection();
    }

    public static DataSource getDSInstance(){
        if (dataSource == null) {
            try {
                Context initContext = new InitialContext();
                    Context envContext = (Context) initContext.lookup("java:comp/env");
                    dataSource = (DataSource) envContext.lookup("jdbc/shelter");
                } catch (NamingException ne) {
                ne.printStackTrace();
            }
        }
return dataSource;
    }
}