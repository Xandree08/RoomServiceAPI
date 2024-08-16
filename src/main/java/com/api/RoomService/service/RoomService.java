package com.api.RoomService.service;

import com.api.RoomService.dto.RoomDTO;
import com.api.RoomService.mapper;
import com.api.RoomService.model.Room;
import com.api.RoomService.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomService {

    private final RoomRepository roomRepository;

    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    // GET METHODS
    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    public Optional<Room> getRoomById(Long id) {
        return roomRepository.findById(id);
    }


    //POST METHODS
    public void createRoom(RoomDTO dto) {
        if (dto != null) {
            roomRepository.save(mapper.toEntity(dto));
        }
    }

    //PUT METHODS
    public Room updateRoomById(Long id, RoomDTO dto) {
        Room room = roomRepository.findById(id).orElseThrow();
        room.setId(dto.id());
        room.setRoomNumber(dto.RoomNumber());
        room.setAvaible(dto.avaible());
        room.setType(dto.type());
        room.setPrice(dto.price());
        room.setCapacity(dto.capacity());
        return roomRepository.save(room);
    }



    //DELETE METHODS

    public void deleteById(Long id){
       roomRepository.deleteById(id);
    }



}
