package com.example.myapplication.view;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.myapplication.R;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;
    int itemLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        //selectFragment(new PrincipalFragment());

        setSupportActionBar(binding.appBarMain.toolbar);

        //usuarioEstaLogueado();

        SharedPreferences sharPrefe = getSharedPreferences("UsuarioLogueado", Context.MODE_PRIVATE);
        Log.d("MainActivity","Recurso: "+sharPrefe.getString("UsuarioObj",""));

        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;



        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.principalFragment, R.id.registrarCitaFragment, R.id.misCitasFragment)
                .setOpenableLayout(drawer)
                .build();


        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.principalFragment:
                        navController.navigate(R.id.principalFragment);
                        break;
                    case R.id.registrarCitaFragment:
                        navController.navigate(R.id.registrarCitaFragment);
                        break;
                    case R.id.misCitasFragment:
                        break;
                    case R.id.logoutFragment:
                        SharedPreferences sharedPreferences = getSharedPreferences("UsuarioLogueado", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.remove("UsuarioObj");
                        editor.putBoolean("isLogged",false);
                        editor.apply();
                        usuarioEstaLogueado();
                        break;
                }

                // Cierra el Drawer después de manejar la selección
                drawer.closeDrawer(GravityCompat.START);

                return true; // Devuelve true para indicar que el evento ha sido manejado
            }
        });

    }

    private void usuarioEstaLogueado() {

            // El usuario ha iniciado sesión, abrir directamente la MainActivity
            startActivity(new Intent(this, Login_Activity.class));
            finish();  // Opcional: Finalizar esta actividad para que no aparezca en la pila

    }

    void selectFragment(Fragment f){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.drawer_layout,f).commit();
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }


}