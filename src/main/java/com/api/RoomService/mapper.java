package com.api.RoomService;

import com.api.RoomService.dto.RoomDTO;
import com.api.RoomService.model.Room;

public class mapper {

    public static RoomDTO toDTO(Room room) {
        return new RoomDTO(
                room.getId(),
                room.getRoomNumber(),
                room.getType(),
                room.getCapacity(),
                room.getPrice(),
                room.isAvaible()
        );
    }

    public static Room toEntity(RoomDTO dto) {
        return new Room(
                dto.id(),
                dto.RoomNumber(),
                dto.type(),
                dto.capacity(),
                dto.price(),
                dto.avaible()
        );
    }
}
