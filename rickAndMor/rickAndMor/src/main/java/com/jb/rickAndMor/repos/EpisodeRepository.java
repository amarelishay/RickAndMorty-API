package com.jb.rickAndMor.repos;

import com.jb.rickAndMor.beans.Episode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EpisodeRepository extends JpaRepository<Episode,Integer> {

}
