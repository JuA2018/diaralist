package org.techtown.listview;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Content> al = new ArrayList<Content>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        al.add(new Content("2018 / 04.25", "(진짜) (나는) (도형) (어떻게할지) (모르겠다)", "일기내용입니다 일기내용입니다 일기내용입니다 일기내용입니다 일기내용입니다 일기내용입니다 일기내용입니다"));
        al.add(new Content("2018 / 04.26", "(진짜) (나는) (도형) (어떻게할지) (모르겠다)", "일기내용입니다 일기내용입니다 일기내용입니다 일기내용입니다 일기내용입니다 일기내용입니다 일기내용입니다"));
        al.add(new Content("2018 / 04.27", "(진짜) (나는) (도형) (어떻게할지) (모르겠다)", "일기내용입니다 일기내용입니다 일기내용입니다 일기내용입니다 일기내용입니다 일기내용입니다 일기내용입니다"));
        al.add(new Content("2018 / 04.28", "(진짜) (나는) (도형) (어떻게할지) (모르겠다)", "일기내용입니다 일기내용입니다 일기내용입니다 일기내용입니다 일기내용입니다 일기내용입니다 일기내용입니다"));
        al.add(new Content("2018 / 04.29", "(진짜) (나는) (도형) (어떻게할지) (모르겠다)", "일기내용입니다 일기내용입니다 일기내용입니다 일기내용입니다 일기내용입니다 일기내용입니다 일기내용입니다"));
        al.add(new Content("2018 / 04.30", "(진짜) (나는) (도형) (어떻게할지) (모르겠다)", "일기내용입니다 일기내용입니다 일기내용입니다 일기내용입니다 일기내용입니다 일기내용입니다 일기내용입니다"));
        al.add(new Content("2018 / 05.01", "(진짜) (나는) (도형) (어떻게할지) (모르겠다)", "일기내용입니다 일기내용입니다 일기내용입니다 일기내용입니다 일기내용입니다 일기내용입니다 일기내용입니다"));

        MyAdapter adapter = new MyAdapter(getApplicationContext(), R.layout.standardlist, al);

        ListView diarylist = (ListView) findViewById(R.id.diarylist);
        diarylist.setAdapter(adapter);

        diarylist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), savediary.class);

                intent.putExtra("tag", al.get(position).tag);
                intent.putExtra("diary", al.get(position).diary);

                startActivity(intent);
            }
        });

    }

    class MyAdapter extends BaseAdapter { // 리스트 뷰의 어뎁터
        Context context;
        int layout;
        ArrayList<Content> al;
        LayoutInflater inf;
        View layoutview;
        public MyAdapter(Context context, int layout, ArrayList<Content> al) {
            this.context = context;
            this.layout = layout;
            this.al = al;
        }
        @Override
        public int getCount() {
            return al.size();
        }
        @Override
        public Object getItem(int position) {
            return al.get(position);
        }
        @Override
        public long getItemId(int position) {
            return position;
        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView==null) {
                layoutview = inf.from(context).inflate(layout, null);

                TextView days = (TextView) layoutview.findViewById(R.id.days);
                TextView tags = (TextView) layoutview.findViewById(R.id.tags);
                TextView contents = (TextView) layoutview.findViewById(R.id.contents);

                Content m = new Content();
                m = al.get(position);
                Log.d("MainActivity", al.get(position).toString());
                days.setText(m.day);
                Log.d("day", m.day.toString());
                tags.setText(m.tag);
                Log.d("tag", m.tag.toString());
                contents.setText(m.diary);
                Log.d("content", m.diary.toString());
            }
            return layoutview;
        }
    }

    class Content {
        String day = ""; // 날짜
        String tag = ""; // 태그들
        String diary = ""; // 일기내용
        public Content(String day, String tag, String diary) {
            super();
            this.day = day;
            this.tag = tag;
            this.diary = diary;
        }
        public Content() {}
    }
}
