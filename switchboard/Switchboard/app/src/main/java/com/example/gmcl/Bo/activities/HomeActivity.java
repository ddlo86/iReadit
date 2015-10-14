package com.example.gmcl.Bo.activities;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.support.design.widget.TabLayout;

import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.gmcl.Bo.Fragments.ContactsFragment;
import com.example.gmcl.Bo.Fragments.DetailsFragment;
import com.example.gmcl.Bo.Fragments.DocumentsFragment;
import com.example.gmcl.Bo.Fragments.HomeFragment;
import com.example.gmcl.Bo.*;
import com.example.gmcl.Bo.data.Job;
import com.example.gmcl.Bo.data.NonSwipeableViewPager;
import com.parse.ParseUser;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity implements DetailsFragment.MapViewSwipeListener{
//TODO: Pull a progress bar
    private Toolbar toolbar;
    private TabLayout tabLayout;
    //private ViewPager viewPager;
    private ParseUser user;
    NonSwipeableViewPager mViewPager;
    //ViewPager mViewPager;
    //TODO: make this more dynamic
    public static final String TAG = HomeActivity.class.getSimpleName();


    @Override
    public void onSwipeOn() {
        mViewPager.setSwipeable(false);
        Log.d(TAG, "onSwipeOn");
    }

    @Override
    public void onSwipeOff() {
        mViewPager.setSwipeable(true);
        Log.d(TAG, "onSwipeOff");
    }





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //TODO: What if null?
        user = ParseUser.getCurrentUser();

        //toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

//        mViewPager = (NonSwipeableViewPager) findViewById(R.id.viewpager);
        mViewPager = (NonSwipeableViewPager) findViewById(R.id.viewpager);
        setupViewPager(mViewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);

        tabLayout.setupWithViewPager(mViewPager);
    }




    private void setupViewPager(ViewPager viewPager) {

        Intent intent = getIntent();
        Job job = (Job) intent.getSerializableExtra("currentJob");
        Bundle bundle = new Bundle();
        bundle.putSerializable("currentJob", job);


        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new HomeFragment(), "HOME");

        Fragment detailsFragment = new DetailsFragment();
        detailsFragment.setArguments(bundle);

        //getSupportFragmentManager().findFragmentById(R.id.fr)

        adapter.addFragment(detailsFragment, "Details");

        adapter.addFragment(new DocumentsFragment(), "DOCUMENTS");
        adapter.addFragment(new ContactsFragment(), "CONTACTS");
        viewPager.setAdapter(adapter);

//        Bundle bundle = new Bundle();
//
//        MyCustomObject obj = new MyCustomObject();
//

    }




    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);

        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        if(id == R.id.action_logout) {

            //Do I need to call appcontext?
            new AlertDialog.Builder(this)
                    .setTitle(getString(R.string.menu_logout))
                    .setMessage(getString(R.string.logout_confirmation))
                    .setPositiveButton(getString(R.string.yes), new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            ParseUser.logOut();
                            Intent intent = new Intent(HomeActivity.this, LoginActivity.class);
                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK |
                                    Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(intent);
                            finish();
                            }
                    })
                    .setNegativeButton(getString(R.string.no), new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    })
                    .show();
            //getActivity().stopService(new Intent(getActivity(), LocationService.class))
        }

        return super.onOptionsItemSelected(item);
    }



}
