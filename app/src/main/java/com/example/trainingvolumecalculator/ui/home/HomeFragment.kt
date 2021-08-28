package com.example.trainingvolumecalculator.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.trainingvolumecalculator.R
import com.example.trainingvolumecalculator.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

//        val textView: TextView = binding.textHome
//        homeViewModel.text.observe(viewLifecycleOwner, Observer {
//            textView.text = it
//        })

        binding.btCalculate.setOnClickListener {
            binding.totalVolume.text = CalculateVolume()
            var target_volume:Int = binding.editTargetVolume.text.toString().toInt()
            binding.volumeGap.text = (binding.totalVolume.text.toString().toInt()
                - target_volume).toString()
            Toast.makeText(activity,"計算完了",Toast.LENGTH_SHORT).show()
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    fun CalculateVolume():String {
        var kg_1st:Int = binding.weightSet1.text.toString().toInt()
        var times_1st:Int = binding.timesSet1.text.toString().toInt()
        var kg_2nd:Int = binding.weightSet2.text.toString().toInt()
        var times_2nd:Int = binding.timesSet2.text.toString().toInt()
        var kg_3rd:Int = binding.weightSet3.text.toString().toInt()
        var times_3rd:Int = binding.timesSet3.text.toString().toInt()
        var kg_4th:Int = binding.weightSet4.text.toString().toInt()
        var times_4th:Int = binding.timesSet4.text.toString().toInt()
        val total_volume: String =  (kg_1st * times_1st +
                    kg_2nd * times_2nd +
                    kg_3rd * times_3rd +
                    kg_4th * times_4th).toString()
        return total_volume
    }

//    fun CalculateVolumeGap(): String {
//        var kg_1st:Int = binding.weightSet1.text.toString().toInt()
//        var times_1st:Int = binding.timesSet1.text.toString().toInt()
//        var kg_2nd:Int = binding.weightSet2.text.toString().toInt()
//        var times_2nd:Int = binding.timesSet2.text.toString().toInt()
//        var kg_3rd:Int = binding.weightSet3.text.toString().toInt()
//        var times_3rd:Int = binding.timesSet3.text.toString().toInt()
//        var kg_4th:Int = binding.weightSet4.text.toString().toInt()
//        var times_4th:Int = binding.timesSet4.text.toString().toInt()
//        val total_volume: Int =  (kg_1st * times_1st +
//                kg_2nd * times_2nd +
//                kg_3rd * times_3rd +
//                kg_4th * times_4th).toString().toInt()
//        var target_volume:Int = binding.editTargetVolume.text.toString().toInt()
//        var volume_gap:String = (target_volume - total_volume).toString()
//        return volume_gap
//    }




}