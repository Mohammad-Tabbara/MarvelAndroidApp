package com.opensource.marvelcharacters

class Constants {

    enum class URL_TYPE(val value: String?){
        WIKI("wiki");
    }

    companion object{
        const val LOCAL_DB: String = "LOCAL_DB"
        const val PUBLIC_KEY = "197b389585b85b0e1b1b5bfd026702e0"
        const val PRIVATE_KEY = "8fd95efa48a8ad09177fffabb1ca605a9a72f990"
        const val MARVEL_API : String = "https://gateway.marvel.com:443"

    }
}