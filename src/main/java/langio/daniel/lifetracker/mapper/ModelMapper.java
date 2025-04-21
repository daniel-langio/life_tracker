package langio.daniel.lifetracker.mapper;

import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.util.List;

/**
 * Model mapper
 *
 * @param <T> the Class of the Model
 */
@Component
public interface ModelMapper<T> {

    /**
     * Create an Object from {@link java.sql.ResultSet}'s data.
     *
     * @param rs {@link java.sql.ResultSet} from a {@link java.sql.Statement} which query an Object's data
     * @return Object with data from database
     */
    T toModel(ResultSet rs);

    /**
     * Extract the Object's properties
     *
     * @param entity Object to extract properties from
     * @return list of the Object's properties with a specific order
     * */
    List<Object> toParams(T entity);
}
