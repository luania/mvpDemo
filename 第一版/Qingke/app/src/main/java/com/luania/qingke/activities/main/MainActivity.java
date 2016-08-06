package com.luania.qingke.activities.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

import com.luania.qingke.R;
import com.luania.qingke.activities.common.BaseActivity;
import com.luania.qingke.activities.search.SearchActivity;
import com.luania.qingke.adapters.HomeFragmentAdapter;

public class MainActivity extends BaseActivity implements MainView {
    private Toolbar toolbar;
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;

    private MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainPresenter = new MainPresenter(this);
        findViews();
        initToolbar();
        initActionBarDrawerToggle();
        initViewPager();
    }

    private void findViews() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        navigationView = (NavigationView) findViewById(R.id.navigationView);
    }

    private void initToolbar() {
        toolbar.setTitle(R.string.qingke);
        toolbar.inflateMenu(R.menu.home);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if (item.getItemId() == R.id.itemSearch) {
                    mainPresenter.onSearchClicked();
                }
                return true;
            }
        });
    }

    private void initActionBarDrawerToggle() {
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                MainActivity.this,
                drawerLayout,
                toolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);
        drawerLayout.setDrawerListener(toggle);
        toggle.syncState();
    }

    private void initViewPager() {
        viewPager.setAdapter(new HomeFragmentAdapter(getSupportFragmentManager()));
        viewPager.setOffscreenPageLimit(3);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public void startSearchActivity() {
        startActivity(new Intent(MainActivity.this, SearchActivity.class));
        overridePendingTransition(R.anim.alpha_in, R.anim.alpha_out);
    }

    @Override
    public void onBackPressed() {
        mainPresenter.onBackPressed();
    }

    @Override
    public boolean isDrawerOpen() {
        return drawerLayout.isDrawerOpen(navigationView);
    }

    @Override
    public void closeDrawer() {
        drawerLayout.closeDrawer(navigationView);
    }

    @Override
    public void toastMorePress() {
        Toast.makeText(this, R.string.more_press_exit, Toast.LENGTH_SHORT).show();
    }
}
