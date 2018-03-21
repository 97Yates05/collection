package com.imooc.play;


import com.imooc.song.Song;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class PlayList {
    private String playListName;
    private List<Song> musicList = new ArrayList<>();

    public PlayList() {
    }

    public PlayList(String playListName) {
        this.setPlayListName(playListName);
    }

    @Override
    public String toString() {
        String str = "";
        for (Song song : this.getMusicList()) {
            str = str + song.toString() + '\n';
        }
        return ("播放列表中的所有歌曲为:\n" + str);
    }

    /**
     * 添加指定歌曲
     *
     * @param song
     */
    public void addToPlayList(Song song) {

        this.getMusicList().add(song);


    }

    /**
     * 显示播放列表中的所有歌曲
     */
    public void displayAllSong() {
        System.out.println("<"+this.getPlayListName()+">"+'\n'+this);

    }

    /**
     * 通过id查询歌曲
     *
     * @param id
     * @return
     */
    public String searchSongById(String id) {
        for (Song song : this.getMusicList()) {
            if (song.getId().equals(id)) {
                return "查询歌曲已找到>>>>>\n" + song.toString();
            }
        }
        return "指定歌曲在播放列表" + this.getPlayListName() + "中不存在或输入id错误！";
    }

    /**
     * 通过名字查询歌曲
     *
     * @param name
     * @return
     */
    public String searchSongByName(String name) {
        for (Song song : this.getMusicList()) {
            if (song.getName().replaceAll(" ", "").equals(name.replaceAll(" ", ""))) {
                return "查询歌曲已找到>>>>>\n" + song.toString();
            }
        }
        return "指定歌曲在播放列表" + this.getPlayListName() + "中不存在或输入名称错误！";
    }

    /**
     * 更新指定歌曲
     *
     * @param song
     */
    public String updateSong(Song song) {
        for (int i = 0; i <this.getMusicList().size() ; i++) {
            if(this.getMusicList().get(i).getId().equals(song.getId())){
                this.getMusicList().set(i,song);
                return this.getPlayListName() +">>>>>更新成功";
            }

        }
        return "";

    }

    /**
     * 删除指定歌曲
     *
     * @param id
     * @return
     */
    public String deleteSong(String id) {
        for (Song s : this.getMusicList()) {
            if (s.getId().equals(id)) {
                this.getMusicList().remove(s);
                return this.getPlayListName()  + ">>>>>指定歌曲已删除";
            }
        }
        return "指定歌曲不存在或输入错误！";
    }

    /**
     * 导出歌单
     */
    public void exportPlayList() {
        String str = this.getPlayListName();
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(str+".txt"));
            for (Song song : this.getMusicList()) {
                oos.writeObject(song);
            }
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public String getPlayListName() {
        return playListName;
    }

    public void setPlayListName(String playListName) {
        this.playListName = playListName;
    }

    public List<Song> getMusicList() {
        return musicList;
    }

    public void setMusicList(ArrayList<Song> musicList) {
        this.musicList = musicList;
    }
}
