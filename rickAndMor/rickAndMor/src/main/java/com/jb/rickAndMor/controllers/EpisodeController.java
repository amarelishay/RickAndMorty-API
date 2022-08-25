package com.jb.rickAndMor.controllers;

import com.jb.rickAndMor.Exeptions.RickAndMortyExceptions;
import com.jb.rickAndMor.Service.EpisodeService;
import com.jb.rickAndMor.beans.Episode;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/episode")
@RequiredArgsConstructor
public class EpisodeController {
    private final EpisodeService episodeService;

    @GetMapping("/{id}")
    public Episode getById(@PathVariable int id) throws RickAndMortyExceptions {
        return episodeService.getEpisodeById(id);
    }
    @GetMapping("/getfromapi/{id}")
    public Episode getByIdFromApi(@PathVariable int id) throws RickAndMortyExceptions {
        return episodeService.getEpisodeByIdFromapi(id);
    }
    @GetMapping
    public List<Episode> getEpisodes(){
        return episodeService.GetAllEpisodes();
    }
    @GetMapping("/getallfromapi")
    public List<Episode> getEpisodesFromApi(){
        return episodeService.findAllFromApi();
    }

}
