package com.sns.notifyapp.view.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.sns.notifyapp.R
import com.sns.notifyapp.databinding.NotifyListRowBinding
import com.sns.notifyapp.model.NotifyData

class ItemAdapter(private val itmeListArr:ArrayList<NotifyData>) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    class ItemViewHolder(private val bindingView:NotifyListRowBinding) : RecyclerView.ViewHolder(bindingView.root) {
        lateinit var vvBinding:NotifyListRowBinding
        init {
            this.vvBinding = bindingView
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {

        val binding:NotifyListRowBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context),R.layout.notify_list_row, parent, false)
        return ItemViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return itmeListArr.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        var notifyData = itmeListArr.get(position)
        holder.vvBinding.notifyData = notifyData
        holder.vvBinding.executePendingBindings()
    }
}