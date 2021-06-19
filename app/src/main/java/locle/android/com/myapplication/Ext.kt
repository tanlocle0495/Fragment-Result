package locle.android.com.myapplication

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction


fun Fragment.baseActivity(): BaseActivity? = (activity as? BaseActivity)
fun Any.className(): String = javaClass.simpleName

fun BaseFragment.push(
    fragment: BaseFragment,
    transition: Transition = Transition.NONE,
    backStack: Boolean = false
) {
    baseActivity()?.push(fragment, transition)
}

fun FragmentTransaction.customAnimations(
    transition: Transition
) {
    when (transition) {
        Transition.PUSH -> {
            setCustomAnimations(
                R.anim.fragment_transition_slide_in_from_right,
                R.anim.fragment_transition_fade_out,
                R.anim.fragment_transition_fade_in,
                R.anim.fragment_transition_slide_out_to_right
            )
        }
        Transition.MODAL -> {
            setCustomAnimations(
                R.anim.fragment_transition_slide_in_from_bottom,
                R.anim.fragment_transition_fade_out,
                R.anim.fragment_transition_fade_in,
                R.anim.fragment_transition_slide_out_to_bottom
            )
        }
        Transition.FADE -> {
            setCustomAnimations(
                R.anim.fragment_transition_fade_in,
                R.anim.fragment_transition_fade_out,
                R.anim.fragment_transition_fade_in,
                R.anim.fragment_transition_fade_out
            )
        }
        Transition.NONE -> {
            setCustomAnimations(
                0,
                0,
                0,
                0
            )
        }
    }

}


