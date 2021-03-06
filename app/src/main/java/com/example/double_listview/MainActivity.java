package com.example.double_listview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ListView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    ArrayList<String> departments = new ArrayList<String >();
    ArrayList<String> test_0 = new ArrayList<String>();
    ArrayList<String> test_1 = new ArrayList<String>();
    ArrayList<String> test_2 = new ArrayList<String>();
    ArrayList<ArrayList<String>> classes = new ArrayList<ArrayList<String >>();

    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ExpandableListView listView = (ExpandableListView) findViewById(R.id.listView);
        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.listView);
        create_departments_list();
        create_classes_list();
        System.out.println(departments);
        System.out.println(classes);
        ExpandableListViewAdapter adapter = new ExpandableListViewAdapter(this, departments, classes);
        listView.setAdapter(adapter);

        listView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView expandableListView, View view, int groupPosition, long l) {
                String departmentName = adapter.getGroup(groupPosition).toString();
                Toast.makeText(MainActivity.this, departmentName, Toast.LENGTH_SHORT).show();
                return false;
            }
        });


        listView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView expandableListView, View view, int groupPosition, int childPosition, long l) {
                String departmentName = adapter.getGroup(groupPosition).toString();
                String className = adapter.getChild(groupPosition, childPosition).toString();
                String classTitle = departmentName + " " + className;
                Toast.makeText(MainActivity.this, classTitle, Toast.LENGTH_SHORT).show();
                return false;
            }
        });

    }
    private void create_departments_list(){
        departments.add("???????????????");
        departments.add("???????????????");
        departments.add("?????????");
    }
    private void create_classes_list(){
        test_0.add("????????????");
        test_0.add("????????????");
        test_0.add("????????????");
        test_0.add("????????????");
        classes.add(test_0);
        test_1.add("????????????");
        test_1.add("????????????");
        test_1.add("????????????");
        test_1.add("????????????");
        classes.add(test_1);
        test_2.add("????????????");
        test_2.add("????????????");
        test_2.add("????????????");
        test_2.add("????????????");
        test_2.add("????????????");
        test_2.add("????????????");
        test_2.add("????????????");
        test_2.add("????????????");
        classes.add(test_2);

    }
}