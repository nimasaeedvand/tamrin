package ir.nima.navigationcomponent

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ir.nima.navigationcomponent.databinding.ItemRecyclerBinding

class Adaptor ( val data: ArrayList<data> ) : RecyclerView.Adapter<Adaptor.viewHolder>() {

    inner class viewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val txt_task = itemView.findViewById<CheckBox>(R.id.txtTask)
        val txt_time = itemView.findViewById<TextView>(R.id.txtTime)


        fun bindView(position: Int){

            txt_task.text = data[position].task
            txt_time.text = data[position].time


        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        val binding = ItemRecyclerBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return viewHolder(binding.root)

    }

    override fun getItemCount(): Int {

       return data.size
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {

        holder.bindView(position)
    }

    fun addnewtask(newdata: data){
        data.add(0 , newdata)
        notifyItemInserted(0)


    }


}