import org.junit.Test;

import static org.junit.Assert.*;

public class ListTest {

    @Test
    public void isEmpty() {
        List<String> e = new EmptyL<>();
        List<String> e2 = new NodeL<>("Z", e);
        List<String> e3 = new NodeL<>("A", new NodeL<>("B", new NodeL<>("C", new NodeL<>("D", new NodeL<>("E", new NodeL<>("F", new EmptyL<>()))))));
        List<String> e4 = new NodeL<>("AAAA", new NodeL<>("AAAA", new NodeL<>("AAAA", new NodeL<>("AAAA", new NodeL<>("AAAA", new NodeL<>("AAAA", new EmptyL<>()))))));
        List<String> e5 = new NodeL<>("A", new NodeL<>("B", new NodeL<>("C", new NodeL<>("D", new NodeL<>("E", new NodeL<>("F", e4))))));
        List<String> e6 = new NodeL<>("ZZ", e5);
        assertTrue(e.isEmpty());
        assertFalse(e2.isEmpty());
        assertFalse(e3.isEmpty());
        assertFalse(e4.isEmpty());
        assertFalse(e5.isEmpty());
        assertFalse(e6.isEmpty());
        assertTrue(e.isEmpty());
    }

    @Test
    public void isSingleton() {
        List<String> e = new EmptyL<>();
        List<String> e2 = new NodeL<>("Z", e);
        List<String> e3 = new NodeL<>("A", new NodeL<>("B", new NodeL<>("C", new NodeL<>("D", new NodeL<>("E", new NodeL<>("F", new EmptyL<>()))))));
        List<String> e4 = new NodeL<>("AAAA", new NodeL<>("AAAA", new NodeL<>("AAAA", new NodeL<>("AAAA", new NodeL<>("AAAA", new NodeL<>("AAAA", new EmptyL<>()))))));
        List<String> e5 = new NodeL<>("A", new NodeL<>("B", new NodeL<>("C", new NodeL<>("D", new NodeL<>("E", new NodeL<>("F", e4))))));
        List<String> e6 = new NodeL<>("ZZ", e5);
        assertFalse(e.isSingleton());
        assertTrue(e2.isSingleton());
        assertFalse(e3.isSingleton());
        assertFalse(e4.isSingleton());
        assertFalse(e5.isSingleton());
        assertFalse(e6.isSingleton());
        assertTrue(e2.isSingleton());
        assertFalse(e.isSingleton());
    }

    @Test (expected = EmptyListException.class)
    public void getFirst() throws EmptyListException {
        List<String> e = new EmptyL<>();
        List<String> e2 = new NodeL<>("Z", e);
        List<String> e3 = new NodeL<>("A", new NodeL<>("B", new NodeL<>("C", new NodeL<>("D", new NodeL<>("E", new NodeL<>("F", new EmptyL<>()))))));
        List<String> e4 = new NodeL<>("AAAA", new NodeL<>("AAAA", new NodeL<>("AAAA", new NodeL<>("AAAA", new NodeL<>("AAAA", new NodeL<>("AAAA", new EmptyL<>()))))));
        List<String> e5 = new NodeL<>("A", new NodeL<>("B", new NodeL<>("C", new NodeL<>("D", new NodeL<>("E", new NodeL<>("F", e4))))));
        List<String> e6 = new NodeL<>("ZZ", e5);
        e.getFirst();
        assertEquals("Z", e2.getFirst());
        assertEquals("A", e3.getFirst());
        assertEquals("AAAA", e4.getFirst());
        assertEquals("A", e5.getFirst());
        assertEquals("ZZ", e6.getFirst());
    }

    @Test (expected = EmptyListException.class)
    public void getRest() throws EmptyListException {
        List<String> e = new EmptyL<>();
        List<String> e2 = new NodeL<>("Z", e);
        List<String> e3 = new NodeL<>("A", new NodeL<>("B", new NodeL<>("C", new NodeL<>("D", new NodeL<>("E", new NodeL<>("F", new EmptyL<>()))))));
        List<String> e4 = new NodeL<>("AAAA", new NodeL<>("AAAA", new NodeL<>("AAAA", new NodeL<>("AAAA", new NodeL<>("AAAA", new NodeL<>("AAAA", new EmptyL<>()))))));
        List<String> e5 = new NodeL<>("A", new NodeL<>("B", new NodeL<>("C", new NodeL<>("D", new NodeL<>("E", new NodeL<>("F", e4))))));
        List<String> e6 = new NodeL<>("ZZ", e5);
        e.getRest();
        assertEquals(e, e2.getRest());
        assertEquals(new NodeL<>("B", new NodeL<>("C", new NodeL<>("D", new NodeL<>("E", new NodeL<>("F", new EmptyL<>()))))), e3.getRest());
        assertEquals(new NodeL<>("AAAA", new NodeL<>("AAAA", new NodeL<>("AAAA", new NodeL<>("AAAA", new NodeL<>("AAAA", new EmptyL<>()))))), e4.getRest());
        assertEquals(new NodeL<>("B", new NodeL<>("C", new NodeL<>("D", new NodeL<>("E", new NodeL<>("F", e4))))), e5.getRest());
        assertEquals(e5, e6.getRest());
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void get() throws EmptyListException {
        List<String> e = new EmptyL<>();
        List<String> e2 = new NodeL<>("Z", e);
        List<String> e3 = new NodeL<>("A", new NodeL<>("B", new NodeL<>("C", new NodeL<>("D", new NodeL<>("E", new NodeL<>("F", new EmptyL<>()))))));
        List<String> e4 = new NodeL<>("AAAA", new NodeL<>("AAAA", new NodeL<>("AAAA", new NodeL<>("AAAA", new NodeL<>("AAAA", new NodeL<>("AAAA", new EmptyL<>()))))));
        List<String> e5 = new NodeL<>("A", new NodeL<>("B", new NodeL<>("C", new NodeL<>("D", new NodeL<>("E", new NodeL<>("F", e4))))));
        List<String> e6 = new NodeL<>("ZZ", e5);
        e.get(2);
        assertEquals("Z", e2.get(0));
        assertEquals("C", e3.get(2));
        assertEquals("A", e3.get(0));
        assertEquals("F", e3.get(5));
        e3.get(60);
        assertEquals("ZZ", e6.get(0));
        assertEquals("A", e6.get(1));
        assertEquals("F", e6.get(6));
        assertEquals("AAAA", e6.get(7));
        assertEquals("AAAA", e6.get(12));
    }

    @Test
    public void length() {
        List<String> e = new EmptyL<>();
        List<String> e2 = new NodeL<>("Z", e);
        List<String> e3 = new NodeL<>("A", new NodeL<>("B", new NodeL<>("C", new NodeL<>("D", new NodeL<>("E", new NodeL<>("F", new EmptyL<>()))))));
        List<String> e4 = new NodeL<>("AAAA", new NodeL<>("AAAA", new NodeL<>("AAAA", new NodeL<>("AAAA", new NodeL<>("AAAA", new NodeL<>("AAAA", new EmptyL<>()))))));
        List<String> e5 = new NodeL<>("A", new NodeL<>("B", new NodeL<>("C", new NodeL<>("D", new NodeL<>("E", new NodeL<>("F", e4))))));
        List<String> e6 = new NodeL<>("ZZ", e5);
        assertEquals(0, e.length());
        assertEquals(1, e2.length());
        assertEquals(6, e3.length());
        assertEquals(6, e4.length());
        assertEquals(12, e5.length());
        assertEquals(13, e6.length());
    }

    @Test
    public void append() throws EmptyListException{
        List<String> e = new EmptyL<>();
        List<String> e2 = new NodeL<>("Z", e);
        List<String> e3 = new NodeL<>("A", new NodeL<>("B", new NodeL<>("C", new NodeL<>("D", new NodeL<>("E", new NodeL<>("F", new EmptyL<>()))))));
        List<String> e4 = new NodeL<>("AAAA", new NodeL<>("AAAA", new NodeL<>("AAAA", new NodeL<>("AAAA", new NodeL<>("AAAA", new NodeL<>("AAAA", new EmptyL<>()))))));
        List<String> e5 = new NodeL<>("A", new NodeL<>("B", new NodeL<>("C", new NodeL<>("D", new NodeL<>("E", new NodeL<>("F", e4))))));
        List<String> e6 = new NodeL<>("ZZ", e5);
        assertTrue(e6.equalTo(new NodeL<>("ZZ", new EmptyL<>()).append(e5)));
        assertTrue(e2.equalTo(new NodeL<>("Z", new EmptyL<>()).append(e)));
        assertTrue(e5.equalTo(new NodeL<>("A", new NodeL<>("B", new NodeL<>("C", new NodeL<>("D", new NodeL<>("E", new NodeL<>("F", new NodeL<>("AAAA", new NodeL<>("AAAA", new NodeL<>("AAAA", new NodeL<>("AAAA", new NodeL<>("AAAA", new NodeL<>("AAAA", new EmptyL<>()))))))))))))));
    }

    @Test
    public void contains() {
        List<String> e = new EmptyL<>();
        List<String> e2 = new NodeL<>("Z", e);
        List<String> e3 = new NodeL<>("A", new NodeL<>("B", new NodeL<>("C", new NodeL<>("D", new NodeL<>("E", new NodeL<>("F", new EmptyL<>()))))));
        List<String> e4 = new NodeL<>("AAAA", new NodeL<>("AAAA", new NodeL<>("AAAA", new NodeL<>("AAAA", new NodeL<>("AAAA", new NodeL<>("AAAA", new EmptyL<>()))))));
        List<String> e5 = new NodeL<>("A", new NodeL<>("B", new NodeL<>("C", new NodeL<>("D", new NodeL<>("E", new NodeL<>("F", e4))))));
        List<String> e6 = new NodeL<>("ZZ", e5);
        assertTrue(e2.contains("Z"));
        assertFalse(e2.contains("A"));
        assertTrue(e3.contains("F"));
        assertTrue(e4.contains("AAAA"));
        assertFalse(e4.contains("AAA"));
        assertTrue(e5.contains("D"));
        assertTrue(e5.contains("AAAA"));
        assertTrue(e6.contains("ZZ"));
        assertTrue(e6.contains("AAAA"));
        assertTrue(e6.contains("E"));
    }
}
