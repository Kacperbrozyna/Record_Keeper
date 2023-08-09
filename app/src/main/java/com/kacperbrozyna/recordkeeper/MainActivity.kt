package com.kacperbrozyna.recordkeeper

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.fragment.app.commit
import com.google.android.material.navigation.NavigationBarView
import com.kacperbrozyna.recordkeeper.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity(), NavigationBarView.OnItemSelectedListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bottomNav.setOnItemSelectedListener(this)

    }

    private fun onRunningClicked() {
        supportFragmentManager.commit { replace(R.id.frame_content, RunningFragment()) }
    }

    private fun onCyclingClicked() {
        supportFragmentManager.commit { replace(R.id.frame_content, CyclingFragment()) }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.nav_cycling -> {
                onCyclingClicked()
                true
            }
            R.id.nav_running -> {
                onRunningClicked()
                true
            }
            else -> {
                false
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar, menu)
        return true;
    }

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
            R.id.reset_running -> true
            R.id.reset_cycling -> true
            R.id.reset_all_records -> true
            else -> super.onOptionsItemSelected(item)
    }
}