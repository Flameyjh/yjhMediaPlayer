package com.yjh.yjhmediaplayer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

/*
* 1. MediaPlayer播放音效
* 2. VideoView播放视频
* */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //1. MediaPlayer播放音效
        findViewById<Button>(R.id.playAudioBtn).setOnClickListener {
            startActivity(Intent(this, PlayAudioActivity::class.java))
        }

        //2. VideoView播放视频
        findViewById<Button>(R.id.playVedioBtn).setOnClickListener {
            startActivity(Intent(this, PlayVideoActivity::class.java))
        }


    }
}