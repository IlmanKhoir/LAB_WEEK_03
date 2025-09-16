package com.example.lab_week_03

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView


// Removed unused parameter arguments (ARG_PARAM1, ARG_PARAM2) and their corresponding properties (param1, param2).

/**
 * A simple [Fragment] subclass.
 * Use the [DetailFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DetailFragment : Fragment() {
    // Changed to lateinit var to ensure initialization in onViewCreated
    private lateinit var coffeeTitle: TextView
    private lateinit var coffeeDesc: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Removed arguments?.let block for param1 and param2 as they were unused.
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment. Assuming R.layout.fragment_detail is the correct layout file.
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Initialize TextViews here after the view has been created
        coffeeTitle = view.findViewById(R.id.coffee_title)
        coffeeDesc = view.findViewById(R.id.coffee_desc)

        val coffeeId = arguments?.getInt(COFFEE_ID, 0) ?: 0
        setCoffeeData(coffeeId)
    }

    fun setCoffeeData(id: Int){
        when(id){
            R.id.affogato -> {
                coffeeTitle.text = getString(R.string.affogato_title)
                coffeeDesc.text = getString(R.string.affogato_desc)
            }
            R.id.americano -> {
                coffeeTitle.text = getString(R.string.americano_title)
                coffeeDesc.text = getString(R.string.americano_desc)
            }
            R.id.latte -> {
                coffeeTitle.text = getString(R.string.latte_title)
                coffeeDesc.text = getString(R.string.latte_desc)
            }
        }
    }
    companion object {
        private const val COFFEE_ID = "COFFEE_ID"
        fun newInstance(coffeeId: Int) =
            DetailFragment().apply {
                arguments = Bundle().apply {
                    putInt(COFFEE_ID, coffeeId)
                }
            }
    }
}