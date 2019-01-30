package com.sani.shahid.remotejobtest;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.squareup.picasso.Picasso;

public class Detailed extends AppCompatActivity {

    TextView detailHallName, seatLayout;
    Button bookButton;
    ImageView detailHallImage;
    Intent intent;
    DocumentReference documentReference;
    FirebaseFirestore mFirestore;
    String hallName, seatL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed);

        seatLayout = findViewById(R.id.seatLayout);
        detailHallName = findViewById(R.id.detailedhallName);

        bookButton = findViewById(R.id.bookButton);
        detailHallImage = findViewById(R.id.detailHallImage);

        mFirestore = FirebaseFirestore.getInstance();

        intent = getIntent();

        if (intent != null){
            hallName = intent.getStringExtra("Cinema Name");
            seatL = intent.getStringExtra("Seat Layout");

            detailHallName.setText(hallName);
            seatLayout.setText(seatL);
        }
    }
}
