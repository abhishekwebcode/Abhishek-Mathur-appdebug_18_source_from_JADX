package com.example.admin.designlay;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    String[] comment = new String[]{"comment1", "comment2", "comment3", "comment4", "comment5", "comment6", "comment7", "comment8", "comment9", "comment10"};
    String[] name = new String[]{"Test1", "Test2", "Test3", "Test4", "Test5", "Test6", "Test7", "Test8", "Test9", "Test10"};
    String[] pa = new String[]{"0", "1", "1", "1", "1", "0", "1", "0", "1", "1"};
    String[] roll_no = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
    StudentAdapter studentAdapter;
    ListView studentlist;
    Toolbar toolbar;

    public class StudentAdapter extends BaseAdapter {
        TextView commenttxt;
        TextView nametxt;
        ImageView paimg;
        TextView rollnotxt;
        String[] s_comment;
        Context s_context;
        String[] s_name;
        String[] s_pa;
        String[] s_rollno;

        StudentAdapter(Context context, String[] rollno, String[] name, String[] pa, String[] comment) {
            this.s_context = context;
            this.s_rollno = rollno;
            this.s_name = name;
            this.s_pa = pa;
            this.s_comment = comment;
        }

        public int getCount() {
            return this.s_rollno.length;
        }

        public Object getItem(int i) {
            return this.s_rollno[i];
        }

        public long getItemId(int i) {
            return (long) i;
        }

        public View getView(final int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = LayoutInflater.from(this.s_context).inflate(C0311R.layout.listitemlayout, viewGroup, false);
            }
            this.rollnotxt = (TextView) view.findViewById(C0311R.id.rollnotxt);
            this.nametxt = (TextView) view.findViewById(C0311R.id.nametxt);
            this.commenttxt = (TextView) view.findViewById(C0311R.id.commenttxt);
            this.paimg = (ImageView) view.findViewById(C0311R.id.paimg);
            this.rollnotxt.setText(this.s_rollno[i]);
            this.nametxt.setText(this.s_name[i]);
            this.commenttxt.setText(this.s_comment[i]);
            if (this.s_pa[i] == "0") {
                this.paimg.setImageResource(C0311R.drawable.present);
            } else {
                this.paimg.setImageResource(C0311R.drawable.absent);
            }
            this.paimg.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    Log.e("click", "yes");
                    if (StudentAdapter.this.paimg.getDrawable() == MainActivity.this.getResources().getDrawable(C0311R.drawable.present)) {
                        Log.e("click", "yes1");
                        StudentAdapter.this.s_pa[i] = "1";
                        StudentAdapter.this.notifyDataSetChanged();
                        return;
                    }
                    Log.e("click", "yes2");
                    StudentAdapter.this.s_pa[i] = "0";
                    StudentAdapter.this.notifyDataSetChanged();
                }
            });
            return view;
        }
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) C0311R.layout.activity_main);
        this.toolbar = (Toolbar) findViewById(C0311R.id.toolbar);
        this.studentlist = (ListView) findViewById(C0311R.id.studentlist);
        setSupportActionBar(this.toolbar);
        this.studentAdapter = new StudentAdapter(this, this.roll_no, this.name, this.pa, this.comment);
        this.studentlist.setAdapter(this.studentAdapter);
    }
}
