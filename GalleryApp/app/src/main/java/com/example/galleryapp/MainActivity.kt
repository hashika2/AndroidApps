package com.example.galleryapp

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import androidx.core.content.FileProvider
import kotlinx.android.synthetic.main.activity_main.*
import java.io.File
import java.io.IOException
import java.net.URI
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    var currentPath:String? =null
    val TAKE_PCTURE =1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonGallery.setOnClickListener {

        }
        buttonCamera.setOnClickListener {

        }
    }

    @SuppressLint("MissingSuperCall")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode ==TAKE_PCTURE && resultCode == Activity.RESULT_OK){
            try {
                val file =File(currentPath)
                val uri =Uri.fromFile(file)
                imageView.setImageURI(uri)

            }catch (e:IOException){
                e.printStackTrace()
            }
        }
    }

    fun dispatchCameraIntent(){

        val intent =Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        if(intent.resolveActivity(packageManager)!=null){
            var photFile:File? =null
            try {
                photFile = createImage()
            }catch (e: IOException){
                e.printStackTrace()
            }
            if (photFile != null){

                //YOU MUST CREATE A CONTENT PROVIDER MATCHING THE AUTHORITY
                var photoUrl =FileProvider.getUriForFile(this,
                    "com.countocode.cameraexample.fileprovider",photFile)
                intent.putExtra(MediaStore.EXTRA_OUTPUT,photoUrl)
                startActivityForResult(intent,TAKE_PCTURE)
            }
        }
    }

    fun createImage():File{
        val timeStamp =SimpleDateFormat("yyyyMMdd_HHmmss").format(Date())
        val imageName="JPEG_"+timeStamp +"_"
        var storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES)
        var image = File.createTempFile(imageName,".jpg",storageDir)
        currentPath =image.absolutePath
        return image
    }
}
