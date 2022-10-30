package redis.hash.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.hash.dao.domain.ItemEntity;
import redis.hash.dao.domain.ListId;
import redis.hash.dao.repository.CustomerRepository;
import redis.hash.service.ServiceList;

import java.time.Instant;

@Service
public class ServiceListImpl implements ServiceList {

    private CustomerRepository repository;

    @Autowired
    public ServiceListImpl(CustomerRepository repository) {
        this.repository = repository;
    }

    @Override
    public ItemEntity createList(String name, Instant publishDate) {

        ListId listId = new ListId();
        listId.setId(name);


        ItemEntity itemEntity = new ItemEntity();

        String id = name.substring(3);

        String key = name.substring(0, name.length() - 1);

        itemEntity.setId(id);
        itemEntity.setInstant(publishDate);

        repository.save(key, itemEntity);

        return itemEntity;

    }


}
