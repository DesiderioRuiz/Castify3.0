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
            "    \"name\": \"ðŸ“º TV Directo en EspaÃ±ol\",\n" +
            "    \"author\": \"jdoer\",\n" +
            "    \"info\": \"Cualquier problema o solicitud por favor acceder a nuestro hilo oficial en W3UFORUM.COM\",\n" +
            "    \"url\": \"http://w3ubin.com/EJyG9lYpe.w3u\",\n" +
            "    \"groups\":[\n" +
            "        {\n" +
            "            \"name\": \"FÃºtbol\",\n" +
            "            \"image\": \"https://cdn3.iconfinder.com/data/icons/choosesport/png/512/football.png\",\n" +
            "            \"info\": \"Recuerda sincronizar la lista antes o justo al inicio de los eventos para tener las Ãºltimas seÃ±ales disponibles. Para los canales que se abren externamente â†—ï¸\u008F, pulsar en el icono de Play â–¶ï¸\u008F con un cÃ\u00ADrculo en cuanto aparezca para abrir en el reproductor.\",\n" +
            "            \"stations\":[\n" +
            "                {\n" +
            "                    \"name\": \"Bein La Liga\",\n" +
            "                    \"image\": \"http://www.audiovisual451.com/wp-content/uploads/beIN-Sports-LaLiga.jpg\",\n" +
            "                    \"url\": \"http://player.livesports.pw/beinlaliga/\",\n" +
            "                    \"referer\": \"http://telefivegb.com/canales/deporte/beinlaliga/\",\n" +
            "                    \"userAgent\": \"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/65.0.3325.181 Safari/537.36\",\n" +
            "                    \"isHost\": true\n" +
            "                },\n" +
            "                {\n" +
            "                    \"name\": \"Bein La Liga (Opc.2)\",\n" +
            "                    \"image\": \"http://www.audiovisual451.com/wp-content/uploads/beIN-Sports-LaLiga.jpg\",\n" +
            "                    \"url\": \"http://vertelevisor.com/tv/deportes/canal-plus-partidazo.html\",\n" +
            "                    \"embed\": true\n" +
            "                },\n" +
            "                {\n" +
            "                    \"name\": \"Bein La Liga (Opc.3)\",\n" +
            "                    \"image\": \"http://www.audiovisual451.com/wp-content/uploads/beIN-Sports-LaLiga.jpg\",\n" +
            "                    \"url\": \"http://37.187.128.169:8000/live/vvvvlllppp12nocara1/vlp1vlpedit1sabno/15.ts\",\n" +
            "                    \"userAgent\": \"VLPLAYER/8.5 LIBVLC/3.0.0 LibVLC/3.0.0-git\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"name\": \"Bein La Liga (Opc.4)\",\n" +
            "                    \"image\": \"http://www.audiovisual451.com/wp-content/uploads/beIN-Sports-LaLiga.jpg\",\n" +
            "                    \"url\": \"http://vergol.com/live3/beinliga.php\",\n" +
            "                    \"referer\": \"http://vertelevisor.com/tv/deportes/canal-plus-partidazo.html\",\n" +
            "                    \"isHost\": true\n" +
            "                },\n" +
            "                {\n" +
            "                    \"name\": \"Bein La Liga (Opc.5)\",\n" +
            "                    \"image\": \"http://www.audiovisual451.com/wp-content/uploads/beIN-Sports-LaLiga.jpg\",\n" +
            "                    \"url\": \"http://hipogrifo.dragontvapp.com/live/verliga/index.m3u8\",\n" +
            "                    \"userAgent\": \"DragonsVideo\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"name\": \"Bein La Liga (Acestream)\",\n" +
            "                    \"image\": \"http://www.audiovisual451.com/wp-content/uploads/beIN-Sports-LaLiga.jpg\",\n" +
            "                    \"url\": \"http://arenavision2018.tk/01\",\n" +
            "                    \"isHost\": true\n" +
            "                },\n" +
            "                {\n" +
            "                    \"name\": \"Bein Sports\",\n" +
            "                    \"image\": \"http://todocanales.net/wp-content/uploads/2014/04/bein-sports.jpg\",\n" +
            "                    \"url\": \"http://player.livesports.pw/beinsportesp/\",\n" +
            "                    \"referer\": \"http://verplusonline.com/ver-bein-sport-espana-en-vivo/\",\n" +
            "                    \"userAgent\": \"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/65.0.3325.181 Safari/537.36\",\n" +
            "                    \"isHost\": true\n" +
            "                },\n" +
            "                {\n" +
            "                    \"name\": \"Bein Sports (Opc.2)\",\n" +
            "                    \"image\": \"http://todocanales.net/wp-content/uploads/2014/04/bein-sports.jpg\",\n" +
            "                    \"url\": \"http://37.187.128.169:8000/live/vvvvlllppp12nocara1/vlp1vlpedit1sabno/51.ts\",\n" +
            "                    \"userAgent\": \"VLPLAYER/8.5 LIBVLC/3.0.0 LibVLC/3.0.0-git\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"name\": \"Bein Sports (Opc.3)\",\n" +
            "                    \"image\": \"http://todocanales.net/wp-content/uploads/2014/04/bein-sports.jpg\",\n" +
            "                    \"url\": \"http://hipogrifo.dragontvapp.com/live/beinsportesp/index.m3u8\",\n" +
            "                    \"userAgent\": \"DragonsVideo\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"name\": \"Bein Ã‘ Sports\",\n" +
            "                    \"image\": \"https://upload.wikimedia.org/wikipedia/commons/thumb/8/8f/Bein_Sport_en_espa%C3%B1ol_logo.svg/1200px-Bein_Sport_en_espa%C3%B1ol_logo.svg.png\",\n" +
            "                    \"url\": \"http://embed.latino-webtv.com/channels/bein.html\",\n" +
            "                    \"embed\": true\n" +
            "                },\n" +
            "                {\n" +
            "                    \"name\": \"Bein Ã‘ Sports (Opc.2)\",\n" +
            "                    \"image\": \"https://upload.wikimedia.org/wikipedia/commons/thumb/8/8f/Bein_Sport_en_espa%C3%B1ol_logo.svg/1200px-Bein_Sport_en_espa%C3%B1ol_logo.svg.png\",\n" +
            "                    \"url\": \"http://www.sunhd.info/channel.php?file=105642&width=675&height=440&autostart=true\",\n" +
            "                    \"referer\": \"http://rivonet.xyz/ch32.html\",\n" +
            "                    \"embed\": true\n" +
            "                },\n" +
            "                {\n" +
            "                    \"name\": \"M+ Partidazo\",\n" +
            "                    \"image\": \"http://www.movistarplus.es/estaticos/images/canales/png/Logo-partidazook.png\",\n" +
            "                    \"url\": \"http://player.livesports.pw/partidazo/\",\n" +
            "                    \"referer\": \"http://telefivegb.com/canales/deporte/partidazo/\",\n" +
            "                    \"userAgent\": \"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/65.0.3325.181 Safari/537.36\",\n" +
            "                    \"isHost\": true\n" +
            "                },\n" +
            "                {\n" +
            "                    \"name\": \"M+ Partidazo (Opc.2)\",\n" +
            "                    \"image\": \"http://www.movistarplus.es/estaticos/images/canales/png/Logo-partidazook.png\",\n" +
            "                    \"url\": \"http://verliga.net/live/verliga1.php\",\n" +
            "                    \"referer\": \"http://verliga.net/verliga.html\",\n" +
            "                    \"isHost\": true\n" +
            "                },\n" +
            "                {\n" +
            "                    \"name\": \"M+ Partidazo (Opc.3)\",\n" +
            "                    \"image\": \"http://www.movistarplus.es/estaticos/images/canales/png/Logo-partidazook.png\",\n" +
            "                    \"url\": \"http://hipogrifo.dragontvapp.com/live/partidazo/index.m3u8\",\n" +
            "                    \"userAgent\": \"DragonsVideo\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"name\": \"M+ Futbol\",\n" +
            "                    \"image\": \"https://upload.wikimedia.org/wikipedia/commons/thumb/f/f1/Movistar_F%C3%BAtbol.svg/800px-Movistar_F%C3%BAtbol.svg.png\",\n" +
            "                    \"url\": \"http://player.livesports.pw/futbol/\",\n" +
            "                    \"referer\": \"http://telefivegb.com/canales/deporte/futbol/\",\n" +
            "                    \"userAgent\": \"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/65.0.3325.181 Safari/537.36\",\n" +
            "                    \"isHost\": true\n" +
            "                },\n" +
            "                {\n" +
            "                    \"name\": \"M+ Futbol (Opc.2)\",\n" +
            "                    \"image\": \"https://upload.wikimedia.org/wikipedia/commons/thumb/f/f1/Movistar_F%C3%BAtbol.svg/800px-Movistar_F%C3%BAtbol.svg.png\",\n" +
            "                    \"url\": \"http://37.187.128.169:8000/live/vvvvlllppp12nocara1/vlp1vlpedit1sabno/19.ts\",\n" +
            "                    \"userAgent\": \"VLPLAYER/8.5 LIBVLC/3.0.0 LibVLC/3.0.0-git\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"name\": \"M+ Futbol (Opc.3)\",\n" +
            "                    \"image\": \"https://upload.wikimedia.org/wikipedia/commons/thumb/f/f1/Movistar_F%C3%BAtbol.svg/800px-Movistar_F%C3%BAtbol.svg.png\",\n" +
            "                    \"url\": \"http://hipogrifo.dragontvapp.com/live/mfutbol/index.m3u8\",\n" +
            "                    \"userAgent\": \"DragonsVideo\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"name\": \"La Liga TV\",\n" +
            "                    \"image\": \"http://files.laliga.es/seccion_logos/laliga-v-16-9.jpg\",\n" +
            "                    \"url\": \"http://37.187.128.169:8000/live/vvvvlllppp12nocara1/vlp1vlpedit1sabno/14.ts\",\n" +
            "                    \"userAgent\": \"VLPLAYER/8.5 LIBVLC/3.0.0 LibVLC/3.0.0-git\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"name\": \"La Liga TV (Opc.2)\",\n" +
            "                    \"image\": \"http://files.laliga.es/seccion_logos/laliga-v-16-9.jpg\",\n" +
            "                    \"url\": \"http://hipogrifo.dragontvapp.com/live/ligatv/index.m3u8\",\n" +
            "                    \"userAgent\": \"DragonsVideo\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"name\": \"LaLiga 123\",\n" +
            "                    \"image\": \"http://files.laliga.es/seccion_logos/laliga-123-v-600x600.png\",\n" +
            "                    \"url\": \"http://vergol.com/live3/liga123.php\",\n" +
            "                    \"referer\": \"http://verliga.net/live/verliga11.php\",\n" +
            "                    \"isHost\": true\n" +
            "                },\n" +
            "                {\n" +
            "                    \"name\": \"LaLiga 123 (Opc.2)\",\n" +
            "                    \"image\": \"http://files.laliga.es/seccion_logos/laliga-123-v-600x600.png\",\n" +
            "                    \"url\": \"http://player.livesports.pw/liga123/\",\n" +
            "                    \"referer\": \"http://telefivegb.com/canales/deporte/LIGA123/\",\n" +
            "                    \"userAgent\": \"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/65.0.3325.181 Safari/537.36\",\n" +
            "                    \"isHost\": true\n" +
            "                },\n" +
            "                {\n" +
            "                    \"name\": \"LaLiga 123 (Opc.3)\",\n" +
            "                    \"image\": \"http://files.laliga.es/seccion_logos/laliga-123-v-600x600.png\",\n" +
            "                    \"url\": \"http://hipogrifo.dragontvapp.com/live/liga123/index.m3u8\",\n" +
            "                    \"userAgent\": \"DragonsVideo\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"name\": \"LaLiga 123 (Acestream)\",\n" +
            "                    \"image\": \"http://files.laliga.es/seccion_logos/laliga-123-v-600x600.png\",\n" +
            "                    \"url\": \"http://arenavision2018.tk/05\",\n" +
            "                    \"isHost\": true\n" +
            "                },\n" +
            "                {\n" +
            "                    \"name\": \"GOL\",\n" +
            "                    \"image\": \"http://iusport.com/upload/img/periodico/img_22530.jpg\",\n" +
            "                    \"url\": \"http://telefivegb.com/canales/deporte/goltv/\",\n" +
            "                    \"isHost\": true\n" +
            "                },\n" +
            "                {\n" +
            "                    \"name\": \"GOL (Opc.2)\",\n" +
            "                    \"image\": \"http://iusport.com/upload/img/periodico/img_22530.jpg\",\n" +
            "                    \"url\": \"http://37.187.128.169:8000/live/vvvvlllppp12nocara1/vlp1vlpedit1sabno/16.ts\",\n" +
            "                    \"userAgent\": \"VLPLAYER/8.5 LIBVLC/3.0.0 LibVLC/3.0.0-git\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"name\": \"GOL PerÃº\",\n" +
            "                    \"image\": \"https://3.bp.blogspot.com/-dnoADpGQHtk/WQ9NVzskrmI/AAAAAAAAAig/cDLXo3tvieAf4QDNOz2tuDvNGCLoTx0CwCLcB/s1600/gol%2Bperu.jpg\",\n" +
            "                    \"url\": \"http://www.embeducaster.com/embedplayer/goltvs655j/1/620/400\",\n" +
            "                    \"referer\": \"http://television-envivo.org/deportes/goltv-en-vivo.php\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"name\": \"Real Madrid TV\",\n" +
            "                    \"image\": \"http://www.defensacentral.com/userfiles/2013/Dec_04/television_interior.jpg\",\n" +
            "                    \"url\": \"http://rmtvlive-lh.akamaihd.net/i/rmtv_1@154306/index_1000_av-b.m3u8?sd=10&rebase=on8\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"name\": \"Sevilla FC\",\n" +
            "                    \"image\": \"http://adminweb.onlycable.net/img/Canale/small/Sevilla-FC-TV/Sevilla-FC-TV_.png\",\n" +
            "                    \"url\": \"http://sevillafc_live-lh.akamaihd.net/i/video_0@354142/master.m3u8\",\n" +
            "                    \"isHost\": false\n" +
            "                }\n" +
            "            ]\n" +
            "        },\n" +
            "        {\n" +
            "            \"name\": \"Deportes\",\n" +
            "            \"image\": \"https://cdn2.iconfinder.com/data/icons/iconslandsport/PNG/256x256/Tennis_Ball.png\",\n" +
            "            \"info\": \"Recuerda sincronizar la lista antes o justo al inicio de los eventos para tener las Ãºltimas seÃ±ales disponibles. Para los canales que se abren externamente â†—ï¸\u008F, pulsar en el icono de Play â–¶ï¸\u008F con un cÃ\u00ADrculo en cuanto aparezca para abrir en el reproductor.\",\n" +
            "            \"stations\":[\n" +
            "                {\n" +
            "                    \"name\": \"Teledeporte\",\n" +
            "                    \"image\": \"http://arabast.com/wp-content/uploads/2014/08/tve_teledeporte.png\",\n" +
            "                    \"url\": \"http://telefivegb.com/canales/deporte/teledeporte/\",\n" +
            "                    \"isHost\": true\n" +
            "                },\n" +
            "                {\n" +
            "                    \"name\": \"M+ Deportes 1\",\n" +
            "                    \"image\": \"http://vignette3.wikia.nocookie.net/logopedia/images/c/c3/MovistarDeportes1.png/revision/latest?cb=20160818140254\",\n" +
            "                    \"url\": \"http://vergol.com/live1/plusdeportes1.php\",\n" +
            "                    \"referer\": \"http://www.vercanalestv.com/tv/deportes/canal-plus-deportes.html\",\n" +
            "                    \"isHost\": true\n" +
            "                },\n" +
            "                {\n" +
            "                    \"name\": \"M+ Deportes 1 (Opc.2)\",\n" +
            "                    \"image\": \"http://vignette3.wikia.nocookie.net/logopedia/images/c/c3/MovistarDeportes1.png/revision/latest?cb=20160818140254\",\n" +
            "                    \"url\": \"http://37.187.128.169:8000/live/vvvvlllppp12nocara1/vlp1vlpedit1sabno/17.ts\",\n" +
            "                    \"userAgent\": \"VLPLAYER/8.5 LIBVLC/3.0.0 LibVLC/3.0.0-git\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"name\": \"M+ Deportes 1 (Opc.3)\",\n" +
            "                    \"image\": \"http://vignette3.wikia.nocookie.net/logopedia/images/c/c3/MovistarDeportes1.png/revision/latest?cb=20160818140254\",\n" +
            "                    \"url\": \"http://player.livesports.pw/deporte1/\",\n" +
            "                    \"referer\": \"http://telefivegb.com/canales/deporte/deporte1/\",\n" +
            "                    \"userAgent\": \"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/65.0.3325.181 Safari/537.36\",\n" +
            "                    \"isHost\": true\n" +
            "                },\n" +
            "                {\n" +
            "                    \"name\": \"M+ Deportes 2\",\n" +
            "                    \"image\": \"http://verdirectotv.com/logos/deportes2.png\",\n" +
            "                    \"url\": \"http://vergol.com/live1/plusdeportes2.php\",\n" +
            "                    \"referer\": \"http://verdirectotv.com/tv/deportes/plusdeportes2.html\",\n" +
            "                    \"isHost\": true\n" +
            "                },\n" +
            "                {\n" +
            "                    \"name\": \"M+ Deportes 2 (Opc.2)\",\n" +
            "                    \"image\": \"http://verdirectotv.com/logos/deportes2.png\",\n" +
            "                    \"url\": \"http://37.187.128.169:8000/live/vvvvlllppp12nocara1/vlp1vlpedit1sabno/18.ts\",\n" +
            "                    \"userAgent\": \"VLPLAYER/8.5 LIBVLC/3.0.0 LibVLC/3.0.0-git\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"name\": \"M+ Deportes 2 (Opc.3)\",\n" +
            "                    \"image\": \"http://verdirectotv.com/logos/deportes2.png\",\n" +
            "                    \"url\": \"http://player.livesports.pw/deporte2/\",\n" +
            "                    \"referer\": \"http://telefivegb.com/canales/deporte/deporte2/\",\n" +
            "                    \"userAgent\": \"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/65.0.3325.181 Safari/537.36\",\n" +
            "                    \"isHost\": true\n" +
            "                },\n" +
            "                {\n" +
            "                    \"name\": \"M+ Golf\",\n" +
            "                    \"image\": \"https://upload.wikimedia.org/wikipedia/commons/thumb/0/02/Movistar_Golf.svg/640px-Movistar_Golf.svg.png\",\n" +
            "                    \"url\": \"http://player.livesports.pw/golf/\",\n" +
            "                    \"referer\": \"http://telefivegb.com/canales/deporte/golf/\",\n" +
            "                    \"userAgent\": \"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/65.0.3325.181 Safari/537.36\",\n" +
            "                    \"isHost\": true\n" +
            "                },\n" +
            "                {\n" +
            "                    \"name\": \"Eurosport\",\n" +
            "                    \"image\": \"https://www.underconsideration.com/brandnew/archives/eurosport_monogram.png\",\n" +
            "                    \"url\": \"http://vergol.com/live1/eurosport.php\",\n" +
            "                    \"referer\": \"http://verdirectotv.com/tv/deportes2/eurosport.html\",\n" +
            "                    \"isHost\": true\n" +
            "                },\n" +
            "                {\n" +
            "                    \"name\": \"Eurosport (Opc.2)\",\n" +
            "                    \"image\": \"https://www.underconsideration.com/brandnew/archives/eurosport_monogram.png\",\n" +
            "                    \"url\": \"http://37.187.128.169:8000/live/vvvvlllppp12nocara1/vlp1vlpedit1sabno/25.ts\",\n" +
            "                    \"userAgent\": \"VLPLAYER/8.5 LIBVLC/3.0.0 LibVLC/3.0.0-git\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"name\": \"WIN Sports\",\n" +
            "                    \"image\": \"https://upload.wikimedia.org/wikipedia/commons/thumb/c/c8/Winsports.svg/1200px-Winsports.svg.png\",\n" +
            "                    \"url\": \"http://embed.latino-webtv.com/channels/win.html\",\n" +
            "                    \"embed\": true\n" +
            "                },\n" +
            "                {\n" +
            "                    \"name\": \"ESPN 1\",\n" +
            "                    \"image\": \"https://s3.amazonaws.com/freebiesupply/large/2x/espn-logo-transparent.png\",\n" +
            "                    \"url\": \"http://embed.latino-webtv.com/channels/espn.html\",\n" +
            "                    \"referer\": \"http://cinestrenostv.tv/canales/envivo/espn.html\",\n" +
            "                    \"isHost\": true\n" +
            "                },\n" +
            "                {\n" +
            "                    \"name\": \"ESPN 2\",\n" +
            "                    \"image\": \"https://vignette.wikia.nocookie.net/disney/images/d/d9/2000px-ESPN2_logo.png/revision/latest?cb=20121007054435\",\n" +
            "                    \"url\": \"http://embed.latino-webtv.com/channels/espn2.html\",\n" +
            "                    \"referer\": \"http://cinestrenostv.tv/canales/envivo/espn2.html\",\n" +
            "                    \"isHost\": true\n" +
            "                },\n" +
            "                {\n" +
            "                    \"name\": \"TDN\",\n" +
            "                    \"image\": \"https://upload.wikimedia.org/wikipedia/commons/8/84/Logo_TDN.png\",\n" +
            "                    \"url\": \"http://www.playerhd1.pw/channel.php?file=106006&width=620&height=450&autostart=true\",\n" +
            "                    \"referer\": \"http://vertelete.com/canales/deporte/univisiontdn/\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"name\": \"TyC\",\n" +
            "                    \"image\": \"https://pbs.twimg.com/profile_images/552133013488685056/_YL6wRw3.jpeg\",\n" +
            "                    \"url\": \"http://clairinlive-a.akamaihd.net/dc-1/live/hls/p/1885581/e/1_8xzo6fux/t/YO19xXbHgW_22sNZezlmTg/index-s32.m3u8\"\n" +
            "                }\n" +
            "            ]\n" +
            "        },\n" +
            "        {\n" +
            "            \"name\": \"Motor\",\n" +
            "            \"image\": \"https://cdn3.iconfinder.com/data/icons/formula1/f1_png/256/checkered_flag.png\",\n" +
            "            \"stations\":[\n" +
            "                {\n" +
            "                    \"name\": \"Movistar Formula 1\",\n" +
            "                    \"image\": \"https://upload.wikimedia.org/wikipedia/commons/7/70/Logo-f1.png\",\n" +
            "                    \"url\": \"http://verliga.net/live/verliga9.php\",\n" +
            "                    \"referer\": \"http://www.vercanalestv.com/ver-formula-1-en-directo-y-online-gratis/\",\n" +
            "                    \"isHost\": true\n" +
            "                },\n" +
            "                {\n" +
            "                    \"name\": \"Movistar Formula 1 (Opc.2)\",\n" +
            "                    \"image\": \"https://upload.wikimedia.org/wikipedia/commons/7/70/Logo-f1.png\",\n" +
            "                    \"url\": \"http://37.187.128.169:8000/live/vvvvlllppp12nocara1/vlp1vlpedit1sabno/21.ts\",\n" +
            "                    \"userAgent\": \"VLPLAYER/8.5 LIBVLC/3.0.0 LibVLC/3.0.0-git\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"name\": \"Movistar Formula 1 (Opc.3)\",\n" +
            "                    \"image\": \"https://upload.wikimedia.org/wikipedia/commons/7/70/Logo-f1.png\",\n" +
            "                    \"url\": \"http://player.livesports.pw/formulauno/\",\n" +
            "                    \"referer\": \"http://telefivegb.com/canales/deporte/F1/\",\n" +
            "                    \"userAgent\": \"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/65.0.3325.181 Safari/537.36\",\n" +
            "                    \"isHost\": true\n" +
            "                },\n" +
            "                {\n" +
            "                    \"name\": \"Movistar Formula 1 (Acestream)\",\n" +
            "                    \"image\": \"https://upload.wikimedia.org/wikipedia/commons/7/70/Logo-f1.png\",\n" +
            "                    \"url\": \"http://arenavision2018.tk/10\",\n" +
            "                    \"isHost\": true\n" +
            "                },\n" +
            "                {\n" +
            "                    \"name\": \"Movistar Moto GP\",\n" +
            "                    \"image\": \"https://upload.wikimedia.org/wikipedia/commons/f/f8/Logo-motogp.png\",\n" +
            "                    \"url\": \"http://vergol.com/live3/motogp.php\",\n" +
            "                    \"referer\": \"http://vertelevisor.com/tv/deportes/moto-gp.html\",\n" +
            "                    \"isHost\": true\n" +
            "                },\n" +
            "                {\n" +
            "                    \"name\": \"Movistar Moto GP (Opc.2)\",\n" +
            "                    \"image\": \"https://upload.wikimedia.org/wikipedia/commons/f/f8/Logo-motogp.png\",\n" +
            "                    \"url\": \"http://37.187.128.169:8000/live/vvvvlllppp12nocara1/vlp1vlpedit1sabno/20.ts\",\n" +
            "                    \"userAgent\": \"VLPLAYER/8.5 LIBVLC/3.0.0 LibVLC/3.0.0-git\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"name\": \"Movistar Moto GP (Opc.3)\",\n" +
            "                    \"image\": \"https://upload.wikimedia.org/wikipedia/commons/f/f8/Logo-motogp.png\",\n" +
            "                    \"url\": \"http://player.livesports.pw/motogp/\",\n" +
            "                    \"referer\": \"http://telefivegb.com/canales/deporte/motogp/\",\n" +
            "                    \"userAgent\": \"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/65.0.3325.181 Safari/537.36\",\n" +
            "                    \"isHost\": true\n" +
            "                },\n" +
            "                {\n" +
            "                    \"name\": \"Movistar Moto GP (Acestream)\",\n" +
            "                    \"image\": \"https://upload.wikimedia.org/wikipedia/commons/f/f8/Logo-motogp.png\",\n" +
            "                    \"url\": \"http://arenavision2018.tk/10\",\n" +
            "                    \"isHost\": true\n" +
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
