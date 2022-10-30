package redis.hash.dao.domain;


import java.io.Serializable;
import java.time.Instant;
import java.util.Map;
import java.util.Objects;

public class ItemEntity implements Serializable {

    private String id;

    private Map<ListId, String> urls;

    private Instant instant;

    public ItemEntity() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Map<ListId, String> getUrls() {
        return urls;
    }

    public void setUrls(Map<ListId, String> urls) {
        this.urls = urls;
    }

    public Instant getInstant() {
        return instant;
    }

    public void setInstant(Instant instant) {
        this.instant = instant;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemEntity that = (ItemEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(urls, that.urls) &&
                Objects.equals(instant, that.instant);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, urls, instant);
    }

    @Override
    public String toString() {
        return "ItemEntity{" +
                "id='" + id + '\'' +
                ", urls=" + urls +
                ", instant=" + instant +
                '}';
    }
}
