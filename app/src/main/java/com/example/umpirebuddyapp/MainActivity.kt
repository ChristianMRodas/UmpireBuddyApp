package com.example.umpirebuddyapp

import android.os.Bundle
import android.widget.TextView
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import android.view.View;

import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    var mynum = 0
    var curr_ball_count = 0
    var curr_strike_count = 0



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //This block will increment the ball count using the Ball Counter button
        BallNumber.setText("" + curr_ball_count )

        BallCounter.setOnClickListener {
            //If not working atm
            if (curr_ball_count  == 4) {
                BallNumber.setText("4 Balls, walk.")
            }
            BallNumber.setText("Current Ball Count: " + curr_ball_count ++)

        }

        //This block will increment the Strike count using the Strike Counter button
        StrikeNumber.setText("" + curr_strike_count )

        StrikeCounter.setOnClickListener {
            //If not working atm
            if (curr_strike_count == 0) {
                StrikeNumber.setText("Strike! You're Out!")
            }
            StrikeNumber.setText("Current Strike Count: " + curr_strike_count ++)

        }


        ResetButton.setOnClickListener {
            curr_ball_count  = curr_ball_count * mynum
            curr_strike_count  = curr_strike_count * mynum

            //BallNumber.setText(id)
            BallNumber.setText("Resetting back to Zero")
            StrikeNumber.setText("Resetting back to Zero")
        }


        ExitButton.setOnClickListener{
            finish()
            System.exit(0)
        }








        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications
            )
        )


        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)





    }
}
