package com.example.facebook

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.facebook.app.RestClient
import com.example.facebook.app.dto.Posts
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        RestClient.initClient()
        val recyclerView = findViewById<RecyclerView>(R.id.myRecyclerView)

        RestClient.reqResApi.getUsers().enqueue(
            object: Callback<MutableList<Posts>>{
                override fun onResponse(
                    call: Call<MutableList<Posts>>,
                    response: Response<MutableList<Posts>>
                ) {
                    if(response.isSuccessful){
                        recyclerView.apply{
                            layoutManager = LinearLayoutManager(this@MainActivity)
                            adapter = Adapter(response.body()!!)
                        }
                    }
                }

                override fun onFailure(call: Call<MutableList<Posts>>, t: Throwable) {
                    TODO("Not yet implemented")
                }

            }
        )
    }
}