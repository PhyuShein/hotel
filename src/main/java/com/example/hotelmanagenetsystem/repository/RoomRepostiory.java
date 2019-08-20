package com.example.hotelmanagenetsystem.repository;

import com.example.hotelmanagenetsystem.model.Rooms;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepostiory extends JpaRepository<Rooms,Long> {
}
