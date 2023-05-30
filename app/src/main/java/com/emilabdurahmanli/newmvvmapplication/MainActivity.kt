package com.emilabdurahmanli.newmvvmapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.emilabdurahmanli.newmvvmapplication.databinding.ActivityMainBinding
import com.emilabdurahmanli.newmvvmapplication.view_model.MainActivityViewModel
import com.squareup.picasso.Picasso

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private lateinit var spinner : ProgressBar
    private lateinit var viewModel : MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[MainActivityViewModel::class.java]

        spinner = findViewById(R.id.progressBar1)
        spinner.visibility = View.GONE

        binding.changeButton.setOnClickListener {
            spinner.visibility = View.VISIBLE
            viewModel.getCoffeeImage(this)
        }

        viewModel.observeCoffeeImage().observe(this, Observer { coffeImage ->
            Picasso.get().load(coffeImage).into(binding.cofeeImage)
            spinner.visibility = View.GONE
        })

    }





}