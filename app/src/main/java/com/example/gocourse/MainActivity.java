package com.example.gocourse;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.appcompat.widget.Toolbar;

import androidx.appcompat.widget.Toolbar; // Make sure to import this

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private NavController navController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);
        Log.d(TAG, "setContentView: activity_main layout loaded.");

        // Set up the Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Log.d(TAG, "Toolbar set as ActionBar.");

        // Obtain NavController via NavHostFragment
        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager()
                .findFragmentById(R.id.nav_host_fragment);

        if (navHostFragment != null) {
            navController = navHostFragment.getNavController();
            Log.d(TAG, "NavController obtained from NavHostFragment: " + navController);
        } else {
            Log.e(TAG, "NavHostFragment is null!");
        }

        if (navController != null) {
            // Set up AppBarConfiguration
            AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
            Log.d(TAG, "AppBarConfiguration set with nav graph.");

            // Set up ActionBar with NavController
            NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
            Log.d(TAG, "ActionBar setup with NavController.");
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        Log.d(TAG, "onSupportNavigateUp called.");
        return navController.navigateUp() || super.onSupportNavigateUp();
    }
}
