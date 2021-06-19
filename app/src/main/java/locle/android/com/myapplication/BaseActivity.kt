package locle.android.com.myapplication

import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {
    fun push(fragment: BaseFragment, transition: Transition = Transition.NONE) {
        val fragTransaction = supportFragmentManager.beginTransaction()
        fragTransaction.add(R.id.container, fragment)
            .setCustomAnimations(
                R.anim.fragment_transition_fade_in,
                R.anim.fragment_transition_fade_out,
                R.anim.fragment_transition_fade_in,
                R.anim.fragment_transition_fade_out
            )
            .addToBackStack(fragment.className())
        fragTransaction.commit()
    }

    fun replace(fragment: BaseFragment) {
        supportFragmentManager.beginTransaction()
            .add(R.id.container, fragment)
            .addToBackStack(fragment.className())
            .commit()
    }

    fun pop(count: Int = 1) {
        while (count > 0) {
        }
    }

}

