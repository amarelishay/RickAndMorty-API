package com.jb.rickAndMor.models.characters;
import java.sql.Date;
import java.util.ArrayList;

public class CharacterResult {
    public int id;
    public String name;
    public String status;
    public String species;
    public String type;
    public String gender;
    public Origin origin;
    public Location location;
    public String image;
    public ArrayList<String> episode;
    public String url;
    public Date created;
}
