package com.zoom.myapplication.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.zoom.myapplication.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private lateinit var carouselAdapter: CarouselAdapter
    private lateinit var categoryAdapter: CategoriesAdapter
    private lateinit var collectionAdapter: CollectionAdapter
    private lateinit var restaurantCollectionAdapter: RestaurantCollectionAdapter

    private val homeViewModel: HomeViewModel by viewModels()

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
        val collectionRecyclerView = binding.collectionRecyclerView
        val restaurantCollectionRecyclerView = binding.restaurantCollectionRecyclerView


        collectionRecyclerView.layoutManager =
            GridLayoutManager(requireContext(), 2)
        collectionAdapter = CollectionAdapter(emptyList(), requireContext())
        collectionRecyclerView.adapter = collectionAdapter

        recyclerView.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)

        categoryRecyclerView.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)

        restaurantCollectionRecyclerView.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)


        homeViewModel.response.observe(viewLifecycleOwner) { apiResponse ->
            val banners = apiResponse?.body()?.data?.banners ?: emptyList()
            carouselAdapter = CarouselAdapter(banners, requireContext())
            recyclerView.adapter = carouselAdapter

            val foodCategories = apiResponse?.body()?.data?.foodCategories ?: emptyList()
            categoryAdapter = CategoriesAdapter(foodCategories, requireContext())
            categoryRecyclerView.adapter = categoryAdapter

            val collection = apiResponse?.body()?.data?.offerCollections ?: emptyList()
            collectionAdapter = CollectionAdapter(collection, requireContext())
            collectionRecyclerView.adapter = collectionAdapter

            val restaurantCollections =
                apiResponse?.body()?.data?.restaurantCollections ?: emptyList()
            val sortedRestaurantCollections = restaurantCollections.sortedBy { it.priority }
            restaurantCollectionAdapter =
                RestaurantCollectionAdapter(sortedRestaurantCollections, requireContext())
            collectionRecyclerView.adapter = collectionAdapter

            val restaurantCollectionAdapter =
                RestaurantCollectionAdapter(sortedRestaurantCollections, requireContext())
            restaurantCollectionRecyclerView.adapter = restaurantCollectionAdapter

        }

        homeViewModel.isLoading.observe(viewLifecycleOwner) { isLoading ->
            if (isLoading) {
                binding.progressBar.visibility = View.VISIBLE
            } else {
                binding.progressBar.visibility = View.GONE
            }
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
