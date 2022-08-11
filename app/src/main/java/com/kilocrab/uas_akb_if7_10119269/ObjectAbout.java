package com.kilocrab.uas_akb_if7_10119269;

//10119269, Zuhair Rasyid Wafi, IF7

import java.util.ArrayList;

public class ObjectAbout {

    int ivObject;
    String txTips;

    public ObjectAbout(int ivObject, String txTips) {
        this.ivObject = ivObject;
        this.txTips = txTips;
    }

    public static ArrayList<ObjectAbout> createData() {
        ArrayList<ObjectAbout> justObject = new ArrayList<>();
        justObject.add(new ObjectAbout(R.drawable.write,"Write your notes with floating button"));
        justObject.add(new ObjectAbout(R.drawable.easy,"Edit or delete your notes with just click the title"));
        justObject.add(new ObjectAbout(R.drawable.free,"The best of all, this app is free :D"));
        return justObject;
    }
}
