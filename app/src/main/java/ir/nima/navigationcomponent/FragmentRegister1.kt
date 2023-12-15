package ir.nima.navigationcomponent

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import ir.nima.navigationcomponent.databinding.FragmentProfileBinding
import ir.nima.navigationcomponent.databinding.FragmentRegister1Binding
import ir.nima.navigationcomponent.databinding.FragmentRegisterBinding


class FragmentRegister1 : Fragment() {

    lateinit var binding: FragmentRegister1Binding
    lateinit var sharedPreferences : SharedPreferences
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = FragmentRegister1Binding.inflate(layoutInflater)

        return binding.root

    }

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

        binding.btnSubmit.setOnClickListener {

            if (binding.edtBirthday.text != null &&
                binding.edtName.text != null &&
                binding.edtPhone.text != null &&
                binding.edtEmail.text != null &&
                binding.edtPassword.text != null
            ){

                val name = binding.edtName.text.toString()
                val birthday = binding.edtBirthday.text.toString()
                val phone = binding.edtPhone.text.toString()
                val email = binding.edtEmail.text.toString()
                val password = binding.edtPassword.text.toString()

                sharedPreferences.edit().putString("name" , name).apply()
                sharedPreferences.edit().putString("birthday" , birthday).apply()
                sharedPreferences.edit().putString("phone" , phone).apply()
                sharedPreferences.edit().putString("email" , email).apply()
                sharedPreferences.edit().putString("password" , password).apply()


            }else {
                Toast.makeText(context, "همه مقادیر را وارد نمایید", Toast.LENGTH_SHORT).show()
            }











        }




    }


}