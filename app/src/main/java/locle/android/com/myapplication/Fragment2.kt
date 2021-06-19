package locle.android.com.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.os.bundleOf
import locle.android.com.myapplication.Fragment1.Companion.KEY_NUMBER
import locle.android.com.myapplication.Fragment1.Companion.REQUEST_KEY

class Fragment2 : BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_2, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<Button>(R.id.button).setOnClickListener {
//            activity?.onBackPressed()
            parentFragmentManager.popBackStack()
            parentFragmentManager.setFragmentResult(
                REQUEST_KEY,
                bundleOf(KEY_NUMBER to 1)
            )
        }


    }

    companion object {
        fun newInstance() = Fragment2()
    }
}