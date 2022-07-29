package uz.unidev.relationshipsofroom.data.entities.relations

import androidx.room.Entity

/**
 *  Created by Nurlibay Koshkinbaev on 29/07/2022 10:59
 */

@Entity(primaryKeys = ["studentName", "subjectName"])
data class StudentSubjectCrossRef(
    val studentName: String,
    val subjectName: String
)