package br.com.java.exploringrestwithspringboot.s5;

public class Greetins {
    private final long id;
    private final String content;

    public Greetins(long id, String content){
        this.id = id;
        this.content = content;
    }

    public long getId(){
        return this.id;
    }

    public String getContent(){
        return this.content;
    }

}
