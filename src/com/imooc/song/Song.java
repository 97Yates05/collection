package com.imooc.song;

import java.io.Serializable;
import java.util.Objects;

public class Song implements Serializable{
    private String id;
    private String name;
    private String singer;

    /**
     * 无参构造
     */
    public Song() {
    }

    /**
     * 单参构造
     * @param id
     */
    public Song(String id){
        this.setId(id);
    }

    /**
     * 多参构造
     * @param id
     * @param name
     * @param singer
     */
    public Song(String id, String name, String singer) {
        this.setId(id);
        this.setName(name);
        this.setSinger(singer);
    }

    /**
     * 重写equals方法
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Song song = (Song) o;
        return Objects.equals(id, song.id) ;
//                &&
//                Objects.equals(name, song.name) &&
//                Objects.equals(singer, song.singer);
    }

    /**
     * 重写hashcode方法
     * @return
     */

    @Override
    public int hashCode() {

        return Objects.hash(id,name,singer);
    }

    /**
     * 重写toString方法
     * @return一个含有歌曲信息的字符串
     */
    @Override
    public String toString() {
        String str="歌曲信息: [歌曲id为:" + this.getId() + ", 歌曲名称为:" +this.getName()+", 演唱者为:"+this.getSinger()+"]";
        return str;
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

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }
}
