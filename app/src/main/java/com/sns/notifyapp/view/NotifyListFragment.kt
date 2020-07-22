package com.sns.notifyapp.view

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sns.notifyapp.R
import com.sns.notifyapp.viewmodel.NotifyListViewModel
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import com.sns.notifyapp.utils.Utilites
import com.sns.notifyapp.view.adapters.NotifyListAdapter

class NotifyListFragment : Fragment() {


    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this@NotifyListFragment)
        super.onAttach(context)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle? ): View? {

        val root = inflater.inflate(R.layout.fragment_notify_list, container, false)

        val itemRecyclerView: RecyclerView = root.findViewById(R.id.notifyListRecyclerView)
        itemRecyclerView.apply {
            layoutManager = LinearLayoutManager(activity?.baseContext)
            addItemDecoration(DividerItemDecoration(activity?.baseContext, DividerItemDecoration.VERTICAL))
            adapter = NotifyListAdapter(Utilites.getNotifyListArr())
        }

        return root
    }

}
