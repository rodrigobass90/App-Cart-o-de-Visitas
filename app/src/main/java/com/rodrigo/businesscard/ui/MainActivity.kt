package com.rodrigo.businesscard.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.renderscript.ScriptGroup
import android.view.LayoutInflater
import com.rodrigo.businesscard.R
import com.rodrigo.businesscard.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val bindind by lazy {ActivityMainBinding.inflate(layoutInflater)}
    private val mainViewModel: MainViewModel by viewModels {
        MainViewModelFactory((application as App).repository)
    }

    private val adapter by lazy { BusinessCardAdapter()}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(bindind.root)
        binding.rvCards.adapter = adapter
        getAllBusinessCard()
        insertListener()

    }

    private fun insertListener () {
        binding.fab.setOnClicklistener{
            val Intent = Intent(this@MainActivity, AddBusinessCardActivity::class.java)
            startActivity(Intent)
        }
        adapter.listenerShare = { card ->
            image.share(this@MainActivity, card)
        }
    }


    private fun getAllBusinessCard() {
        mainViewModel.getAll().observe( owner: this) { businessCards ->
            adapter.submitList(businessCards)
        }
    }
}
