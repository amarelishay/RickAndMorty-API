package com.jb.rickAndMor.Service;

import com.jb.rickAndMor.Exeptions.CustomExceptions;
import com.jb.rickAndMor.Exeptions.RickAndMortyExceptions;
import com.jb.rickAndMor.beans.Character;
import com.jb.rickAndMor.beans.Episode;
import com.jb.rickAndMor.models.characters.CharacterResult;
import com.jb.rickAndMor.models.episodes.EpisodeResult;
import com.jb.rickAndMor.repos.CharacterRepository;
import com.jb.rickAndMor.repos.EpisodeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EpisodeServiceImpl implements EpisodeService {
    private final RestTemplate restTemplate;
    private final EpisodeRepository episodeRepository;
    private final CharacterRepository characterRepository;
    @Value("${open.rickandomrty.api.base.url}")
    private String webApi;


    @Override
    public Episode getEpisodeById(int id) throws RickAndMortyExceptions {
        return episodeRepository.findById(id).orElseThrow(() -> new RickAndMortyExceptions(CustomExceptions.DONE_EXISTS));
    }

    public Episode getEpisodeByIdFromapi(int id) {
        String url = webApi + "/" + id;
        EpisodeResult episodeResult = restTemplate.getForObject(url, EpisodeResult.class);
        Episode episode = Episode.builder().name(episodeResult.getName()).episodeId(episodeResult.getId()).build();
        List<Character> characters = new ArrayList<>();
        int i = 1;
        for (String charurl : episodeResult.characters) {
            CharacterResult characterResult = restTemplate.getForObject(charurl, CharacterResult.class);

            Character character = Character.builder().
                   name(characterResult.name).
                    species(characterResult.species).
                    status(characterResult.status).build();
            if (!characterRepository.existsByName(characterResult.name)) {
                characterRepository.save(character);
            }
            if (characterRepository.existsById(i)) {
                characters.add(characterRepository.findById(i).get());
            }
            i++;

        }
        episode.setCharacters(characters);
        episodeRepository.save(episode);
        return episode;
    }

    public List<Episode> findAllFromApi() {

        List<Episode> episodes = new ArrayList<>();
        int i = 1;
        boolean flag = true;
        while (flag) {
            try {
                Episode episode = getEpisodeByIdFromapi(i);
                episodes.add(episode);
                i++;
                if (i==8)
                    i++;
            } catch (Exception e) {
                flag = false;
            }


        }

        return episodes;
    }

    @Override
    public List<Episode> GetAllEpisodes() {
        return episodeRepository.findAll();
    }
}
