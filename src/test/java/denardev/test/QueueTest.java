package denardev.test;

import org.junit.jupiter.api.*;

import java.util.LinkedList;
import java.util.Queue;

@DisplayName("A Queue")
public class QueueTest {

    private Queue<String> queue;

    @Nested
    @DisplayName("When New")
    public class WhenNew{
        @BeforeEach
        void setUp() {
            queue = new LinkedList<>();
        }

        @Test
        @DisplayName("When offer, size must be 1")
        void offerNewData(){
            queue.offer("Denar");
            Assertions.assertEquals(1, queue.size());
        }

        @Test
        @DisplayName("When offer 2 data, size must be 2")
        void offerMoreData(){
            queue.offer("Ahmaron");
            queue.offer("Surya");
            Assertions.assertEquals(2, queue.size());
        }
    }

}
