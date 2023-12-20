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
public class Buildings {

    private Integer id;
    private String name;
    List<Floor> floors;



}
