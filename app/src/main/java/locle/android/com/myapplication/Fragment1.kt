package locle.android.com.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.FragmentResultListener

class Fragment1 : BaseFragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        parentFragmentManager.setFragmentResultListener(
            REQUEST_KEY,
            this,
            FragmentResultListener { result, pa2 ->
//                Preconditions.checkState(REQUEST_KEY == requestKey)
                val number = pa2.getInt(KEY_NUMBER)
                Toast.makeText(requireContext(), "$number", Toast.LENGTH_SHORT).show()
//                resultListenerNumberTextView.text =
//                    getString(R.string.result_listener_number_message, number)

            })

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_1, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<Button>(R.id.button).setOnClickListener {
            push(Fragment2.newInstance(), Transition.MODAL)
        }
    }

    companion object {
        const val REQUEST_KEY = "asasas"
        const val KEY_NUMBER = "KEY_NUMBER"
        fun newInstance() = Fragment1()
    }
}