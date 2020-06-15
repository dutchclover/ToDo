package com.commonsware.todo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.content.Intent
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.todo_roster.*

class RosterListFragment : androidx.fragment.app.Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.todo_roster,container,false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        toolbar.title = getString(R.string.app_name)
        toolbar.inflateMenu(R.menu.actions)

        toolbar.setOnMenuItemClickListener { item ->
            when(item.itemId) {
            R.id.about -> startActivity(Intent(activity,AboutActivity::class.java))
            else -> return@setOnMenuItemClickListener false
        }
        true
        }
        val adapter = RosterAdapter(layoutInflater) {model ->
            ToDoRepository.save(model.copy(isCompleted = !model.isCompleted))
        }
        items.apply {
            setAdapter(adapter)
            layoutManager = LinearLayoutManager(context)

            addItemDecoration(DividerItemDecoration(activity,DividerItemDecoration.VERTICAL))
        }
        adapter.submitList(ToDoRepository.items)
        empty.visibility  = View.GONE
    }
}
