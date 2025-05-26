package ar.edu.ort.testingapp.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "BOOK")
data class Book(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "book_id")
    val id: Int = 0,

    @ColumnInfo(name = "book_name")
    val name: String?,

    @ColumnInfo(name = "book_price")
    val price: Double?,

    @ColumnInfo(name = "book_author")
    val author: String?
)
