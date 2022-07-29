package uz.unidev.relationshipsofroom.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 *  Created by Nurlibay Koshkinbaev on 29/07/2022 10:16
 */

@Entity
data class School(
    @PrimaryKey(autoGenerate = false)
    val schoolName: String
)