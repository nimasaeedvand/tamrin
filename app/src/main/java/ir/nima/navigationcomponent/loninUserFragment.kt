package ir.nima.navigationcomponent

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import ir.nima.navigationcomponent.databinding.FragmentLoginBinding
import ir.nima.navigationcomponent.databinding.FragmentLoninUserBinding


class loninUserFragment : Fragment() {
    lateinit var binding : FragmentLoninUserBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = FragmentLoninUserBinding.inflate(layoutInflater)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        binding.btnLogin.setOnClickListener {

            findNavController().navigate(R.id.action_loninUserFragment_to_fragment_home)



        }


    }


    }
