package com.example.bai29api

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var rclView: RecyclerView
    private val list: MutableList<User> = mutableListOf()
    lateinit var adapter: CustomAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rclView = findViewById(R.id.rclView)
        adapter = CustomAdapter(list)
        rclView.adapter = adapter
        rclView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)


        callUser()
    }

    private fun callUser() {
        NetWork.apiNetWork.getDataUser().enqueue(object : Callback<List<User>> {
            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                list.clear()
                list.addAll(response.body() ?: emptyList())
                adapter = CustomAdapter(list.toList())
                rclView.adapter = adapter
                Log.d("xxx", "${list}")
                Toast.makeText(this@MainActivity, "vippro", Toast.LENGTH_SHORT).show()
            }

            override fun onFailure(call: Call<List<User>>, t: Throwable) {
                Toast.makeText(this@MainActivity, "qua ngu", Toast.LENGTH_SHORT).show()
            }
        })

    }

    /*    private fun getListUser(): List<User> {
            val list= ArrayList<User>()
            list.add(User(1,"22"))
            list.add(User(2,"s"))
            list.add(User(2,"das"))
            return list

        }*/
}