package com.jb.rickAndMor.Service;

import com.jb.rickAndMor.Exeptions.RickAndMortyExceptions;
import com.jb.rickAndMor.beans.Episode;

import java.util.List;

public interface EpisodeService {
    Episode getEpisodeById(int id) throws RickAndMortyExceptions;
    Episode getEpisodeByIdFromapi(int id);
    List<Episode> GetAllEpisodes();
    List<Episode> findAllFromApi();
}
