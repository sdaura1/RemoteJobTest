package com.sani.shahid.remotejobtest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.JsonReader;
import android.util.Log;
import android.widget.Toast;

import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "Main Activity";
    List<Hall> hallList;
    RecyclerView mainHallList;
    FirebaseFirestore mFirestore;
    HallListAdapter hallListAdapter;
    StringBuilder jsonBuilder;
    Hall hall;
    JSONObject mJsonObject, kJsonObject;
    String line;
    String response = null;
    Hall[] halls;
    int j;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FirebaseDatabase.getInstance().setPersistenceEnabled(true);
        hallList = new ArrayList<>();

        mainHallList = findViewById(R.id.mainHallList);
        mainHallList.setHasFixedSize(true);
        mainHallList.setLayoutManager(new LinearLayoutManager(this));
        mFirestore = FirebaseFirestore.getInstance();

        try {
            BufferedReader jsonReader = new BufferedReader(new InputStreamReader(this.getResources().openRawResource(R.raw.info)));
            jsonBuilder = new StringBuilder();
            for (line = null;
                 (line = jsonReader.readLine()) != null;) {
                jsonBuilder.append(line).append("\n");
            }
            response = jsonBuilder.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try{
            mJsonObject = new JSONObject(response);
            kJsonObject = mJsonObject.getJSONObject("Cinema");

            halls = new Hall[kJsonObject.length()];

            JSONObject h = kJsonObject.getJSONObject("-LVslJA6mqCdU0Fx4twm");

            JSONArray r = h.getJSONArray("Screen");
            for (j = 0; j < r.length(); j++) {
                hall = new Hall();
                JSONObject rJSONObject = r.getJSONObject(j);
                String seatLayout = rJSONObject.getString("SeatLayout");
                String time = rJSONObject.getString("time");
                String id = h.getString("Cinema_Id");
                String name = h.getString("Name");
                int no = Integer.valueOf(h.getString("Number_Of_Screens"));

                hall.setCinemaId(id);
                hall.setTime(time);
                hall.setScreenLayout(seatLayout);
                hall.setName(name);
                hall.setNumOfScreen(no);

                hallList.add(hall);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        hallListAdapter = new HallListAdapter(this, hallList, new OnclickListener() {
            @Override
            public void onItemClick(int position) {
                Intent i = new Intent(MainActivity.this, Detailed.class);
                i.putExtra("Cinema Name", hallList.get(position).getName());
                i.putExtra("Seat Layout", hallList.get(position).getScreenLayout());
                startActivity(i);
            }
        });
        mainHallList.setAdapter(hallListAdapter);
    }
}
