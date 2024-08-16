package com.api.RoomService.controller;
import com.api.RoomService.dto.RoomDTO;
import com.api.RoomService.mapper;
import com.api.RoomService.model.Room;
import com.api.RoomService.service.RoomService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping
public class RoomController {

    private final RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }
    //GET METHODS

   @GetMapping("/room")
    public List<Room> getAllRooms (){
       return roomService.getAllRooms();
   }

   @GetMapping("/room/{id}")
    public ResponseEntity<RoomDTO> getRoomById (@PathVariable Long id){
        Optional<Room> room = roomService.getRoomById(id);
        if(room.isPresent()){
            RoomDTO roomdto = mapper.toDTO(room.get());
            return ResponseEntity.ok(roomdto);
        }else {
            return ResponseEntity.notFound().build();
        }
   }


    //POST METHODS

    @PostMapping("/room")
    public void createRoom (@RequestBody RoomDTO dto){
       if(dto != null) {
           roomService.createRoom(dto);
       }
    }

    //PUT METHODS

    @PutMapping("/room/{id}")
    public ResponseEntity<Room> updateRoomById(@PathVariable Long id , @RequestBody RoomDTO dto){
       return ResponseEntity.ok(roomService.updateRoomById(id, dto));
    }

    //DELETE METHODS

    @DeleteMapping("room/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
      roomService.deleteById(id);
      return ResponseEntity.noContent().build();
    }

}
