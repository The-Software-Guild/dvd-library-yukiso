package com.m3.c242.dto;


public class Dvd {

    private String title;
    private String date;
    private String mpaa;
    private String directorName;
    private String studio;
    private String userRatingNote;

    public Dvd(String title, String date, String mpaa, String directorName, String studio, String userRatingNote) {
        this.title = title;
        this.date = date;
        this.mpaa = mpaa;
        this.directorName = directorName;
        this.studio = studio;
        this.userRatingNote = userRatingNote;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMpaa() {
        return mpaa;
    }

    public void setMpaa(String mpaa) {
        this.mpaa = mpaa;
    }

    public String getDirectorName() {
        return directorName;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public String getUserRatingNote() {
        return userRatingNote;
    }

    public void setUserRatingNote(String userRatingNote) {
        this.userRatingNote = userRatingNote;
    }

    @Override
    public String toString() {
        return String.format("#%s(%s)\n\t%s\n\t%s\n\t%s\n\t%s",
                this.title,
                this.date,
                this.directorName,
                this.mpaa,
                this.studio,
                this.userRatingNote);
    }
}
