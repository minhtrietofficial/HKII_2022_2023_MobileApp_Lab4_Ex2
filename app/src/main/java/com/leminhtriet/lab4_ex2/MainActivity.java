package com.leminhtriet.lab4_ex2;

import android.os.Bundle;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class MainActivity extends AppCompatActivity {

    private static Random rand = new Random();
    private static final int qua_item = rand.nextInt(100);
    private ListView TV_Item;
    private List<String> items = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TV_Item = findViewById(R.id.TV_Item);

        generateRandomItems();
        setAdapterView();
    }

    private void setAdapterView() {
        ItemsArrayAdapter itemsArrayAdapter = new ItemsArrayAdapter(this,
                R.layout.list_item, items);
        TV_Item.setAdapter(itemsArrayAdapter);
    }

    private void generateRandomItems() {
        for (int i = 0; i < qua_item; i++) {
            items.add("Item " + i);
        }
    }
}