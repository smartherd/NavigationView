package com.annie.smartherd.navigationview;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

	private Toolbar mToolbar;
	private DrawerLayout mDrawerLayout;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		setupToolbarMenu();
		setupNavigationDrawerMenu();
	}

	private void setupToolbarMenu() {

		mToolbar = (Toolbar) findViewById(R.id.toolbar);
		mToolbar.setTitle("Navigation View");
	}

	private void setupNavigationDrawerMenu() {

		NavigationView navigationView = (NavigationView) findViewById(R.id.navigationView);
		mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
		navigationView.setNavigationItemSelectedListener(this);

		ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this,
				mDrawerLayout,
				mToolbar,
				R.string.drawer_open,
				R.string.drawer_close);

		mDrawerLayout.addDrawerListener(drawerToggle);
		drawerToggle.syncState();
	}

	@Override // Called when Any Navigation Item is Clicked
	public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

//		menuItem.setCheckable(true);
//		menuItem.setChecked(true);  // This helps to know which Menu Item is Clicked

		String itemName = (String) menuItem.getTitle();

		Toast.makeText(MainActivity.this, itemName + " Clicked", Toast.LENGTH_SHORT).show();

		closeDrawer();

		switch (menuItem.getItemId()) {

			case R.id.item_facebook:
				// Put your Item specific Code here
				break;

			case R.id.item_bag:
				// Put your item specific Code here
				break;
		}

		return true;
	}

	// Close the Drawer
	private void closeDrawer() {
		mDrawerLayout.closeDrawer(GravityCompat.START);
	}

	// Open the Drawer
	private void showDrawer() {
		mDrawerLayout.openDrawer(GravityCompat.START);
	}

	@Override
	public void onBackPressed() {
		if (mDrawerLayout.isDrawerOpen(GravityCompat.START))
			closeDrawer();
		else
			super.onBackPressed();
	}
}
