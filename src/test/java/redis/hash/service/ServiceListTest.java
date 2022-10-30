package redis.hash.service;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import redis.hash.dao.domain.ItemEntity;
import redis.hash.dao.domain.ListId;
import redis.hash.dao.repository.CustomerRepository;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class ServiceListTest {

    @Autowired
    private CustomerRepository repository;

    @Autowired
    private ServiceList serviceList;

    @Test
    void createList() {

        Instant instant = getInstant();

        String key = "PL-2";

        ItemEntity itemEntity = repository.find("PL-", "1");
        Map<String, ItemEntity> all = repository.findAll("PL-");

        Map<ListId, String> urls = itemEntity.getUrls();

        System.out.println(itemEntity);
         /* if(entitySet.size() == 0)
            throw new PublishListException("PublishListId : " + key + " - is exists already");*/

        serviceList.createList(key, instant);
    }

    private Instant getInstant() {

        String dateStr = "11:01 1 января 2021 года";

        DateTimeFormatter dateTimeFormatter =
                DateTimeFormatter.ofPattern("H:m d MMMM yyyy года");

        LocalDateTime localDateTime = LocalDateTime.parse(dateStr, dateTimeFormatter);

        Instant instant = localDateTime.toInstant(ZoneOffset.UTC);

        return instant;
    }
}