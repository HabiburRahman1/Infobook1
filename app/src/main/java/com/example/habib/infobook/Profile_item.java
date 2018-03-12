package com.example.habib.infobook;

/**
 * Created by Habib on 8/25/17.
 */

public class Profile_item {

    public String uid;
    public String email;
    public String firebaseToken;
    public Profile_item(){

    }

    public Profile_item(String uid, String email, String firebaseToken){
        this.uid = uid;
        this.email = email;
        this.firebaseToken = firebaseToken;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFirebaseToken(String firebaseToken) {
        this.firebaseToken = firebaseToken;
    }

    public String getUid() {
        return uid;
    }

    public String getEmail() {
        return email;
    }

    public String getFirebaseToken() {
        return firebaseToken;
    }
}
