package com.yjh.yjhmediaplayer

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

/*
* 1. MediaPlayer播放音效
* 音效资源在assets文件夹下
* */
class PlayAudioActivity : AppCompatActivity() {

    private val mediaPlayer = MediaPlayer()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_play_audio)

        initMediaPlayer()

        findViewById<Button>(R.id.play).setOnClickListener {
            if (!mediaPlayer.isPlaying){
                mediaPlayer.start() //开始播放
            }
        }
        findViewById<Button>(R.id.pause).setOnClickListener {
            if (mediaPlayer.isPlaying){
                mediaPlayer.pause() //暂停播放
            }
        }
        findViewById<Button>(R.id.stop).setOnClickListener {
            if (mediaPlayer.isPlaying){
                mediaPlayer.reset() //停止播放
                initMediaPlayer()
            }
        }

    }

    private fun initMediaPlayer() {
        val assetManager = assets //assetManager用于读取assets目录下的任何资源
        val fd = assetManager.openFd("一样的月光.mp3")
        mediaPlayer.setDataSource(fd.fileDescriptor, fd.startOffset, fd.length)
        mediaPlayer.prepare()
    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer.stop()
        mediaPlayer.release()
    }
}