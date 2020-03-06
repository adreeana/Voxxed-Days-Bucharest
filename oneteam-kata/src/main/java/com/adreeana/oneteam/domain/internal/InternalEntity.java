package com.adreeana.oneteam.domain.internal;

import java.util.Objects;

public abstract class InternalEntity {
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InternalEntity internalEntity = (InternalEntity) o;
        return Objects.equals(id, internalEntity.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
