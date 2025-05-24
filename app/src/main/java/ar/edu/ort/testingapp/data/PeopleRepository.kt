package ar.edu.ort.testingapp.data


interface PeopleRepository {
    suspend fun getPeople(): List<People>
}