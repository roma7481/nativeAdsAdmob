package template.myapplication;

import android.os.Bundle;

import com.facebook.ads.AdSettings;
import com.facebook.ads.AudienceNetworkAds;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;

import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<Item> items;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        AudienceNetworkAds.initialize(this);
        AdSettings.addTestDevice("539f97c0-671a-4dc7-8150-648e13063df2");
        items = new ArrayList<>();
        items.add(new Item("Test1","Lore ipsulm Lore ipsulm Lore ipsulm Lore ipsulm Lore ipsulm Lore ipsulm Lore ipsulm",R.drawable.round_bg));
        items.add(new Item("Test2","Lore ipsulm Lore ipsulm Lore ipsulm Lore ipsulm Lore ipsulm Lore ipsulm Lore ipsulm",R.drawable.round_bg));
        items.add(new Item("Test3","Lore ipsulm Lore ipsulm Lore ipsulm Lore ipsulm Lore ipsulm Lore ipsulm Lore ipsulm",R.drawable.round_bg));
        items.add(new Item("Test4","Lore ipsulm Lore ipsulm Lore ipsulm Lore ipsulm Lore ipsulm Lore ipsulm Lore ipsulm",R.drawable.round_bg));
        items.add(new Item("Test5","Lore ipsulm Lore ipsulm Lore ipsulm Lore ipsulm Lore ipsulm Lore ipsulm Lore ipsulm",R.drawable.round_bg));
        items.add(new Item("Test6","Lore ipsulm Lore ipsulm Lore ipsulm Lore ipsulm Lore ipsulm Lore ipsulm Lore ipsulm",R.drawable.round_bg));
        recyclerView = findViewById(R.id.recycleList);
        RecyclerView.LayoutManager layoutManager;
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        CardAdapter adapter = new CardAdapter(items, this);
        recyclerView.setAdapter(adapter);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}