package io.donatogomez.themoviedb.view.movies

import android.os.Bundle
import android.provider.Settings.Global.putString
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import io.donatogomez.themoviedb.R
import io.donatogomez.themoviedb.databinding.FragmentMoviesBinding
import io.donatogomez.themoviedb.view.detail.DetailFragment


@AndroidEntryPoint
class MoviesFragment : Fragment() {

    companion object {
        fun newInstance() = MoviesFragment()
    }

    private lateinit var binding: FragmentMoviesBinding
    private val viewModel: MoviesViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_movies, container, false)
        binding = FragmentMoviesBinding.bind(view)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = MoviesAdapter(ArrayList()) { movie ->
            Bundle().apply {
                putInt("id", movie.id)
                putString("title", movie.title)
                putString("image", movie.posterPath)
            }.also {
                val fragment = DetailFragment()
                fragment.arguments = it
                parentFragmentManager.beginTransaction().replace(R.id.fragment_container, fragment)
                    .commit()
            }
        }

        binding.myRecycler.adapter = adapter
        binding.myRecycler.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)

        //Pido los datos
        viewModel.getViewModelPopularMovies()
        //Observo los cambios
        viewModel.data.observe(viewLifecycleOwner) {
            adapter.updateMovies(it)
        }
    }
}