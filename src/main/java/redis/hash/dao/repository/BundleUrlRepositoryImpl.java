package redis.hash.dao.repository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import redis.hash.dao.domain.ItemEntity;

import javax.annotation.PostConstruct;
import java.util.Map;

@Repository
@Transactional
public class BundleUrlRepositoryImpl implements CustomerRepository {


    private HashOperations<String, String, ItemEntity> hashOperations;

    private RedisTemplate<String, Object> redisTemplate;

    @Autowired
    public BundleUrlRepositoryImpl(RedisTemplate <String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @PostConstruct
    private void init() {
        hashOperations = redisTemplate.opsForHash();
    }

    @Override
    public void save(String key, ItemEntity itemEntity) {

        hashOperations.put(key, itemEntity.getId(), itemEntity);
    }


    @Override
    public ItemEntity find(String key, String id) {

        ItemEntity itemEntity = hashOperations.get(key, id);

        return itemEntity;
    }


    @Override
    public Map<String, ItemEntity> findAll(String key) {

        Map<String, ItemEntity> entries = hashOperations.entries(key);

        return entries;
    }

    @Override
    public void update(String key, ItemEntity itemEntity) {

        hashOperations.put(key, itemEntity.getId(), itemEntity);
    }



    @Override
    public void delete(String key, String id) {
        hashOperations.delete(key, id);
    }


}
