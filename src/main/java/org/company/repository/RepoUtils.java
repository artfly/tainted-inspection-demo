package org.company.repository;

import org.checkerframework.checker.tainting.qual.Untainted;

import javax.sql.*;
import java.sql.*;

public class RepoUtils {
    
    public static ResultSet execute(DataSource dataSource, @Untainted String sql) {
        try {
            Connection connection = dataSource.getConnection();
            Statement statement = connection.createStatement();
            return statement.executeQuery(sql);
        } catch (SQLException e) {
            return null;
        }
    }
}
