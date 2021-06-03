package sg.edu.rp.c346.id20002694.demodynamiclistviewcolourlist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    EditText editIndex;
    Button btnAdd;
    Button btnEdit;
    Button btnRemove;

    ListView lvColour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editIndex = findViewById(R.id.editIndex);
        editText = findViewById(R.id.editText);
        btnAdd = findViewById(R.id.btnAdd);
        btnEdit = findViewById(R.id.btnEdit);
        btnRemove = findViewById(R.id.btnRemove);
        lvColour = findViewById(R.id.lvItem);

        ArrayList <String> alColours = new ArrayList<String>();

        alColours.add(0,"Red");
        alColours.add(0,"Orange");

        ArrayAdapter aaColour = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, alColours);

        lvColour.setAdapter(aaColour);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newColour = editText.getText().toString();
                alColours.add( Integer.parseInt(editIndex.getText().toString()),  newColour);
                aaColour.notifyDataSetChanged();
            }
        });

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newColour = editText.getText().toString();
                alColours.set( Integer.parseInt(editIndex.getText().toString()),  newColour);
                aaColour.notifyDataSetChanged();
            }
        });

        btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alColours.remove( Integer.parseInt(editIndex.getText().toString()));
                aaColour.notifyDataSetChanged();
            }
        });

        lvColour.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String toastColour =alColours.get(position);
                Toast.makeText(MainActivity.this, toastColour, Toast.LENGTH_SHORT).show();

            }
        });
    }
}