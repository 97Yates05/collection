package com.imooc.play;

import java.util.HashMap;
import java.util.Map;

public class PlayListCollection {
    private HashMap<String, PlayList> hashMap = new HashMap<>();

    /**
     * 无参构造
     */
    public PlayListCollection() {
    }

    /**
     * 多参构造
     *
     * @param hashMap
     */
    public PlayListCollection(HashMap hashMap) {
        this.hashMap = hashMap;
    }

    /**
     * 添加播放列表
     *
     * @param playList
     */
    public void addPlayList(PlayList playList) {
        this.getHashMap().put(playList.getPlayListName(), playList);
    }

    /**
     * 删除播放列表
     *
     * @param playList
     */
    public String deletePlayList(PlayList playList) {
        if(playList.getPlayListName().equals("主播放列表")){
            return "主播放列表无法删除！";
        }
        for (String str : this.getHashMap().keySet()) {
            if (str.equals(playList.getPlayListName())) {
                this.getHashMap().remove(str, this.getHashMap().get(str));
                return "删除成功>>>>>";
            }
        }
        return "该播放列表不存在或输入错误，无法删除！";


    }

    /**
     * 通过名字查询指定列表
     *
     * @return
     */
    public String searchPlayListByName(String playListName) {
        for (String str : this.getHashMap().keySet()) {
            if (str.equals(playListName)) {
                return "查询成功>>>>>" + '\n' + '<' + str + '>' + '\n' + this.getHashMap().get(str).toString();
            }
        }
        return "查询的播放列表不存在或输入有误，请检查输入是否正确！";
    }

    /**
     * 显示所有播放列表名称
     */
    public String displayPlayListName() {
        String str1 = "";
        for (String str : this.getHashMap().keySet()) {
            str1 = str1 + '<' + str + '>' + '\n' + this.getHashMap().get(str).toString();
        }
        return str1;


    }

    public HashMap<String, PlayList> getHashMap() {
        return hashMap;
    }

    public void setHashMap(HashMap hashMap) {
        this.hashMap = hashMap;
    }
}
