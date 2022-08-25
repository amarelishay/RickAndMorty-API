package com.jb.rickAndMor.beans;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity()
@Table(name = "characters")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Character {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int charid;
    @Column(length = 40)
    private String name;
    private String status;
    private String species;
}
