package io.donatogomez.themoviedb.view.detail

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import io.donatogomez.themoviedb.R
import io.donatogomez.themoviedb.databinding.FragmentDetailBinding
import io.donatogomez.themoviedb.view.movies.MoviesViewModel

@AndroidEntryPoint
class DetailFragment : Fragment() {

    companion object {
        fun newInstance() = DetailFragment()
    }

    private lateinit var binding: FragmentDetailBinding
    private val viewModel: DetailViewModel by viewModels()
    private var isFavorite: Boolean = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_detail, container, false)
        binding = FragmentDetailBinding.bind(view)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.favBtn.setOnFavoriteChangeListener { buttonView, favorite ->
            if (favorite) {
                // TODO: addToFavorites(MovieNetwork)
                Snackbar.make(buttonView, "Añadido a favoritos", Snackbar.LENGTH_SHORT).show()
            } else {
                // TODO: removeFromFavorites(MovieNetwork)
                Snackbar.make(buttonView, "Eliminado de favoritos", Snackbar.LENGTH_SHORT).show()
            }
        }

        val args = this.arguments
        val idData = args?.getInt("id")
        val titleData = args?.get("title")
        val imageData = args?.get("image")

        binding.detailTitle.text = titleData.toString()
        val imageURL = "https://image.tmdb.org/t/p/w500/${imageData}"
        Glide.with(binding.detailImage.context).load(imageURL).into(binding.detailImage)

        Log.d("idData", idData.toString())

        idData?.let { viewModel.getViewModelMovieDetails(it) }

        Log.d("MovieDetails", idData?.let { viewModel.getViewModelMoviesDetails(it) }.toString())
        viewModel.data.observe(viewLifecycleOwner){
            binding.detailDescription.text = idData.toString()
        }
    }
}