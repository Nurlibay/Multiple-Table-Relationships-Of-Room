package uz.unidev.relationshipsofroom

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import uz.unidev.relationshipsofroom.data.SchoolDatabase
import uz.unidev.relationshipsofroom.data.entities.Director
import uz.unidev.relationshipsofroom.data.entities.School
import uz.unidev.relationshipsofroom.data.entities.Student
import uz.unidev.relationshipsofroom.data.entities.Subject
import uz.unidev.relationshipsofroom.data.entities.relations.StudentSubjectCrossRef

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dao = SchoolDatabase.getInstance(this).schoolDao()

        val directors = listOf(
            Director("Baltabay", "Baltabaev atindagi mektep"),
            Director("Teńizbay", "Teńizbayev atindagi mektep"),
            Director("Erkinbay", "Erkinbayev atindagi mektep")
        )

        val schools = listOf(
            School("Baltabaev atindagi mektep"),
            School("Teńizbayev atindagi mektep"),
            School("Erkinbayev atindagi mektep")
        )

        val subjects = listOf(
            Subject("Matematika"),
            Subject("Fizika"),
            Subject("English")
        )

        val students = listOf(
            Student("Baltabaydiń balasi", 2, "Baltabaev atindagi mektep"),
            Student("Teńizbaydiń balasi", 3, "Teńizbayev atindagi mektep"),
            Student("Erkinbaydiń balasi", 4, "Erkinbayev atindagi mektep")
        )

        val studentSubjectRelations = listOf(
            StudentSubjectCrossRef("Baltabaydiń balasi", "Matematika"),
            StudentSubjectCrossRef("Teńizbaydiń balasi", "Fizika"),
            StudentSubjectCrossRef("Erkinbaydiń balasi", "English")
        )

        lifecycleScope.launchWhenCreated {
            directors.forEach { dao.insertDirector(it) }
            schools.forEach { dao.insertSchool(it) }
            subjects.forEach { dao.insertSubject(it) }
            students.forEach { dao.insertStudent(it) }
            studentSubjectRelations.forEach { dao.insertStudentSubjectCrossRef(it) }

            val schoolWithDirector = dao.getSchoolAndDirectorWithSchoolName("Teńizbayev atindagi mektep")
            schoolWithDirector.first().director.directorName
            schoolWithDirector.first().school.schoolName

            val schoolWithStudent = dao.getSchoolWithStudents("Teńizbayev atindagi mektep")
            schoolWithStudent.first().students
            schoolWithStudent.last().school
        }
    }
}