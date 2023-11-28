package ir.nima.navigationcomponent

import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import ir.nima.navigationcomponent.databinding.FragmentLoginBinding


class login : Fragment() {
    lateinit var binding: FragmentLoginBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
       binding = FragmentLoginBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {


        val navController = findNavController()

        Handler().postDelayed({
            navController.navigate(R.id.action_login_to_loninUserFragment)
        }, 4000) // زمان تاخیر (میلی‌ثانیه)

    }





    }
