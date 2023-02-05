package bg.books.model.DTOs;

import bg.books.model.entity.AuthorEntity;

public class AuthorDTO {

    private String name;

    public AuthorDTO(){}

    public AuthorDTO(AuthorEntity author){
        this.name = author.getName();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
