package com.zoom.myapplication.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.zoom.myapplication.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private lateinit var carouselAdapter: CarouselAdapter
    private lateinit var categoryAdapter: CategoriesAdapter

    private val homeViewModel: HomeViewModel by viewModels()

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val recyclerView = binding.carouselRecyclerView
        val categoryRecyclerView = binding.categoryRecyclerView

        recyclerView.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        categoryRecyclerView.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)

        homeViewModel.response.observe(viewLifecycleOwner) { apiResponse ->
            val banners = apiResponse?.body()?.data?.banners ?: emptyList()
            carouselAdapter = CarouselAdapter(banners, requireContext())
            recyclerView.adapter = carouselAdapter

            val foodCategories = apiResponse?.body()?.data?.foodCategories ?: emptyList()
            categoryAdapter = CategoriesAdapter(foodCategories, requireContext())
            categoryRecyclerView.adapter = categoryAdapter
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
