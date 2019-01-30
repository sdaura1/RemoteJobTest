package com.sani.shahid.remotejobtest;

import android.support.annotation.NonNull;

public class HallId {

    public String userID;

    public <T extends HallId> T withId(@NonNull final String id){
        this.userID = id;
        return (T) this;
    }
}
