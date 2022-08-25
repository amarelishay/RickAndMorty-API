package com.jb.rickAndMor.repos;

import com.jb.rickAndMor.beans.Character;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CharacterRepository extends JpaRepository<Character,Integer> {
boolean existsByName(String name);
}

