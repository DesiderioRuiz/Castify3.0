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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
                        //mi.setUrl(station.getUrl());
                        //mi.setUrl("http://playlist.onlybest.tv/ru/channel/45d923b700bdbb53af22c8219ae034ac/613/index.m3u8");//F1
                        //mi.setUrl("http://95.122.50.234:4022//udp/239.0.0.13:8208");//Calle 13
                        //mi.setUrl("http://playlist.onlybest.tv/ru/channel/f772b8505cfea04b38985616da5f973f/613/index.m3u8");//GP
                        mi.setUrl("http://51.15.144.38:3222/play/a02a/index.m3u8");//F1
                        mi.addImage(station.getImage());

                        mediaList.add(mi);
                    }
                }

            }

            //return VideoProvider.buildMedia(mUrl);
            return mediaList;
        } catch (Exception e) {
            Log.e(TAG, "Failed to fetch media data", e);
            return null;
        }
    }

    private HashMap<String, Integer> parseHLSMetadata(InputStream i ){

        try {
            BufferedReader r = new BufferedReader(new InputStreamReader(i, "UTF-8"));
            String line;
            HashMap<String, Integer> segmentsMap = null;
            String digitRegex = "\\d+";
            Pattern p = Pattern.compile(digitRegex);

            while((line = r.readLine())!=null){
                if(line.equals("#EXTM3U")){ //start of m3u8
                    segmentsMap = new HashMap<String, Integer>();
                }else if(line.contains("#EXTINF")){ //once found EXTINFO use runner to get the next line which contains the media file, parse duration of the segment
                    Matcher matcher = p.matcher(line);
                    matcher.find(); //find the first matching digit, which represents the duration of the segment, dont call .find() again that will throw digit which may be contained in the description.
                    segmentsMap.put(r.readLine(), Integer.parseInt(matcher.group(0)));
                }
            }
            r.close();
            return segmentsMap;
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
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
