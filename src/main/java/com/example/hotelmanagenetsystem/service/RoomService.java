package com.example.hotelmanagenetsystem.service;

import com.example.hotelmanagenetsystem.model.Rooms;

import java.util.List;

public interface RoomService {

    Rooms create(Rooms rooms);
    Rooms findById(long id);
    List<Rooms> findAll();
}
