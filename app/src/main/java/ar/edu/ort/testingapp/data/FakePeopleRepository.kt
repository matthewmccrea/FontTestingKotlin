package ar.edu.ort.testingapp.data

class FakePeopleRepository : PeopleRepository {
    override suspend fun getPeople(): List<People> {
        return fakePeopleList
    }
}