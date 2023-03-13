package com.example.androiddb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button btn_add,btn_view;
    EditText name,age;
    Switch isActive;
    ListView list;
    Model model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_add=findViewById(R.id.add_button);
        btn_view=findViewById(R.id.view_button);
        name=(EditText) findViewById(R.id.name);
        age=(EditText) findViewById(R.id.age);
        isActive=findViewById(R.id.switch1);
        list=findViewById(R.id.list_view);



        btn_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DbHelper dbHelper=new DbHelper(MainActivity.this);
                List<Model> everyone=dbHelper.getEveryone();
                ArrayAdapter adapter=new ArrayAdapter<Model>(MainActivity.this, android.R.layout.simple_list_item_1,everyone);

                list.setAdapter(adapter);

                //Toast.makeText(MainActivity.this, everyone.toString(), Toast.LENGTH_SHORT).show();
            }

        });
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    model=new Model(-1,name.getText().toString(),Integer.parseInt(age.getText().toString()),isActive.isChecked());
                    Toast.makeText(MainActivity.this, model.toString(), Toast.LENGTH_SHORT).show();
                }
                catch (Exception e){
                    Toast.makeText(MainActivity.this, "Enter valid details", Toast.LENGTH_SHORT).show();
                }
DbHelper dbHelper=new DbHelper(MainActivity.this);

            }
        });

    }
}