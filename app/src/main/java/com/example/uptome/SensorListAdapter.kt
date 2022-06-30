package com.example.uptome

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class SensorListAdapter : ListAdapter<Activity, SensorListAdapter.SensorViewHolder>(ActivityComparator()) {

    override fun onCreateViewHolder(parent:ViewGroup, viewType: Int): SensorViewHolder {
        return SensorViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: SensorViewHolder, position: Int){
        val current = getItem(position)
        holder.bind(current.sensed_activity)
    }

    class SensorViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView){
        private val activityItemView: TextView = itemView.findViewById((R.id.textView2))

        fun bind(text: String?){
            activityItemView.text = text
        }

        companion object {
            fun create(parent: ViewGroup):SensorViewHolder {
                val view: View = LayoutInflater.from(parent.context)
                    .inflate(R.layout.recyclerview_item, parent, false)
                return SensorViewHolder(view)
            }
        }
    }

    class ActivityComparator : DiffUtil.ItemCallback<Activity>(){
        override fun areItemsTheSame(oldItem: Activity, newItem: Activity): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Activity, newItem: Activity): Boolean {
            return oldItem.sensed_activity == newItem.sensed_activity
        }
    }
}