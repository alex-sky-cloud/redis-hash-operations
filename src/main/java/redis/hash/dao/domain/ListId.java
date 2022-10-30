package redis.hash.dao.domain;

import java.util.Objects;

public class ListId {

    String id;

    public ListId() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListId listId = (ListId) o;
        return Objects.equals(id, listId.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "ListId{" +
                "id='" + id + '\'' +
                '}';
    }
}
