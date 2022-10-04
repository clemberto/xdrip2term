package com.eveningoutpost.dexdrip.services.broadcastservice.models;

import android.os.Bundle;

public class BroadcastModel {
    private Settings settings;
    private long statCacheTime = 0;
    private int statCacheHoursVal = 0;
    private Bundle statBundle;

    public BroadcastModel(Settings settings) {
        this.settings = settings;
    }

    public Bundle getStatBundle() {
        return statBundle;
    }

    public void setStatCache(Bundle statBundle, int statCacheHoursVal) {
        this.statBundle = statBundle;
        this.statCacheHoursVal = statCacheHoursVal;
        this.statCacheTime = 0;//JoH.tsl();
    }

    public Settings getSettings() {
        return settings;
    }

    public void setSettings(Settings settings) {
        this.settings = settings;
    }

    public long getStatCacheTime() {
        return statCacheTime;
    }

    public boolean isStatCacheValid(int statHoursVal) {
        return /*JoH.msSince(statCacheTime)*/0 < 60000 && statHoursVal == statCacheHoursVal && statBundle != null;
    }
}
