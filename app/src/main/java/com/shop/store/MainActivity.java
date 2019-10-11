package com.shop.store;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import com.shop.store.view.cart.CartFragment;
import com.shop.store.view.group.GroupFragment;
import com.shop.store.view.home.HomeFragment;
import com.shop.store.view.mine.MineFragment;
import com.shop.store.view.subject.SubjectFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.toolbar_tv)
    TextView toolbarTv;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    toolbar.setTitle("");
                    toolbarTv.setText("仿网易严选");
                    transaction.replace(R.id.frame, homeFragment).commit();
                    return true;
                case R.id.navigation_subject:
                    toolbar.setTitle("");
                    toolbarTv.setText("仿网易严选");
                    transaction.replace(R.id.frame, subjectFragment).commit();
                    return true;
                case R.id.navigation_group:
                    toolbar.setTitle("");
                    toolbarTv.setText("仿网易严选");
                    transaction.replace(R.id.frame, groupFragment).commit();
                    return true;
                case R.id.navigation_cart:
                    toolbar.setTitle("仿网易严选");
                    toolbarTv.setText("");
                    transaction.replace(R.id.frame, cartFragment).commit();
                    return true;
                case R.id.navigation_mine:
                    toolbar.setTitle("我的");
                    toolbarTv.setText("");
                    transaction.replace(R.id.frame, mineFragment).commit();
                    return true;
            }
            return false;
        }
    };
    private HomeFragment homeFragment;
    private SubjectFragment subjectFragment;
    private GroupFragment groupFragment;
    private CartFragment cartFragment;
    private MineFragment mineFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        homeFragment = new HomeFragment();
        subjectFragment = new SubjectFragment();
        groupFragment = new GroupFragment();
        cartFragment = new CartFragment();
        mineFragment = new MineFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.frame, homeFragment).commit();
    }

}
