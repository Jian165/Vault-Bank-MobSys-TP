package com.example.vaultbank;

import android.os.Bundle;
import android.view.ViewGroup;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;

public class Dashboard extends AppCompatActivity {
    private TabLayout tlManuBar;
    private ViewPager2 vp2Dashboard;
    private DashboardFragmentAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_dashboard);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        LoadComponenets();

        FragmentManager fragmentManager = getSupportFragmentManager();
        adapter = new DashboardFragmentAdapter(fragmentManager,getLifecycle());
        vp2Dashboard.setAdapter(adapter);

        tlManuBar.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            boolean isFromLeft;
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                vp2Dashboard.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        vp2Dashboard.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                tlManuBar.selectTab(tlManuBar.getTabAt(position));
            }
        });
    }

    private void LoadComponenets(){
       tlManuBar = findViewById(R.id.tl_menuBar) ;
       vp2Dashboard = findViewById(R.id.vp2_Dashboard) ;
    }
}