package com.example.bottomnavigation.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bottomnavigation.R;
import com.example.bottomnavigation.adapter.StudentAdapter;
import com.example.bottomnavigation.model.Student;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    static List<Student> studentList = new ArrayList<>();
    private RecyclerView recycler_view;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_home, container, false);

        recycler_view = root.findViewById(R.id.recycler_view);
        Student student = new Student("Sushma Praja", "Dillibazar", "Female", 22);
        studentList = student.getStudentList();

        if(studentList.isEmpty()) {
            studentList.add(new Student("Sushma Praja", "Dillibazar", "Female", 22));
            studentList.add(new Student("Sanish Maharjan", "Putalisadak", "Male", 21));
            student.setStudentList(studentList);
        }
        StudentAdapter studentAdapter = new StudentAdapter(getActivity(), studentList);
        recycler_view.setAdapter(studentAdapter);
        recycler_view.setLayoutManager(new LinearLayoutManager(getActivity()));


        return root;




    }
}