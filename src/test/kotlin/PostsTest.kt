import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals

class PostsTest {
    @Before
    fun clearArray() {
        WallService.clear()
    }

    @Test
    fun testAddCount(){
        val post = Post(1,1, 1, date = 1)

        val beforeCount = WallService.count()
        WallService.add(post)
        val afterCount = WallService.count()

        assertEquals(beforeCount + 1, afterCount)

    }

    @Test
    fun testUpdateTrue(){
        val post = Post(1,1, 1, date = 1)

        WallService.add(post)
        val result =  WallService.update(post)
        assertEquals( true, result)

    }

    @Test
    fun testUpdateFalse(){
        val post = Post(1,1, 1, date = 1)

        val result =  WallService.update(post)
        assertEquals( false, result)

    }

    @Test
    fun testAddUniqueId(){
        val post = Post(1,1, 1, date = 1)




      val result1 =  WallService.add(post)
        val result2 =  WallService.add(post)

        assertNotEquals( result1.id, result2.id)

    }

    @Test
    fun createComment_addTrue() {
        WallService.add(Post(1, 1, 1, date = 1))
        val result = WallService.createComment(1, Comment())
        assertEquals(1, result.id)
    }

    @Test(expected = PostNotFoundException::class)
    fun shouldThrow() {
        WallService.add(Post(1, 1, 1, date = 1))
        WallService.createComment(5, Comment())
    }
}