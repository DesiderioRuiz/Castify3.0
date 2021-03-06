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

import com.google.sample.cast.refplayer.utils.MediaItem;

import android.content.Context;
import android.os.Environment;
import android.support.v4.content.AsyncTaskLoader;
import android.util.Log;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;


public class VideoItemLoader extends AsyncTaskLoader<List<MediaItem>> {

    private static final String TAG = "VideoItemLoader";
    private final String mUrl;
    ArrayList<String> allURls = new ArrayList<String>();

    public VideoItemLoader(Context context, String url) {
        super(context);
        this.mUrl = url;
    }

    public ArrayList<String> readURLs(String url) {
        if (url == null) return null;
        String data = "";
        try {
            Document doc = Jsoup.connect(url).get();
            Elements elements = doc.getAllElements();
            for (Element element : elements) {
                data = element.ownText();
                if (!data.isEmpty()) {
                    System.out.println(data);
                }
            }
            BufferedReader in = new BufferedReader(new StringReader(data));
            String str;
            while ((str = in.readLine()) != null && allURls.size() != 1) {
                allURls.add(str);
            }
            in.close();

            return allURls;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private String readFileFromRawDirectory(){
        InputStream iStream = getContext().getResources().openRawResource(
                getContext().getResources().getIdentifier("lista",
                        "raw", getContext().getPackageName())
        );
        ByteArrayOutputStream byteStream = null;
        try {
            byte[] buffer = new byte[iStream.available()];
            iStream.read(buffer);
            byteStream = new ByteArrayOutputStream();
            byteStream.write(buffer);
            byteStream.close();
            iStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return byteStream.toString();
    }



    @Override
    public List<MediaItem> loadInBackground() {
        String links;
        try {
            links = readFileFromRawDirectory();

            List<String> linksList = Arrays.asList(links.split("\\n"));

            return parseHLSMetadata(linksList);
            //return VideoProvider.buildMedia(mUrl);
//            Parent mParent = new Gson().fromJson(Utils.json, Parent.class);

//            List<Group> results = mParent.getGroups();

//            for(Group group : results){
//                if (group.getStations()!=null) {
//                    for (Station station : group.getStations()) {
//                        MediaItem mi = new MediaItem();
//
//                        mi.setTitle(station.getName());
//                        //mi.setUrl(station.getUrl());
//                        //mi.setUrl("http://playlist.onlybest.tv/ru/channel/45d923b700bdbb53af22c8219ae034ac/613/index.m3u8");//F1
//                        mi.setUrl("DesigningForGoogleCast.mpd");//Calle 13
//                        //mi.setUrl("http://playlist.onlybest.tv/ru/channel/f772b8505cfea04b38985616da5f973f/613/index.m3u8");//GP
//                        //mi.setUrl("http://51.15.144.38:3222/play/a02a/index.m3u8");
//                        mi.addImage(station.getImage());
//
//                        mediaList.add(mi);
//                    }
//                }
//
//            }

//            return null;

//            return VideoProvider.buildMedia(mUrl);
//            return mediaList;
        } catch (Exception e) {
            Log.e(TAG, "Failed to fetch media data", e);
            return null;
        }
    }


    private List<MediaItem> parseHLSMetadata(List<String> i) {

        try {
            List<MediaItem> mediaList = new ArrayList<>();
            MediaItem mi = new MediaItem();
            if (mediaList.size() == 0) {
                String digitRegex = "\\d+";
                Pattern p = Pattern.compile(digitRegex);



                for (String line : i) {
                    if (line.contains("#EXTINF")) { //once found EXTINFO use runner to get the next line which contains the media file, parse duration of the segment
                        try {
                            String[] datas = line.split("#EXTINF:-1");
                            for (String data : datas) {
                                mi = new MediaItem();

                                String[] infos = data.split(" ");

                                for (String info : infos){
                                    if (info.contains("tvg-logo")){
                                        mi.addImage(info.trim().replaceAll("tvg-logo=", "").replaceAll("\"", ""));
                                    }
                                    if (info.contains("group-title")){
                                        mi.setTitle(data.substring(data.indexOf("group-title=")+12));
                                    }
                                }

                               /**
                                if (data.endsWith(" "))
                                    data = data.substring(0, data.length() - 1);
                                int last = data.lastIndexOf(" ");
                                if (last != -1) {
                                    String title = data.substring(0, last);
                                    String url = data.substring(last + 1);
                                    String image = data.substring(1 + last);
                                    mi.addImage(image);
                                    mi.setTitle(title);
                                    mi.setUrl(url);
                                    mediaList.add(mi);
                                }
                                */
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } else {
                        if (mi!= null && mi.getTitle()!=null) {
                            mi.setUrl(line);
                            mediaList.add(mi);
                        }
                    }
                }

                return mediaList;
            }
        } catch (
                Exception e) {
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
