package com.sw10k.zhe.sw10k;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.sw10k.zhe.sw10k.adapter.SectionsPagerAdapter;
import com.sw10k.zhe.sw10k.fragment.CameraFragment;
import com.sw10k.zhe.sw10k.fragment.GalleryFragment;
import com.sw10k.zhe.sw10k.listener.OnFragmentInteractionListener;

public class NavigationDrawerActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener, OnFragmentInteractionListener {

    private Toolbar toolbar, toolbarChild;
    private FloatingActionButton fab;
    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;
    private TabLayout tabLayout;
    private DrawerLayout drawer;
    private ActionBarDrawerToggle toggle;
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_drawer);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
//        toolbarChild = (Toolbar) findViewById(R.id.toolbar_child);

        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(this);

        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        mViewPager = (ViewPager) findViewById(R.id.navigation_drawer_container);
        mViewPager.setOffscreenPageLimit(mSectionsPagerAdapter.getCount());
        mViewPager.setAdapter(mSectionsPagerAdapter);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);
        for (int i = 0; i < tabLayout.getTabCount(); i++) {
            TabLayout.Tab tab = tabLayout.getTabAt(i);
            if (tab != null) {
                tab.setIcon(mSectionsPagerAdapter.getTabImageId(i));
            }
        }

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);
//        navigationView.setCheckedItem(R.id.nav_camera);
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.app_bar_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_camera:
//                setSupportActionBar(toolbarChild);
                toggleFragment(CameraFragment.newInstance("", ""));
                break;
            case R.id.nav_gallery:
                toggleFragment(GalleryFragment.newInstance("", ""));
                break;
            case R.id.nav_slideshow:
                break;
            case R.id.nav_manage:
                break;
            case R.id.nav_share:
                break;
            case R.id.nav_send:
                break;
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void toggleFragment(Fragment curFragment) {
        Log.d("aa", "toggleFragment");
        FragmentManager manager = getSupportFragmentManager();
        String tag = curFragment.getClass().getSimpleName();
//        FragmentTransaction transaction = obtainFragmentTransaction(manager, postion);
        FragmentTransaction transaction = manager.beginTransaction();
        Fragment fragment = manager.findFragmentByTag(tag);
        if (fragment == null) {
            try {
                // 替换时保留Fragment,以便复用
                transaction.replace(R.id.navigation_drawer_content, curFragment, tag);
                transaction.addToBackStack(tag);
            } catch (Exception e) {
                // ignore
            }
        } else {
            transaction.replace(R.id.navigation_drawer_content, fragment, tag);
        }
        transaction.commit();
    }

//    private FragmentTransaction obtainFragmentTransaction(FragmentManager manager, boolean bBack) {
//        FragmentTransaction ft = manager.beginTransaction();
//        // 设置切换动画
//        if (!bBack) {
//            ft.setCustomAnimations(R.anim.fragment_slide_in_from_right, R.anim.fragment_slide_out_to_left);
//        } else {
//            ft.setCustomAnimations(R.anim.fragment_slide_in_from_left, R.anim.fragment_slide_out_to_right);
//        }
//        return ft;
//    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fab:
                Snackbar.make(v, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                break;
        }
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
