package com.adreeana.oneteam.domain;

import com.livedocumentation.Repository;

@Repository
public interface Teams {
    Team add(Team team);

    Team get(String name);
}
