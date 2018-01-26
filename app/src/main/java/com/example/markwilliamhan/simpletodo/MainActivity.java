package com.example.markwilliamhan.simpletodo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<String> items;
    private ArrayAdapter<String> itemsAdapter;
    private ListView lvItems;


    /**
     * onCreate method inflates activity_main, sets up listView using ArrayAdapter.
     * Initially this screen will have two objects, First Item and Second Item
     */
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

        // Setup remove listener method call
        setupListViewListener();
    }

    /**
     * This method sets up a listener which removes to-do from listview after being Long Clicked
     */
    private void setupListViewListener() {
        lvItems.setOnItemLongClickListener(
                new AdapterView.OnItemLongClickListener() {
                    @Override
                    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                        // Remove the item within array at position
                        items.remove(position);
                        // Refresh the Adapter
                        itemsAdapter.notifyDataSetChanged();
                        // Return true consumes the long click event (marks it handled)
                        return true;

                    }
                }
        );
    }


    /**
     * This method occurs when the button is clicked.  It adds the text in the edittextbox as a list item.
     * It then erases the text in the edittext box.
     * This is using a simple onclick attribute which was added to activity_main.xml
     *
     * @param v refers to the view that was clicked.
     */
    public void onAddItem(View v) {
        // Finds the EditText in layout
        EditText etNewItem = (EditText) findViewById(R.id.etNewItem);

        // gets the Text that is written by user in the EditText box and labels it itemText
        String itemText = etNewItem.getText().toString();

        //Adds the itemText, containing what was written by user in the EditText, and adds it to the itemsAdapter
        itemsAdapter.add(itemText);

        // Erases what was previously in the EditText
        etNewItem.setText("");

    }


}
