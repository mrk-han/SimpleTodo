package com.example.markwilliamhan.simpletodo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<String> items;
    private ArrayAdapter<String> itemsAdapter;
    private ListView lvItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        // Finds the ListView in activity_main.xml and links it to lvItems variable.
        lvItems = (ListView) findViewById(R.id.lvItems);

        // Initializes items as ArrayList
        items = new ArrayList<String>();

        // This Array Adapter is called itemsAdapter and uses simple_list_item_1 as a layout and takes in the list of items from the items ArrayList.
        // The context, THIS, refers to this activity, the MainActivity.
        itemsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items);

        // Configures itemsAdapter to be used on the ListView lvItems
        lvItems.setAdapter(itemsAdapter);


        // Adding the first two items to the ArrayList (These would be the first two TODOs that you add to the list)
        items.add("First Item");
        items.add("Second Item");

    }
}
