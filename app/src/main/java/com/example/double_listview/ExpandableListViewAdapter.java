package com.example.double_listview;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ExpandableListViewAdapter extends BaseExpandableListAdapter {

    private Context context;
    private ArrayList<String> departments;
    private ArrayList<ArrayList<String>> classes;


    public ExpandableListViewAdapter(Context cont, ArrayList<String> depart, ArrayList<ArrayList<String>> cla){
        context = cont;
        departments = depart;
        classes = cla;
    }


    @Override
    public int getGroupCount() {
        return departments.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return classes.get(groupPosition).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return departments.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return classes.get(groupPosition).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition-1;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return groupPosition * 100 + childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }
    //groupPosition: Int, isExpanded: Boolean, convertView: View?, parent: ViewGroup?
    //val view = convertView ?: LayoutInflater.from(context).inflate(R.layout.item_department, null)
    //    val textView = view.findViewById<TextView>(R.id.txtDepartmentName)
    //    textView.text = departments[groupPosition]
    //
    //    return view
    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {

        LayoutInflater LI = ((Activity)context).getLayoutInflater();
        View view = LI.inflate(R.layout.item_department, null);
        TextView textView = view.findViewById(R.id.txtDepartmentName);
        textView.setText(departments.get(groupPosition));
        return view;
    }
    //groupPosition: Int, childPosition: Int, isLastChild: Boolean, convertView: View?, parent: ViewGroup?
    //val view = convertView ?: LayoutInflater.from(context).inflate(R.layout.item_class, null)
    //    val textView = view.findViewById<TextView>(R.id.txtClassName)
    //    textView.text = classes[groupPosition][childPosition]
    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        LayoutInflater LI = ((Activity)context).getLayoutInflater();
        View view = LI.inflate(R.layout.item_class, null);
        TextView textView = view.findViewById(R.id.txtClassName);
        textView.setText(classes.get(groupPosition).get(childPosition));
        return view;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }
}
