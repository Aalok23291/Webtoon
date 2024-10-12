package com.example.webtoon
import android.os.Parcel
import android.os.Parcelable

data class Webtoon(
    val id: String,
    val title: String,
    val imageResId: Int,
    val description: String
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readInt(),
        parcel.readString()!!
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(id)
        parcel.writeString(title)
        parcel.writeInt(imageResId)
        parcel.writeString(description)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Webtoon> {
        override fun createFromParcel(parcel: Parcel): Webtoon {
            return Webtoon(parcel)
        }

        override fun newArray(size: Int): Array<Webtoon?> {
            return arrayOfNulls(size)
        }
    }
}
