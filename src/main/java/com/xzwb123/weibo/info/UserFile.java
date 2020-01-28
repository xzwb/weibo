package com.xzwb123.weibo.info;

import java.sql.Blob;
import java.sql.Date;
import java.sql.Time;

public class UserFile {
    private int uid;
    private int fid;
    private String uname;
    private String txt;
    private Date date;
    private Time time;
    private Blob blob;

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getFid() {
        return fid;
    }

    public void setFid(int fid) {
        this.fid = fid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getTxt() {
        return txt;
    }

    public void setTxt(String txt) {
        this.txt = txt;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public Blob getBlob() {
        return blob;
    }

    public void setBlob(Blob blob) {
        this.blob = blob;
    }
}
