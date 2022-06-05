package io.donatogomez.themoviedb.view.series

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import io.donatogomez.themoviedb.R
import io.donatogomez.themoviedb.databinding.FragmentSeriesBinding

@AndroidEntryPoint
class SeriesFragment : Fragment() {

    companion object {
        fun newInstance() = SeriesFragment()
    }

    private lateinit var binding: FragmentSeriesBinding
    private val viewModel: SeriesViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_series, container, false)
        binding = FragmentSeriesBinding.bind(view)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = SeriesAdapter(ArrayList())

        binding.myRecycler.adapter = adapter
        binding.myRecycler.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)

        //Pido los datos
        viewModel.getViewModelPopularSeries()
        //Observo los cambios
        viewModel.data.observe(viewLifecycleOwner) {
            adapter.updateSeries(it)
        }
    }
}
