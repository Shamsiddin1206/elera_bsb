package com.example.elera.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.core.content.ContextCompat
import androidx.viewpager2.widget.ViewPager2
import com.example.elera.Adapters.ViewPagerAdapter
import com.example.elera.DataClasses.ViewPagerData
import com.example.elera.R
import com.example.elera.databinding.FragmentIntroductionBinding

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class IntroductionFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    lateinit var viewPagerAdapter: ViewPagerAdapter
    lateinit var binding: FragmentIntroductionBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentIntroductionBinding.inflate(inflater, container, false)
        SetOnboardingItems()
        setIndicators()
        CheckIndicator(0)
        return binding.root
    }

    private fun SetOnboardingItems(){
        viewPagerAdapter = ViewPagerAdapter(
            listOf(
                ViewPagerData(R.drawable.qizforviewpager, "We provide the best learning courses and great mentors!"),
                ViewPagerData(R.drawable.menwithglasses, "Learn anytime and anywhere easily and conveniently"),
                ViewPagerData(R.drawable.secondgirlforviewpager, "Let`s improve your skills together with Elera right now!")
                ) as MutableList<ViewPagerData>
        )
        binding.viewpagerIntroduction.adapter = viewPagerAdapter
        binding.viewpagerIntroduction.registerOnPageChangeCallback(
            object : ViewPager2.OnPageChangeCallback(){
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    CheckIndicator(position)
                }
            }
        )
    }

    private fun setIndicators(){
        val indicators = arrayOfNulls<ImageView>(viewPagerAdapter.itemCount)
        val layoutParams: LinearLayoutCompat.LayoutParams =
            LinearLayoutCompat.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
        layoutParams.setMargins(8, 0, 8, 0)
        for (i in indicators.indices){
            indicators[i] = ImageView(requireContext())
            indicators[i]?.let {
                it.setImageDrawable(
                    ContextCompat.getDrawable(
                        requireContext(),
                        R.drawable.indicator2
                    )
                )
                it.layoutParams = layoutParams
                binding.indicatorLayout.addView(it)
            }
        }
    }

    private fun CheckIndicator(position: Int){
        val childCount = binding.indicatorLayout.childCount
        for (i in 0..childCount-1){
            val imageView = binding.indicatorLayout.getChildAt(i) as ImageView
            if (i==position){
                imageView.setImageDrawable(
                    ContextCompat.getDrawable(
                        requireContext(),
                        R.drawable.indicator
                    )
                )
            } else{
                imageView.setImageDrawable(
                    ContextCompat.getDrawable(
                        requireContext(),
                        R.drawable.indicator2
                    )
                )
            }
        }
        if (position==3){
            binding.introductionButton.text = "Get Started"
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            IntroductionFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}