package ir.nima.navigationcomponent

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ir.nima.navigationcomponent.databinding.DeletItemBinding
import ir.nima.navigationcomponent.databinding.EdtTaskBinding
import ir.nima.navigationcomponent.databinding.FragmentHome2Binding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FragmentHomeButten.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragmentHomeButten : Fragment() , Godata ,evant{
    lateinit var binding: FragmentHome2Binding
    lateinit var datalist:ArrayList<data>
    lateinit var adaptor: Adaptor
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentHome2Binding.inflate(layoutInflater)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?)  {

        datalist  = arrayListOf(data("go gym" , "1402/2/8") , data("simple" , "1402/8/9"))



         adaptor = Adaptor(datalist,this)
        binding.rrcyclerMain.adapter = adaptor
        binding.rrcyclerMain.layoutManager = LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)

        binding.fabMain.setOnClickListener{

            val dialog = Fragment_add(this)
            dialog.show(childFragmentManager,null)

        }

        binding.rrcyclerMain.setOnClickListener {

            Toast.makeText(context, "item select", Toast.LENGTH_SHORT).show()



        }


    }

    override fun GOdata(date: String, task: String) {
        val newtask = data(task, date)
        adaptor.addnewtask(newtask)


    }

    override fun longclick(data: data, position: Int) {
        val dialog = AlertDialog.Builder(requireContext()).create()
        val dialogDeleteBinding = DeletItemBinding.inflate(layoutInflater)
        dialog.setView(dialogDeleteBinding.root)
        dialog.setCancelable(true)

        dialog.show()

        dialogDeleteBinding.btnNo.setOnClickListener {
            dialog.dismiss()
        }

        dialogDeleteBinding.btnYes.setOnClickListener {
            adaptor.deletItem(data , position)
            dialog.dismiss()


        }



    }

    override fun onClick(data: data, position: Int) {

        val dialog = AlertDialog.Builder(requireContext()).create()
        val dialogDeleteBinding = EdtTaskBinding.inflate(layoutInflater)
        dialog.setView(dialogDeleteBinding.root)
        dialog.setCancelable(true)

        dialogDeleteBinding.edtDate.setText(data.time)
        dialogDeleteBinding.edtNewtask.setText(data.task)


        dialog.show()

        dialogDeleteBinding.btnCancle.setOnClickListener {
            dialog.dismiss()
        }

        dialogDeleteBinding.btnAdd.setOnClickListener {

            val newtask = dialogDeleteBinding.edtNewtask.text.toString()
            val newdate = dialogDeleteBinding.edtDate.text.toString()

            adaptor.updateitem(data(newtask,newdate),position)
            dialog.dismiss()







        }








    }


}

