package com.example.vehiclebuyingapp.Activities;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vehiclebuyingapp.Adapter.CarAdapter;
import com.example.vehiclebuyingapp.R;
import com.example.vehiclebuyingapp.model.Car;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {
    private EditText Type, color, price, year;
    private Button search;
    private RecyclerView recycler;
    private CarAdapter carAdapter;
    private List<Car> carList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Type = findViewById(R.id.Type);
        color = findViewById(R.id.color);
        price = findViewById(R.id.price);
        year = findViewById(R.id.year);
        search = findViewById(R.id.search);
        recycler = findViewById(R.id.recycler);

        recycler.setLayoutManager(new LinearLayoutManager(this));
        carList = new ArrayList<>();
        carAdapter = new CarAdapter(carList);
        recycler.setAdapter(carAdapter);

        loadSampleData();
    }

    public void searchMe(View v){
        filterCars();
    }

    // Populate with some sample data



    private void loadSampleData(){
        carList.add(new Car("Sedan", "Red", 10000, 2019));
        carList.add(new Car("SUV", "Blue", 20000, 2022));
        carList.add(new Car("Truck", "Red", 30000, 2020));
        carList.add(new Car("NISSAN", "Red", 50000, 2002));
        carList.add(new Car("TOYOTA", "Red", 10000, 2016));


        carAdapter.notifyDataSetChanged();
    }

    private void filterCars(){
        String type = Type.getText().toString().trim();
        String colour = color.getText().toString().trim();
        String prc = price.getText().toString().trim();
        String yer = year.getText().toString().trim();

        List<Car> filteredList = new ArrayList<>();

        for (Car car : carList) {
            boolean matches = true;
            if (!TextUtils.isEmpty(type) && !car.getType().equalsIgnoreCase(type)) {
                matches = false;
            }

            if (!TextUtils.isEmpty(colour) && !car.getColor().equalsIgnoreCase(colour)) {
                matches = false;
            }

            if (!TextUtils.isEmpty(prc)) {
                int price = Integer.parseInt(prc);
                if (car.getPrice() > price) {
                    matches = false;
                }
            }

            if (!TextUtils.isEmpty(yer)) {
                int year = Integer.parseInt(yer);
                if (car.getYear() != year) {
                    matches = false;
                }

                if (matches) {
                    filteredList.add(car);
                }
            }
            carAdapter.updateList(filteredList);
        }
    }
}