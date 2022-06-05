package io.donatogomez.themoviedb.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint
import io.donatogomez.themoviedb.R
import io.donatogomez.themoviedb.databinding.ActivityMainBinding
import io.donatogomez.themoviedb.view.movies.MoviesFragment
import io.donatogomez.themoviedb.view.series.SeriesFragment
import io.donatogomez.themoviedb.viewmodel.TheMovieDBViewModel

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: TheMovieDBViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction()
            .replace(binding.fragmentContainer.id, MoviesFragment.newInstance())
            .commit()

        binding.bottomNavBar.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.movies -> {
                    supportFragmentManager.beginTransaction()
                        .replace(binding.fragmentContainer.id, MoviesFragment.newInstance())
                        .commit()
                    true
                }
                R.id.series -> {
                    supportFragmentManager.beginTransaction()
                        .replace(binding.fragmentContainer.id, SeriesFragment.newInstance())
                        .commit()
                    true
                }
                else -> {
                    true
                }
            }
        }
    }
}