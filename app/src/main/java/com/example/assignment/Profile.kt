package com.example.assignment

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.assignment.Adapters.EssentialsAdapter
import com.example.assignment.Adapters.RewardsAdapter
import com.example.assignment.Classes.Essentials
import com.example.assignment.Classes.Rewards
import javax.net.ssl.ExtendedSSLSession

class Profile : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_profile)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        val EssentialsRecycler = findViewById<RecyclerView>(R.id.essentialsRecyclerView)
        val RewardsRecycler = findViewById<RecyclerView>(R.id.RewardsRecyclerView)

        EssentialsRecycler.layoutManager = LinearLayoutManager(this)
        var essentialsAdapter: EssentialsAdapter
        var rewardsAdapter : RewardsAdapter

        val divider = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        ContextCompat.getDrawable(this, R.drawable.divider)?.let {
            divider.setDrawable(it)
        }


        val essentialsList = listOf(
            Essentials(R.drawable.speedometer,"credit score","•REFRESH AVAILABLE",true,"757"),
            Essentials(R.drawable.rupee,"lifetime cashback","",false,"\u20B9 3"),
            Essentials(R.drawable.upi,"credit score","",false,"check"),
        )
        EssentialsRecycler.addItemDecoration(divider)
        EssentialsRecycler.layoutManager = LinearLayoutManager(this)
        essentialsAdapter = EssentialsAdapter(essentialsList)
        EssentialsRecycler.adapter = essentialsAdapter


        val rewardsList = listOf(
            Rewards("cashback balance","\u20B90"),
            Rewards("coins","26,46,583"),
            Rewards("win upto Rs 1000","refer and earn")
        )
        RewardsRecycler.addItemDecoration(divider)
        RewardsRecycler.layoutManager = LinearLayoutManager(this)
        rewardsAdapter = RewardsAdapter(rewardsList)
        RewardsRecycler.adapter = rewardsAdapter


        findViewById<ImageView>(R.id.BackPageArrow).setOnClickListener {
            finish()
        }

    }
}