package org.company.repository;

import org.company.controller.*;

import javax.sql.*;
import java.sql.*;

public class AccountRepository {
    
    private final DataSource dataSource;

    public AccountRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Account getAccount(String code) {
        @SuppressWarnings("SqlResolve")
        String sql = "SELECT * FROM Account WHERE code='" + code + "';";
        ResultSet resultSet = RepoUtils.execute(dataSource, sql);
        if (resultSet == null) return null;
        try {
            if (!resultSet.next()) return null;
            String type = resultSet.getString("type");
            return new Account(code, type);
        } catch (SQLException e) {
            return null;
        }
    }
}
