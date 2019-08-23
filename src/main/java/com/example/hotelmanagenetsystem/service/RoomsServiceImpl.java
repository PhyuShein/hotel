package com.example.hotelmanagenetsystem.service;

import com.example.hotelmanagenetsystem.model.Rooms;
import com.example.hotelmanagenetsystem.repository.RoomRepostiory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RoomsServiceImpl implements RoomService {

    private final RoomRepostiory roomRepostiory;

    public RoomsServiceImpl(RoomRepostiory roomRepostiory) {
        this.roomRepostiory = roomRepostiory;
    }

    @Override
    public Rooms create(Rooms rooms) {
        return this.roomRepostiory.save(rooms);
    }

    @Override
    public Rooms findById(long id) {
        return this.roomRepostiory.findById(id).orElse(null);
    }

    @Override
    public List<Rooms> findAll() {
        return this.roomRepostiory.findAll();
    }

    @Override
    public void delete(long id) {
        roomRepostiory.deleteById(id);
    }

    @Override
    @Transactional
    public Rooms update(long id, Rooms rooms) {
        Rooms oldRomm = findById(id);
        oldRomm.setRoomStatus(rooms.getRoomStatus());
        oldRomm.setRoomType(rooms.getRoomType());
        return rooms;
    }

    @Override
    public Rooms findByRommsNumber(String roomNumber) {
        return roomRepostiory.findByRoomsNumber(roomNumber).orElse(null);
    }
}
