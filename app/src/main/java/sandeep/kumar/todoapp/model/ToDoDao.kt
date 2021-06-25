package sandeep.kumar.todoapp.model

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ToDoDao {

    @Insert()
    suspend fun insertTask(todoModel: ToDoModel):Long

    @Query("Select * from todo where isFinished == 0")
    fun getTask():LiveData<List<ToDoModel>>

    @Query("Update todo Set isFinished = 1 where id=:uid")
    fun finishTask(uid:Long)

    @Query("Delete from todo where id=:uid")
    fun deleteTask(uid:Long)
}