package com.owncloud.android.data.user.datasources.implementation

import com.owncloud.android.data.user.datasources.LocalUserDataSource
import com.owncloud.android.data.user.datasources.mapper.UserQuotaMapper
import com.owncloud.android.data.user.db.UserQuotaDao
import com.owncloud.android.domain.user.model.UserQuota

class OCLocalUserDataSource(
    private val userQuotaDao: UserQuotaDao,
    private val userQuotaMapper: UserQuotaMapper
) : LocalUserDataSource {

    override fun saveQuotaForAccount(accountName: String, userQuota: UserQuota) =
        userQuotaDao.insert(userQuotaMapper.toEntity(userQuota)!!.copy(accountName = accountName))

    override fun getQuotaForAccount(accountName: String): UserQuota? =
        userQuotaMapper.toModel(userQuotaDao.getQuotaForAccount(accountName))

}
