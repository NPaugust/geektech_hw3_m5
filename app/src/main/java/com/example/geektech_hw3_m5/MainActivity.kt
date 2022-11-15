package com.example.geektech_hw3_m5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import com.example.geektech_hw3_m5.databinding.ActivityMainBinding
import com.example.geektech_hw3_m5.model.PixabayModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding
    var adapter = PixabayAdapter(listOf())
    var page = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initClicker()
    }

    private fun initClicker() {
        with(binding){




          binding.recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener(){

              override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                  super.onScrollStateChanged(recyclerView, newState)


              if (!recyclerView.canScrollVertically(1)){
                  ++page
                  requestByImage(page)
                  }
              }



          })

            addPhotoBtn.setOnClickListener {
              ++page
                requestByImage(page)
            }
            requestBtn.setOnClickListener {
                requestByImage(page)
            }
        }
    }




    private fun ActivityMainBinding.requestByImage(page : Int) {

        App.api.getImage(keyWord = keyEd.text.toString(), page = page).enqueue(object : Callback<PixabayModel> {
            override fun onResponse(
                call: Call<PixabayModel>,
                response: Response<PixabayModel>
            ) {
                if (response.isSuccessful) {
                    response.body()?.hits?.let {
                        adapter = PixabayAdapter(it)
                        recyclerView.adapter = this@MainActivity.adapter
                    }

                }
            }


            override fun onFailure(call: Call<PixabayModel>, t: Throwable) {
                Log.e("ololo", "onFailure${t.message}")
            }



        })
    }}
/*
{
    "total": 33624,
    "totalHits": 500,
    "hits": [
    {
        "id": 2295434,
        "pageURL": "https://pixabay.com/photos/spring-bird-bird-tit-spring-blue-2295434/",
        "type": "photo",
        "tags": "spring bird, bird, tit",
        "previewURL": "https://cdn.pixabay.com/photo/2017/05/08/13/15/spring-bird-2295434_150.jpg",
        "previewWidth": 150,
        "previewHeight": 99,
        "webformatURL": "https://pixabay.com/get/g05ec3877793bf4da7446ee5eae1340919359dc6bfc585a3b3ff9c7e78591eae78cc11a109261ec7a5860a2cc9447727a8dc7081fe225bc85435d91df9ddbe0e8_640.jpg",
        "webformatWidth": 640,
        "webformatHeight": 426,
        "largeImageURL": "https://pixabay.com/get/gaa5e956dc67685ef963e2c6454d68d5918d25e7607e04b920aaf35d7c5befead9c9229c89e41882e2bd5d21c772c520301ab2560c89547eb3818c45f54a38e03_1280.jpg",
        "imageWidth": 5363,
        "imageHeight": 3575,
        "imageSize": 2938651,
        "views": 574371,
        "downloads": 322092,
        "collections": 2002,
        "likes": 1943,
        "comments": 240,
        "user_id": 334088,
        "user": "JillWellington",
        "userImageURL": "https://cdn.pixabay.com/user/2018/06/27/01-23-02-27_250x250.jpg"
    },
    {
        "id": 3063284,
        "pageURL": "https://pixabay.com/photos/rose-flower-petal-floral-noble-3063284/",
        "type": "photo",
        "tags": "rose, flower, petal",
        "previewURL": "https://cdn.pixabay.com/photo/2018/01/05/16/24/rose-3063284_150.jpg",
        "previewWidth": 150,
        "previewHeight": 99,
        "webformatURL": "https://pixabay.com/get/g3010fac2351e16836006b55558425f2785b995952c6d619c263a3aede757772ba8714bc9f31586b6e7077754890d09829f595706bb19cbb466d4666d93340ca9_640.jpg",
        "webformatWidth": 640,
        "webformatHeight": 426,
        "largeImageURL": "https://pixabay.com/get/g93e808b2b927e399b4a9565798840d389a10e067c0cee6cff225ae0d32449e9d81378449fe0e9c7681795f3090356c16525ffd773b6b7940864867598d31002e_1280.jpg",
        "imageWidth": 6000,
        "imageHeight": 4000,
        "imageSize": 3574625,
        "views": 1018533,
        "downloads": 656797,
        "collections": 1374,
        "likes": 1508,
        "comments": 330,
        "user_id": 1564471,
        "user": "anncapictures",
        "userImageURL": "https://cdn.pixabay.com/user/2015/11/27/06-58-54-609_250x250.jpg"
    },
    {
        "id": 1127174,
        "pageURL": "https://pixabay.com/photos/sunflower-flower-plant-petals-1127174/",
        "type": "photo",
        "tags": "sunflower, flower, plant",
        "previewURL": "https://cdn.pixabay.com/photo/2016/01/08/05/24/sunflower-1127174_150.jpg",
        "previewWidth": 150,
        "previewHeight": 99,
        "webformatURL": "https://pixabay.com/get/g47d06518f58510ab7aaeb1fde1a33d9ff9cefcae5747cd6985486f2a70dfae00c2c5fc70c5f84925b0c5ecef91ab099fbf66a0ec7e284a8c77057a8627cb6b17_640.jpg",
        "webformatWidth": 640,
        "webformatHeight": 426,
        "largeImageURL": "https://pixabay.com/get/g5630c22993ec0fa53692bb88da0989a445e7ea4e7e2b6e375aa3e2d76938d685cb65877a01e214f5dd14f82fc0315160a5fc1629542ad1465345782897bb4a74_1280.jpg",
        "imageWidth": 4752,
        "imageHeight": 3168,
        "imageSize": 3922163,
        "views": 432193,
        "downloads": 270229,
        "collections": 1040,
        "likes": 1041,
        "comments": 149,
        "user_id": 1445608,
        "user": "mploscar",
        "userImageURL": "https://cdn.pixabay.com/user/2016/01/05/14-08-20-943_250x250.jpg"
    },
    {
        "id": 887443,
        "pageURL": "https://pixabay.com/photos/flower-life-yellow-flower-crack-887443/",
        "type": "photo",
        "tags": "flower, life, yellow flower",
        "previewURL": "https://cdn.pixabay.com/photo/2015/08/13/20/06/flower-887443_150.jpg",
        "previewWidth": 150,
        "previewHeight": 116,
        "webformatURL": "https://pixabay.com/get/g7ba729b658be2fa1905f3725c9acef4a0df80c23bffea98e86fee9243ded66aef9daeaf634eac6a1087498c12a084712_640.jpg",
        "webformatWidth": 640,
        "webformatHeight": 497,
        "largeImageURL": "https://pixabay.com/get/g42d9ac6aa6cefc77b4f6d52a5eead69e692b57529117d13e99e0c39da1fe58d6f4585b50b6c435164b0285c018051b9eacce5339846b0a0e0a5650efd82fcd8f_1280.jpg",
        "imageWidth": 3867,
        "imageHeight": 3005,
        "imageSize": 2611531,
        "views": 337482,
        "downloads": 199516,
        "collections": 836,
        "likes": 1151,
        "comments": 196,
        "user_id": 1298145,
        "user": "klimkin",
        "userImageURL": "https://cdn.pixabay.com/user/2017/07/18/13-46-18-393_250x250.jpg"
    },
    {
        "id": 3113318,
        "pageURL": "https://pixabay.com/photos/sunflower-nature-flora-flower-3113318/",
        "type": "photo",
        "tags": "sunflower, nature, flora",
        "previewURL": "https://cdn.pixabay.com/photo/2018/01/28/11/24/sunflower-3113318_150.jpg",
        "previewWidth": 150,
        "previewHeight": 99,
        "webformatURL": "https://pixabay.com/get/g055ee6a8091f98deb8748492fd03d782a9be2c3a3e97b96a977f2cbe67701e1e6495950b66320b4385ea1b19a848a253fbd321f117b8b4af4dba9e200b565660_640.jpg",
        "webformatWidth": 640,
        "webformatHeight": 426,
        "largeImageURL": "https://pixabay.com/get/g77ed64b1be76c359f4ee3451d6e4a2138be866542cb38bace6d0ad6a999ea095a57f4661417a7012b42fb4a9a8619ac68d1f6977518259fa63a26be1b268b2e2_1280.jpg",
        "imageWidth": 2736,
        "imageHeight": 1824,
        "imageSize": 1026006,
        "views": 573814,
        "downloads": 416312,
        "collections": 677,
        "likes": 992,
        "comments": 155,
        "user_id": 7410713,
        "user": "bichnguyenvo",
        "userImageURL": "https://cdn.pixabay.com/user/2017/12/16/10-28-39-199_250x250.jpg"
    },
    {
        "id": 1627193,
        "pageURL": "https://pixabay.com/photos/sunflower-yellow-flower-pollen-1627193/",
        "type": "photo",
        "tags": "sunflower, yellow, flower",
        "previewURL": "https://cdn.pixabay.com/photo/2016/08/28/23/24/sunflower-1627193_150.jpg",
        "previewWidth": 150,
        "previewHeight": 99,
        "webformatURL": "https://pixabay.com/get/g9a25407cd3f3b6c1cf8bc592c76639e87ecf4c23a90e7f3024755d916d3bff394e03d3b6f8d8f04a1e85d3230cfe0aa3c99fe7c0f55b58abb1dded74f3c32c41_640.jpg",
        "webformatWidth": 640,
        "webformatHeight": 426,
        "largeImageURL": "https://pixabay.com/get/g71fda967ba16fdc60548adeb97f69212d09dc3d30ba089c3c43e43d7ba4c7fa4a334dfa5be768c076aae7973e544990e73ddbdfc101b0e0e8c0b432cd6ce2980_1280.jpg",
        "imageWidth": 6000,
        "imageHeight": 4000,
        "imageSize": 5414839,
        "views": 291460,
        "downloads": 135697,
        "collections": 731,
        "likes": 664,
        "comments": 129,
        "user_id": 1834854,
        "user": "ulleo",
        "userImageURL": "https://cdn.pixabay.com/user/2022/02/27/09-13-19-744_250x250.jpg"
    },
    {
        "id": 3792914,
        "pageURL": "https://pixabay.com/photos/hd-wallpaper-nature-wallpaper-3792914/",
        "type": "photo",
        "tags": "hd wallpaper, nature wallpaper, sunflowers",
        "previewURL": "https://cdn.pixabay.com/photo/2018/11/03/21/42/sunflowers-3792914_150.jpg",
        "previewWidth": 150,
        "previewHeight": 69,
        "webformatURL": "https://pixabay.com/get/g6205705d57dcfcb8fce2541544b0c27f7e60d34ef0918965eef1db1354295631b5fddeb21a43b1d7eefa88bab9808a0c9cdcfe718b5542d251b2ea56ff22099a_640.jpg",
        "webformatWidth": 640,
        "webformatHeight": 296,
        "largeImageURL": "https://pixabay.com/get/g5163af82d827baf42b225a6d7f1e3660d2d686881f6b22cfe1c098b28ed50adaf95d410e3b8d23c1210b15a05d9249934f873253cf8a62b1a8dd3fba3be30a13_1280.jpg",
        "imageWidth": 6000,
        "imageHeight": 2780,
        "imageSize": 3835319,
        "views": 285107,
        "downloads": 186384,
        "collections": 600,
        "likes": 682,
        "comments": 146,
        "user_id": 165106,
        "user": "suju-foto",
        "userImageURL": "https://cdn.pixabay.com/user/2022/09/14/17-45-19-564_250x250.jpeg"
    },
    {
        "id": 2145539,
        "pageURL": "https://pixabay.com/photos/crocus-flower-wet-spring-2145539/",
        "type": "photo",
        "tags": "crocus, flower, wet",
        "previewURL": "https://cdn.pixabay.com/photo/2017/03/15/09/00/crocus-2145539_150.jpg",
        "previewWidth": 150,
        "previewHeight": 91,
        "webformatURL": "https://pixabay.com/get/g44222fc1e214307daf563817a4fad162888846a0e460774138d5d1138dac9dca17295391e2322e42efec54d87fd29daaa1e6ce68abb406975f933a54b81d3a90_640.jpg",
        "webformatWidth": 640,
        "webformatHeight": 390,
        "largeImageURL": "https://pixabay.com/get/gca549c57f3d70e7d5dd800064ae7ce957ebb6bed76923c2220c28d4f57e60513f25f3b7c8a61b577f4ee33ac6989964ee33c989c4c2618e4e30ea167be3bd2c7_1280.jpg",
        "imageWidth": 4000,
        "imageHeight": 2443,
        "imageSize": 823922,
        "views": 141959,
        "downloads": 94421,
        "collections": 572,
        "likes": 677,
        "comments": 70,
        "user_id": 2364555,
        "user": "pixel2013",
        "userImageURL": "https://cdn.pixabay.com/user/2020/07/25/21-10-11-80_250x250.jpg"
    },
    {
        "id": 729515,
        "pageURL": "https://pixabay.com/photos/flower-beautiful-bloom-blooming-729515/",
        "type": "photo",
        "tags": "flower, beautiful, bloom",
        "previewURL": "https://cdn.pixabay.com/photo/2015/04/19/08/33/flower-729515_150.jpg",
        "previewWidth": 150,
        "previewHeight": 97,
        "webformatURL": "https://pixabay.com/get/g2c828cf84617401bf65b098e93d59d059560d9f4ff53b831357c253064a92df181dfbd428caf4a68aab30130ec40e051_640.jpg",
        "webformatWidth": 640,
        "webformatHeight": 416,
        "largeImageURL": "https://pixabay.com/get/g8e6264d9aa78cc8dee4be3084faa7bdf3cf74bada54168bf43bee5092546b16988e306afeb4b8042682f4e40f0a161e04db2da56b61e14d4ea461ace74ab41d3_1280.jpg",
        "imageWidth": 1980,
        "imageHeight": 1288,
        "imageSize": 370390,
        "views": 117283,
        "downloads": 81207,
        "collections": 675,
        "likes": 518,
        "comments": 56,
        "user_id": 909086,
        "user": "Bessi",
        "userImageURL": "https://cdn.pixabay.com/user/2019/04/11/22-45-05-994_250x250.jpg"
    },
    {
        "id": 1512813,
        "pageURL": "https://pixabay.com/photos/lilies-yellow-flowers-petals-1512813/",
        "type": "photo",
        "tags": "lilies, yellow, flowers",
        "previewURL": "https://cdn.pixabay.com/photo/2016/07/12/18/54/lilies-1512813_150.jpg",
        "previewWidth": 150,
        "previewHeight": 75,
        "webformatURL": "https://pixabay.com/get/gbdd64d383f6541d513acffd4add9b578d1df235195a9752f801d8a00ddac31cc1c3e3f17b3272b2e691624958db2d56d96fffe100ab60a8637583c23dc1ba8c0_640.jpg",
        "webformatWidth": 640,
        "webformatHeight": 323,
        "largeImageURL": "https://pixabay.com/get/ga6cf1b1a7d110681ed8f6db62d0dc02539cefaaebe7194f0bfeec62eb8d45c4c99838742ac8397b75bdfda1b42b5faebff15085d73ca8e06e198dea4d5189d8a_1280.jpg",
        "imageWidth": 3861,
        "imageHeight": 1952,
        "imageSize": 1037708,
        "views": 171324,
        "downloads": 97879,
        "collections": 575,
        "likes": 606,
        "comments": 58,
        "user_id": 2364555,
        "user": "pixel2013",
        "userImageURL": "https://cdn.pixabay.com/user/2020/07/25/21-10-11-80_250x250.jpg"
    },
    {
        "id": 1536088,
        "pageURL": "https://pixabay.com/photos/sunflower-flower-plant-petals-1536088/",
        "type": "photo",
        "tags": "sunflower, flower, plant",
        "previewURL": "https://cdn.pixabay.com/photo/2016/07/23/00/12/sunflower-1536088_150.jpg",
        "previewWidth": 150,
        "previewHeight": 98,
        "webformatURL": "https://pixabay.com/get/g94a7f0c7cfc221fdbd038bbaa48bbb072c904053e4a45fbb906a8df7b607d0d522f3a8a51043d8a29dbc25a9bd396b32621e1899a53a4bf7e5e54f2b6b0d16bd_640.jpg",
        "webformatWidth": 640,
        "webformatHeight": 419,
        "largeImageURL": "https://pixabay.com/get/g39e305f609eb57eb5c19ae68da830004ad8cfd471249dc00525be2af3211723e3c3b15929c28a61a9f5c90215c4435955ee80ab95d4196632203488f385b9575_1280.jpg",
        "imageWidth": 4896,
        "imageHeight": 3208,
        "imageSize": 5103399,
        "views": 400957,
        "downloads": 119796,
        "collections": 533,
        "likes": 577,
        "comments": 92,
        "user_id": 1195798,
        "user": "Couleur",
        "userImageURL": "https://cdn.pixabay.com/user/2022/11/12/11-09-47-160_250x250.jpg"
    },
    {
        "id": 3050078,
        "pageURL": "https://pixabay.com/photos/fog-woman-meadow-flowers-tender-3050078/",
        "type": "photo",
        "tags": "fog, woman, meadow",
        "previewURL": "https://cdn.pixabay.com/photo/2017/12/30/13/26/fog-3050078_150.jpg",
        "previewWidth": 150,
        "previewHeight": 99,
        "webformatURL": "https://pixabay.com/get/gb84bc87573beb0de337cab00de5f2bedfbbe20f246c653275e96605cc4b8db3e0e56e074800749f18a03a1b9d913a2ffdb5d79d8a103a0310773503342e56197_640.jpg",
        "webformatWidth": 640,
        "webformatHeight": 426,
        "largeImageURL": "https://pixabay.com/get/ge0fae4cd3a29c78b553d7eb48624890d6398a6b1b1c51bd56b1c7a704e7b55382191bb7784091146cc38f74ca2ccffd0df1a960a2850697ecffa3751953a3d16_1280.jpg",
        "imageWidth": 5472,
        "imageHeight": 3648,
        "imageSize": 3473927,
        "views": 130983,
        "downloads": 85648,
        "collections": 514,
        "likes": 575,
        "comments": 84,
        "user_id": 6663646,
        "user": "ThuyHaBich",
        "userImageURL": "https://cdn.pixabay.com/user/2017/11/17/08-35-57-188_250x250.jpg"
    },
    {
        "id": 791450,
        "pageURL": "https://pixabay.com/photos/iphone-iphone-6-iphone-6-plus-apple-791450/",
        "type": "photo",
        "tags": "iphone, iphone 6, iphone 6 plus",
        "previewURL": "https://cdn.pixabay.com/photo/2015/05/31/12/14/iphone-791450_150.jpg",
        "previewWidth": 150,
        "previewHeight": 99,
        "webformatURL": "https://pixabay.com/get/g64cc5e80b11c8e12bcf8698c351d046850ade566587e370abdf186375065dc1188461ac78e05fc9e139155583eff22a0_640.jpg",
        "webformatWidth": 640,
        "webformatHeight": 426,
        "largeImageURL": "https://pixabay.com/get/g0ae054156d1b726501ce926d344ef0fc054ddd428aefd7205800307a6c7274466deec85feda23e2b055a1ec6ffe4ba5e19e3ded4fd055b967cbf7d849b962f03_1280.jpg",
        "imageWidth": 5254,
        "imageHeight": 3503,
        "imageSize": 1909143,
        "views": 166430,
        "downloads": 110118,
        "collections": 672,
        "likes": 377,
        "comments": 68,
        "user_id": 1013994,
        "user": "kaboompics",
        "userImageURL": "https://cdn.pixabay.com/user/2018/04/09/00-31-22-504_250x250.jpg"
    },
    {
        "id": 3215188,
        "pageURL": "https://pixabay.com/photos/flowers-orange-orange-petals-3215188/",
        "type": "photo",
        "tags": "flowers, orange, orange petals",
        "previewURL": "https://cdn.pixabay.com/photo/2018/03/10/20/26/flowers-3215188_150.jpg",
        "previewWidth": 150,
        "previewHeight": 83,
        "webformatURL": "https://pixabay.com/get/gac8845d1bb7f6fdb4a4d7235cd1b727076ccc56d76ea5e03b007aca4dc0bf280471122f7bc18b482af0766f1b2ba2c35fec76b7084ea40f777115a27186906cf_640.jpg",
        "webformatWidth": 640,
        "webformatHeight": 358,
        "largeImageURL": "https://pixabay.com/get/g6d32b0307bbf514f8f09696210ab917c06d1c5d62100476de3735dd7e3b692a132b675acb39bad86aa8467d4fc639e9582166deb3599d2f424a8b43ae9b56139_1280.jpg",
        "imageWidth": 2027,
        "imageHeight": 1134,
        "imageSize": 399066,
        "views": 203404,
        "downloads": 142623,
        "collections": 444,
        "likes": 483,
        "comments": 118,
        "user_id": 7097598,
        "user": "Candiix",
        "userImageURL": "https://cdn.pixabay.com/user/2017/12/06/20-08-45-84_250x250.jpg"
    },
    {
        "id": 1643794,
        "pageURL": "https://pixabay.com/photos/sunflower-bee-macro-pollen-1643794/",
        "type": "photo",
        "tags": "sunflower, bee, macro",
        "previewURL": "https://cdn.pixabay.com/photo/2016/09/04/12/05/sunflower-1643794_150.jpg",
        "previewWidth": 150,
        "previewHeight": 113,
        "webformatURL": "https://pixabay.com/get/g50e93dc41adabe584cd9038bd12f99592e20f90e1c2f5b4e329bb06b485eeaeecf7d93b279d3a1180b622a948276197f6ef8beb2eff3b7b0264c24829fb0ac65_640.jpg",
        "webformatWidth": 640,
        "webformatHeight": 484,
        "largeImageURL": "https://pixabay.com/get/g70f4afc267c41071b8c3597fede6c135552b1e6d58523e919f1524077e578ee4eda418ec9886daa1a446abc8348c0bf93a4c0cafdbe24eeae859cfdb78de67d4_1280.jpg",
        "imageWidth": 5285,
        "imageHeight": 4000,
        "imageSize": 5457910,
        "views": 144705,
        "downloads": 102873,
        "collections": 510,
        "likes": 462,
        "comments": 45,
        "user_id": 686414,
        "user": "Alexas_Fotos",
        "userImageURL": "https://cdn.pixabay.com/user/2022/07/05/23-09-40-265_250x250.jpg"
    },
    {
        "id": 190483,
        "pageURL": "https://pixabay.com/photos/bike-bicycle-wheels-bicycle-wheels-190483/",
        "type": "photo",
        "tags": "bike, bicycle, wheels",
        "previewURL": "https://cdn.pixabay.com/photo/2013/10/03/23/19/bike-190483_150.jpg",
        "previewWidth": 150,
        "previewHeight": 99,
        "webformatURL": "https://pixabay.com/get/g149f5e46ad9075be24daff4f542d9929a8a6463733c34c7496fa88e9c5911d9f497fb08a39aab5648540b70f36dbd0f4_640.jpg",
        "webformatWidth": 640,
        "webformatHeight": 426,
        "largeImageURL": "https://pixabay.com/get/g05a11aa94958ac0ee409b51b71e03dde25d0258c62b4a1e529fedc5fee2186747c16b0846e786699a5ba7e84c462fcb4fa86aa6455990d3b1d46a6a53fcc526a_1280.jpg",
        "imageWidth": 2160,
        "imageHeight": 1440,
        "imageSize": 2093738,
        "views": 160089,
        "downloads": 58827,
        "collections": 492,
        "likes": 429,
        "comments": 65,
        "user_id": 55851,
        "user": "danfador",
        "userImageURL": ""
    },
    {
        "id": 3050076,
        "pageURL": "https://pixabay.com/photos/portrait-girl-fog-flowers-beauty-3050076/",
        "type": "photo",
        "tags": "portrait, girl, fog",
        "previewURL": "https://cdn.pixabay.com/photo/2017/12/30/13/25/portrait-3050076_150.jpg",
        "previewWidth": 150,
        "previewHeight": 99,
        "webformatURL": "https://pixabay.com/get/gaecc83d1ec95fbc9fc0b64c8ffe069be03f878af7c1f9ecea6e1853067d5fa601034be2828f89cce9b802f041e8ec33c1c420f572287761ca008908f5052ebac_640.jpg",
        "webformatWidth": 640,
        "webformatHeight": 426,
        "largeImageURL": "https://pixabay.com/get/g957d4b218c146bc7876d22126a6ba4fec9d1d3e6ed87e2e4f84eefbecad42fc09cf1933d5dc4f34bba89735cbd7a172d60b2212b031eba5bd2d6138ec48867f7_1280.jpg",
        "imageWidth": 5472,
        "imageHeight": 3648,
        "imageSize": 2914111,
        "views": 222553,
        "downloads": 157521,
        "collections": 466,
        "likes": 437,
        "comments": 50,
        "user_id": 6663646,
        "user": "ThuyHaBich",
        "userImageURL": "https://cdn.pixabay.com/user/2017/11/17/08-35-57-188_250x250.jpg"
    },
    {
        "id": 5143015,
        "pageURL": "https://pixabay.com/photos/forget-me-not-pointed-flower-5143015/",
        "type": "photo",
        "tags": "forget me not, pointed flower, spring flowers",
        "previewURL": "https://cdn.pixabay.com/photo/2020/05/07/20/12/forget-me-not-5143015_150.jpg",
        "previewWidth": 150,
        "previewHeight": 100,
        "webformatURL": "https://pixabay.com/get/g95e501990bda5e35309708357d959ca00fd8d10a65144bf163443c57a7a85796451c0fca760f13eb06ed8af1ea87bf43ae0da79b47dc248f33ee97233dab1c96_640.jpg",
        "webformatWidth": 640,
        "webformatHeight": 427,
        "largeImageURL": "https://pixabay.com/get/gd5d5b90d816f8417158c8ef269e33b1dd88316e9fba8a8590fae1c2787ee6b19b7d35c52e2a74ca34f4df1765372bb459e74abbcb5afe16529930ac1b69e1efd_1280.jpg",
        "imageWidth": 5809,
        "imageHeight": 3873,
        "imageSize": 3759081,
        "views": 121659,
        "downloads": 96300,
        "collections": 341,
        "likes": 425,
        "comments": 256,
        "user_id": 12752456,
        "user": "mariya_m",
        "userImageURL": "https://cdn.pixabay.com/user/2022/10/27/21-21-00-720_250x250.jpeg"
    },
    {
        "id": 1972411,
        "pageURL": "https://pixabay.com/photos/drip-yellow-petals-globules-water-1972411/",
        "type": "photo",
        "tags": "drip, yellow, petals",
        "previewURL": "https://cdn.pixabay.com/photo/2017/01/11/17/27/drip-1972411_150.jpg",
        "previewWidth": 150,
        "previewHeight": 87,
        "webformatURL": "https://pixabay.com/get/ga6d699484ac0144bf900ec6d4b9655d245e5e581ec27f0deb138fa7ca859eed30fff33ec0fe0b066b188503fe20a223bdb4636c01d4f18454ba252e86bcde5ba_640.jpg",
        "webformatWidth": 640,
        "webformatHeight": 372,
        "largeImageURL": "https://pixabay.com/get/gd4fd0ba2ce37041c2e26550220fb8e01c2c253d6b2aae0cdf6201e82504c3f5c84aee83e89ae044d428b3f6eef815d501d3158438ff993b9e120e5ff1daf0438_1280.jpg",
        "imageWidth": 4288,
        "imageHeight": 2499,
        "imageSize": 1510459,
        "views": 138183,
        "downloads": 112845,
        "collections": 402,
        "likes": 424,
        "comments": 63,
        "user_id": 1777190,
        "user": "susannp4",
        "userImageURL": "https://cdn.pixabay.com/user/2015/12/16/17-56-55-832_250x250.jpg"
    },
    {
        "id": 2107024,
        "pageURL": "https://pixabay.com/photos/crocus-flowers-yellow-bloom-2107024/",
        "type": "photo",
        "tags": "crocus, flowers, yellow",
        "previewURL": "https://cdn.pixabay.com/photo/2017/02/28/22/37/crocus-2107024_150.jpg",
        "previewWidth": 150,
        "previewHeight": 99,
        "webformatURL": "https://pixabay.com/get/g9d2c69121e4359991e6e0367754047cc275e581b7fa293747f066c4a0a7790dec2b1b1d37e64b9fa48c2a2809342c06a372dee40bb28430c6c3d37aefa07c0b8_640.jpg",
        "webformatWidth": 640,
        "webformatHeight": 426,
        "largeImageURL": "https://pixabay.com/get/g1dedf71a978e53c04fca2c5509527a4a54bc24ffb02d76b1b473e5d5a10af4f3c65fa29ce565cdbd0386d297c1b4784c50f921bd20325b18a5b92f2542732dc3_1280.jpg",
        "imageWidth": 4896,
        "imageHeight": 3264,
        "imageSize": 2596169,
        "views": 93652,
        "downloads": 59224,
        "collections": 549,
        "likes": 281,
        "comments": 50,
        "user_id": 1195798,
        "user": "Couleur",
        "userImageURL": "https://cdn.pixabay.com/user/2022/11/12/11-09-47-160_250x250.jpg"
    }
    ]}*/
