package consumer

import org.junit.Assert
import org.junit.Test

class BuildConfigGeneratedTest {

    @Suppress("USELESS_IS_CHECK")
    @Test
    fun test() {
        Assert.assertTrue(BuildConfig.booleanValue is Boolean)
        Assert.assertTrue(BuildConfig.charValue is Char)
        Assert.assertTrue(BuildConfig.doubleValue is Double)
        Assert.assertTrue(BuildConfig.floatValue is Float)
        Assert.assertTrue(BuildConfig.intValue is Int)
        Assert.assertTrue(BuildConfig.longValue is Long)
        Assert.assertTrue(BuildConfig.stringValue is String)
    }
}