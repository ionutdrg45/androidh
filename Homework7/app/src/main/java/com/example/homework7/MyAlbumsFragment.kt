package com.example.homework7

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.homework7.databinding.FragmentMyAlbumsBinding


class MyAlbumsFragment : Fragment() {

    lateinit var binding: FragmentMyAlbumsBinding;

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        (activity as MainActivity).supportActionBar?.title = getString(R.string.my_albums)

        binding = FragmentMyAlbumsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRv()
    }

    private fun setupRv() {
        val recyclerview = binding.recyclerview

        recyclerview.layoutManager = LinearLayoutManager(requireContext())

        val data = ArrayList<AlbumViewModel>()

        // This loop will create 20 Views containing
        // the image with the count of view
        for (i in 1..20) {
            data.add(AlbumViewModel("Name " + i, "https://upload.wikimedia.org/wikipedia/commons/thumb/4/4a/Eminem_-_Concert_for_Valor_in_Washington%2C_D.C._Nov._11%2C_2014_%282%29_%28Cropped%29.jpg/220px-Eminem_-_Concert_for_Valor_in_Washington%2C_D.C._Nov._11%2C_2014_%282%29_%28Cropped%29.jpg", "genre",
                i%3 == 0, 2))
        }

        // This will pass the ArrayList to our Adapter
        val adapter = AlbumAdapter(data)

        // Setting the Adapter with the recyclerview
        recyclerview.adapter = adapter

        adapter.setAlbumClickListener(object: AlbumAdapter.FavAlbumClickListener{
            var activity: Activity? = getActivity()
            override fun onAlbumImageClicked(album: AlbumViewModel) {
                Toast.makeText(activity, "Album image: ${album.thumbnail}", Toast.LENGTH_SHORT).show()
            }

            override fun onAlbumDetailsClicked(album: AlbumViewModel) {
                Toast.makeText(activity, "Album name: ${album.name}", Toast.LENGTH_SHORT).show()
            }

            override fun onHeartClicked(album: AlbumViewModel) {
                album.favourite = !album.favourite
            }
        })
    }
}