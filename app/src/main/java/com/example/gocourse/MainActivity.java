package com.example.gocourse;

import android.os.Bundle;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";  // 定义日志的标签
    private NavController navController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Log savedInstanceState
            Log.d(TAG, "onCreate: savedInstanceState = " + savedInstanceState);

        // 设置全屏显示，内容延伸到系统栏区域
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);

        setContentView(R.layout.activity_main);
            Log.d(TAG, "setContentView: activity_main layout loaded.");

        // 处理系统栏的边距
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
                Log.d(TAG, "Insets applied: left=" + systemBars.left + ", top=" + systemBars.top +
                    ", right=" + systemBars.right + ", bottom=" + systemBars.bottom);
            return WindowInsetsCompat.CONSUMED;
        });

        // 初始化 NavController
        navController = Navigation.findNavController(this, R.id.nav_host_fragment);
            Log.d(TAG, "NavController initialized: navController = " + navController);

        // 设置 AppBarConfiguration
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
            Log.d(TAG, "AppBarConfiguration set with nav graph.");

        // 设置 ActionBar 与 NavController 联动（如果需要）
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
            Log.d(TAG, "ActionBar setup with NavController.");
    }

    @Override
    public boolean onSupportNavigateUp() {
            Log.d(TAG, "onSupportNavigateUp called.");
        boolean result = navController.navigateUp();
            Log.d(TAG, "NavController navigateUp result: " + result);
        return result;
    }
}
