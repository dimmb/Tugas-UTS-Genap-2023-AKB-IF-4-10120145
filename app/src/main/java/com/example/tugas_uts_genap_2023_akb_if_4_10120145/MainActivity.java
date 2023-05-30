package com.example.tugas_uts_genap_2023_akb_if_4_10120145;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

// Nama                 : Taufik Wandani
// Nim                  : 10120163
// Kelas                : IF-4

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) BottomNavigationView navigationView = findViewById(R.id.bottom_nav);

        final HomeFragment homeFragment = new HomeFragment();
        final CatatanFragment catatanFragment = new CatatanFragment();
        final ProfileFragment profileFragment = new ProfileFragment();

        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int id = menuItem.getItemId();
                if (id == R.id.home) {
                    setFragment(homeFragment);
                    return true;
                } else if (id == R.id.contact) {
                    setFragment(catatanFragment);
                    return true;
                } else if (id == R.id.profile) {
                    setFragment(profileFragment);
                    return true;
                }
                return false;
            }
        });

        navigationView.setSelectedItemId(R.id.home);
    }

    private void setFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame, fragment);
        fragmentTransaction.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.header_nav_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.add:
                startActivity(new Intent(this, InputActivity.class));

                Toast.makeText(this, "Add Data", Toast.LENGTH_LONG).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}