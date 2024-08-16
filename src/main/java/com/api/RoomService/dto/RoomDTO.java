package com.api.RoomService.dto;

public record RoomDTO(
        Long id,
        String RoomNumber,
        String type,
        int capacity,
        double price,
        boolean avaible
) {
    public RoomDTO(Long id, String RoomNumber, String type, int capacity, double price, boolean avaible) {
        this.id = id;
        this.RoomNumber = RoomNumber;
        this.type = type;
        this.capacity = capacity;
        this.price = price;
        this.avaible = avaible;
    }
}
