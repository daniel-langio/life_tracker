package langio.daniel.lifetracker.mapper;

import java.util.List;

/**
 * DTO Mapper
 *
 * @param <R> the DTO class
 * @param <T> the Model class
 * */
public interface DTOMapper<R, T> {
    /**
     * Converts a list of DTO into a list of Object
     *
     * @param DTOs the list of the DTOs to convert
     * @return list of Object from DTOs conversion
     * */
    List<T> toModels(List<R> DTOs);

    /**
     * Converts a list of an Object into a list of its DTO
     *
     * @param entities list of the Objects to converts
     * @return list of the Object's DTOs
     * */
    List<R> toDTOs(List<T> entities);

    /**
     * Creates an Object from a DTO
     *
     * @param dto the DTO to convert
     * @return Object with the DTO's values
     * */
    public T toModel(R dto);

    /**
     * Creates an Object from its DTO
     *
     * @param entity the Object to convert
     * @return DTO with the Object values
     * */
    R toDTO(T entity);
}
