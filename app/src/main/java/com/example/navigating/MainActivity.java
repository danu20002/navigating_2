package com.example.navigating;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

 BottomNavigationView bottomnavigation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomnavigation=findViewById(R.id.bottmnav);
         bottomnavigation.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
             @Override
             public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                 int id=item.getItemId();
                 if(id==R.id.nav_home){
                    loadfrag(new homefragment(),false);
                 }else if(id==R.id.nav_search){
                    loadfrag(new searchfrag(),false);
                 }else if(id==R.id.nav_utilities){
                   loadfrag(new utilitesfrag(),false);
                 }else if(id==R.id.contacts){
                    loadfrag(new contactfrag(),false);
                 }else{
               loadfrag(new profilefrag(),false);
                 }
                 return true;
             } 

         });
        bottomnavigation.setSelectedItemId(R.id.nav_profile);
    }
    public void loadfrag(Fragment fragment,boolean flag){
        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        ft.add(R.id.framelayout,fragment);
        if(flag){
            ft.add(R.id.framelayout,fragment);
        }else{
            ft.replace(R.id.framelayout,fragment);
        }
        ft.commit();
    }
}