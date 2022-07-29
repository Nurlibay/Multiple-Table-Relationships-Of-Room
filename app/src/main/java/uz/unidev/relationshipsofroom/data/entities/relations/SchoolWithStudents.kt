package uz.unidev.relationshipsofroom.data.entities.relations

import androidx.room.Embedded
import androidx.room.Relation
import uz.unidev.relationshipsofroom.data.entities.School
import uz.unidev.relationshipsofroom.data.entities.Student

/**
 *  Created by Nurlibay Koshkinbaev on 29/07/2022 10:41
 */

/** ONE-to-N RELATIONSHIP */

data class SchoolWithStudents(
    @Embedded val school: School,
    @Relation(
        parentColumn = "schoolName",
        entityColumn = "schoolName"
    )
    val students: List<Student>
)