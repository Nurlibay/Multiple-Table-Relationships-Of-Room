package uz.unidev.relationshipsofroom.data.entities.relations

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import uz.unidev.relationshipsofroom.data.entities.Student
import uz.unidev.relationshipsofroom.data.entities.Subject

/**
 *  Created by Nurlibay Koshkinbaev on 29/07/2022 11:03
 */

/** N-to-M Relationship */

data class StudentWithSubjects(
    @Embedded val student: Student,
    @Relation(
        parentColumn = "studentName",
        entityColumn = "subjectName",
        associateBy = Junction(StudentSubjectCrossRef::class)
    )
    val subjects: List<Subject>
)