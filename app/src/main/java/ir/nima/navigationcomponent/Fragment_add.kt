package ir.nima.navigationcomponent

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import ir.nima.navigationcomponent.databinding.AddNewTaskBinding

class Fragment_add(val godata: Godata) :DialogFragment() {
lateinit var binding: AddNewTaskBinding



    @SuppressLint("SuspiciousIndentation")
    override fun onCreateDialog(savedInstanceState: Bundle? ): Dialog {

        binding = AddNewTaskBinding.inflate(layoutInflater)

      val dialog=   AlertDialog.Builder(context)
            .setView(binding.root)
          .create()

        binding.btnCancle.setOnClickListener {

            dialog.dismiss()

        }

        binding.btnAdd.setOnClickListener {

            if (binding.edtDate.text != null && binding.edtNewtask.text != null){

                val newtask = binding.edtNewtask.text.toString()
                val date = binding.edtDate.text.toString()

                godata.GOdata(date,newtask)

                dialog.dismiss()



            }

        }

        return dialog

    }

}
interface Godata{

    fun GOdata( date : String , task:String)


}