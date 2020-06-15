package com.commonsware.todo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import androidx.fragment.app.commit
import androidx.fragment.app.transaction
import kotlinx.android.synthetic.main.todo_roster.*

class MainActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    if(supportFragmentManager.findFragmentById(android.R.id.content)== null){
      supportFragmentManager.beginTransaction().add(android.R.id.content, RosterListFragment()).commit()
    }
  }
}
