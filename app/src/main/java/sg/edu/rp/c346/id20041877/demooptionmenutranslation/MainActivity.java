package sg.edu.rp.c346.id20041877.demooptionmenutranslation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvTranslatedText, tvTranslatedText2;
    String wordClicked = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvTranslatedText = findViewById(R.id.textViewTranslatedText);
        tvTranslatedText2 = findViewById(R.id.textViewTranslatedText2);

        registerForContextMenu(tvTranslatedText);
        registerForContextMenu(tvTranslatedText2);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.add(0, 0, 0, "English");
        menu.add(0, 1, 1, "Italian");

        if(v == tvTranslatedText){
            wordClicked = "1st";
        }
        else if(v == tvTranslatedText2) {
            wordClicked = "2nd";
        }

        menu.setHeaderTitle(wordClicked + " row is clicked");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if (wordClicked.equalsIgnoreCase("1st")) {
            if (item.getItemId() == 0) { //check whether the item menu item ID is 0
                //code for action
                //Toast.makeText(MainActivity.this, "English is chosen", Toast.LENGTH_SHORT).show();
                tvTranslatedText.setText("Hello");
                return true; //menu item successfully handled
            } else if (item.getItemId() == 1) { //check whether the item menu item ID is 1
                //Toast.makeText(MainActivity.this, "Italian is chosen", Toast.LENGTH_SHORT).show();
                tvTranslatedText.setText("Ciao");
                return true; //menu item successfully handled
            }
        }
        else if (wordClicked.equalsIgnoreCase("2nd")) {
            if (item.getItemId() == 0) {
                tvTranslatedText2.setText("Bye");
                return true;
            }
            else if (item.getItemId() == 1) {
                tvTranslatedText2.setText("Addio");
                return true;
            }
        }
        return super.onContextItemSelected(item); //pass menu item to the superclass implementation
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        int id = item.getItemId();

        if(id == R.id.EnglishSelection) {
            tvTranslatedText.setText("Hello");
            tvTranslatedText2.setText("Bye");
            return true;
        }
        else if(id == R.id.italianSelection) {
            tvTranslatedText.setText("Ciao");
            tvTranslatedText2.setText("Addio");
            return true;
        }
        else {
            tvTranslatedText.setText("Error Translation");
        }

        return super.onOptionsItemSelected(item);
    }
}