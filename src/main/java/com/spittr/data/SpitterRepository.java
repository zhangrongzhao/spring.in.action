package com.spittr.data;

import com.spittr.model.Spitter;

public interface SpitterRepository {
    Spitter save(Spitter spitter);
    Spitter findByUserName(String userName);
}
