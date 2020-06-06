package com.portales.proyecto_apps.principal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.navigation.findNavController
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.portales.proyecto_apps.R
import com.portales.proyecto_apps.login.LoginActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.drawer_header.view.*

class MainActivity : AppCompatActivity() {

    private val user = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        navigationOptions()
        val action = ActionBarDrawerToggle(
            this,
            drawer_layout,
            toolbar,
            R.string.openDrawer,
            R.string.closeDrawer
        )
        drawer_layout.addDrawerListener(action)
        action.syncState()

        updateUI()

    }

    private fun navigationOptions() {
        nav_view.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.nav_inicio -> {
                    findNavController(R.id.fragmentmain).navigate(R.id.inicioFragment)
                }

                R.id.nav_rutina_diaria -> {
                    findNavController(R.id.fragmentmain).navigate(R.id.rutinaDiariaFragment)
                }
                R.id.nav_publicar_rutina -> {
                    findNavController(R.id.fragmentmain).navigate(R.id.publicarRutinaFragment)
                }
                R.id.nav_rutinas_comunidad -> {
                    findNavController(R.id.fragmentmain).navigate(R.id.rutinasComunidadFragment)
                }
                R.id.nav_rutinas_favs -> {
                    findNavController(R.id.fragmentmain).navigate(R.id.rutinasFavoritasFragment)
                }
                R.id.nav_ajustes -> {
                    findNavController(R.id.fragmentmain).navigate(R.id.ajustesFragment)
                }
                R.id.nav_signout -> {
                    user.signOut()
                    startActivity(Intent(this, LoginActivity::class.java))
                    finish()
                }
            }
            drawer_layout.closeDrawer(GravityCompat.START)
            return@setNavigationItemSelectedListener true
        }
    }


    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    private fun updateUI(){
        val navheader = nav_view.getHeaderView(0)
        navheader.txtUsername.text = user.currentUser?.displayName
        navheader.txtUserEmail.text = user.currentUser?.email
    }

}