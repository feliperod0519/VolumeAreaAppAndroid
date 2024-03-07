package com.feliperodcoding.volumeareaapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.GridView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import android.widget.AdapterView;
import android.view.View;
import com.feliperodcoding.volumeareaapp.sphere;


public class MainActivity extends AppCompatActivity {

    //1-Adapter view
    GridView gridView;
    //2-Data source: ArrayList<Shape>
    ArrayList<Shape> shapeArrayList;

    //3-Adapter
    MyCustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        gridView = findViewById(R.id.gridView);
        shapeArrayList = new ArrayList<>();

        Shape sphere = new Shape(R.drawable.sphere,"Sphere");
        Shape cylinder = new Shape(R.drawable.cylinder,"Cylinder");
        Shape cube = new Shape(R.drawable.cube,"Cube");
        Shape prism = new Shape(R.drawable.prism,"Prism");
        shapeArrayList.add(sphere);
        shapeArrayList.add(cylinder);
        shapeArrayList.add(cube);
        shapeArrayList.add(prism);

        adapter = new MyCustomAdapter(getApplicationContext(),shapeArrayList);

        gridView.setAdapter(adapter);
        gridView.setNumColumns(2);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(getApplicationContext(), sphere.class);
                startActivity(i);
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}