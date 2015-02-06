/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librarysearch;

import java.util.ArrayList;

/**
 *
 * @author alprocto
 */
public class Songs {

    private ArrayList<String> title;
    private ArrayList<String> artist;
    private ArrayList<Integer> ID;
    private ArrayList<Integer> duration;

    public Songs() {
        this.ID = new ArrayList<Integer>();
        this.artist = new ArrayList<String>();
        this.title = new ArrayList<String>();
        this.duration = new ArrayList<Integer>();
    }

    public void addSong(int ID, String artist, String title, int duration) {
        this.ID.add((Integer) ID);
        this.title.add(title);
        this.artist.add(artist);
        this.duration.add((Integer) duration);
    }

//    public Songs(String titleSearch, String artistSearch){
//        
//    }
    public String getTitle(int index) {
        return title.get(index);
    }

    public String getArtist(int index) {
        return artist.get(index);
    }

    public int getID(int index) {
        return (int) ID.get(index);
    }

    public int getDuration(int index) {
        return (int) duration.get(index);
    }

    public int getLenght() {
        return title.size();
    }

    public String getDurationString(int index) {
        int songDuration = ((int) duration.get(index)/1000);
        if (songDuration >= (60 * 60)) {
            return Integer.toString(songDuration / (60 * 60)) + ":" + String.format("%02d",(songDuration % (60 * 60)) / 60) + ":" + String.format("%02d",songDuration % 60);
        } else {
            return Integer.toString(songDuration / 60) + ":" + String.format("%02d", songDuration % 60);
        }
    }
}
