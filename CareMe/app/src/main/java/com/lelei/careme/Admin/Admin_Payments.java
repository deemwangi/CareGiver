package com.lelei.careme.Admin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;
import com.lelei.careme.Helpers.Admin_Payments_Current;
import com.lelei.careme.Helpers.Admin_Payments_Previous;
import com.lelei.careme.R;

import java.util.ArrayList;
import java.util.List;

public class Admin_Payments extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_payment);
        tabLayout=findViewById(R.id.tabLayout);
        viewPager=findViewById(R.id.viewPager);
        Toast.makeText(Admin_Payments.this, "Swipe to mark the payment!", Toast.LENGTH_LONG).show();
        //TODO

    }


}
