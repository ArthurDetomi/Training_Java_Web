package org.dao;

import com.mysql.cj.xdevapi.SqlResult;
import org.conexao_jdbc.SingleConnection;
import org.domain.model.UserPosJava;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserPosDao {

    private Connection connection;

    public UserPosDao() {
        connection = SingleConnection.getConnection();
    }

    public void save(UserPosJava userPosJava) {
        try {
            String sql = "INSERT INTO userposjava (id, nome, email) value (?, ?)";
            PreparedStatement insert = connection.prepareStatement(sql);

            insert.setLong(1, userPosJava.getId());
            insert.setString(2, userPosJava.getNome());
            insert.setString(3, userPosJava.getEmail());

            insert.execute();
            connection.commit(); // salva no banco de dados
        } catch (Exception e) {
            try {
                connection.rollback();
            } catch (SQLException s1) {
                s1.printStackTrace();
            }
            e.printStackTrace();
        }
    }

    public List<UserPosJava> findAll() throws Exception {
        List<UserPosJava> listUsers = new ArrayList<>();

        String sql = "SELECT * FROM userposjava";
        PreparedStatement statement = connection.prepareStatement(sql);

        ResultSet result = statement.executeQuery(sql);

        while (result.next()) {
            UserPosJava userPosJava = new UserPosJava();
            userPosJava.setId(result.getLong("id"));
            userPosJava.setNome(result.getString("nome"));
            userPosJava.setEmail(result.getString("email"));

            listUsers.add(userPosJava);
        }
        return listUsers;
    }

    public UserPosJava findById(Long id) throws Exception {
        String sql = "SELECT * FROM userposjava WHERE id =" + id;

        PreparedStatement statement = connection.prepareStatement(sql);

        ResultSet result = statement.executeQuery(sql);

        if (result.next()) {
            UserPosJava userPosJava = new UserPosJava();
            userPosJava.setId(result.getLong("id"));
            userPosJava.setNome(result.getString("nome"));
            userPosJava.setEmail(result.getString("email"));
            return userPosJava;
        }

        return null;
    }

}
