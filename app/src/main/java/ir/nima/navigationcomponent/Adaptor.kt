package ir.nima.navigationcomponent

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import ir.nima.navigationcomponent.databinding.ItemRecyclerBinding
import kotlin.coroutines.coroutineContext

class Adaptor ( val data: ArrayList<data> , val evant: evant) : RecyclerView.Adapter<Adaptor.viewHolder>() {

    inner class viewHolder( itemView: View):RecyclerView.ViewHolder(itemView){
        val txt_task = itemView.findViewById<CheckBox>(R.id.txtTask)
        val txt_time = itemView.findViewById<TextView>(R.id.txtTime)


        fun bindView(position: Int){

            txt_task.text = data[position].task
            txt_time.text = data[position].time


            itemView.setOnClickListener{

                evant.onClick(data[adapterPosition] , adapterPosition)



            }

            itemView.setOnLongClickListener{


                evant.longclick(data[adapterPosition] , adapterPosition)


                true
            }



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

    fun updateitem(data : data , position: Int){

        this.data.set(position,data)
        notifyItemChanged(position)


    }

    fun deletItem(data: data , position: Int){
        this.data.remove(data)
        notifyItemRemoved(position)

    }



}
interface evant {

    fun longclick (data: data , position: Int)
    fun onClick(data: data,position: Int)


}