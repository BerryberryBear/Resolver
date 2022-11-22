package com.example.resolver;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button=findViewById(R.id.r_button);

        ContentResolver resolver=getContentResolver();
        ContentValues contentValues=new ContentValues();
        contentValues.put("name","小张");
        contentValues.put("age",20);
        ContentValues contentValues2=new ContentValues();
        contentValues2.put("name","小钱");
        contentValues2.put("age",22);
        ContentValues contentValues3=new ContentValues();
        contentValues3.put("name","小李");
        contentValues3.put("age",21);

        Uri uri=Uri.parse("content://yun.provider/student");

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resolver.insert(uri,contentValues);
                resolver.insert(uri,contentValues2);
                resolver.insert(uri,contentValues3);
            }
        });
    }
}