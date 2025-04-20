package langio.daniel.lifetracker.repository;

import langio.daniel.lifetracker.config.DatabaseProperties;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Provides database Connection instance.
 * <p>
 * NOTE: only postgresql is supported for now
 * */
@Getter
@Repository
public class DataSource {

    private final String url;
    private final Connection connection;

    /**
     * Creates a new {@link DataSource} instance with a connection to the specified PostgreSQL database.
     * @param properties {@link DatabaseProperties} instance with database information
     */
    @Autowired
    public DataSource(DatabaseProperties properties) {
        this(properties.getUsername(), properties.getPassword(), properties.getUrl());
    }

    /**
     * Creates a new {@link DataSource} instance with a connection to the specified PostgreSQL database.
     *
     * @param username the username used for authenticating the database connection
     * @param password the password corresponding to the username
     * @param url the jdbc url of the database
     */
    public DataSource(String username, String password, String url) {
        this.url = url;
        this.connection = getConnection(username, password, url);
    }

    /**
     * Establishes a connection to the specified database using the provided credentials.
     *
     * @param username the database username
     * @param password the database password
     * @param url the JDBC URL of the database (e.g., jdbc:postgresql://host:port/database)
     * @return a {@link java.sql.Connection} object representing the established connection
     * @throws RuntimeException if a database access error occurs
     */
    public static Connection getConnection(String username, String password, String url) {
        try {
            return DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
