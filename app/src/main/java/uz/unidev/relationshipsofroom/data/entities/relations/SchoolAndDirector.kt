package uz.unidev.relationshipsofroom.data.entities.relations

import androidx.room.Embedded
import androidx.room.Relation
import uz.unidev.relationshipsofroom.data.entities.Director
import uz.unidev.relationshipsofroom.data.entities.School

/**
 *  Created by Nurlibay Koshkinbaev on 29/07/2022 10:20
 */

/** ONE-to-ONE RELATIONSHIP */

data class SchoolAndDirector(
    @Embedded val school: School,
    @Relation(
        parentColumn = "schoolName",
        entityColumn = "schoolName"
    )
    val director: Director
)