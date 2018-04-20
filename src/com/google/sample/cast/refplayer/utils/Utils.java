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

package com.google.sample.cast.refplayer.utils;

import com.google.sample.cast.refplayer.R;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageInfo;
import android.content.res.Configuration;
import android.graphics.Point;
import android.view.Display;
import android.view.WindowManager;
import android.widget.Toast;

/**
 * A collection of utility methods, all static.
 */
public class Utils {

    private static final String TAG = "Utils";

    public static String json = "{\n" +
            "    \"categories\": [\n" +
            "        {\n" +
            "            \"name\": \"Movies\",\n" +
            "            \"hls\":\"https://commondatastorage.googleapis.com/gtv-videos-bucket/CastVideos/hls/\",\n" +
            "            \"dash\":\"https://commondatastorage.googleapis.com/gtv-videos-bucket/CastVideos/dash/\",\n" +
            "            \"mp4\":\"https://commondatastorage.googleapis.com/gtv-videos-bucket/CastVideos/mp4/\",\n" +
            "            \"images\":\"https://commondatastorage.googleapis.com/gtv-videos-bucket/CastVideos/images/\",\n" +
            "            \"tracks\":\"https://commondatastorage.googleapis.com/gtv-videos-bucket/CastVideos/tracks/\",\n" +
            "            \"videos\": [\n" +
            "                {\n" +
            "                    \"subtitle\": \"Fusce id nisi turpis. Praesent viverra bibendum semper. Donec tristique, orci sed semper lacinia, quam erat rhoncus massa, non congue tellus est quis tellus. Sed mollis orci venenatis quam scelerisque accumsan. Curabitur a massa sit amet mi accumsan mollis sed et magna. Vivamus sed aliquam risus. Nulla eget dolor in elit facilisis mattis. Ut aliquet luctus lacus. Phasellus nec commodo erat. Praesent tempus id lectus ac scelerisque. Maecenas pretium cursus lectus id volutpat.\",\n" +
            "                    \"sources\": [\n" +
            "                        {\n" +
            "                            \"type\": \"hls\",\n" +
            "                            \"mime\": \"application/x-mpegurl\",\n" +
            "                            \"url\": \"DesigningForGoogleCast.m3u8\"\n" +
            "                        },\n" +
            "                        {\n" +
            "                            \"type\": \"dash\",\n" +
            "                            \"mime\": \"application/dash+xml\",\n" +
            "                            \"url\": \"DesigningForGoogleCast.mpd\"\n" +
            "                        },\n" +
            "                        {\n" +
            "                            \"type\": \"mp4\",\n" +
            "                            \"mime\": \"videos/mp4\",\n" +
            "                            \"url\": \"DesigningForGoogleCast.mp4\"\n" +
            "                        }\n" +
            "                    ],\n" +
            "                    \"thumb\": \"images/DesigningForGoogleCast-480x270.jpg\",\n" +
            "                    \"image-480x270\": \"480x270/DesigningForGoogleCast2-480x270.jpg\",\n" +
            "                    \"image-780x1200\": \"780x1200/DesigningForGoogleCast-887x1200.jpg\",\n" +
            "                    \"title\": \"Designing For Google Cast\",\n" +
            "                    \"studio\": \"Google IO - 2014\",\n" +
            "                    \"duration\" : 333,\n" +
            "                    \"tracks\": [\n" +
            "                        {\n" +
            "                            \"id\": \"1\",\n" +
            "                            \"type\": \"text\",\n" +
            "                            \"subtype\": \"captions\",\n" +
            "                            \"contentId\": \"DesigningForGoogleCast-en.vtt\",\n" +
            "                            \"name\": \"English Subtitle\",\n" +
            "                            \"language\": \"en-US\"\n" +
            "                        }\n" +
            "                    ]\n" +
            "                },\n" +
            "                {\n" +
            "                    \"subtitle\": \"Fusce id nisi turpis. Praesent viverra bibendum semper. Donec tristique, orci sed semper lacinia, quam erat rhoncus massa, non congue tellus est quis tellus. Sed mollis orci venenatis quam scelerisque accumsan. Curabitur a massa sit amet mi accumsan mollis sed et magna. Vivamus sed aliquam risus. Nulla eget dolor in elit facilisis mattis. Ut aliquet luctus lacus. Phasellus nec commodo erat. Praesent tempus id lectus ac scelerisque. Maecenas pretium cursus lectus id volutpat.\",\n" +
            "                    \"sources\": [\n" +
            "                        {\n" +
            "                            \"type\": \"hls\",\n" +
            "                            \"mime\": \"application/x-mpegurl\",\n" +
            "                            \"url\": \"GoogleIO-2014-CastingToTheFuture.m3u8\"\n" +
            "                        },\n" +
            "                        {\n" +
            "                            \"type\": \"dash\",\n" +
            "                            \"mime\": \"application/dash+xml\",\n" +
            "                            \"url\": \"GoogleIO-2014-CastingToTheFuture.mpd\"\n" +
            "                        },\n" +
            "                        {\n" +
            "                            \"type\": \"mp4\",\n" +
            "                            \"mime\": \"videos/mp4\",\n" +
            "                            \"url\": \"GoogleIO-2014-CastingToTheFuture.mp4\"\n" +
            "                        }\n" +
            "                    ],\n" +
            "                    \"thumb\": \"images/ToTheFuture-480x270.jpg\",\n" +
            "                    \"image-480x270\": \"480x270/ToTheFuture2-480x270.jpg\",\n" +
            "                    \"image-780x1200\": \"780x1200/ToTheFuture-789x1200.jpg\",\n" +
            "                    \"title\": \"Casting To The Future\",\n" +
            "                    \"studio\": \"Google IO - 2014\",\n" +
            "                    \"duration\" : 2596,\n" +
            "                    \"tracks\": [\n" +
            "                        {\n" +
            "                            \"id\": \"1\",\n" +
            "                            \"type\": \"text\",\n" +
            "                            \"subtype\": \"captions\",\n" +
            "                            \"contentId\": \"GoogleIO-2014-CastingToTheFuture2-en.vtt\",\n" +
            "                            \"name\": \"English Subtitle\",\n" +
            "                            \"language\": \"en-US\"\n" +
            "                        }\n" +
            "                    ]\n" +
            "                },\n" +
            "                {\n" +
            "                    \"subtitle\": \"Fusce id nisi turpis. Praesent viverra bibendum semper. Donec tristique, orci sed semper lacinia, quam erat rhoncus massa, non congue tellus est quis tellus. Sed mollis orci venenatis quam scelerisque accumsan. Curabitur a massa sit amet mi accumsan mollis sed et magna. Vivamus sed aliquam risus. Nulla eget dolor in elit facilisis mattis. Ut aliquet luctus lacus. Phasellus nec commodo erat. Praesent tempus id lectus ac scelerisque. Maecenas pretium cursus lectus id volutpat.\",\n" +
            "                    \"sources\": [\n" +
            "                        {\n" +
            "                            \"type\": \"hls\",\n" +
            "                            \"mime\": \"application/x-mpegurl\",\n" +
            "                            \"url\": \"GoogleIO-2014-MakingGoogleCastReadyAppsDiscoverable.m3u8\"\n" +
            "                        },\n" +
            "                        {\n" +
            "                            \"type\": \"dash\",\n" +
            "                            \"mime\": \"application/dash+xml\",\n" +
            "                            \"url\": \"GoogleIO-2014-MakingGoogleCastReadyAppsDiscoverable.mpd\"\n" +
            "                        },\n" +
            "                        {\n" +
            "                            \"type\": \"mp4\",\n" +
            "                            \"mime\": \"videos/mp4\",\n" +
            "                            \"url\": \"GoogleIO-2014-MakingGoogleCastReadyAppsDiscoverable.mp4\"\n" +
            "                        }\n" +
            "                    ],\n" +
            "                    \"thumb\": \"images/MakingGoogleCastReadyAppsDiscoverable-480-270.jpg\",\n" +
            "                    \"image-480x270\": \"480x270/MakingGoogleCastReadyAppsDiscoverable-480-270.jpg\",\n" +
            "                    \"image-780x1200\": \"780x1200/MakingGoogleCastReadyAppsDiscoverable-852-1200.jpg\",\n" +
            "                    \"title\": \"Making Cast Ready Apps Discoverable\",\n" +
            "                    \"studio\": \"Google IO - 2014\",\n" +
            "                    \"duration\" : 820,\n" +
            "                    \"tracks\": [\n" +
            "                        {\n" +
            "                            \"id\": \"1\",\n" +
            "                            \"type\": \"text\",\n" +
            "                            \"subtype\": \"captions\",\n" +
            "                            \"contentId\": \"GoogleIO-2014-MakingGoogleCastReadyAppsDiscoverable-en.vtt\",\n" +
            "                            \"name\": \"English Subtitle\",\n" +
            "                            \"language\": \"en-US\"\n" +
            "                        }\n" +
            "                    ]\n" +
            "                },\n" +
            "                {\n" +
            "                    \"subtitle\": \"Fusce id nisi turpis. Praesent viverra bibendum semper. Donec tristique, orci sed semper lacinia, quam erat rhoncus massa, non congue tellus est quis tellus. Sed mollis orci venenatis quam scelerisque accumsan. Curabitur a massa sit amet mi accumsan mollis sed et magna. Vivamus sed aliquam risus. Nulla eget dolor in elit facilisis mattis. Ut aliquet luctus lacus. Phasellus nec commodo erat. Praesent tempus id lectus ac scelerisque. Maecenas pretium cursus lectus id volutpat.\",\n" +
            "                    \"sources\": [\n" +
            "                        {\n" +
            "                            \"type\": \"hls\",\n" +
            "                            \"mime\": \"application/x-mpegurl\",\n" +
            "                            \"url\": \"BigBuckBunny.m3u8\"\n" +
            "                        },\n" +
            "                        {\n" +
            "                            \"type\": \"dash\",\n" +
            "                            \"mime\": \"application/dash+xml\",\n" +
            "                            \"url\": \"BigBuckBunny.mpd\"\n" +
            "                        },\n" +
            "                        {\n" +
            "                            \"type\": \"mp4\",\n" +
            "                            \"mime\": \"videos/mp4\",\n" +
            "                            \"url\": \"BigBuckBunny.mp4\"\n" +
            "                        }\n" +
            "                    ],\n" +
            "                    \"thumb\": \"images/BigBuckBunny.jpg\",\n" +
            "                    \"image-480x270\": \"480x270/BigBuckBunny.jpg\",\n" +
            "                    \"image-780x1200\": \"780x1200/BigBuckBunny-780x1200.jpg\",\n" +
            "                    \"title\": \"Big Buck Bunny\",\n" +
            "                    \"studio\": \"Blender Foundation\",\n" +
            "                    \"duration\" : 596\n" +
            "                },\n" +
            "                {\n" +
            "                    \"subtitle\": \"Fusce id nisi turpis. Praesent viverra bibendum semper. Donec tristique, orci sed semper lacinia, quam erat rhoncus massa, non congue tellus est quis tellus. Sed mollis orci venenatis quam scelerisque accumsan. Curabitur a massa sit amet mi accumsan mollis sed et magna. Vivamus sed aliquam risus. Nulla eget dolor in elit facilisis mattis. Ut aliquet luctus lacus. Phasellus nec commodo erat. Praesent tempus id lectus ac scelerisque. Maecenas pretium cursus lectus id volutpat.\",\n" +
            "                    \"sources\": [\n" +
            "                        {\n" +
            "                            \"type\": \"hls\",\n" +
            "                            \"mime\": \"application/x-mpegurl\",\n" +
            "                            \"url\": \"ElephantsDream.m3u8\"\n" +
            "                        },\n" +
            "                        {\n" +
            "                            \"type\": \"dash\",\n" +
            "                            \"mime\": \"application/dash+xml\",\n" +
            "                            \"url\": \"ElephantsDream.mpd\"\n" +
            "                        },\n" +
            "                        {\n" +
            "                            \"type\": \"mp4\",\n" +
            "                            \"mime\": \"videos/mp4\",\n" +
            "                            \"url\": \"ElephantsDream.mp4\"\n" +
            "                        }\n" +
            "                    ],\n" +
            "                    \"thumb\": \"images/ElephantsDream.jpg\",\n" +
            "                    \"image-480x270\": \"480x270/ElephantsDream.jpg\",\n" +
            "                    \"image-780x1200\": \"780x1200/ElephantsDream-780x1200.jpg\",\n" +
            "                    \"title\": \"Elephants Dream\",\n" +
            "                    \"studio\": \"Blender Foundation\",\n" +
            "                    \"duration\" : 653\n" +
            "                },\n" +
            "                {\n" +
            "                    \"subtitle\": \"Fusce id nisi turpis. Praesent viverra bibendum semper. Donec tristique, orci sed semper lacinia, quam erat rhoncus massa, non congue tellus est quis tellus. Sed mollis orci venenatis quam scelerisque accumsan. Curabitur a massa sit amet mi accumsan mollis sed et magna. Vivamus sed aliquam risus. Nulla eget dolor in elit facilisis mattis. Ut aliquet luctus lacus. Phasellus nec commodo erat. Praesent tempus id lectus ac scelerisque. Maecenas pretium cursus lectus id volutpat.\",\n" +
            "                    \"sources\": [\n" +
            "                        {\n" +
            "                            \"type\": \"hls\",\n" +
            "                            \"mime\": \"application/x-mpegurl\",\n" +
            "                            \"url\": \"ForBiggerBlazes.m3u8\"\n" +
            "                        },\n" +
            "                        {\n" +
            "                            \"type\": \"dash\",\n" +
            "                            \"mime\": \"application/dash+xml\",\n" +
            "                            \"url\": \"ForBiggerBlazes.mpd\"\n" +
            "                        },\n" +
            "                        {\n" +
            "                            \"type\": \"mp4\",\n" +
            "                            \"mime\": \"videos/mp4\",\n" +
            "                            \"url\": \"ForBiggerBlazes.mp4\"\n" +
            "                        }\n" +
            "                    ],\n" +
            "                    \"thumb\": \"images/ForBiggerBlazes.jpg\",\n" +
            "                    \"image-480x270\": \"480x270/ForBiggerBlazes.jpg\",\n" +
            "                    \"image-780x1200\": \"780x1200/Blaze-780x1200.jpg\",\n" +
            "                    \"title\": \"For Bigger Blazes\",\n" +
            "                    \"studio\": \"Google\",\n" +
            "                    \"duration\" : 15\n" +
            "                },\n" +
            "                {\n" +
            "                    \"subtitle\": \"Fusce id nisi turpis. Praesent viverra bibendum semper. Donec tristique, orci sed semper lacinia, quam erat rhoncus massa, non congue tellus est quis tellus. Sed mollis orci venenatis quam scelerisque accumsan. Curabitur a massa sit amet mi accumsan mollis sed et magna. Vivamus sed aliquam risus. Nulla eget dolor in elit facilisis mattis. Ut aliquet luctus lacus. Phasellus nec commodo erat. Praesent tempus id lectus ac scelerisque. Maecenas pretium cursus lectus id volutpat.\",\n" +
            "                    \"sources\": [\n" +
            "                        {\n" +
            "                            \"type\": \"hls\",\n" +
            "                            \"mime\": \"application/x-mpegurl\",\n" +
            "                            \"url\": \"ForBiggerEscapes.m3u8\"\n" +
            "                        },\n" +
            "                        {\n" +
            "                            \"type\": \"dash\",\n" +
            "                            \"mime\": \"application/dash+xml\",\n" +
            "                            \"url\": \"ForBiggerEscapes.mpd\"\n" +
            "                        },\n" +
            "                        {\n" +
            "                            \"type\": \"mp4\",\n" +
            "                            \"mime\": \"videos/mp4\",\n" +
            "                            \"url\": \"ForBiggerEscapes.mp4\"\n" +
            "                        }\n" +
            "                    ],\n" +
            "                    \"thumb\": \"images/ForBiggerEscapes.jpg\",\n" +
            "                    \"image-480x270\": \"480x270/ForBiggerEscapes.jpg\",\n" +
            "                    \"image-780x1200\": \"780x1200/Escape-780x1200.jpg\",\n" +
            "                    \"title\": \"For Bigger Escape\",\n" +
            "                    \"studio\": \"Google\",\n" +
            "                    \"duration\" : 15\n" +
            "                },\n" +
            "                {\n" +
            "                    \"subtitle\": \"Fusce id nisi turpis. Praesent viverra bibendum semper. Donec tristique, orci sed semper lacinia, quam erat rhoncus massa, non congue tellus est quis tellus. Sed mollis orci venenatis quam scelerisque accumsan. Curabitur a massa sit amet mi accumsan mollis sed et magna. Vivamus sed aliquam risus. Nulla eget dolor in elit facilisis mattis. Ut aliquet luctus lacus. Phasellus nec commodo erat. Praesent tempus id lectus ac scelerisque. Maecenas pretium cursus lectus id volutpat.\",\n" +
            "                    \"sources\": [\n" +
            "                        {\n" +
            "                            \"type\": \"hls\",\n" +
            "                            \"mime\": \"application/x-mpegurl\",\n" +
            "                            \"url\": \"ForBiggerFun.m3u8\"\n" +
            "                        },\n" +
            "                        {\n" +
            "                            \"type\": \"dash\",\n" +
            "                            \"mime\": \"application/dash+xml\",\n" +
            "                            \"url\": \"ForBiggerFun.mpd\"\n" +
            "                        },\n" +
            "                        {\n" +
            "                            \"type\": \"mp4\",\n" +
            "                            \"mime\": \"videos/mp4\",\n" +
            "                            \"url\": \"ForBiggerFun.mp4\"\n" +
            "                        }\n" +
            "                    ],\n" +
            "                    \"thumb\": \"images/ForBiggerFun.jpg\",\n" +
            "                    \"image-480x270\": \"480x270/ForBiggerFun.jpg\",\n" +
            "                    \"image-780x1200\": \"780x1200/Fun-780x1200.jpg\",\n" +
            "                    \"title\": \"For Bigger Fun\",\n" +
            "                    \"studio\": \"Google\",\n" +
            "                    \"duration\" : 60\n" +
            "                },\n" +
            "                {\n" +
            "                    \"subtitle\": \"Fusce id nisi turpis. Praesent viverra bibendum semper. Donec tristique, orci sed semper lacinia, quam erat rhoncus massa, non congue tellus est quis tellus. Sed mollis orci venenatis quam scelerisque accumsan. Curabitur a massa sit amet mi accumsan mollis sed et magna. Vivamus sed aliquam risus. Nulla eget dolor in elit facilisis mattis. Ut aliquet luctus lacus. Phasellus nec commodo erat. Praesent tempus id lectus ac scelerisque. Maecenas pretium cursus lectus id volutpat.\",\n" +
            "                    \"sources\": [\n" +
            "                        {\n" +
            "                            \"type\": \"hls\",\n" +
            "                            \"mime\": \"application/x-mpegurl\",\n" +
            "                            \"url\": \"ForBiggerJoyrides.m3u8\"\n" +
            "                        },\n" +
            "                        {\n" +
            "                            \"type\": \"dash\",\n" +
            "                            \"mime\": \"application/dash+xml\",\n" +
            "                            \"url\": \"ForBiggerJoyrides.mpd\"\n" +
            "                        },\n" +
            "                        {\n" +
            "                            \"type\": \"mp4\",\n" +
            "                            \"mime\": \"videos/mp4\",\n" +
            "                            \"url\": \"ForBiggerJoyrides.mp4\"\n" +
            "                        }\n" +
            "                    ],\n" +
            "                    \"thumb\": \"images/ForBiggerJoyrides.jpg\",\n" +
            "                    \"image-480x270\": \"480x270/ForBiggerJoyrides.jpg\",\n" +
            "                    \"image-780x1200\": \"780x1200/Joyride-780x1200.jpg\",\n" +
            "                    \"title\": \"For Bigger Joyrides\",\n" +
            "                    \"studio\": \"Google\",\n" +
            "                    \"duration\" : 15\n" +
            "                },\n" +
            "                {\n" +
            "                    \"subtitle\": \"Fusce id nisi turpis. Praesent viverra bibendum semper. Donec tristique, orci sed semper lacinia, quam erat rhoncus massa, non congue tellus est quis tellus. Sed mollis orci venenatis quam scelerisque accumsan. Curabitur a massa sit amet mi accumsan mollis sed et magna. Vivamus sed aliquam risus. Nulla eget dolor in elit facilisis mattis. Ut aliquet luctus lacus. Phasellus nec commodo erat. Praesent tempus id lectus ac scelerisque. Maecenas pretium cursus lectus id volutpat.\",\n" +
            "                    \"sources\": [\n" +
            "                        {\n" +
            "                            \"type\": \"hls\",\n" +
            "                            \"mime\": \"application/x-mpegurl\",\n" +
            "                            \"url\": \"ForBiggerMeltdowns.m3u8\"\n" +
            "                        },\n" +
            "                        {\n" +
            "                            \"type\": \"dash\",\n" +
            "                            \"mime\": \"application/dash+xml\",\n" +
            "                            \"url\": \"ForBiggerMeltdowns.mpd\"\n" +
            "                        },\n" +
            "                        {\n" +
            "                            \"type\": \"mp4\",\n" +
            "                            \"mime\": \"videos/mp4\",\n" +
            "                            \"url\": \"ForBiggerMeltdowns.mp4\"\n" +
            "                        }\n" +
            "                    ],\n" +
            "                    \"thumb\": \"images/ForBiggerMeltdowns.jpg\",\n" +
            "                    \"image-480x270\": \"480x270/ForBiggerMeltdowns.jpg\",\n" +
            "                    \"image-780x1200\": \"780x1200/Meltdown-780x1200.jpg\",\n" +
            "                    \"title\": \"For Bigger Meltdowns\",\n" +
            "                    \"studio\": \"Google\",\n" +
            "                    \"duration\" : 15\n" +
            "                },\n" +
            "                {\n" +
            "                    \"subtitle\": \"Fusce id nisi turpis. Praesent viverra bibendum semper. Donec tristique, orci sed semper lacinia, quam erat rhoncus massa, non congue tellus est quis tellus. Sed mollis orci venenatis quam scelerisque accumsan. Curabitur a massa sit amet mi accumsan mollis sed et magna. Vivamus sed aliquam risus. Nulla eget dolor in elit facilisis mattis. Ut aliquet luctus lacus. Phasellus nec commodo erat. Praesent tempus id lectus ac scelerisque. Maecenas pretium cursus lectus id volutpat.\",\n" +
            "                    \"sources\": [\n" +
            "                        {\n" +
            "                            \"type\": \"hls\",\n" +
            "                            \"mime\": \"application/x-mpegurl\",\n" +
            "                            \"url\": \"Sintel.m3u8\"\n" +
            "                        },\n" +
            "                        {\n" +
            "                            \"type\": \"dash\",\n" +
            "                            \"mime\": \"application/dash+xml\",\n" +
            "                            \"url\": \"Sintel.mpd\"\n" +
            "                        },\n" +
            "                        {\n" +
            "                            \"type\": \"mp4\",\n" +
            "                            \"mime\": \"videos/mp4\",\n" +
            "                            \"url\": \"Sintel.mp4\"\n" +
            "                        }\n" +
            "                    ],\n" +
            "                    \"thumb\": \"images/Sintel.jpg\",\n" +
            "                    \"image-480x270\": \"480x270/Sintel.jpg\",\n" +
            "                    \"image-780x1200\": \"780x1200/Sintel-780x1200.jpg\",\n" +
            "                    \"title\": \"Sintel\",\n" +
            "                    \"studio\": \"Blender Foundation\",\n" +
            "                    \"duration\" : 888\n" +
            "                },\n" +
            "                {\n" +
            "                    \"subtitle\": \"Fusce id nisi turpis. Praesent viverra bibendum semper. Donec tristique, orci sed semper lacinia, quam erat rhoncus massa, non congue tellus est quis tellus. Sed mollis orci venenatis quam scelerisque accumsan. Curabitur a massa sit amet mi accumsan mollis sed et magna. Vivamus sed aliquam risus. Nulla eget dolor in elit facilisis mattis. Ut aliquet luctus lacus. Phasellus nec commodo erat. Praesent tempus id lectus ac scelerisque. Maecenas pretium cursus lectus id volutpat.\",\n" +
            "                    \"sources\": [\n" +
            "                        {\n" +
            "                            \"type\": \"hls\",\n" +
            "                            \"mime\": \"application/x-mpegurl\",\n" +
            "                            \"url\": \"TearsOfSteel.m3u8\"\n" +
            "                        },\n" +
            "                        {\n" +
            "                            \"type\": \"dash\",\n" +
            "                            \"mime\": \"application/dash+xml\",\n" +
            "                            \"url\": \"TearsOfSteel.mpd\"\n" +
            "                        },\n" +
            "                        {\n" +
            "                            \"type\": \"mp4\",\n" +
            "                            \"mime\": \"videos/mp4\",\n" +
            "                            \"url\": \"TearsOfSteel.mp4\"\n" +
            "                        }\n" +
            "                    ],\n" +
            "                    \"thumb\": \"images/TearsOfSteel.jpg\",\n" +
            "                    \"image-480x270\": \"480x270/TearsOfSteel.jpg\",\n" +
            "                    \"image-780x1200\": \"780x1200/TearsOfSteel-780x1200.jpg\",\n" +
            "                    \"title\": \"Tears of Steel\",\n" +
            "                    \"studio\": \"Blender Foundation\",\n" +
            "                    \"duration\" : 734\n" +
            "                },\n" +
            "                {\n" +
            "                    \"subtitle\": \"Fusce id nisi turpis. Praesent viverra bibendum semper. Donec tristique, orci sed semper lacinia, quam erat rhoncus massa, non congue tellus est quis tellus. Sed mollis orci venenatis quam scelerisque accumsan. Curabitur a massa sit amet mi accumsan mollis sed et magna. Vivamus sed aliquam risus. Nulla eget dolor in elit facilisis mattis. Ut aliquet luctus lacus. Phasellus nec commodo erat. Praesent tempus id lectus ac scelerisque. Maecenas pretium cursus lectus id volutpat.\",\n" +
            "                    \"sources\": [\n" +
            "                        {\n" +
            "                            \"type\": \"hls\",\n" +
            "                            \"mime\": \"application/x-mpegurl\",\n" +
            "                            \"url\": \"SubaruOutbackOnStreetAndDirt.m3u8\"\n" +
            "                        },\n" +
            "                        {\n" +
            "                            \"type\": \"dash\",\n" +
            "                            \"mime\": \"application/dash+xml\",\n" +
            "                            \"url\": \"SubaruOutbackOnStreetAndDirt.mpd\"\n" +
            "                        },\n" +
            "                        {\n" +
            "                            \"type\": \"mp4\",\n" +
            "                            \"mime\": \"videos/mp4\",\n" +
            "                            \"url\": \"SubaruOutbackOnStreetAndDirt.mp4\"\n" +
            "                        }\n" +
            "                    ],\n" +
            "                    \"thumb\": \"images/SubaruOutbackOnStreetAndDirt.jpg\",\n" +
            "                    \"image-480x270\": \"480x270/SubaruOutbackOnStreetAndDirt.jpg\",\n" +
            "                    \"image-780x1200\": \"780x1200/Subaru-780x1200.jpg\",\n" +
            "                    \"title\": \"Subaru Outback On Street And Dirt\",\n" +
            "                    \"studio\": \"Garage419\",\n" +
            "                    \"duration\": 594\n" +
            "                },\n" +
            "                {\n" +
            "                    \"subtitle\": \"Fusce id nisi turpis. Praesent viverra bibendum semper. Donec tristique, orci sed semper lacinia, quam erat rhoncus massa, non congue tellus est quis tellus. Sed mollis orci venenatis quam scelerisque accumsan. Curabitur a massa sit amet mi accumsan mollis sed et magna. Vivamus sed aliquam risus. Nulla eget dolor in elit facilisis mattis. Ut aliquet luctus lacus. Phasellus nec commodo erat. Praesent tempus id lectus ac scelerisque. Maecenas pretium cursus lectus id volutpat.\",\n" +
            "                    \"sources\": [\n" +
            "                        {\n" +
            "                            \"type\": \"hls\",\n" +
            "                            \"mime\": \"application/x-mpegurl\",\n" +
            "                            \"url\": \"VolkswagenGTIReview.m3u8\"\n" +
            "                        },\n" +
            "                        {\n" +
            "                            \"type\": \"dash\",\n" +
            "                            \"mime\": \"application/dash+xml\",\n" +
            "                            \"url\": \"VolkswagenGTIReview.mpd\"\n" +
            "                        },\n" +
            "                        {\n" +
            "                            \"type\": \"mp4\",\n" +
            "                            \"mime\": \"videos/mp4\",\n" +
            "                            \"url\": \"VolkswagenGTIReview.mp4\"\n" +
            "                        }\n" +
            "                    ],\n" +
            "                    \"thumb\": \"images/VolkswagenGTIReview.jpg\",\n" +
            "                    \"image-480x270\": \"480x270/VolkswagenGTIReview.jpg\",\n" +
            "                    \"image-780x1200\": \"780x1200/VolksWagen-780x1200.jpg\",\n" +
            "                    \"title\": \"Volkswagen GTI Review\",\n" +
            "                    \"studio\": \"Garage419\",\n" +
            "                    \"duration\":  587\n" +
            "                },\n" +
            "                {\n" +
            "                    \"subtitle\": \"Fusce id nisi turpis. Praesent viverra bibendum semper. Donec tristique, orci sed semper lacinia, quam erat rhoncus massa, non congue tellus est quis tellus. Sed mollis orci venenatis quam scelerisque accumsan. Curabitur a massa sit amet mi accumsan mollis sed et magna. Vivamus sed aliquam risus. Nulla eget dolor in elit facilisis mattis. Ut aliquet luctus lacus. Phasellus nec commodo erat. Praesent tempus id lectus ac scelerisque. Maecenas pretium cursus lectus id volutpat.\",\n" +
            "                    \"sources\": [\n" +
            "                        {\n" +
            "                            \"type\": \"hls\",\n" +
            "                            \"mime\": \"application/x-mpegurl\",\n" +
            "                            \"url\": \"WeAreGoingOnBullrun.m3u8\"\n" +
            "                        },\n" +
            "                        {\n" +
            "                            \"type\": \"dash\",\n" +
            "                            \"mime\": \"application/dash+xml\",\n" +
            "                            \"url\": \"WeAreGoingOnBullrun.mpd\"\n" +
            "                        },\n" +
            "                        {\n" +
            "                            \"type\": \"mp4\",\n" +
            "                            \"mime\": \"videos/mp4\",\n" +
            "                            \"url\": \"WeAreGoingOnBullrun.mp4\"\n" +
            "                        }\n" +
            "                    ],\n" +
            "                    \"thumb\": \"images/WeAreGoingOnBullrun.jpg\",\n" +
            "                    \"image-480x270\": \"480x270/WeAreGoingOnBullrun.jpg\",\n" +
            "                    \"image-780x1200\": \"780x1200/Bullrun-780x1200.jpg\",\n" +
            "                    \"title\": \"We Are Going On Bullrun\",\n" +
            "                    \"studio\": \"Garage419\",\n" +
            "                    \"duration\": 47\n" +
            "                },\n" +
            "                {\n" +
            "                    \"subtitle\": \"Fusce id nisi turpis. Praesent viverra bibendum semper. Donec tristique, orci sed semper lacinia, quam erat rhoncus massa, non congue tellus est quis tellus. Sed mollis orci venenatis quam scelerisque accumsan. Curabitur a massa sit amet mi accumsan mollis sed et magna. Vivamus sed aliquam risus. Nulla eget dolor in elit facilisis mattis. Ut aliquet luctus lacus. Phasellus nec commodo erat. Praesent tempus id lectus ac scelerisque. Maecenas pretium cursus lectus id volutpat.\",\n" +
            "                    \"sources\": [\n" +
            "                        {\n" +
            "                            \"type\": \"hls\",\n" +
            "                            \"mime\": \"application/x-mpegurl\",\n" +
            "                            \"url\": \"WhatCarCanYouGetForAGrand.m3u8\"\n" +
            "                        },\n" +
            "                        {\n" +
            "                            \"type\": \"dash\",\n" +
            "                            \"mime\": \"application/dash+xml\",\n" +
            "                            \"url\": \"WhatCarCanYouGetForAGrand.mpd\"\n" +
            "                        },\n" +
            "                        {\n" +
            "                            \"type\": \"mp4\",\n" +
            "                            \"mime\": \"videos/mp4\",\n" +
            "                            \"url\": \"WhatCarCanYouGetForAGrand.mp4\"\n" +
            "                        }\n" +
            "                    ],\n" +
            "                    \"thumb\": \"images/WhatCarCanYouGetForAGrand.jpg\",\n" +
            "                    \"image-480x270\": \"480x270/WhatCarCanYouGetForAGrand.jpg\",\n" +
            "                    \"image-780x1200\": \"780x1200/grand-780x1200.jpg\",\n" +
            "                    \"title\": \"What care can you get for a grand?\",\n" +
            "                    \"studio\": \"Garage419\",\n" +
            "                    \"duration\": 561\n" +
            "                },\n" +
            "                {\n" +
            "                    \"subtitle\": \"Fusce id nisi turpis. Praesent viverra bibendum semper. Donec tristique, orci sed semper lacinia, quam erat rhoncus massa, non congue tellus est quis tellus. Sed mollis orci venenatis quam scelerisque accumsan. Curabitur a massa sit amet mi accumsan mollis sed et magna. Vivamus sed aliquam risus. Nulla eget dolor in elit facilisis mattis. Ut aliquet luctus lacus. Phasellus nec commodo erat. Praesent tempus id lectus ac scelerisque. Maecenas pretium cursus lectus id volutpat.\",\n" +
            "                    \"sources\": [\n" +
            "                        {\n" +
            "                            \"type\": \"hls\",\n" +
            "                            \"mime\": \"application/x-mpegurl\",\n" +
            "                            \"url\": \"Google_I_O_2013_Keynote.m3u8\"\n" +
            "                        },\n" +
            "                        {\n" +
            "                            \"type\": \"dash\",\n" +
            "                            \"mime\": \"application/dash+xml\",\n" +
            "                            \"url\": \"Google_I_O_2013_Keynote.mpd\"\n" +
            "                        },\n" +
            "                        {\n" +
            "                            \"type\": \"mp4\",\n" +
            "                            \"mime\": \"videos/mp4\",\n" +
            "                            \"url\": \"Google_I_O_2013_Keynote.mp4\"\n" +
            "                        }\n" +
            "                    ],\n" +
            "                    \"thumb\": \"images/Google_I_O_2013_Keynote-480x270.jpg\",\n" +
            "                    \"image-480x270\": \"480x270/Google_I_O_2013_Keynote-480x270.jpg\",\n" +
            "                    \"image-780x1200\": \"780x1200/Google_I_O_2013_Keynote-780x1200.jpg\",\n" +
            "                    \"title\": \"Google I/O Keynote 2013\",\n" +
            "                    \"studio\": \"Google\",\n" +
            "                    \"duration\" : 12332\n" +
            "                }\n" +
            "            ]\n" +
            "        }\n" +
            "    ]\n" +
            "}";
    /*
     * Making sure public utility methods remain static
     */
    private Utils() {
    }

    @SuppressWarnings("deprecation")
    /**
     * Returns the screen/display size
     *
     */
    public static Point getDisplaySize(Context context) {
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        int width = display.getWidth();
        int height = display.getHeight();
        return new Point(width, height);
    }

    /**
     * Returns {@code true} if and only if the screen orientation is portrait.
     */
    public static boolean isOrientationPortrait(Context context) {
        return context.getResources().getConfiguration().orientation
                == Configuration.ORIENTATION_PORTRAIT;
    }

    /**
     * Shows an error dialog with a given text message.
     */
    public static void showErrorDialog(Context context, String errorString) {
        new AlertDialog.Builder(context).setTitle(R.string.error)
                .setMessage(errorString)
                .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                })
                .create()
                .show();
    }

    /**
     * Shows an "Oops" error dialog with a text provided by a resource ID
     */
    public static void showOopsDialog(Context context, int resourceId) {
        new AlertDialog.Builder(context).setTitle(R.string.oops)
                .setMessage(context.getString(resourceId))
                .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                })
                .setIcon(R.drawable.ic_action_alerts_and_states_warning)
                .create()
                .show();
    }

    /**
     * Gets the version of app.
     */
    public static String getAppVersionName(Context context) {
        String versionString = null;
        try {
            PackageInfo info = context.getPackageManager().getPackageInfo(context.getPackageName(),
                    0 /* basic info */);
            versionString = info.versionName;
        } catch (Exception e) {
            // do nothing
        }
        return versionString;
    }

    /**
     * Shows a (long) toast.
     */
    public static void showToast(Context context, int resourceId) {
        Toast.makeText(context, context.getString(resourceId), Toast.LENGTH_LONG).show();
    }

    /**
     * Formats time from milliseconds to hh:mm:ss string format.
     */
    public static String formatMillis(int millisec) {
        int seconds = (int) (millisec / 1000);
        int hours = seconds / (60 * 60);
        seconds %= (60 * 60);
        int minutes = seconds / 60;
        seconds %= 60;

        String time;
        if (hours > 0) {
            time = String.format("%d:%02d:%02d", hours, minutes, seconds);
        } else {
            time = String.format("%d:%02d", minutes, seconds);
        }
        return time;
    }
}
