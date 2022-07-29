package uz.unidev.relationshipsofroom.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 *  Created by Nurlibay Koshkinbaev on 29/07/2022 10:56
 */

@Entity
data class Subject(
    @PrimaryKey(autoGenerate = false)
    val subjectName: String
)