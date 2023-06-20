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

class MainActivity3 :AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var drawer: DrawerLayout
    private lateinit var toggle: ActionBarDrawerToggle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        val toolbar:androidx.appcompat.widget.Toolbar= findViewById(R.id.toolbar_main)
        setSupportActionBar(toolbar)

        drawer= findViewById(R.id.drawer_layout)

        toggle = ActionBarDrawerToggle(this,drawer,toolbar,R.string.navigation_drawer_open , R.string.navigation_drawer_close)
        drawer.addDrawerListener(toggle)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)

        val navigationView:NavigationView= findViewById(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener(this)
        hamPollo()
        hamMaxi()
        hamTocino()

        val buttonComprar = findViewById<Button>(R.id.button_comprar)
        buttonComprar.setOnClickListener {
            if (pollo > 0 || maxi > 0 || tocino > 0) {
                val intent = Intent(this, Ticket::class.java)
                intent.putExtra("pedido", intArrayOf(pollo, maxi, tocino))
                startActivity(intent)
            } else{
                Toast.makeText(this,"Necesitemos que compres", Toast.LENGTH_SHORT).show()
            }
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
            R.id.privacidad -> startActivity(Intent(this, Privacidad::class.java))
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    var pollo: Int = 0
    var maxi: Int = 0
    var tocino: Int = 0

    fun hamPollo() {
        val button6 = findViewById<Button>(R.id.button4)
        val button4 = findViewById<Button>(R.id.button6)
        button6.setOnClickListener {
            if (pollo <= 0) {
                Toast.makeText(this,"No podemos descontar más", Toast.LENGTH_SHORT).show()
            } else {
                pollo--;
                editarTextoDelBoton(R.id.button5, Integer.toString(pollo))
                Toast.makeText(this,"Un producto fue quitado del ticket", Toast.LENGTH_SHORT).show()
            }
        }
        button4.setOnClickListener {
            pollo++;
            editarTextoDelBoton(R.id.button5, Integer.toString(pollo))
            Toast.makeText(this,"Agregado Correctamente", Toast.LENGTH_SHORT).show()
        }
    }

    fun hamMaxi() {
        val button9 = findViewById<Button>(R.id.button9)
        val button7 = findViewById<Button>(R.id.button7)
        button7.setOnClickListener {
            if (maxi <= 0) {
                Toast.makeText(this,"No podemos descontar más", Toast.LENGTH_SHORT).show()
            } else {
                maxi--;
                editarTextoDelBoton(R.id.button8, Integer.toString(maxi))
                Toast.makeText(this,"Un producto fue quitado del ticket", Toast.LENGTH_SHORT).show()
            }
        }
        button9.setOnClickListener {
            maxi++;
            editarTextoDelBoton(R.id.button8, Integer.toString(maxi))
            Toast.makeText(this,"Agregado Correctamente", Toast.LENGTH_SHORT).show()
        }
    }

    fun hamTocino() {
        val button12 = findViewById<Button>(R.id.button12)
        val button10 = findViewById<Button>(R.id.button10)
        button10.setOnClickListener {
            if (tocino <= 0) {
                Toast.makeText(this,"No podemos descontar más", Toast.LENGTH_SHORT).show()
            } else {
                tocino--;
                editarTextoDelBoton(R.id.button11, Integer.toString(tocino))
                Toast.makeText(this,"Un producto fue quitado del ticket", Toast.LENGTH_SHORT).show()
            }
        }
        button12.setOnClickListener {
            tocino++;
            editarTextoDelBoton(R.id.button11, Integer.toString(tocino))
            Toast.makeText(this,"Agregado Correctamente", Toast.LENGTH_SHORT).show()
        }
    }

    fun editarTextoDelBoton(idBoton: Int, texto: String) {
        val button = findViewById<Button>(idBoton)
        button.text = texto
    }
}