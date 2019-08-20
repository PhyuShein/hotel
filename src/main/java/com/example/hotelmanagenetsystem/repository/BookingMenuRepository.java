package com.example.hotelmanagenetsystem.repository;

import com.example.hotelmanagenetsystem.model.BookingMenu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingMenuRepository extends JpaRepository<BookingMenu,Long> {
}
