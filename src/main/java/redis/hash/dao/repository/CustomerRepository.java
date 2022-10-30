package redis.hash.dao.repository;


import redis.hash.dao.domain.ItemEntity;

import java.util.Map;

public interface CustomerRepository {


    void save(String key, ItemEntity itemEntity);

    ItemEntity find(String key, String id);

    Map<String, ItemEntity> findAll(String key);

    void update(String key, ItemEntity itemEntity);

    void delete(String key, String id);

}
