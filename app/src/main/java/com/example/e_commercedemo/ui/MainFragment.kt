package com.example.e_commercedemo.ui

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.e_commercedemo.R
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            val id = when (item.itemId) {
                R.id.menu_home -> {
                    toolbar.title = "Home"
                    R.id.homeFragment
                }
                R.id.menu_notifications -> {
                    toolbar.title = "Notifications"
                    R.id.notificationsFragment
                }
                R.id.menu_favorite -> {
                    toolbar.title = "Favorite"
                    R.id.favoriteFragment
                }
                R.id.menu_settings -> {
                    toolbar.title = "Settings"
                    R.id.settingsFragment
                }
                else -> null
            }

            id?.let {
                Navigation.findNavController(
                    requireActivity(),
                    R.id.navHostHome
                ).navigate(it)
            }

            return@setOnNavigationItemSelectedListener true
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.main_menu, menu)
    }
}