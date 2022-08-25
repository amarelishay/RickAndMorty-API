package com.jb.rickAndMor.Exeptions;

public class RickAndMortyExceptions extends Exception{
    private CustomExceptions customExceptions;
    public RickAndMortyExceptions(CustomExceptions customExceptions) {
        super(customExceptions.getMsg());
        this.customExceptions=customExceptions;
    }
}
