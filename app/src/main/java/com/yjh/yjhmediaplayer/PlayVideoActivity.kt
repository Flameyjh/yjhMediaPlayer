package com.yjh.yjhmediaplayer

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.VideoView

/*
* 2. VideoView播放视频
* 视频资源在res/raw文件夹下
* */
class PlayVideoActivity : AppCompatActivity() {

    lateinit var videoView: VideoView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_play_video)

        val uri = Uri.parse("android.resource://$packageName/${R.raw.video}")

        videoView = findViewById<VideoView>(R.id.videoView)
        videoView.setVideoURI(uri)

        findViewById<Button>(R.id.play).setOnClickListener {
            if (!videoView.isPlaying){
                videoView.start() //开始播放
            }
        }
        findViewById<Button>(R.id.pause).setOnClickListener {
            if (videoView.isPlaying){
                videoView.pause() //暂停播放
            }
        }
        findViewById<Button>(R.id.replay).setOnClickListener {
            videoView.resume() //重新播放
            videoView.start()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        videoView.suspend()
    }
}