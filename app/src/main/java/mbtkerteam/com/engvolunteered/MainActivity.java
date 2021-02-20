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

public class MainActivity extends AppCompatActivity {


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_mothq:

                    MothqFragment mothqFragment = new MothqFragment();
                    FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.Guest_Continer, mothqFragment);
                    fragmentTransaction.commit();

                    return true;
                case R.id.navigation_guest_challenges:

                    ChallengesFragment settingsFragment = new ChallengesFragment();
                    FragmentTransaction fragmentTransaction3 = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction3.replace(R.id.Guest_Continer, settingsFragment);
                    fragmentTransaction3.commit();

                    return true;
                case R.id.navigation_idea:

                    IdeaFragment ideaFragment = new IdeaFragment();
                    FragmentTransaction fragmentTransactiodn3 = getSupportFragmentManager().beginTransaction();
                    fragmentTransactiodn3.replace(R.id.Guest_Continer, ideaFragment);
                    fragmentTransactiodn3.commit();

                    return true;
                case R.id.navigation_guest_events:

                    EventsFragment eventsFragment = new EventsFragment();
                    FragmentTransaction fragmentTransaction4 = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction4.replace(R.id.Guest_Continer, eventsFragment);
                    fragmentTransaction4.commit();

                    return true;
                case R.id.navigation_guest_more:

                    MoreGuestFragment moreFragment = new MoreGuestFragment();
                    FragmentTransaction fragmentTransaction5 = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction5.replace(R.id.Guest_Continer, moreFragment);
                    fragmentTransaction5.commit();

                    return true;
            }
            return false;
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navView = findViewById(R.id.nav_view);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        View view = navView.findViewById(R.id.navigation_mothq);
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