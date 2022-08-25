package com.jb.rickAndMor.models.episodes;
import lombok.Data;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
@Data
public class EpisodeResult{
    public int id;
    public String name;
    public String air_date;
    public String episode;
    public ArrayList<String> characters;
    public String url;
    public Date created;
}
