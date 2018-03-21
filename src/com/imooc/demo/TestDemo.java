package com.imooc.demo;

import com.imooc.play.PlayList;
import com.imooc.play.PlayListCollection;
import com.imooc.song.Song;

import java.io.*;
import java.util.Scanner;

public class TestDemo {
    /**
     * 测试歌曲类
     */
    public void testSong() {
        Song song1 = new Song("s001", "let it go", "冰雪奇缘乐队");
        Song song2 = new Song("s002", "粉色的回忆", "唐人街乐队");
        Song song3 = new Song("s003", "都选c", "缝纫机乐队");

    }

    /**
     * 测试播放器类
     */
    public void testPlayList() {
        Song song1 = new Song("s001", "let it go", "冰雪奇缘乐队");
        Song song2 = new Song("s002", "粉色的回忆", "唐人街乐队");
        Song song3 = new Song("s003", "都选c", "缝纫机乐队");
        Song song4 = new Song("s003", "都选addas", "缝纫机乐队");
        PlayList playList = new PlayList("主播放列表");
        playList.addToPlayList(song1);
        playList.addToPlayList(song2);
        playList.addToPlayList(song3);
        playList.addToPlayList(song4);                          //测试插入重复歌曲
        playList.displayAllSong();                              //显示所有歌曲
        System.out.println("***********************************");
        System.out.println(playList.searchSongById("s001"));    //通过id搜索歌曲
        System.out.println("***********************************");
        System.out.println(playList.searchSongByName("letitgo"));  //通过名字搜索歌曲
        System.out.println("***********************************");
        System.out.println("删除后的列表:");
        System.out.println(playList.deleteSong("s002"));                         //删除歌曲
        playList.displayAllSong();
        System.out.println("***********************************");
        System.out.println(playList.deleteSong("s005"));     //删除不存在或输入错误id的歌曲
        System.out.println("***********************************");
        System.out.println("更新后的列表:");
        System.out.println(playList.updateSong(song4));                              //更新歌曲
        playList.displayAllSong();

    }

    /**
     * 测试播放器类
     */
    public void testPlayListCOllection() {
        Song song1 = new Song("s001", "let it go", "冰雪奇缘乐队");
        Song song2 = new Song("s002", "粉色的回忆", "唐人街乐队");
        Song song3 = new Song("s003", "都选c", "缝纫机乐队");
        PlayList playList = new PlayList("主播放列表");
        PlayList playList1 = new PlayList("喜爱的歌");
        PlayList playList2 = new PlayList();
        PlayListCollection playListCollection = new PlayListCollection();
        playListCollection.addPlayList(playList);                       //添加播放列表
        playListCollection.addPlayList(playList1);
        playList.addToPlayList(song1);
        playList.addToPlayList(song2);
        playList.addToPlayList(song3);
        playList1.addToPlayList(song1);
        playList1.addToPlayList(song2);
        playList1.addToPlayList(song3);
        System.out.println("***********************************");
        System.out.println(playListCollection.displayPlayListName());  //测试显示所有播放列表
        System.out.println("***********************************");
        System.out.println(playListCollection.deletePlayList(playList1));                  //删除指定播放列表
        System.out.println(playListCollection.displayPlayListName());
        System.out.println("***********************************");
        System.out.println(playListCollection.searchPlayListByName("主播放列"));   //通过名字查询播放列表

    }

    /**
     * 主菜单
     */
    public void mainMenu() {
        System.out.println("\t*********************");
        System.out.println("\t*\t\t 主菜单\t\t*");
        System.out.println("\t*\t1-播放列表管理\t*");
        System.out.println("\t*\t2-播放器管理\t\t*");
        System.out.println("\t*\t0-退出\t\t\t*");
        System.out.println("\t*********************");
        System.out.println("请输入对应数字进行操作:");

    }

    /**
     * 播放器列表管理菜单
     */
    public void playListMenu() {
        System.out.println("\t*****************************");
        System.out.println("\t*\t\t 播放列表管理\t\t\t*");
        System.out.println("\t*\t1-将歌曲添加到主播放列表\t*");
        System.out.println("\t*\t2-将歌曲添加到普通播放列表\t*");
        System.out.println("\t*\t3-通过歌曲id检索列表\t\t*");
        System.out.println("\t*\t4-通过歌曲名称检索列表\t\t*");
        System.out.println("\t*\t5-修改播放列表中的歌曲\t\t*");
        System.out.println("\t*\t6-删除播放列表中的歌曲\t\t*");
        System.out.println("\t*\t7-显示列表中的所有歌曲\t\t*");
        System.out.println("\t*\t8-导出歌单\t\t\t\t*");
        System.out.println("\t*\t9-返回上一级菜单\t\t\t*");
        System.out.println("\t*****************************");
        System.out.println("请输入对应数字对播放列表进行管理:");

    }

    /**
     * 播放器菜单
     */
    public void playerMenu() {
        System.out.println("\t*****************************");
        System.out.println("\t*\t\t 播放器管理\t\t\t*");
        System.out.println("\t*\t1-向播放器添加播放列表\t\t*");
        System.out.println("\t*\t2-从播放器中删除播放列表\t*");
        System.out.println("\t*\t3-通过列表名称查询列表信息\t*");
        System.out.println("\t*\t4-显示所有播放列表名称\t\t*");
        System.out.println("\t*\t9-返回上一级菜单\t\t\t*");
        System.out.println("\t*****************************");
        System.out.println("请输入对应数字对播放器进行管理:");

    }

    /**
     * 方法用于判断用户输入类型是否为int型数据
     *
     * @return一个int类型的数据
     */
    public int judge() {
        int a = 2;
        Scanner aa = new Scanner(System.in);
        while (true) {

            try {
                a = aa.nextInt();
                break;
            } catch (java.util.InputMismatchException e) {
                System.out.println("异常警告：请不要输入非int类型的数据！！！");
                aa.next();

            }
        }

        return a;
    }

    /**
     * 输入字符串的方法
     *
     * @return
     */
    public String input() {
        String str = "";
        Scanner scanner = new Scanner(System.in);
        str = scanner.next();
        return str;
    }

    /**
     * 主流程实现
     */
    public void test() {
        int a = 0;              //存放用户输入的数字
        String str = "";        //存放用户输入的歌曲id
        String str1 = "";       //存放用户输入的歌曲名称
        String str2 = "";       //存放用户输入的演唱者
        String str3 = "";       //存放用户输入的播放列表名称
        TestDemo testDemo = new TestDemo();
        PlayList playList = new PlayList("主播放列表");
        PlayListCollection playListCollection = new PlayListCollection();
        playListCollection.addPlayList(playList);
        while (true) {
            while (true) {
                testDemo.mainMenu();
                a = testDemo.judge();
                if (a < 0 || a > 2) {
                    System.out.println("请重新输入（提示:0～2）");
                } else {
                    break;
                }
            }
            if (a == 0) {
                System.out.println("退出程序！");
                return;
            }
            switch (a) {
                case 1:
                    while (true) {
                        testDemo.playListMenu();
                        while (true) {
                            a = testDemo.judge();
                            if (a < 1 || a > 9) {
                                System.out.println("请重新输入（提示:0～9）");
                            } else {
                                break;
                            }
                        }
                        if (a == 9) {
                            break;
                        }
                        switch (a) {
                            case 1:
                                System.out.println("将歌曲添加到主播放列表>>>>>");
                                System.out.println("请输入要添加的歌曲数量:");
                                while (true) {
                                    a = testDemo.judge();
                                    if (a < 1) {
                                        System.out.println("请重新输入(提示:大于等于1");
                                    } else {
                                        break;
                                    }
                                }
                                for (int i = 1; i <= a; i++) {
                                    System.out.println("请输入第" + i + "首歌曲>>>>>");
                                    System.out.println("歌曲id为（注意:歌曲id具有唯一性，一旦填入无法修改！）:");
                                    str = testDemo.input();
                                    if (playList.getMusicList().contains(new Song(str))) {
                                        System.out.println("此id已存在，请重新输入！");
                                        i--;
                                        continue;
                                    }
                                    System.out.println("歌曲名称为:");
                                    str1 = testDemo.input();
                                    System.out.println("演唱者为:");
                                    str2 = testDemo.input();
                                    playList.addToPlayList(new Song(str, str1, str2));


                                }
                                System.out.println("已成功添加歌曲到主播放列表！");
                                break;
                            case 2:
                                System.out.println("将歌曲添加到普通播放列表>>>>>");
                                System.out.println("请输入要添加的播放列表名称:(提示:已创建的播放列表有"
                                        + playListCollection.getHashMap().keySet() + ')');
                                str3 = testDemo.input();
                                if (!playListCollection.getHashMap().containsKey(str3)) {
                                    System.out.println("该播放列表不存在或输入错误，请先将播放列表添加到播放器中！");
                                    break;
                                } else if (str3.equals("主播放列表")) {
                                    System.out.println("添加歌曲到主播放列表请输入1！");
                                    break;
                                }
                                System.out.println("请输入要添加的歌曲数量:");
                                while (true) {
                                    a = testDemo.judge();
                                    if (a < 1) {
                                        System.out.println("请重新输入(提示:大于等于1");
                                    } else {
                                        break;
                                    }
                                }
                                for (int i = 1; i <= a; i++) {
                                    System.out.println("请输入第" + i + "首歌曲>>>>>");
                                    System.out.println("歌曲id为（注意:歌曲id具有唯一性，一旦填入无法修改！）:");
                                    str = testDemo.input();
                                    if (playList.getMusicList().contains(new Song(str))) {
                                        System.out.println("此歌曲在主播放列表中已存在，已自动将其添加到" + str + "列表中！");
                                        for (Song song : playList.getMusicList()) {
                                            if (song.getId().equals(str)) {
                                                playListCollection.getHashMap().get(str3).addToPlayList(song);
                                            }
                                        }
                                        break;
                                    }
                                    System.out.println("歌曲名称为:");
                                    str1 = testDemo.input();
                                    System.out.println("演唱者为:");
                                    str2 = testDemo.input();
                                    playList.addToPlayList(new Song(str, str1, str2));
                                    playListCollection.getHashMap().get(str3).addToPlayList(new Song(str, str1, str2));
                                    System.out.println("已成功添加歌曲到主播放列表和" + str3 + "列表中！");

                                }

                                break;
                            case 3:
                                System.out.println("请输入要查询的播放列表名称:(提示:已创建的播放列表有"
                                        + playListCollection.getHashMap().keySet() + ')');
                                str3 = testDemo.input();
                                if (playListCollection.getHashMap().keySet().contains(str3)) {
                                    System.out.println("请输入歌曲id:");
                                    str = testDemo.input();
                                    System.out.println(playListCollection.getHashMap().get(str3).searchSongById(str));
                                } else {
                                    System.out.println("该播放列表不存在或输入错误！");
                                }
                                break;
                            case 4:
                                System.out.println("请输入要查询的播放列表名称:(提示:已创建的播放列表有"
                                        + playListCollection.getHashMap().keySet() + ')');
                                str3 = testDemo.input();
                                if (playListCollection.getHashMap().keySet().contains(str3)) {
                                    System.out.println("请输入歌曲名称:");
                                    str = testDemo.input();
                                    System.out.println(playListCollection.getHashMap().get(str3).searchSongByName(str));
                                } else {
                                    System.out.println("该播放列表不存在或输入错误！");
                                }
                                break;
                            case 5:
                                boolean flag = false;
                                System.out.println("修改播放列表中的歌曲>>>>>");
                                System.out.println("请输入要修改的歌曲id:");
                                str = testDemo.input();
                                for (Song song : playList.getMusicList()) {
                                    if (song.getId().equals(str)) {
                                        flag = true;
                                        System.out.println("请输入修改后的歌曲名称:");
                                        str1 = testDemo.input();
                                        System.out.println("请输入修改后的演唱者:");
                                        str2 = testDemo.input();
                                        for (PlayList playList1 : playListCollection.getHashMap().values()) {
                                            System.out.println(playList1.updateSong(new Song(str, str1, str2)));
                                        }

                                    }

                                }
                                if (!flag) {
                                    System.out.println("指定歌曲不存在或id输入错误！");
                                }
                                break;
                            case 6:
                                System.out.println("删除播放列表中的歌曲>>>>>");
                                System.out.println("请输入要删除的歌曲所在播放列表名称:(提示:已创建的播放列表有"
                                        + playListCollection.getHashMap().keySet() + ')');
                                str3 = testDemo.input();
                                if (!playListCollection.getHashMap().containsKey(str3)) {
                                    System.out.println("该播放列表不存在或输入错误，请先将播放列表添加到播放器中！");
                                    break;
                                }
                                if (str3.equals("主播放列表")) {
                                    System.out.println("<注意:删除主播放列表中的歌曲时，其他播放列表中该歌曲将会一并删除>");
                                    System.out.println("请输入要删除的歌曲id:");
                                    str = testDemo.input();
                                    for (PlayList playList1 : playListCollection.getHashMap().values()) {
                                        System.out.println(playList1.deleteSong(str));
                                    }
                                    break;
                                } else {
                                    System.out.println("请输入要删除的歌曲id:");
                                    str = testDemo.input();
                                    System.out.println(playListCollection.getHashMap().get(str3).deleteSong(str));
                                }


                                break;
                            case 7:
                                System.out.println("显示播放列表中的所有歌曲>>>>>");
                                System.out.println("");
                                System.out.println("请输入要显示的播放列表名称:(提示:已创建的播放列表有"
                                        + playListCollection.getHashMap().keySet() + ')');
                                str3 = testDemo.input();
                                if (playListCollection.getHashMap().keySet().contains(str3)) {
                                    playListCollection.getHashMap().get(str3).displayAllSong();
                                } else {
                                    System.out.println("该播放列表不存在或输入错误！");
                                }
                                break;
                            case 8:
                                System.out.println("请输入要导出的歌单的播放列表名称:(提示:已创建的播放列表有"
                                        + playListCollection.getHashMap().keySet() + ')');
                                str3 = testDemo.input();
                                if (!playListCollection.getHashMap().keySet().contains(str3)) {
                                    System.out.println("播放列表不存在或名称输入错误");
                                    break;
                                }
                                playListCollection.getHashMap().get(str3).exportPlayList();
                                System.out.println("导出歌单成功！");
                                break;

                        }
                    }
                    break;
                case 2:
                    while (true) {
                        testDemo.playerMenu();
                        while (true) {
                            a = testDemo.judge();
                            if (a < 1 || a > 4 && a != 9) {
                                System.out.println("请重新输入（提示:0～9）");
                            } else {
                                break;
                            }
                        }
                        if (a == 9) {
                            break;
                        }
                        switch (a) {
                            case 1:
                                System.out.println("向播放器添加列表>>>>>");
                                System.out.println("请输入要添加的播放列表名称:");
                                str3 = testDemo.input();
                                playListCollection.addPlayList(new PlayList(str3));
                                break;
                            case 2:
                                System.out.println("从播放器删除播放列表>>>>>");
                                System.out.println("请输入删除的播放列表名称:");
                                str3 = testDemo.input();
                                System.out.println(playListCollection.deletePlayList(new PlayList(str3)));
                                break;
                            case 3:
                                System.out.println("通过名称查询列表信息>>>>>");
                                System.out.println("请输入要查询的播放列表名称:(提示:已创建的播放列表有"
                                        + playListCollection.getHashMap().keySet());
                                str3 = testDemo.input();
                                System.out.println(playListCollection.searchPlayListByName(str3));
                                break;
                            case 4:
                                System.out.println("显示所有播放列表名称>>>>>");
                                System.out.println(playListCollection.displayPlayListName());
                                break;
                        }

                    }
                    break;
            }


        }
    }

    public static void main(String[] args) {
        new TestDemo().test();
//        ObjectInputStream ois;                  //导入歌单并显示
//        try {
//            ois = new ObjectInputStream(new FileInputStream("歌单.txt"));
//            while (true) {
//                System.out.println(ois.readObject());
//            }
//        } catch (EOFException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}
