package model.api;

import java.util.Set;

/**
 * Factory Pattern for auomatically generated Entities, such as Zombies and Suns.
 */
public interface EntitiesFactory {
    /**
     * Generates an Entity.
     * 
     * @return the generated entity.
     */
    Entities createEntity();
    
    /**
     * Generates a Set of Entities.
     * Calls {@link #createEntity()} n times.
     * 
     * @param n number of entities to generate.
     * @return the generated set of entities.
     */
    Set<Entities> createEntities(int n);
}
