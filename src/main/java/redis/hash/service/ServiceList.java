package redis.hash.service;

import redis.hash.dao.domain.ItemEntity;

import java.time.Instant;

public interface ServiceList {

    ItemEntity createList(String name, Instant publishDate);
}
