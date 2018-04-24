package id.simplify.prosperoinv.pengadaan;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import id.simplify.prosperoinv.Login;
import id.simplify.prosperoinv.R;


public class Pengadaan3Activity extends AppCompatActivity {
    FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pengadaan3);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Create an instance of the tab layout from the view.
        // Membuat adanya tab layout
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        // Set the text for each tab.
        //Setting nama masing-masing tab
        tabLayout.addTab(tabLayout.newTab().setText(R.string.tab_label1));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.tab_label2));
        // Set the tabs to fill the entire layout.
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        FirebaseUser a = FirebaseAuth.getInstance().getCurrentUser();
        if (a.getUid() != null) {
            Toast.makeText(this, a.getUid(), Toast.LENGTH_SHORT).show();
        }
        // Use PagerAdapter to manage page views in fragments.
        // Each page is represented by its own fragment.
        // This is another example of the adapter pattern.
        final ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        final PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        // Setting a listener for clicks.
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            //Apa yang terjadi ketika tab dipilih
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {}
            @Override
            public void onTabReselected(TabLayout.Tab tab) {}
        });
    }
    @Override
    //Mengaplikasikan menu di atas (Laporan)
    public boolean onCreateOptionsMenu(Menu menu_main) {
        getMenuInflater().inflate(R.menu.main_menu, menu_main);
        return true;
    }

    @SuppressLint("NewApi")
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            //Berpindah laman ke laporan
            Intent intent = new Intent(this, DetailBarang.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.logout) {
            //Logout dan mencegah dapat mengklik back
            FirebaseAuth.getInstance().signOut();
            Intent a = new Intent(this, Login.class);
            startActivity(a);
            finishAffinity();
            return true;
        } else if (id == R.id.tambahbarangbaru) {
            //Menambah barang mentah baru
            Intent b = new Intent(this, tbhbarangbaru.class);
            startActivity(b);
        } else if (id == R.id.tambahpesanan) {
            Intent c = new Intent(this,TambahPesanan.class);
            startActivity(c);

        }
        return super.onOptionsItemSelected(item);
    }


}
