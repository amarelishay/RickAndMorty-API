package com.jb.rickAndMor.beans;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "episodes")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Episode {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;

    private int episodeId;
    @Column(length = 40)
    private String name;
    @ManyToMany(fetch = FetchType.LAZY)
    @Singular
    private List<Character> characters = new ArrayList<>();


}
