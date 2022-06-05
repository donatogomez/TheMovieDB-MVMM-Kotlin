package io.donatogomez.themoviedb.view.series

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import io.donatogomez.themoviedb.R
import io.donatogomez.themoviedb.model.presentation.SeriePresentation

class SeriesAdapter(private var data: ArrayList<SeriePresentation>) :
    RecyclerView.Adapter<SeriesAdapter.SeriesViewHolder>() {

    class SeriesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val serieName = itemView.findViewById<TextView>(R.id.serie_name)
        private val serieImageView = itemView.findViewById<ImageView>(R.id.serie_image)
        private val serieVoteCount = itemView.findViewById<TextView>(R.id.serie_vote_count)

        fun bind(serie: SeriePresentation, position: Int) {
            serieName.text = serie.name
            val imageURL = "https://image.tmdb.org/t/p/w500/${serie.posterPath}"
            Glide.with(serieImageView.context).load(imageURL).into(serieImageView)
            serieVoteCount.text = serie.voteCount.toString()
        }
    }

    fun updateSeries(movies: List<SeriePresentation>) {
        data.clear()
        data.addAll(movies)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SeriesViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_serie, parent, false)
        return SeriesViewHolder(view)
    }

    override fun onBindViewHolder(holder: SeriesViewHolder, position: Int) {
        val element = data[position]
        holder.bind(element, position)
    }

    override fun getItemCount(): Int {
        return data.size
    }

}