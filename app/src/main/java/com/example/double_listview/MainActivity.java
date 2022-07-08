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
        departments.add("資訊管理系");
        departments.add("財務金融系");
        departments.add("會計系");
    }
    private void create_classes_list(){
        test_0.add("一年甲班");
        test_0.add("二年甲班");
        test_0.add("三年甲班");
        test_0.add("四年甲班");
        classes.add(test_0);
        test_1.add("一年乙班");
        test_1.add("二年乙班");
        test_1.add("三年乙班");
        test_1.add("四年乙班");
        classes.add(test_1);
        test_2.add("一年甲班");
        test_2.add("一年乙班");
        test_2.add("二年甲班");
        test_2.add("二年乙班");
        test_2.add("三年甲班");
        test_2.add("三年乙班");
        test_2.add("四年甲班");
        test_2.add("四年乙班");
        classes.add(test_2);

    }
}