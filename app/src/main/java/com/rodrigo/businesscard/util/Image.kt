package com.rodrigo.businesscard.util

class Image {
    companion object {

    }
    fun share(context : context, card: view) {
        val bitmap = getScreeenShotFromView(view)

        bitmap?.let {it:Bitmap
            saveMediaToStorage(context, card)

        }

    }


    private fun getScreenShotFromView(card: View): Bitmao? {
        var screenshot: Bitmap? = null
        try {

            screenshot = Bitmap.createBitmap(
                card.measuredWidth,
                card.measureHeight,
                Bitmap.Config.ARBG_8888
            )
            val canvas = canvas(screenshot)
            card.draw(canvas)
        } catch (e: Exception) {
            log.e(tag:"Error->", msg"Falha ap capturar imagem" + e.message)

        }
        return screenshot
    }

    private fun saveMediaToStorage(context: Context, bitmap:Bitmap){
        val filename = "${System.currentTimeMillis()}.jpg"

        var fos: OutputStream?= null

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            context.contentResolver?.also { resolver ->

                val contentValues = ContentValues().apply {this:ContentValues
                    put(MediaStore.MediaColumns.DISPLAY_NAME, filename)
                    put(MediaStore.MediaColumns.MIME_TYPE, "image/jpg")
                    put(MediaStore.MediaColumns.RELATIVE_PATH, Enviroment.DIRECTORY_PICTURES)

                }

    var imagUri: uri? =
        resolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues)

    fos= imageUri?.let {it:Uri
        shareIntent(context, imageUri)
        resolver.openOutputStream(it)
    }
            }

        }else{
//Devices rodando < Q
            val imagesDir = context.getExternalFilesDir(Enviroment.DIRECTORY_PICTURES)
            val image = File(imagesDir, filename)
            shareIntent(context, uri.fromFile(image))
            fos = FileOutputStream(image)
        }

        fos?.use {it:OutpuStream)
            bitmap.compress(Bitmap.CompressFormat.JPEG, quality 100, it)
            Toast.makeText(context, text:"Imagem capturada com sucesso", Toast.LENGTH_SHORT).show()
        }
    }


    private fun shareIntent(context: context, imageUri: uri): OutputStream? {
        var shareIntent: Intent = Intent().apply {this:Intent
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_STREAM, imageUri)
            type = "image/jpeg"
        }
        context.startActivity(
            Intent.createChooser(
                shareIntent,
                context.resources.getText(R.string.label_shar)
    }
}
}