package com.navin.joblisting_backend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import jakarta.validation.constraints.NotBlank;
import java.util.List;

@Document(collection = "JobPost")
public class Post {

    @Id
    private String id;

    @NotBlank(message = "Profile is mandatory")
    private String profile;

    @NotBlank(message = "Description is mandatory")
    private String desc;

    private int exp;

    private List<String> techs;

    public Post() {
    }

    public Post(String id, String profile, String desc, int exp, List<String> techs) {
        this.id = id;
        this.profile = profile;
        this.desc = desc;
        this.exp = exp;
        this.techs = techs;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public List<String> getTechs() {
        return techs;
    }

    public void setTechs(List<String> techs) {
        this.techs = techs;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id='" + id + '\'' +
                ", profile='" + profile + '\'' +
                ", desc='" + desc + '\'' +
                ", exp=" + exp +
                ", techs=" + techs +
                '}';
    }
}
