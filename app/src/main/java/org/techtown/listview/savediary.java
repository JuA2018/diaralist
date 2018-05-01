package org.techtown.listview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class savediary extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_savediary);

        TextView edittag = (TextView) findViewById(R.id.edittag);
        TextView editcontent = (TextView) findViewById(R.id.editcontent);

        Intent intent = getIntent();
        edittag.setText(intent.getStringExtra("tag"));
        editcontent.setText(intent.getStringExtra("diary"));
    }
}
