package com.owncloud.android.data.user.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.owncloud.android.data.ProviderMeta
import com.owncloud.android.data.capabilities.db.OCCapabilityEntity

@Dao
abstract class UserQuotaDao {

    companion object {
        private const val SELECT =
            "SELECT * " +
                    "FROM ${ProviderMeta.ProviderTableMeta.USER_QUOTAS_TABLE_NAME} " +
                    "WHERE accountName = :accountName"
        private const val DELETE =
            "DELETE FROM ${ProviderMeta.ProviderTableMeta.USER_QUOTAS_TABLE_NAME} " +
                    "WHERE accountName = :accountName"
    }

    @Query(SELECT)
    abstract fun getQuotaForAccount(
        accountName: String
    ): UserQuotaEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insert(userQuotaEntity: UserQuotaEntity)

    @Query(DELETE)
    abstract fun delete(accountName: String)

}
