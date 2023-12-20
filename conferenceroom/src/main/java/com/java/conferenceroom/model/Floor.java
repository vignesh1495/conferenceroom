package com.java.conferenceroom.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Floor {

    private Integer id;
    private Buildings buildings;
    private String name;
    private List<Room> rooms;



}
