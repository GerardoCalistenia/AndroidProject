package com.example.tarea02

import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class MainActivity2 : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener{
    private lateinit var drawer: DrawerLayout
    private lateinit var toggle: ActionBarDrawerToggle

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val btn3: Button = findViewById(R.id.button2)
        setOnClickListener(btn3, MainActivity3::class.java)

        val toolbar:androidx.appcompat.widget.Toolbar= findViewById(R.id.toolbar_main)
        setSupportActionBar(toolbar)

        drawer= findViewById(R.id.drawer_layoutdos)

        toggle = ActionBarDrawerToggle(this,drawer,toolbar,R.string.navigation_drawer_open , R.string.navigation_drawer_close)
        drawer.addDrawerListener(toggle)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)

        val navigationView:NavigationView= findViewById(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener(this)
    }

    fun setOnClickListener(button: Button, activity: Class<*>) {
        button.setOnClickListener {
            val intent = Intent(this, activity)
            startActivity(intent)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.nav_item_one -> {
                val intent = Intent(this, MainActivity2::class.java)
                startActivity(intent)
            }
            R.id.nav_item_two -> {
                val intent = Intent(this, MapsFinal::class.java)
                startActivity(intent)
            }
            R.id.nav_item_three -> {
                val intent = Intent(this, SobreNosotros::class.java)
                startActivity(intent)
            }
            R.id.nav_item_six -> {
                val intent = Intent(this, Pagar ::class.java)
                startActivity(intent)
            }
        }
        drawer.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        toggle.syncState()
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        toggle.onConfigurationChanged(newConfig)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)){
            return true
        }
        when(item.itemId){
            R.id.restaurantes -> startActivity(Intent(this, MapsFinal::class.java))
            R.id.sobre -> startActivity(Intent(this, SobreNosotros::class.java))
            //R.id.privacidad -> startActivity(Intent(this, Privacidad::class.java))
            R.id.privacidad -> {
                val intent = Intent(this, Ticket::class.java)
                intent.putExtra("pedido", intArrayOf(10, 0, 3))
                startActivity(intent)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}