package com.example.geektech_hw3_m5.model

data class PixabayModel (
    val hits : List<ImageModel>
)

data class ImageModel(
    val largeImageURL:String
)
