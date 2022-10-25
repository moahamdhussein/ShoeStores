package com.example.shoestores

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.ui.AppBarConfiguration
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.example.shoestores.databinding.ActivityMainBinding
import timber.log.Timber

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        Timber.plant(Timber.DebugTree())
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController

        val appBarConfiguration = getAppBarConfiguration()
        binding.toolbar.setupWithNavController(navController ,getAppBarConfiguration())
        setSupportActionBar(binding.toolbar)

        binding.toolbar.setNavigationOnClickListener{
            NavigationUI.navigateUp(navController,appBarConfiguration)
        }


    }

    private fun getAppBarConfiguration(): AppBarConfiguration{
        return AppBarConfiguration(
            setOf(
                R.id.welcomeFragment,
                R.id.shoeListFragment,
                R.id.loginFragment
            )
        )
    }

    override fun onSupportNavigateUp(): Boolean {
        return (Navigation.findNavController(this, R.id.nav_host_fragment).navigateUp()
                || super.onSupportNavigateUp())
    }
}