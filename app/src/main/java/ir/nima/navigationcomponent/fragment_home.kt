package ir.nima.navigationcomponent

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import ir.nima.navigationcomponent.databinding.FragmentHomeBinding


class fragment_home : Fragment() {
    lateinit var binding: FragmentHomeBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        return binding.root




    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val transaction = childFragmentManager.beginTransaction()
        transaction.replace(R.id.contaner , FragmentHomeButten() )
            .commit()

        binding.bottomNavigationView.setOnItemSelectedListener {

            when(it.itemId){

                R.id.home -> {

                    val transaction = childFragmentManager.beginTransaction()
                    transaction.replace(R.id.contaner , FragmentHomeButten() )
                        .commit()

                }

                R.id.register ->{

                    val transaction = childFragmentManager.beginTransaction()
                    transaction.replace(R.id.contaner , FragmentRegister() )
                        .commit()
                }


                R.id.profile ->{
                    val transaction = childFragmentManager.beginTransaction()
                    transaction.replace(R.id.contaner , Fragment_profile() )
                        .commit()

                }


            }

            return@setOnItemSelectedListener true


        }
    }


}