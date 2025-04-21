package langio.daniel.lifetracker.repository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * Class containing basic DAO operations
 *
 * @param <T> Object for data representation
 */
@AllArgsConstructor
@Repository
public class BaseDAO<T> {

    private DataSource dataSource;

    /**
     * Perform a database update request.
     *
     * @param sql {@link String} containing a sql update request
     * @param parameters parameters for the request (replaces the "?" in the request)
     * @return the amount of affected column
     * */
    public Integer executeUpdate(String sql, List<Object> parameters) {
        try {
            PreparedStatement preparedStatement = getPreparedStatement(sql, parameters);

            return preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Perform a database query request.
     *
     * @param sql  {@link String} containing a sql SELECT request
     * @param parameters parameters for the request (replaces the "?" in the request)
     * @param resultSetHandler from a {@link java.sql.Statement}
     * @return the amount of affected column
     * */
    public Integer executeQuery(String sql, List<Object> parameters, ResultSetHandler resultSetHandler) {
        try {
            PreparedStatement preparedStatement = getPreparedStatement(sql, parameters);

            return resultSetHandler.execute(preparedStatement.executeQuery());

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Builds a {@link PreparedStatement}
     *
     * @param sql {@link String} containing the sql request
     * @param parameters parameters for the request (replaces the "?" in the request)
     * @throws SQLException if an sql error occur
     * @return {@link PreparedStatement}
     * */
    public PreparedStatement getPreparedStatement(String sql, List<Object> parameters) throws SQLException {
        PreparedStatement preparedStatement = dataSource.getConnection().prepareStatement(sql);

        for (int i = 0; i < parameters.size(); i++) {
            preparedStatement.setObject(i + 1, parameters.get(i));
        }

        return preparedStatement;
    }
}
