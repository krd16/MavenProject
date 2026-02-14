package org.example.dao;

import org.example.config.MySQLConnection;
import org.example.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    public void createUser(User user) throws SQLException {

        String sql = "INSERT INTO usuarios(nombre,email) VALUES (?,?)";

        try (Connection connection = MySQLConnection.connect();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());
            ps.executeUpdate();
        }
    }

    public List<User> getAllUsers() throws SQLException {

        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM usuarios";

        try (Connection connection = MySQLConnection.connect();
             Statement st = connection.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {

                User user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("nombre"));
                user.setEmail(rs.getString("email"));
                user.setCreatedAt(rs.getTimestamp("fecha_creacion"));

                users.add(user);
            }
        }

        return users;
    }

    public void updateUserName(int id, String newName) throws SQLException {

        String sql = "UPDATE usuarios SET nombre=? WHERE id=?";

        try (Connection connection = MySQLConnection.connect();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setString(1, newName);
            ps.setInt(2, id);
            ps.executeUpdate();
        }
    }

    public void deleteUser(int id) throws SQLException {

        String sql = "DELETE FROM usuarios WHERE id=?";

        try (Connection connection = MySQLConnection.connect();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }
}
