package ir.nima.navigationcomponent

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import ir.nima.navigationcomponent.databinding.FragmentLoginBinding
import ir.nima.navigationcomponent.databinding.FragmentLoninUserBinding


class loninUserFragment : Fragment() {
    lateinit var binding : FragmentLoninUserBinding
    lateinit var sharedPreferences : SharedPreferences
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = FragmentLoninUserBinding.inflate(layoutInflater)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        binding.btnLogin.setOnClickListener {
            sharedPreferences = requireActivity().getSharedPreferences("data" , Context.MODE_PRIVATE)
            val email = sharedPreferences.getString("email" , "").toString()
            val password = sharedPreferences.getString("password" , "").toString()

            if (binding.textInputEditText.text.toString() == email && binding.textInputEditText2.text.toString() == password){

                findNavController().navigate(R.id.action_loninUserFragment_to_fragment_home)


            }else {
                Toast.makeText(context, "نام کاربری یا رمزعبور اشتباه است", Toast.LENGTH_SHORT).show()

            }







        }
        binding.textNewAccunt.setOnClickListener {

            findNavController().navigate(R.id.action_loninUserFragment_to_fragmentRegister1)

        }


    }


    }
