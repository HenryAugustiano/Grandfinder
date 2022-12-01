package com.google.firebase.codelab.grandfinder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
<<<<<<< Updated upstream
=======
import android.widget.Toast;
import android.widget.ImageView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
>>>>>>> Stashed changes

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CreateBio extends AppCompatActivity {
    private DatabaseReference database = FirebaseDatabase.getInstance().getReference();
    private CheckBox c1, c2, c3;
    int i = 0;
    private int[] myImages = {R.drawable.mete1, R.drawable.mete2, R.drawable.mete3};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_bio);

    }

    public void saveChange(View view){
        DatabaseReference myRef = database.child("UserProfile");

        EditText editText1 = (EditText) findViewById(R.id.name);
        EditText editText2 = (EditText) findViewById(R.id.personality);
        EditText editText3 = (EditText) findViewById(R.id.hobby);
        EditText editText4 = (EditText) findViewById(R.id.about);

        String habits = "";

        c1 = (CheckBox)findViewById(R.id.checkBox1);
        c2 = (CheckBox)findViewById(R.id.checkBox2);
        c3 = (CheckBox)findViewById(R.id.checkBox3);

        if(c1.isChecked() && c2.isChecked() && c3.isChecked())
            habits = "Smoking, Alcohol, Drugs";
        else if(c1.isChecked() && c2.isChecked() && !c3.isChecked())
            habits = "Smoking, Alcohol";
        else if(c1.isChecked() && !c2.isChecked() && c3.isChecked())
            habits = "Smoking, Drugs";
        else if(!c1.isChecked() && c2.isChecked() && c3.isChecked())
            habits = "Alcohol, Drugs";
        else if(c1.isChecked() && !c2.isChecked() && !c3.isChecked())
            habits = "Smoking";
        else if(!c1.isChecked() && c2.isChecked() && !c3.isChecked())
            habits = "Alcohol";
        else if(!c1.isChecked() && !c2.isChecked() && c3.isChecked())
            habits = "Drugs";
        else
            habits = "none";


        String message1 = editText1.getText().toString();
        String message2 = editText2.getText().toString();
        String message3 = editText3.getText().toString();
        String message4 = editText4.getText().toString();

        myRef.child("User1").child("Name").setValue(message1);
        myRef.child("User1").child("Hobby").setValue(message2);
        myRef.child("User1").child("Personality").setValue(message3);
        myRef.child("User1").child("About").setValue(message4);
        myRef.child("User1").child("Habits").setValue(habits);

        Toast.makeText(getApplicationContext(), "Success Creating Bio", Toast.LENGTH_LONG).show();

        Intent intent = new Intent(this, landingPage.class);
        startActivity(intent);
    }

    public void next(View view){
        i++;
        if(i == 3) {
            i = 0;
        }
        ImageView image = (ImageView) findViewById(R.id.imageView);
        image.setImageResource(myImages[i]);
    }

    public void previous(View view){
        i--;
        if(i == -1) {
            i = 3;
        }
        ImageView img = (ImageView) findViewById(R.id.imageView);
        img.setImageResource(myImages[i]);
    }
}