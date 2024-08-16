package com.api.RoomService.repository;

import com.api.RoomService.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RoomRepository extends JpaRepository<Room,Long> {
}
