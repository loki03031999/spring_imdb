package com.spring.imdb.business.bean;

import java.util.Set;

public class TitleBean {
    public int titleId;
    public String titleName;
    public Set<GenreBean> genreSet;

    public int getTitleId() {
        return titleId;
    }

    public void setTitleId(int titleId) {
        this.titleId = titleId;
    }

    public String getTitleName() {
        return titleName;
    }

    public void setTitleName(String titleName) {
        this.titleName = titleName;
    }

    public Set<GenreBean> getGenreSet() {
        return genreSet;
    }

    public void setGenreSet(Set<GenreBean> genreSet) {
        this.genreSet = genreSet;
    }

    public String toString() {
        return titleId + titleName + genreSet;
    }
}
