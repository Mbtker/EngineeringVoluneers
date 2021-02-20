package mbtkerteam.com.engvolunteered;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import mbtkerteam.com.engvolunteered.Helpers.IdeaFragment;

public class EngMainActivity extends AppCompatActivity {

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_volunteer:

                    VolunteerFragment volunteerFragment = new VolunteerFragment();
                    FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.Continer, volunteerFragment);
                    fragmentTransaction.commit();

                    return true;
                case R.id.navigation_groups:

                    GroupsFragment groupsFragment = new GroupsFragment();
                    FragmentTransaction fragmentTransaction2 = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction2.replace(R.id.Continer, groupsFragment);
                    fragmentTransaction2.commit();

                    return true;
                case R.id.navigation_challenges:

                    ChallengesFragment settingsFragment = new ChallengesFragment();
                    FragmentTransaction fragmentTransaction3 = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction3.replace(R.id.Continer, settingsFragment);
                    fragmentTransaction3.commit();

                    return true;
                case R.id.navigation_idea:

                    IdeaFragment ideaFragment = new IdeaFragment();
                    FragmentTransaction fragmentTransactionr = getSupportFragmentManager().beginTransaction();
                    fragmentTransactionr.replace(R.id.Guest_Continer, ideaFragment);
                    fragmentTransactionr.commit();

                    return true;
                case R.id.navigation_events:

                    EventsFragment eventsFragment = new EventsFragment();
                    FragmentTransaction fragmentTransaction4 = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction4.replace(R.id.Continer, eventsFragment);
                    fragmentTransaction4.commit();

                    return true;
                case R.id.navigation_more:

                    MoreFragment moreFragment = new MoreFragment();
                    FragmentTransaction fragmentTransaction5 = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction5.replace(R.id.Continer, moreFragment);
                    fragmentTransaction5.commit();

                    return true;
            }
            return false;
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eng_main);

        BottomNavigationView navView = findViewById(R.id.nav_view);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        View view = navView.findViewById(R.id.navigation_volunteer);
        view.performClick();


    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}