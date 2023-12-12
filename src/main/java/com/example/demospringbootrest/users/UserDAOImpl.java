package com.example.demospringbootrest.users;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO{

    private JdbcTemplate jdbcTemplate;
    private DataSource dataSource;
    private Dotenv dotenv;

    public UserDAOImpl() {
        this.dotenv = Dotenv.configure().load();
        this.dataSource = new DriverManagerDataSource(
                this.dotenv.get("DB_URL"),
                this.dotenv.get("DB_USER"),
                this.dotenv.get("DB_PASS"));
        this.jdbcTemplate = new JdbcTemplate(this.dataSource);
    }

    @Override
    public void insertUser(User user) {
        String query = "INSERT INTO USER VALUES(?,?,?)";
        Object[] args = {user.getUserID(), user.getName(), user.getAge()};
        int rows = jdbcTemplate.update(query, args);
        System.out.println("Inserted a Record. "+rows+" Edited");
    }

    @Override
    public void deleteUser(int ID) {
        String query = "DELETE FROM USER WHERE ID=?";
        Object[] args = {ID};
        jdbcTemplate.update(query, args);
        System.out.println("Delete record with ID="+ID);
    }

    @Override
    public User getUser(Integer userID) {
        String query = "SELECT * FROM USER WHERE ID=?";
        Object[] args = {userID};
        User user = jdbcTemplate.queryForObject(query, args, new UserRowMapper());
        System.out.println("Fetched 1 Record");
        return user;
    }

    @Override
    public List<User> getUsers() {
        String query = "SELECT * FROM USER";
        List<User> users = jdbcTemplate.query(query, new UserRowMapper());
        System.out.println("Fetched All Records");
        return users;
    }

    @Override
    public void updateUser(int ID, String name) {
        String query = "UPDATE USER SET NAME=? WHERE ID=?";
        Object[] args = {ID, name};
        jdbcTemplate.update(query, args);
        System.out.println("Updated Name of User with ID="+ID);
    }
}
