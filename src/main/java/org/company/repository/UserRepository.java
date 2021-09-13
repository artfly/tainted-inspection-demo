package org.company.repository;

import javax.sql.*;
import java.sql.*;

public class UserRepository {
    
    private final DataSource dataSource;

    public UserRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public UserDto getUser(String name) {
        @SuppressWarnings("SqlResolve")
        String sql = "SELECT * FROM User WHERE name='" + name + "';";
        ResultSet resultSet = RepoUtils.execute(dataSource, sql);
        if (resultSet == null) return null;
        try {
            if (!resultSet.next()) return null;
            String surname = resultSet.getString("surname");
            int id = resultSet.getInt("id");
            UserDto userDto = new UserDto();
            userDto.setId(id);
            userDto.setName(name);
            userDto.setSurname(surname);
            return userDto;
        } catch (SQLException e) {
            return null;
        }
    }
}
