package org.wanderin.data;

public class User {
    private String username = null;
    private int uid = 0;
    public User(String username, int uid) {
        this.username = username;
        this.uid = uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getUid() {
        return uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
