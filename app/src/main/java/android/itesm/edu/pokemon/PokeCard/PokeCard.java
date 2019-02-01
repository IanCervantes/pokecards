package android.itesm.edu.pokemon.PokeCard;

import java.io.Serializable;

public class PokeCard implements Serializable {
    private String id, name, imageUrl, author;

    public PokeCard(){

    }

    public PokeCard(String id, String name, String imageUrl, String author){
        this.id=id;
        this.name=name;
        this.imageUrl=imageUrl;
        this.author=author;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}

