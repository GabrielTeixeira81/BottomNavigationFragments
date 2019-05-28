package br.com.digitalhouse.bottomnavigationfragments.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import br.com.digitalhouse.bottomnavigationfragments.R;
import br.com.digitalhouse.bottomnavigationfragments.dashboard.DashboardFragment;
import br.com.digitalhouse.bottomnavigationfragments.home.HomeFragment;
import br.com.digitalhouse.bottomnavigationfragments.notifications.NotificacaoFragment;
import br.com.digitalhouse.bottomnavigationfragments.settings.ConfiguracoesFragment;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navigation = findViewById(R.id.navigation);

        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        switch (menuItem.getItemId()) {

        case R.id.navigation_home:
        //Fragment para Home
            replaceFragment(new HomeFragment());
        return true;

        case R.id.navigation_dashboard:
        //Fragment para Dashboard
            replaceFragment(new DashboardFragment());
        return true;

        case R.id.navigation_notifications:
        //Fragment para Notifications
            replaceFragment(new NotificacaoFragment());
        return true;

        case R.id.navigation_settings:
        //Fragment para Configurações
            replaceFragment(new ConfiguracoesFragment());
        return true;
            }

                return false;
            }
        });
    }

    private void replaceFragment(Fragment fragment){
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.container, fragment);
        transaction.commit();
        }

}
