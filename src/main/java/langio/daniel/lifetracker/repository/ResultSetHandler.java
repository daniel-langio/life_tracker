package langio.daniel.lifetracker.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@FunctionalInterface
public interface ResultSetHandler {
    /**
     * Handles {@link java.sql.ResultSet} from a {@link java.sql.Statement}
     *
     * Note: Must do ResultSet::next first
     * @param resultSet an instance of {@link java.sql.ResultSet}
     * @throws SQLException if an error occur on database query
     * @return amount of affected column
     * */
    Integer execute(ResultSet resultSet) throws SQLException;
}
