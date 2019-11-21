package com.example.bottomnavigation.ui.addstudent;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.bottomnavigation.R;
import com.example.bottomnavigation.model.Student;

import java.util.ArrayList;
import java.util.List;


public class StudentFragment extends Fragment implements View.OnClickListener{

    String Gender, Age, Address, Username;
    static List<Student> studentList = new ArrayList<>();


    EditText editName, editAge, editAddress;
    RadioGroup rgGender;
    RadioButton rbMale, rbFemale, rbOthers;
    Button btnSave;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_student, container, false);
        editName = view.findViewById(R.id.etName);
        editAge = view.findViewById(R.id.etAge);
        editAddress = view.findViewById(R.id.etAddress);
        rbMale= view.findViewById(R.id.rbMale);
        rbFemale= view.findViewById(R.id.rbFemale);
        rbOthers= view.findViewById(R.id.rbOthers);
        rgGender=view.findViewById(R.id.rgGender);
        btnSave=view.findViewById(R.id.btnSave);
        btnSave.setOnClickListener(this);
        return view;

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btnSave:
                Username = editName.getText().toString().trim();
                Age = editAge.getText().toString().trim();
                Address = editAddress.getText().toString().trim();

                if (TextUtils.isEmpty(Username)) {
                    editName.setError("Enter Username");
                    return;
                }
                if (TextUtils.isEmpty(Age)) {
                    editAge.setError("Enter Age");
                    return;
                }
                if (TextUtils.isEmpty(Address)) {
                    editAddress.setError("Enter Address");
                    return;
                }

                if (rbMale.isChecked()) {
                    Gender = "Male";
                }
                if (rbFemale.isChecked()) {
                    Gender = "Female";
                }
                if (rbOthers.isChecked()) {
                    Gender = "Others";
                }

                Student u = new Student(Username, Address, Gender, Integer.parseInt(Age));
                studentList=u.getStudentList();
                studentList.add(u);
                u.setStudentList(studentList);

                Toast.makeText(getActivity(), "Student Added Successfully: " + Username, Toast.LENGTH_SHORT).show();

                editName.setText("");
                editAge.setText("");
                editAddress.setText("");
                rbMale.setChecked(false);
                rbFemale.setChecked(false);
                rbOthers.setChecked(false);

                break;
        }
    }
}