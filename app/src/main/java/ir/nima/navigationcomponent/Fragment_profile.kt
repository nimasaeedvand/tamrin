package ir.nima.navigationcomponent

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import ir.nima.navigationcomponent.databinding.FragmentProfileBinding


class Fragment_profile : Fragment() {

    lateinit var binding: FragmentProfileBinding
    lateinit var sharedPreferences : SharedPreferences
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = FragmentProfileBinding.inflate(layoutInflater)

        return binding.root

    }

    @SuppressLint("SuspiciousIndentation")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        sharedPreferences = requireActivity().getSharedPreferences("data" , Context.MODE_PRIVATE)

        val name = sharedPreferences.getString("name" , "")
        val birthday = sharedPreferences.getString("birthday" , "")
        val phone = sharedPreferences.getString("phone" , "")
        val email = sharedPreferences.getString("email" , "")
        val password = sharedPreferences.getString("password" , "")

        binding.edtPassword.setText(password)
        binding.edtName.setText(name)
        binding.edtBirthday.setText(birthday)
        binding.edtPhone.setText(phone)
        binding.edtEmail.setText(email)


        binding.btnEdite.setOnClickListener {

          val transaction = requireFragmentManager().beginTransaction()
            transaction.replace(R.id.contaner , FragmentRegister())
            transaction.commit()






        }





    }


}