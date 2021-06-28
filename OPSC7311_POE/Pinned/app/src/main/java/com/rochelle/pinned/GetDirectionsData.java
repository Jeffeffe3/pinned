package com.rochelle.pinned;

import android.os.AsyncTask;
import android.util.Log;

import com.google.android.gms.maps.GoogleMap;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class GetDirectionsData extends AsyncTask<Object,String,String> {

    GoogleMap mMap;
    String url;
    String googleDirectionsData;

    @Override
    protected String doInBackground(Object... objects) {

        mMap = (GoogleMap)objects[0];
        url = (String)objects[1];

        DownloadURL downloadURL = new DownloadURL();
        try {
            googleDirectionsData = downloadURL.readUrl(url);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return googleDirectionsData;
    }

    @Override
    protected void onPostExecute(String s){
        HashMap<String,String> directionsList = null;
        DataParser parser = new DataParser();
        directionsList = parser.parseDirections(s);
        displayDirection[directionsList];
    }

    public void displayDirection(String[] directionsList){
        int count = directionsList.length;
        for (int i = 0;i<count;i++){
            PolylineOptions options = new PolylineOptions();
            options.color[Color.RED];
            options.width[10];
            options.addAll[PolyUtil.decode(directionsList[i])];

            mMap.addPolyline(options);

        }

    }

}
