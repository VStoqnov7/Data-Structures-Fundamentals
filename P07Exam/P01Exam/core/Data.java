package P07Exam.P01Exam.core;

import P07Exam.P01Exam.interfaces.Entity;
import P07Exam.P01Exam.interfaces.Repository;

import java.util.*;

public class Data implements Repository {
    private Map<Integer, Entity> entities = new LinkedHashMap<>();
    private int mostRecentId = Integer.MIN_VALUE;


    @Override
    public void add(Entity entity) {
        entities.put(entity.getId(), entity);
        mostRecentId = Math.max(mostRecentId, entity.getId());
    }

    @Override
    public Entity getById(int id) {
        return entities.get(id);
    }

    @Override
    public List<Entity> getByParentId(int id) {
        List<Entity> result = new ArrayList<>();
        for (Entity entity : entities.values()) {
            if (entity.getParentId() == id) {
                result.add(entity);
            }
        }
        return result;
    }

    @Override
    public List<Entity> getAll() {
        return new ArrayList<>(entities.values());
    }

    @Override
    public Repository copy() {
        Data copyData = new Data();
        copyData.entities.putAll(this.entities);
        copyData.mostRecentId = this.mostRecentId;
        return copyData;
    }

    @Override
    public List<Entity> getAllByType(String type) {
        List<Entity> result = new ArrayList<>();
        for (Entity entity : entities.values()) {
            if (entity.getClass().getSimpleName().equals(type)) {
                result.add(entity);
            }
        }
        return result;
    }

    @Override
    public Entity peekMostRecent() {
        if (entities.isEmpty()) {
            throw new IllegalStateException("Operation on empty Data");
        }
        return entities.get(mostRecentId);
    }

    @Override
    public Entity pollMostRecent() {
        if (entities.isEmpty()) {
            throw new IllegalStateException("Operation on empty Data");
        }
        Entity mostRecentEntity = entities.get(mostRecentId);
        entities.remove(mostRecentId);
        if (!entities.isEmpty()) {
            mostRecentId = entities.keySet().stream().max(Integer::compareTo).orElse(Integer.MIN_VALUE);
        } else {
            mostRecentId = Integer.MIN_VALUE;
        }
        return mostRecentEntity;
    }

    @Override
    public int size() {
        return entities.size();
    }
}