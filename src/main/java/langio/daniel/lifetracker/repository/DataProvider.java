package langio.daniel.lifetracker.repository;

import org.springframework.stereotype.Repository;

/**
 * Base class for a Database Access Object
 *
 * @param <T> Object used for data representation
 * @param <I> type of the Object's identifier
 */
@Repository
public interface DataProvider<T, I> {

    /**
     * Provide an Object with the associated with its identifier from the database
     *
     * @param id the identifier of the Object in the database
     * @return Object with the database's data
     * */
    T get(I id);

    /**
     * Save an Object's data to the database
     *
     * @param entity the Object to add in the database
     * @return 1 if the addition succeeded, 0 otherwise
     * */
    Integer add(T entity);

    /**
     * Update an Object's associated data from the database
     *
     * @param entity the Object to update in the database
     * @return 1 if the update succeeded, 0 otherwise
     * */
    Integer update(T entity);

    /**
     * Save an Object to the database.
     * The Object is created if not exists, else it's updated.
     *
     * @param entity the Object representing the data to save
     * @return 1 if the Object didn't exist, 0 otherwise
     * */
    Integer save(T entity);

    /**
     * Delete data associated with an Object in the database by its identifier
     *
     * @param id the identifier of the Object
     * @return 1 if the deletion succeeded, 0 otherwise
     * */
    Integer delete(I id);

    /**
     * Check if an Object exist on the database
     *
     * @param id the identifier of the Object in the database
     * @return true if the Object exists, false otherwise
     * */
    Boolean isExists(I id);

}
