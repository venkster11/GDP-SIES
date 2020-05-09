package com.venkat.gdp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Switch;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottom_nav_bar);

        getSupportFragmentManager().beginTransaction().replace(R.id.frame_main,new HomeFragment()).commit();

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment frag_selected = null;

                switch (item.getItemId()){
                    case R.id.home_nav:
                        frag_selected = new HomeFragment();
                        break;

                    case R.id.trending_nav:
                        frag_selected = new TrendingFragment();
                        break;

                    case R.id.subscription_nav:
                        frag_selected = new SubscriptionFragment();
                        break;

                    case R.id.inbox_nav:
                        frag_selected = new InboxFragment();
                        break;

                    case R.id.library_nav:
                        frag_selected = new LibraryFragment();
                        break;
                }

                getSupportFragmentManager().beginTransaction().replace(R.id.frame_main,frag_selected).commit();

                return true;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {


        return true;
    }
}
