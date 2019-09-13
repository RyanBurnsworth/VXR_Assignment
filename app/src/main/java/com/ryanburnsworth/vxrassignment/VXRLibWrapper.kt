package com.ryanburnsworth.vxrassignment

class VXRLibWrapper {

    external fun generateRandomString(): String
    external fun init(width: Int, height: Int)
    external fun step()

    companion object {
        init {
            System.loadLibrary("vxrlib")
        }
    }
}
