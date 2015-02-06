/*
 * Copyright (C) 2015 alprocto
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
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
