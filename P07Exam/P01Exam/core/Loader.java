package P07Exam.P01Exam.core;

import P07Exam.P01Exam.interfaces.Buffer;
import P07Exam.P01Exam.interfaces.Entity;
import P07Exam.P01Exam.model.BaseEntity;

import java.util.*;

public class Loader implements Buffer {
    private Map<Integer, Entity> entityMap = new LinkedHashMap<>();

    @Override
    public void add(Entity entity) {
        entityMap.put(entity.getId(), entity);
    }

    @Override
    public Entity extract(int id) {

        for (Entity entity : entityMap.values()) {
            if (entity.getId() == id) {
                entityMap.remove(entity.getId());
                return entity;
            }
        }
        return null;

    }

    @Override
    public Entity find(Entity entity) {
        if (!contains(entity)) {
            return null;
        }

        return entityMap.get(entity.getId());
    }

    @Override
    public boolean contains(Entity entity) {
        return entityMap.containsKey(entity.getId());

    }

    @Override
    public int entitiesCount() {
        return this.entityMap.values().size();
    }

    @Override
    public void replace(Entity oldEntity, Entity newEntity) {
        if (!contains(oldEntity)) {
            throw new IllegalStateException("Entity not found");
        }

        int entity = oldEntity.getId();

        entityMap.put(entity,newEntity);


    }

    @Override
    public void swap(Entity first, Entity second) {

        int firstId = first.getId();
        int secondId = second.getId();
        if (!entityMap.containsKey(firstId) || !entityMap.containsKey(secondId)) {
            throw new IllegalStateException("Entities not found");
        }
        entityMap.put(firstId, second);
        entityMap.put(secondId, first);

    }

    @Override
    public void clear() {
        this.entityMap.clear();
    }

    @Override
    public Entity[] toArray() {
        return this.entityMap.values().toArray(new Entity[0]);
    }

    @Override
    public List<Entity> retainAllFromTo(BaseEntity.Status lowerBound, BaseEntity.Status upperBound) {
        List<Entity> retainedEntities = new ArrayList<>();
        for (Entity entity : entityMap.values()) {
            if (entity.getStatus().compareTo(lowerBound) >= 0 && entity.getStatus().compareTo(upperBound) <= 0) {
                retainedEntities.add(entity);
            }
        }
        return retainedEntities;
    }

    @Override
    public List<Entity> getAll() {
        return new ArrayList<>(entityMap.values());
    }

    @Override
    public void updateAll(BaseEntity.Status oldStatus, BaseEntity.Status newStatus) {
        for (Entity entity : entityMap.values()) {
            if (entity.getStatus().equals(oldStatus)) {
                entity.setStatus(newStatus);
            }
        }
    }

    @Override
    public void removeSold() {
        List<Integer> toRemove = new ArrayList<>();
        for (Map.Entry<Integer, Entity> entry : entityMap.entrySet()) {
            if (entry.getValue().getStatus() == BaseEntity.Status.SOLD) {
                toRemove.add(entry.getKey());
            }
        }
        for (Integer id : toRemove) {
            entityMap.remove(id);
        }
    }

    @Override
    public Iterator<Entity> iterator() {
        return this.entityMap.values().iterator();
    }
}