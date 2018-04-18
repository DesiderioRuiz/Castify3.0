/*
 * Copyright (C) 2016 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.sample.cast.refplayer.browser;

import com.google.gson.Gson;
import com.google.sample.cast.refplayer.model.Group;
import com.google.sample.cast.refplayer.model.Parent;
import com.google.sample.cast.refplayer.model.Station;
import com.google.sample.cast.refplayer.utils.MediaItem;
import com.google.sample.cast.refplayer.utils.Utils;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;
import android.util.Log;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class VideoItemLoader extends AsyncTaskLoader<List<MediaItem>> {

    private static final String TAG = "VideoItemLoader";
    private final String mUrl;

    public VideoItemLoader(Context context, String url) {
        super(context);
        this.mUrl = url;
    }

    @Override
    public List<MediaItem> loadInBackground() {
        try {
            //return VideoProvider.buildMedia(mUrl);
            Parent mParent = new Gson().fromJson(Utils.json, Parent.class);
            List<MediaItem> mediaList = new ArrayList<>();
            List<Group> results = mParent.getGroups();

            for(Group group : results){
                if (group.getStations()!=null) {
                    for (Station station : group.getStations()) {
                        MediaItem mi = new MediaItem();

                        mi.setTitle(station.getName());
                        mi.setUrl(station.getUrl());
                        //mi.setUrl("http://163.172.202.69:4022/formula1hd");
                        mi.addImage(station.getImage());

                        mediaList.add(mi);
                    }
                }

            }

            return VideoProvider.buildMedia(mUrl);
            //return mediaList;
        } catch (Exception e) {
            Log.e(TAG, "Failed to fetch media data", e);
            return null;
        }
    }

    @Override
    protected void onStartLoading() {
        super.onStartLoading();
        forceLoad();
    }

    /**
     * Handles a request to stop the Loader.
     */
    @Override
    protected void onStopLoading() {
        // Attempt to cancel the current load task if possible.
        cancelLoad();
    }

}
