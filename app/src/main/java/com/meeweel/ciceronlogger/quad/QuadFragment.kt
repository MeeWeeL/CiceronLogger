package com.meeweel.ciceronlogger.quad

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.meeweel.ciceronlogger.R
import com.meeweel.ciceronlogger.databinding.QuadFragmentLayoutBinding
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class QuadFragment : MvpAppCompatFragment(R.layout.quad_fragment_layout), QuadView {

    private lateinit var viewBinging: QuadFragmentLayoutBinding
    private val presenter : QuadPresenter by moxyPresenter {
        QuadPresenter()
    }
    lateinit var listener: View.OnClickListener

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinging = QuadFragmentLayoutBinding.bind(view)
        setListener()
        viewBinging.calculateButton.setOnClickListener(listener)
    }

    private fun setListener() {
        listener = View.OnClickListener {
            val value: String = viewBinging.userInputValue.text.toString()
            presenter.calculate(value)
        }
    }
    override fun showResult(text: String) {
        viewBinging.resultOutput.text = text
    }

    override fun calculate(value: String) {
        presenter.calculate(value)
    }

    override fun toast(text: String) {
        Toast.makeText(requireContext(), text, Toast.LENGTH_SHORT).show()
    }

    companion object {
        fun newInstance(): Fragment = QuadFragment()
    }
}