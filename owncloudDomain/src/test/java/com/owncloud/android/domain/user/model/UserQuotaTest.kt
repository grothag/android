package com.owncloud.android.domain.user.model

import org.junit.Assert
import org.junit.Test

class UserQuotaTest {
    @Test
    fun testConstructor() {
        val item = UserQuota(
            800,
            200
        )

        Assert.assertEquals(800, item.available)
        Assert.assertEquals(20, item.used)
    }

    @Test
    fun testEqualsOk() {
        val item1 = UserInfo(
            id = "admin",
            displayName = "adminOc",
            email = null
        )

        val item2 = UserInfo(
            "admin",
            "adminOc",
            null
        )

        Assert.assertTrue(item1 == item2)
        Assert.assertFalse(item1 === item2)
    }

    @Test
    fun testEqualsKo() {
        val item1 = UserInfo(
            id = "admin",
            displayName = "adminOc",
            email = null
        )

        val item2 = UserInfo(
            "admin",
            "adminOc",
            "demo@owncloud.com"
        )

        Assert.assertFalse(item1 == item2)
        Assert.assertFalse(item1 === item2)
    }
}
